package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
