package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.dto.ProfessorDTO;
import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;
import com.grupoBom.sistemaDiretor.service.CursoService;
import com.grupoBom.sistemaDiretor.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;
    private final CursoService cursoService;

    public ProfessorController(ProfessorService professorService, CursoService cursoService) {
        this.professorService = professorService;
        this.cursoService = cursoService;
    }

    @Autowired
    @GetMapping("/principalProfessor")
    public ModelAndView pricipalProfessor(){
        ModelAndView mv = new ModelAndView("professor/principalProfessor.html");
        return mv;
    }


    @GetMapping("/listarProfessores")
    public ModelAndView getProfessores(){
        ModelAndView mv = new ModelAndView("professor/listaProfessores.html");
        mv.addObject("professores", professorService.getProfessroes());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getFormProfessor(ProfessorDTO professorDTO){
        ModelAndView mv = new ModelAndView("professor/cadastroProfessor.html");
        mv.addObject("professorStatus", StatusProfessor.values());
        mv.addObject("cursos", cursoService.getCursos());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid ProfessorDTO professorDTO, BindingResult result){
        if (result.hasErrors()){
            System.out.println("*****Erro Detectado*****");
            System.out.println(professorDTO);
            ModelAndView mv = new ModelAndView("redirect:/professores/new");
            mv.addObject("professorStatus", StatusProfessor.values());
            mv.addObject("cursos", cursoService.getCursos());
            return mv;
        }
        System.out.println(professorDTO);
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

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, ProfessorDTO professorDTO){
        Optional<Professor> optionalProfessor = professorService.getProfessorById(id);
        if(optionalProfessor.isEmpty()){
            System.out.println("***** id não encontrado *****");
            return new ModelAndView("redirect:/professores/listarProfessores");
        }
        Professor professor = optionalProfessor.get();
        professorDTO.fromProfessor(professor);
        ModelAndView mv = new ModelAndView("professor/editarProfessor.html");
        mv.addObject("professorStatus", StatusProfessor.values());
        mv.addObject("professorId", professor.getId());
        mv.addObject("cursos", cursoService.getCursos());
        return mv;
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid ProfessorDTO professorDTO, BindingResult result){
        if(result.hasErrors()){
            System.out.println("**** erro durante o envio do formulário");
            ModelAndView mv = new ModelAndView("professor/editarProfessor");
            mv.addObject("professorStatus", StatusProfessor.values());
            mv.addObject("cursos", cursoService.getCursos());
            return mv;
        }
        Optional<Professor> optionalProfessor = professorService.getProfessorById(id);
        if(optionalProfessor.isEmpty()){
            System.out.println("id não encontrado");
            return new ModelAndView("redirect:/professores/listarProfessores");
        }
        Professor professor = professorDTO.toProfessor(optionalProfessor.get());
        professorService.saveProfessor(professor);
        return new ModelAndView("redirect:/professores/listarProfessores");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        try {
            professorService.deleteProfessorById(id);
            return new ModelAndView("redirect:/professores/listarProfessores");
        }
        catch (EmptyResultDataAccessException e){
            System.out.println(e);
            return new ModelAndView("redirect:/professores/listarProfessores");
        }
    }

}
