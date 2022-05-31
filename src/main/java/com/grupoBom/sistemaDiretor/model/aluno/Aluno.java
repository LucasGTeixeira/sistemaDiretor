package com.grupoBom.sistemaDiretor.model.aluno;

import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String registroAluno;
    @Enumerated(EnumType.STRING)
    private StatusAluno status;

    @ManyToMany(mappedBy = "listaAlunos")
    private List<Disciplina> listaDisciplinas;

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
