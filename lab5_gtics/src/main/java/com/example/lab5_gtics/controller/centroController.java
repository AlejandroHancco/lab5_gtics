package com.example.lab5_gtics.controller;


import com.example.lab5_gtics.entity.Area;
import com.example.lab5_gtics.entity.Fecha;
import com.example.lab5_gtics.entity.Profesional;
import com.example.lab5_gtics.entity.Sede;
import com.example.lab5_gtics.repository.AreaRepository;
import com.example.lab5_gtics.repository.FechaRepository;
import com.example.lab5_gtics.repository.ProfesionalRepository;
import com.example.lab5_gtics.repository.SedeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/centro")
public class centroController {

    final AreaRepository areaRepository;
    final FechaRepository fechaRepository;
    final ProfesionalRepository profesionalRepository;
    final SedeRepository sedeRepository;


    public centroController(AreaRepository areaRepository, FechaRepository fechaRepository, ProfesionalRepository profesionalRepository, SedeRepository sedeRepository) {
        this.areaRepository = areaRepository;
        this.fechaRepository = fechaRepository;
        this.profesionalRepository = profesionalRepository;
        this.sedeRepository = sedeRepository;
    }
    @GetMapping("/profesionales")
    public String showCatalogo(Model model) {
        List<Area> areaList = areaRepository.findAll();
        List<Fecha> fechaList = fechaRepository.findAll();
        List<Profesional> profesionalList = profesionalRepository.findAll();
        List<Sede> sedeList = sedeRepository.findAll();


        model.addAttribute("areaList", areaList);
        model.addAttribute("fechaList", fechaList);
        model.addAttribute("profesionalList", profesionalList);
        model.addAttribute("sedeList", sedeList);

        return "profesionales";

    }



}
