package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, AlunoRepository alunoRepository) {
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Professor> findProfessroes(){
        return professorRepository.findAll();
    }

    public void saveProfessor(Professor professor){
        professorRepository.save(professor);
    }

    public void updateProfessor(Professor professor){
        saveProfessor(professor);
    }

    public void deleteProfessorById(Long id){
        professorRepository.deleteById(id);
    }
}
