package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/listarDisciplinas")
    public ModelAndView getDisciplinas(){
        ModelAndView mv = new ModelAndView("disciplina/listaDisciplinas.html");
        List<Disciplina> listaDisciplinas = disciplinaService.getDisciplinas();
        mv.addObject(listaDisciplinas);
        return mv;
    }
}
