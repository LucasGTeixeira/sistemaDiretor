package com.grupoBom.sistemaDiretor.repository;

import com.grupoBom.sistemaDiretor.model.aluno.Aluno;
import com.grupoBom.sistemaDiretor.model.aluno.StatusAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findAlunosByStatus(StatusAluno statusAluno);

    Aluno findAlunoByRegistroAluno(String registroAluno);
}






