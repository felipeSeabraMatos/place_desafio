package br.com.place.service;

import br.com.place.model.Curso;
import br.com.place.repository.CursoRepository;
import br.com.place.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Curso> buscarCurso() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos;

    }

    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);

    }

    public Curso atualizarCurso(Curso curso, Long cursoId) {
        Optional<Curso> cursoExistente = cursoRepository.findById(cursoId);
        if(cursoExistente.isPresent()){
            curso.setId(cursoExistente.get().getId());


        }
        return cursoRepository.save(curso);

    }

    public void deletarCursos(Long cursoId) {
        cursoRepository.deleteById(cursoId);

    }
}
