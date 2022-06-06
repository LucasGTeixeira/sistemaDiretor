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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        List<Professor> listaProfessores = professorService.getProfessroes();
        mv.addObject("professores", listaProfessores);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getFormProfessor(ProfessorDTO professorDTO){
        ModelAndView mv = new ModelAndView("professor/cadastroProfessor.html");
        mv.addObject("professorStatus", StatusProfessor.values());
        List<Disciplina> listaDisciplinas = disciplinaService.getDisciplinas();
        mv.addObject("disciplinas", listaDisciplinas);
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid ProfessorDTO professorDTO, BindingResult result){
        if (result.hasErrors()){
            System.out.println("*****Erro Detectado*****");
            ModelAndView mv = new ModelAndView("redirect:professores/new");
            mv.addObject("professorStatus", StatusProfessor.values());
            return mv;
        }
        Professor professor = professorDTO.toProfessor();
        professorService.saveProfessor(professor);
        return new ModelAndView("redirect:/professores/listarProfessores");
    }

    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("professor/detalhesProfessor");
        Optional<Professor> optionalProfessor = professorService.getProfessorById(id);
        if(optionalProfessor.isEmpty()) {
            System.out.println("id não encontrado");
            return new ModelAndView("redirect:/professores/listarProfessores");
        }
        Professor professor = optionalProfessor.get();
        mv.addObject("professor", professor);
        return mv;
    }





}
