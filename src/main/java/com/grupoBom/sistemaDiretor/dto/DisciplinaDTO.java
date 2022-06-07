package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.model.professor.Professor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class DisciplinaDTO {
    @NotBlank
    private String nome;
    @NotNull
    private Integer qntAulas;
    @NotNull
    private List<Aluno> listaAlunos;
    @NotNull
    private Professor professor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQntAulas() {
        return qntAulas;
    }

    public void setQntAulas(Integer qntAulas) {
        this.qntAulas = qntAulas;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina toDisciplina(){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(this.nome);
        disciplina.setQntAulas(this.qntAulas);
        disciplina.setProfessor(this.professor);
        disciplina.setListaAlunos(this.listaAlunos);
        return disciplina;
    }

    public Disciplina toDisciplina(Disciplina disciplina){
        disciplina.setNome(this.nome);
        disciplina.setQntAulas(this.qntAulas);
        disciplina.setProfessor(this.professor);
        disciplina.setListaAlunos(this.listaAlunos);
        return disciplina;
    }

    public void fromDisciplina(Disciplina disciplina){
        this.nome = disciplina.getNome();
        this.qntAulas = disciplina.getQntAulas();
        this.professor = disciplina.getProfessor();
        this.listaAlunos = disciplina.getListaAlunos();
    }

}
