package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.AvaliacaoFisicaServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;


    public AvaliacaoFisicaController(AvaliacaoFisicaServiceImpl avaliacaoFisicaService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    @GetMapping()
    public List<AvaliacaoFisica> getAllAvaliacao(){
        List<AvaliacaoFisica> listAvaliacaoFisica = avaliacaoFisicaService.getAll();
        return listAvaliacaoFisica;
    }
    @GetMapping("/{id}")
    public AvaliacaoFisica getAvaliacao(@PathVariable("id") Long id){
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.get(id);
        return avaliacaoFisica;
    }

    @PostMapping
    public AvaliacaoFisica createAvaliacao(@Valid @RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm){
        return avaliacaoFisicaService.create(avaliacaoFisicaForm);
    }
    @PutMapping("/{id}")
    public AvaliacaoFisica updateAvaliacao(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm){
        return avaliacaoFisicaService.update(id, avaliacaoFisicaUpdateForm);
    }

    @DeleteMapping("/{id}")
    public void deleteAvaliacao(@PathVariable("id") Long id){
        avaliacaoFisicaService.delete(id);
    }
}
