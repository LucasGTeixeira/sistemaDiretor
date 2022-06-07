package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.dto.CursoDTO;
import com.grupoBom.sistemaDiretor.dto.CursoDTO;
import com.grupoBom.sistemaDiretor.model.curso.Curso;
import com.grupoBom.sistemaDiretor.service.CursoService;
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
import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/listarCursos")
    public ModelAndView getCursos(){
        ModelAndView mv = new ModelAndView("curso/listaCursos.html");
        mv.addObject("cursos", cursoService.getCursos());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getFormCurso(CursoDTO cursoDTO){
        ModelAndView mv = new ModelAndView("curso/cadastroCurso.html");
        mv.addObject("cursos", cursoService.getCursos());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid CursoDTO cursoDTO, BindingResult result){
        if(result.hasErrors()){
            System.out.println("****** Erro na requisição ******");
            return new ModelAndView("curso/cadastroCurso.html");
        }
        Curso curso = cursoDTO.toCurso();
        cursoService.saveCurso(curso);
        return new ModelAndView("redirect:/cursos/listarCursos");
    }


    @GetMapping("show/{id}")
    public ModelAndView show(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("curso/detalhesCurso.html");
        Optional<Curso> optionalCurso = cursoService.findCursoById(id);
        if(optionalCurso.isEmpty()){
            System.out.println("id não encontrado");
            return new ModelAndView("redirect:/cursos/listarCursos");
        }
        Curso curso = optionalCurso.get();
        mv.addObject("curso", curso);
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, CursoDTO cursoDTO){
        Optional<Curso> optionalCurso = cursoService.findCursoById(id);
        if(optionalCurso.isEmpty()){
            System.out.println("***** id não encontrado *****");
            return new ModelAndView("redirect:/cursos/listarCursos");
        }
        Curso curso = optionalCurso.get();
        cursoDTO.fromCurso(curso);
        ModelAndView mv = new ModelAndView("curso/editarCurso.html");
        mv.addObject("cursoId", curso.getId());
        mv.addObject("cursos", cursoService.getCursos());
        return mv;
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid CursoDTO cursoDTO, BindingResult result){
        if(result.hasErrors()){
            System.out.println("***** erro de validação *****");
            return new ModelAndView("redirect:/cursos/listarCursos");
        }
        Optional<Curso> optionalCurso = cursoService.findCursoById(id);
        if(optionalCurso.isEmpty()){
            System.out.println("id não encontrado");
            return new ModelAndView("redirect:/cursos/listarCursos");
        }
        Curso curso = cursoDTO.toCurso(optionalCurso.get());
        cursoService.saveCurso(curso);
        return new ModelAndView("redirect:/cursos/listarCursos");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id){
        try {
            cursoService.deleteCursoById(id);
            return new ModelAndView("redirect:/cursos/listarCursos");
        }
        catch (EmptyResultDataAccessException e){
            System.out.println(e);
            return new ModelAndView("redirect:/cursos/listarCursos");
        }
    }









}
