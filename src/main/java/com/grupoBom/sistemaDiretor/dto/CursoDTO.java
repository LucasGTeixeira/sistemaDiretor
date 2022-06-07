package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.curso.Curso;

import javax.validation.constraints.NotBlank;

public class CursoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String codigo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso toCurso(){
        Curso curso = new Curso();
        curso.setNome(this.nome);
        curso.setCodigo(this.codigo);
        return curso;
    }

    public Curso toCurso(Curso curso){
        curso.setNome(this.nome);
        curso.setCodigo(this.codigo);
        return curso;
    }

    public void fromCurso(Curso curso){
        this.nome = curso.getNome();
        this.codigo = curso.getCodigo();
    }
}
