package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.curso.Curso;
import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProfessorDTO {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String numRegistro;
    @NotBlank
    private String cpf;
    @NotNull
    private StatusProfessor status;
    @NotNull
    private Curso curso;


    public ProfessorDTO(String nomeCompleto, String numRegistro, String cpf, StatusProfessor status, Curso curso) {
        this.nomeCompleto = nomeCompleto;
        this.numRegistro = numRegistro;
        this.cpf = cpf;
        this.status = status;
        this.curso = curso;
    }

    public ProfessorDTO() {
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNomeCompleto(this.nomeCompleto);
        professor.setNumRegistro(this.numRegistro);
        professor.setCpf(this.cpf);
        professor.setStatus(this.status);
        professor.setCurso(this.curso);
        return professor;
    }

    public Professor toProfessor(Professor professor){
        professor.setNomeCompleto(this.nomeCompleto);
        professor.setCpf(this.cpf);
        professor.setNumRegistro(this.numRegistro);
        professor.setStatus(this.status);
        professor.setCurso(this.curso);
        return professor;
    }

    public void fromProfessor(Professor professor){
        this.nomeCompleto = professor.getNomeCompleto();
        this.cpf = professor.getCpf();
        this.numRegistro = professor.getNumRegistro();
        this.status = professor.getStatus();
        this.curso = professor.getCurso();
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", numRegistro='" + numRegistro + '\'' +
                ", cpf='" + cpf + '\'' +
                ", status=" + status +
                ", curso=" + curso +
                '}';
    }
}
