package com.grupoBom.sistemaDiretor.dto;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.curso.Curso;
import com.grupoBom.sistemaDiretor.model.professor.Professor;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CursoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String codigo;

    private List<Aluno> alunos;

    private List<Professor> professores;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

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
        curso.setAlunos(this.alunos);
        curso.setProfessores(this.professores);
        return curso;
    }

    public Curso toCurso(Curso curso){
        curso.setNome(this.nome);
        curso.setCodigo(this.codigo);
        curso.setAlunos(this.alunos);
        curso.setProfessores(this.professores);
        return curso;
    }

    public void fromCurso(Curso curso){
        this.nome = curso.getNome();
        this.codigo = curso.getCodigo();
        this.professores = curso.getProfessores();
        this.alunos = curso.getAlunos();
    }
}
