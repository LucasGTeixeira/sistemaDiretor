package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
