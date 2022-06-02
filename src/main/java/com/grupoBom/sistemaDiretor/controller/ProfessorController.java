package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.dto.ProfessorDTO;
import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;
import com.grupoBom.sistemaDiretor.service.DisciplinaService;
import com.grupoBom.sistemaDiretor.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;

    public ProfessorController(ProfessorService professorService, DisciplinaService disciplinaService) {
        this.professorService = professorService;
        this.disciplinaService = disciplinaService;
    }

    @Autowired


    @GetMapping("/listarProfessores")
    public ModelAndView getProfessores(){
        ModelAndView mv = new ModelAndView("professor/listaProfessores.html");
        List<Professor> listaProfessores = professorService.findProfessroes();
        mv.addObject("professores", listaProfessores);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView postProfessor(){
        ModelAndView mv = new ModelAndView("professor/cadastroProfessor.html");
        mv.addObject("professorStatus", StatusProfessor.values());
        List<Disciplina> listaDisciplinas = disciplinaService.getDisciplinas();
        mv.addObject("disciplinas", listaDisciplinas);
        return mv;
    }

    @PostMapping("/save")
    public String create(@Valid ProfessorDTO professorDTO, BindingResult result){
        if (result.hasErrors()){
            System.out.println("*****Erro Detectado*****");
            return "redirect:professores/new";
        }
        Professor professor = professorDTO.toProfessor();

        return "redirect:/professores/listarProfessores";
    }





}
