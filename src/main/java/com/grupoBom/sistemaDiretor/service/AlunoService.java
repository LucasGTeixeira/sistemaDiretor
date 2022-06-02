package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository) {
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
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
}
