package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listarAlunos")
    public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("aluno/listaAlunos");
        List<Aluno> listaAlunos = alunoService.getAlunos();
        mv.addObject(listaAlunos);
        return mv;
    }
}
