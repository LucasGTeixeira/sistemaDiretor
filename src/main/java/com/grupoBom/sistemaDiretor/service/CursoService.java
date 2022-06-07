package com.grupoBom.sistemaDiretor.service;

import com.grupoBom.sistemaDiretor.model.curso.Curso;
import com.grupoBom.sistemaDiretor.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    public void saveCurso(Curso curso){
        cursoRepository.save(curso);
    }

    public void updateCurso(Curso curso){
        saveCurso(curso);
    }

    public void deleteCursoById(Long id){
        cursoRepository.deleteById(id);
    }

    public Optional<Curso> findCursoById(Long id){
        return cursoRepository.findById(id);
    }
}
