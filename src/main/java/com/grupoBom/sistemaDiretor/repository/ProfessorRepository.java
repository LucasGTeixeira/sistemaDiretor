package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findProfessorsByStatus(StatusProfessor status);

    Professor findProfessorByNumRegistro(String numRegistro);
}
