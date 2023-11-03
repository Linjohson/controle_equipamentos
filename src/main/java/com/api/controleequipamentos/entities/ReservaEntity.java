package com.api.controleequipamentos.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private EquipamentosEntity equipamento;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessoresEntity professor;

    private String dataReserva;  // Agora é uma string

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipamentosEntity getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentosEntity equipamento) {
        this.equipamento = equipamento;
    }

    public ProfessoresEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessoresEntity professor) {
        this.professor = professor;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    // Getters e setters
    // Construtores
}

