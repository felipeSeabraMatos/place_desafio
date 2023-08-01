package br.com.place.resource;

import br.com.place.model.Curso;
import br.com.place.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    public CursoResource(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    private ResponseEntity<List<Curso>> buscarCursos(){
        List<Curso> cursos = cursoService.buscarCurso();
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    private ResponseEntity<Curso> cadastrarCursos(@RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.cadastrarCurso(curso));
    }

    @PutMapping("/{cursoId}")
    private ResponseEntity<Curso> atualizarCursos(@PathVariable Long cursoId, @RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.atualizarCurso(curso, cursoId));
    }

    @DeleteMapping("/{cursoId}")
    private ResponseEntity<Void> deletarCursos(@PathVariable Long cursoId){
        cursoService.deletarCursos(cursoId);
        return ResponseEntity.noContent().build();
    }
}
