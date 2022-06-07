package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.DisciplinaRepository;
import com.grupoBom.sistemaDiretor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository, AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public void saveDisciplina(Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }

    public void updateDisciplina(Disciplina disciplina){
        saveDisciplina(disciplina);
    }

    public void deleteDisciplinaById(Long id){
        disciplinaRepository.deleteById(id);
    }

    public Optional<Disciplina> findDisciplinaById(Long id){
        return disciplinaRepository.findById(id);
    }

}
