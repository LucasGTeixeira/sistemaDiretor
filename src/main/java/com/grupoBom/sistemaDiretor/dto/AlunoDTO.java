package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
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

    public Aluno toAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setRegistroAluno(this.registroAluno);
        aluno.setStatus(this.status);
        aluno.setListaDisciplinas(this.listaDisciplinas);
        return aluno;
    }

    public Aluno toAluno(Aluno aluno){
        aluno.setNome(this.nome);
        aluno.setRegistroAluno(this.registroAluno);
        aluno.setStatus(this.status);
        aluno.setListaDisciplinas(this.listaDisciplinas);
        return aluno;
    }

    public void fromAluno(Aluno aluno){
        this.nome = aluno.getNome();
        this.registroAluno = aluno.getRegistroAluno();
        this.status = aluno.getStatus();
        this.listaDisciplinas = aluno.getListaDisciplinas();
    }
}
