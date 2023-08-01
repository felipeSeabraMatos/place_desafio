package br.com.place.service;

import br.com.place.model.Turma;
import br.com.place.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> buscarTurma() {
        List<Turma> turma = turmaRepository.findAll();
        return turma;
    }

    public Turma cadastrarTurma(Turma turma) {
        return turmaRepository.save(turma);

    }

    public Turma atualizarTurma(Turma turma, Long turmaId) {
        Optional<Turma> turmaExistente = turmaRepository.findById(turmaId);
        if (turmaExistente.isPresent()) {
            turma.setId(turmaExistente.get().getId());


        }
        return turmaRepository.save(turma);

    }

    public void deletarTurma(Long turmaId) {
        turmaRepository.deleteById(turmaId);
    }
}

