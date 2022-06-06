package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProfessorDTO {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String numRegistro;
    @NotBlank
    private String cpf;
    @NotNull
    private StatusProfessor status;
    //pode ser null pois o professor será nosso elemento independente (assim como aluno)
    private List<Disciplina> listDisciplinas;

    public ProfessorDTO(String nomeCompleto, String numRegistro, String cpf, StatusProfessor status, List<Disciplina> listDisciplinas) {
        this.nomeCompleto = nomeCompleto;
        this.numRegistro = numRegistro;
        this.cpf = cpf;
        this.status = status;
        this.listDisciplinas = listDisciplinas;
    }

    public ProfessorDTO() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusProfessor getStatus() {
        return status;
    }

    public void setStatus(StatusProfessor status) {
        this.status = status;
    }

    public List<Disciplina> getListDisciplinas() {
        return listDisciplinas;
    }

    public void setListDisciplinas(List<Disciplina> listDisciplinas) {
        this.listDisciplinas = listDisciplinas;
    }

    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNomeCompleto(this.nomeCompleto);
        professor.setNumRegistro(this.numRegistro);
        professor.setCpf(this.cpf);
        professor.setStatus(this.status);
        return professor;
    }
}
