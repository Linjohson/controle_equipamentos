package com.api.controleequipamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.controleequipamentos.entities.ProfessoresEntity;
import com.api.controleequipamentos.entities.EquipamentosEntity;
import com.api.controleequipamentos.repository.ProfessoresRepository;
import com.api.controleequipamentos.repository.EquipamentosRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
	
    private final ProfessoresRepository professoresRepository;

	@Autowired
    private EquipamentosRepository equipamentosRepository;
	public AdministradorController(ProfessoresRepository professoresRepository) {
        this.professoresRepository = professoresRepository;
    }
	

    // Listar todos os equipamentos
    @GetMapping("/listarEquipamentos")
    public List<EquipamentosEntity> getAllEquipamentos() {
        return equipamentosRepository.findAll();
    }

    // Obter um equipamento por ID
    @GetMapping("/listarEquipamentos/{id}")
    public ResponseEntity<EquipamentosEntity> getEquipamentoById(@PathVariable Long id) {
        Optional<EquipamentosEntity> equipamento = equipamentosRepository.findById(id);
        return equipamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

 // Adicionar um novo equipamento
    @PostMapping("/adicionarEquipamento")
    public ResponseEntity<?> adicionarEquipamento(@RequestBody EquipamentosEntity equipamento) {
        // Verificar se já existe um equipamento com o mesmo número de série
        Optional<EquipamentosEntity> existingEquipamento = equipamentosRepository.findByNumeroSerie(equipamento.getNumeroSerie());

        if (existingEquipamento.isPresent()) {
            return ResponseEntity.badRequest().body("Esse equipamento com número de série " + equipamento.getNumeroSerie() + " já foi cadastrado.");
        } else {
            EquipamentosEntity savedEquipamento = equipamentosRepository.save(equipamento);
            return ResponseEntity.ok(savedEquipamento);
        }
    }

    @PutMapping("/atualizarEquipamento/{id}")
    public ResponseEntity<?> atualizarEquipamento(@PathVariable Long id, @RequestBody EquipamentosEntity equipamento) {
        Optional<EquipamentosEntity> existingEquipamentoWithSameNumeroSerie = equipamentosRepository.findByNumeroSerie(equipamento.getNumeroSerie());

        if (existingEquipamentoWithSameNumeroSerie.isPresent() && !existingEquipamentoWithSameNumeroSerie.get().getId().equals(id)) {
            return ResponseEntity.badRequest().body("Já existe um equipamento com o mesmo número de série.");
        } else {
            Optional<EquipamentosEntity> existingEquipamento = equipamentosRepository.findById(id);

            if (existingEquipamento.isPresent()) {
                EquipamentosEntity updatedEquipamento = existingEquipamento.get();
                updatedEquipamento.setNome(equipamento.getNome());
                updatedEquipamento.setNumeroSerie(equipamento.getNumeroSerie());

                EquipamentosEntity savedEquipamento = equipamentosRepository.save(updatedEquipamento);
                return ResponseEntity.ok(savedEquipamento);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }


    // Deletar um equipamento por ID
    @DeleteMapping("/deletarEquipamento/{id}")
    public ResponseEntity<?> deletarEquipamento(@PathVariable Long id) {
        Optional<EquipamentosEntity> existingEquipamento = equipamentosRepository.findById(id);

        if (existingEquipamento.isPresent()) {
            equipamentosRepository.deleteById(id);
            return ResponseEntity.ok("Equipamento excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    
    //ProfessoresEntity
    
    //Listar professores
    @GetMapping("/listarProfessores")
    public List<ProfessoresEntity> listarProfessores() {
        return professoresRepository.findAll();
    }
    
    //Listar um professor por ID
    @GetMapping("/listarProfessores/{id}")
    public ProfessoresEntity buscarProfessorPorId(@PathVariable Long id) {
        return professoresRepository.findById(id).orElse(null);
    }
    
    //Adicionar um professor por ID
    @PostMapping("/adicionarProfessor")
    public ResponseEntity<?> adicionarProfessor(@RequestBody ProfessoresEntity professor) {
        // Verificar se já existe um professor com a mesma matrícula
        Optional<ProfessoresEntity> existingProfessor = professoresRepository.findByMatricula(professor.getMatricula());

        if (existingProfessor.isPresent()) {
            // Um professor com a mesma matrícula já existe, retorne um erro ou mensagem adequada
            return ResponseEntity.badRequest().body("Já existe um professor com a mesma matrícula.");
        } else {
            // Não existe um professor com a mesma matrícula, então podemos salvar o novo professor
        	ProfessoresEntity savedProfessor = professoresRepository.save(professor);
            return ResponseEntity.ok(savedProfessor);
        }
    }
    
    //Atualizar um professor por ID
    @PutMapping("/atualizarProfessor/{id}")
    public ResponseEntity<?> atualizarProfessor(@PathVariable Long id, @RequestBody ProfessoresEntity professor) {
        // Verificar se já existe um professor com a mesma matrícula
        Optional<ProfessoresEntity> existingProfessorWithSameMatricula = professoresRepository.findByMatricula(professor.getMatricula());

        if (existingProfessorWithSameMatricula.isPresent() && !existingProfessorWithSameMatricula.get().getId().equals(id)) {
            // Um professor com a mesma matrícula já existe e não é o mesmo professor que estamos atualizando.
            return ResponseEntity.badRequest().body("Já existe um professor com a mesma matrícula.");
        } else {
            // Prossiga com a atualização do professor, pois a matrícula é única ou não existe conflito.
            Optional<ProfessoresEntity> existingProfessor = professoresRepository.findById(id);

            if (existingProfessor.isPresent()) {
                // Atualize os dados do professor existente com os novos dados
                ProfessoresEntity updatedProfessor = existingProfessor.get();
                updatedProfessor.setNome(professor.getNome());
                updatedProfessor.setMatricula(professor.getMatricula());
                // Atualize outros atributos, se necessário

                ProfessoresEntity savedProfessor = professoresRepository.save(updatedProfessor);
                return ResponseEntity.ok(savedProfessor);
            } else {
                // Se o professor com o ID especificado não existe, retorne um erro adequado.
                return ResponseEntity.notFound().build();
            }
        }
    }

    //Deletar um professor por ID
    @DeleteMapping("/deletarProfessor/{id}")
    public ResponseEntity<?> deletarProfessor(@PathVariable Long id) {
        Optional<ProfessoresEntity> existingProfessor = professoresRepository.findById(id);

        if (existingProfessor.isPresent()) {
            professoresRepository.deleteById(id);
            return ResponseEntity.ok("Professor excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

