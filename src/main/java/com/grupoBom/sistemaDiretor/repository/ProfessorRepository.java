package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.professor.Professor;
import com.grupoBom.sistemaDiretor.model.professor.StatusProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor>findProfessorsByStatus(StatusProfessor status);

    Professor findProfessorByNumRegistro(String numRegistro);
}
