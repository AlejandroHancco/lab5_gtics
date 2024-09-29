package com.example.lab5_gtics.controller;


import com.example.lab5_gtics.entity.*;
import com.example.lab5_gtics.repository.*;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/centro")
public class centroController {

    final AreaRepository areaRepository;
    final FechaRepository fechaRepository;
    final ProfesionalRepository profesionalRepository;
    final SedeRepository sedeRepository;
    final RiesgoRepository riesgoRepository;
    final CitaRepository citaRepository;
    final PacienteRepository pacienteRepository;

    public centroController(AreaRepository areaRepository, FechaRepository fechaRepository, ProfesionalRepository profesionalRepository, SedeRepository sedeRepository, RiesgoRepository riesgoRepository,CitaRepository citaRepository,PacienteRepository pacienteRepository) {
        this.areaRepository = areaRepository;
        this.fechaRepository = fechaRepository;
        this.profesionalRepository = profesionalRepository;
        this.sedeRepository = sedeRepository;
        this.riesgoRepository = riesgoRepository;
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
    }
    @GetMapping("/profesionales")
    public String showCatalogo(Model model) {
        packAtributes(model);
        List<Profesional> profesionalList = profesionalRepository.findAll();
        model.addAttribute("profesionalList", profesionalList);
        return "profesionales";
    }


    @GetMapping("/search")
    public String Filtrado (Model model,@RequestParam Integer idarea,@RequestParam Integer idsede,@RequestParam Integer idfecha) {
        packAtributes(model);
        List<Profesional> profesionalesFiltrados = profesionalRepository.findProfesionalesByAreaAndFechaAndSede(idarea, idfecha, idsede);
        model.addAttribute("profesionalList", profesionalesFiltrados);

        return "profesionales";

    }
    @GetMapping("/nuevaCita")
    public String nuevaCita (Model model) {
        packAtributes(model);
        List<Profesional> profesionalList = profesionalRepository.findAll();
        model.addAttribute("profesionalList", profesionalList);
        return "formCita";

    }


    @PostMapping("/save")
    public String GuardarCita(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("dni") String dni,
            @RequestParam("idriesgo") Integer idriesgo,
            @RequestParam("consulta") String consulta,
            @RequestParam("idarea") Integer idarea,
            @RequestParam("idprofesional") Integer idprofesional,
            @RequestParam("idsede") Integer idsede,
            @RequestParam("idFecha") Integer idfecha,
            Model model, RedirectAttributes redirectAttributes) {

        Cita cita = new Cita();

        // Buscar el paciente por DNI
        Paciente pacienteAux = pacienteRepository.findByDni(dni);


        Optional<Riesgo> riesgoOptional = riesgoRepository.findById(idriesgo);
        riesgoOptional.ifPresent(cita::setRiesgo);


        cita.setMotivoConsulta(consulta);


        areaRepository.findById(idarea).ifPresent(cita::setArea);
        sedeRepository.findById(idsede).ifPresent(cita::setSede);
        fechaRepository.findById(idfecha).ifPresent(cita::setFecha);
        profesionalRepository.findById(idprofesional).ifPresent(cita::setProfesional);

        Optional<Profesional> profesionalOptional = profesionalRepository.findById(idprofesional);
        if (profesionalOptional.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "El profesional no existe");
            redirectAttributes.addFlashAttribute("alert", "alert-danger");
            return "redirect:/centro/profesionales"; // O la página que corresponda
        }

        Profesional profesional = profesionalOptional.get();
        Area area = areaRepository.findById(idarea).orElse(null);
        Fecha fecha = fechaRepository.findById(idfecha).orElse(null);
        assert area != null;
        if (!profesional.getArea().getIdAreas().equals(area.getIdAreas())) {
            redirectAttributes.addFlashAttribute("msg", "El profesional no coincide con el área");
            redirectAttributes.addFlashAttribute("alert", "alert-danger");
            return "redirect:/centro/profesionales";
        }


        if (!profesional.getSede().getIdSedes().equals(idsede)) {
            redirectAttributes.addFlashAttribute("msg", "El profesional no está disponible");
            redirectAttributes.addFlashAttribute("alert", "alert-danger");
            return "redirect:/centro/profesionales";
        }
        assert fecha != null;
        if (!fecha.getIdFechas().equals(idfecha)) {
            redirectAttributes.addFlashAttribute("msg", "Fecha no disponible");
            redirectAttributes.addFlashAttribute("alert", "alert-danger");
            return "redirect:/centro/profesionales";
        }

        if (pacienteAux != null) {
            cita.setPaciente(pacienteAux);
        } else {
            Paciente nuevoPaciente = new Paciente();
            nuevoPaciente.setNombrePaciente(firstName + " " + lastName);
            nuevoPaciente.setDni(dni);
            nuevoPaciente = pacienteRepository.save(nuevoPaciente);
            cita.setPaciente(nuevoPaciente);
        }


        return "redirect:/centro/profesionales";
    }






    private void packAtributes (Model model){
        List<Area> areaList = areaRepository.findAll();
        List<Fecha> fechaList = fechaRepository.findAll();

        List<Sede> sedeList = sedeRepository.findAll();
        List<Riesgo> riesgoList=riesgoRepository.findAll();

        model.addAttribute("areaList", areaList);
        model.addAttribute("fechaList", fechaList);

        model.addAttribute("sedeList", sedeList);
        model.addAttribute("riesgoList", riesgoList);
    }



}
