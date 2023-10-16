package com.api.controleequipamentos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controleequipamentos.entities.EquipamentosEntity;


public interface EquipamentosRepository extends JpaRepository<EquipamentosEntity, Long> {

    List<EquipamentosEntity> findAll(); // Método existente

    Optional<EquipamentosEntity> findByNome(String nome); // Novo método para verificar o nome
    Optional<EquipamentosEntity> findByNumeroSerie(String nome); // Novo método para verificar o nome

}

