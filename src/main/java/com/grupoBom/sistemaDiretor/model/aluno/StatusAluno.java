package com.grupoBom.sistemaDiretor.model.aluno;

public enum StatusAluno {
    ATIVO("ativo"),
    INATIVO("inativo");

    final String descricao;

    StatusAluno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
