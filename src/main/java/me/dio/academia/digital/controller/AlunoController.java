package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.AlunoServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoServiceImpl alunoService;

    public AlunoController(AlunoServiceImpl service) {
        this.alunoService = service;
    }
    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
        return alunoService.getAll(dataDeNascimento);
    }
    @PostMapping
    public Aluno createAluno(@Valid @RequestBody AlunoForm form){

        return alunoService.create(form);
    }
    @GetMapping("avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable("id") Long id){
        return alunoService.getAllAvaliacaoFisica(id);
    }
    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable("id") Long id, @Valid @RequestBody AlunoUpdateForm alunoUpdateForm){
        return alunoService.update(id, alunoUpdateForm);
    }
    @DeleteMapping("/{id}")
        public void deleteAluno(@PathVariable("id") Long id){
        alunoService.delete(id);
    }
}
