package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, AlunoRepository alunoRepository) {
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }
}
