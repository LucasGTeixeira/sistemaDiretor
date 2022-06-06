package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.dto.AlunoDTO;
import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.aluno.StatusAluno;
import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.service.AlunoService;
import com.grupoBom.sistemaDiretor.service.DisciplinaService;
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
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;

    @Autowired
    public AlunoController(AlunoService alunoService, DisciplinaService disciplinaService) {
        this.alunoService = alunoService;
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("/listarAlunos")
    public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("aluno/listaAlunos.html");
        List<Aluno> listaAlunos = alunoService.getAlunos();
        mv.addObject("alunos", listaAlunos);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getFormAluno(AlunoDTO alunoDTO){
        ModelAndView mv = new ModelAndView("aluno/cadastroAluno.html");
        mv.addObject("alunoStatus", StatusAluno.values());
        List<Disciplina> listaDisciplinas = disciplinaService.getDisciplinas();
        mv.addObject("disciplinas", listaDisciplinas);
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid AlunoDTO alunoDTO, BindingResult result){
        if(result.hasErrors()){
            System.out.println("****** Erro na requisição ******");
            return new ModelAndView("aluno/cadastroAluno.html");
        }
        Aluno aluno = alunoDTO.toAluno();
        alunoService.saveAluno(aluno);
        return new ModelAndView("redirect:/alunos/listarAlunos");
    }
}
