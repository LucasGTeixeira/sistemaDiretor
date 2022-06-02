package com.grupoBom.sistemaDiretor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @GetMapping("/listarAlunos")
    public String getAlunos(){
        return "aluno/listaAlunos";
    }
}
