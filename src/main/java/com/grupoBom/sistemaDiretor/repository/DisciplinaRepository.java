package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.disciplina.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findDisciplinasByNome(String name);

    Optional<Disciplina> findDisciplinaByNome(String nome);

}
