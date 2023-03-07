package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.MatriculaServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    private MatriculaServiceImpl matriculaService;

    public MatriculaController(MatriculaServiceImpl matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> getAllMatricula(){
        List<Matricula> listMatricula = matriculaService.getAll();
        return listMatricula;
    }

    @PostMapping()
    public Matricula createMatricula(@Valid @RequestBody MatriculaForm matriculaForm){
        return matriculaService.create(matriculaForm);
    }

    @DeleteMapping("/{id}")
    public void deleteMatricula(@PathVariable("id") Long id){
        matriculaService.delete(id);
    }

}
