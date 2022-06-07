package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
