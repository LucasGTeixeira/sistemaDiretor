package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.usuario.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNome(String nome);
}
