package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.repository.CursoRepository;
import com.grupoBom.sistemaDiretor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, CursoRepository cursoRepository) {
        this.professorRepository = professorRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Professor> getProfessroes(){
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

    public Optional<Professor> getProfessorById(Long id){
        return professorRepository.findById(id);
    }
}
