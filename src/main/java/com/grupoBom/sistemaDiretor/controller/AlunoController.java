package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.dto.AlunoDTO;
import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.aluno.StatusAluno;
import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.service.AlunoService;
import com.grupoBom.sistemaDiretor.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @GetMapping("show/{id}")
    public ModelAndView show(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("aluno/detalhesAluno.html");
        Optional<Aluno> optionalAluno = alunoService.findAlunoById(id);
        if(optionalAluno.isEmpty()){
            System.out.println("id não encontrado");
            return new ModelAndView("redirect:/alunos/listarAlunos");
        }
        Aluno aluno = optionalAluno.get();
        mv.addObject("aluno", aluno);
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, AlunoDTO alunoDTO){
        Optional<Aluno> optionalAluno = alunoService.findAlunoById(id);
        if(optionalAluno.isEmpty()){
            System.out.println("***** id não encontrado *****");
            return new ModelAndView("redirect:/alunos/listarAlunos");
        }
        Aluno aluno = optionalAluno.get();
        alunoDTO.fromAluno(aluno);
        ModelAndView mv = new ModelAndView("aluno/editarAluno.html");
        mv.addObject("alunoStatus", StatusAluno.values());
        mv.addObject("alunoId", aluno.getId());
        mv.addObject("disciplinas", disciplinaService.getDisciplinas());
        return mv;
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid AlunoDTO alunoDTO, BindingResult result){
        if(result.hasErrors()){
            System.out.println("***** erro de validação *****");
            ModelAndView mv = new ModelAndView("redirect:/alunos/listarAlunos");
            mv.addObject("alunoStatus", StatusAluno.values());
            mv.addObject("disciplinas", disciplinaService.getDisciplinas());
            return mv;
        }
        Optional<Aluno> optionalAluno = alunoService.findAlunoById(id);
        if(optionalAluno.isEmpty()){
            System.out.println("id não encontrado");
            return new ModelAndView("redirect:/alunos/listarAlunos");
        }
        Aluno aluno = alunoDTO.toAluno(optionalAluno.get());
        alunoService.saveAluno(aluno);
        return new ModelAndView("redirect:/alunos/listarAlunos");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        try {
            alunoService.deleteAlunoById(id);
            return new ModelAndView("redirect:/alunos/listarAlunos");
        }
        catch (EmptyResultDataAccessException e){
            System.out.println(e);
            return new ModelAndView("redirect:/alunos/listarAlunos");
        }
    }
}
