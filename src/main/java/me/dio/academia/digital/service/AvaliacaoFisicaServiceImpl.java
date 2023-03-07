package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private AlunoRepository alunoRepository;

    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository avaliacaoFisicaRepository, AlunoServiceImpl alunoService, AlunoRepository alunoRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaRepository.getById(id);
    }

    @Override
    @Transactional
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    @Transactional
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAluno(alunoRepository.findById(form.getAlunoId()).get());
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    @Transactional
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.getById(id);
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        return avaliacaoFisica;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        get(id);
        avaliacaoFisicaRepository.deleteById(id);
    }
}
