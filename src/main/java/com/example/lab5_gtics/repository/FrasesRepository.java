package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Frases;
import com.example.lab5_gtics.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrasesRepository extends JpaRepository<Frases, Integer> {


}