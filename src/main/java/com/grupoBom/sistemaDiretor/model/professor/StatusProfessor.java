package com.grupoBom.sistemaDiretor.model.professor;

public enum StatusProfessor {
    ATIVO("ativo"),
    INATIVO("inativo"),
    EM_LICENCA("em licença");

    final String descricao;

    StatusProfessor(String descricao) {
        this.descricao = descricao;
    }
}
