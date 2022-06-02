package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.aluno.StatusAluno;
import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlunoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String registroAluno;
    @NotNull
    private StatusAluno status;

    private List<Disciplina> listaDisciplinas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroAluno() {
        return registroAluno;
    }

    public void setRegistroAluno(String registroAluno) {
        this.registroAluno = registroAluno;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
}
