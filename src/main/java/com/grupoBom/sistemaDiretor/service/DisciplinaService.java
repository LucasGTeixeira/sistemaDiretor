package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.DisciplinaRepository;
import com.grupoBom.sistemaDiretor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
