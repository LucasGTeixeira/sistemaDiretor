package com.grupoBom.sistemaDiretor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professores")
public class ProfessorConstroller {

    @GetMapping("/listarProfessores")
    public String getProfessores(){
        return "professor/listaProfessores.html";
    }
}
