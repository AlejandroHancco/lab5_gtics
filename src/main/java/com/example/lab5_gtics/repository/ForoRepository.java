package com.example.lab5_gtics.repository;


import com.example.lab5_gtics.entity.Foro;
import com.example.lab5_gtics.entity.Riesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForoRepository extends JpaRepository<Foro, Integer> {
}