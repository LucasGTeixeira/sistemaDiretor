package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }

    public void saveAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public void updateAluno(Aluno aluno){
        saveAluno(aluno);
    }

    public void deleteAlunoById(Long id){
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> findAlunoById(Long id){
        return alunoRepository.findById(id);
    }
}
