package com.grupoBom.sistemaDiretor.model.professor;

import com.grupoBom.sistemaDiretor.model.curso.Curso;
import javax.persistence.*;

@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private String numRegistro;
    @Column(nullable = false)
    private String cpf;
    @Enumerated(EnumType.STRING)
    private StatusProfessor status;

    @ManyToOne()
    @JoinColumn(name = "curso_id_fk")
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
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
}
