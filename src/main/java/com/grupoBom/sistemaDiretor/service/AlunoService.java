package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.repository.AlunoRepository;
import com.grupoBom.sistemaDiretor.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository) {
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }
}
