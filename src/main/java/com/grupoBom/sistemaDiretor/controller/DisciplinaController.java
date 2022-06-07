package com.grupoBom.sistemaDiretor.controller;

import com.grupoBom.sistemaDiretor.dto.DisciplinaDTO;
import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.service.AlunoService;
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
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final AlunoService alunoService;
    private final ProfessorService professorService;

    public DisciplinaController(DisciplinaService disciplinaService, AlunoService alunoService, ProfessorService professorService) {
        this.disciplinaService = disciplinaService;
        this.alunoService = alunoService;
        this.professorService = professorService;
    }

    @Autowired


    @GetMapping("/listarDisciplinas")
    public ModelAndView getDisciplinas(){
        ModelAndView mv = new ModelAndView("disciplina/listaDisciplinas.html");
        List<Disciplina> listaDisciplinas = disciplinaService.getDisciplinas();
        mv.addObject("disciplinas", listaDisciplinas);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getFormDisciplina(DisciplinaDTO disciplinaDTO){
        ModelAndView mv = new ModelAndView("disciplina/cadastroDisciplina.html");
        mv.addObject("professores", professorService.getProfessroes());
        mv.addObject("alunos", alunoService.getAlunos());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView create(@Valid DisciplinaDTO disciplinaDTO, BindingResult result){
        if(result.hasErrors()){
            System.out.println("****** erro de validação ******");
            ModelAndView mv = new ModelAndView("disciplina/cadastroDisciplina.html");
            mv.addObject("alunos", alunoService.getAlunos());
            mv.addObject("professores", professorService.getProfessroes());
            return mv;
        }
        Disciplina disciplina = disciplinaDTO.toDisciplina();
        disciplinaService.saveDisciplina(disciplina);
        return new ModelAndView("disciplina/listaDisciplinas.html");
    }

    //TODO update e delete + configuração das páginas html
}
