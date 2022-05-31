package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
