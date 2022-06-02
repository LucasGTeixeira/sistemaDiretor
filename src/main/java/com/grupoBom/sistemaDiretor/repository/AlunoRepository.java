package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.aluno.StatusAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findAlunosByStatus(StatusAluno statusAluno);

    Aluno findAlunoByRegistroAluno(String registroAluno);
}
