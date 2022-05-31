package com.grupoBom.sistemaDiretor.model.disciplina;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.professor.Professor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer qntAulas;

    @ManyToMany(mappedBy = "listaDisciplinas")
    private List<Aluno> listaAlunos;

    @ManyToOne
    @JoinColumn(name = "professor_id_fk")
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
