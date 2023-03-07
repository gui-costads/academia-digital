package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    private AlunoRepository alunoRepository;
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository,
                            AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.alunoRepository = alunoRepository;
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Aluno get(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return alunoRepository.findAll();
        }
        LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
        return alunoRepository.findByDataDeNascimento(localDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno.getAvaliacoes();
    }

    @Override
    @Transactional
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    @Transactional
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = alunoRepository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        get(id);
        alunoRepository.deleteById(id);
    }

}
