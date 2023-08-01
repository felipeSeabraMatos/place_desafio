package br.com.place.resource;

import br.com.place.model.Turma;
import br.com.place.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaResource {

    @Autowired
    private TurmaService turmaService;

    public TurmaResource(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/{turmaId}")
    private ResponseEntity<List<Turma>> buscarTurma(){
        List<Turma> turmas = turmaService.buscarTurma();
        return ResponseEntity.ok().body(turmas);
    }

    @PostMapping("/{turmaId}")
    private ResponseEntity<Turma> cadastrarTurmas(@RequestBody Turma turma){
        return ResponseEntity.ok(turmaService.cadastrarTurma(turma));
    }

    @PutMapping("/{turmaId}")
    private ResponseEntity<Turma> atualizarTurmas(@PathVariable Long turmaId, @RequestBody Turma turma){
        return ResponseEntity.ok(turmaService.atualizarTurma(turma, turmaId));
    }

    @DeleteMapping("/{turmaId}")
    private ResponseEntity<Void> deletarTurmas(@PathVariable Long turmaId){
        turmaService.deletarTurma(turmaId);
        return ResponseEntity.noContent().build();
    }


}
