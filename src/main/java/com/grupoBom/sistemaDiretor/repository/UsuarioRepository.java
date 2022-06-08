package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.login.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByUsername(String username);
}
