package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;
import com.grupoBom.sistemaDiretor.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorConstroller {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorConstroller(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/listarProfessores")
    public ModelAndView getProfessores(){
        ModelAndView mv = new ModelAndView("professor/listaProfessores.html");
        List<Professor> listaProfessores = professorService.getProfessroes();
        mv.addObject("professores", listaProfessores);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView postProfessor(){
        ModelAndView mv = new ModelAndView("professor/cadastroProfessor");
        mv.addObject("professorStatus", StatusProfessor.values());
        return mv;
    }





}
