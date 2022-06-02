package com.grupoBom.sistemaDiretor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @GetMapping("/listarDisciplinas")
    public String getDisciplinas(){
        return "disciplina/listaDisciplinas.html";
    }
}
