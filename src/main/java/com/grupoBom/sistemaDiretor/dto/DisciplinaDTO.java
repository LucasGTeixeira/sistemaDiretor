package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
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
}
