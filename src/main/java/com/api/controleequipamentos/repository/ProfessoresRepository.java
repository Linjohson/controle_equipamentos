package com.api.controleequipamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controleequipamentos.entities.ProfessoresEntity;

import java.util.List;
import java.util.Optional;

public interface ProfessoresRepository extends JpaRepository<ProfessoresEntity, Long> {

    List<ProfessoresEntity> findAll(); // Método existente

    Optional<ProfessoresEntity> findByMatricula(String matricula); // Novo método para verificar a matrícula
}


