package com.grupoBom.sistemaDiretor.model.professor;

public enum StatusProfessor {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    EM_LICENCA("Em licença"),
    APOSENTADO("Aposentado");

    final String descricao;

    StatusProfessor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
