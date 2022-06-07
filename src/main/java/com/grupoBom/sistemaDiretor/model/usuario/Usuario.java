package com.grupoBom.sistemaDiretor.model.usuario;

import com.grupoBom.sistemaDiretor.model.usuario.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayDeque;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String username;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayDeque<>();
}
