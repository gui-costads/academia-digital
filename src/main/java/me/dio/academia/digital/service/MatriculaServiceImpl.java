package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
    private AlunoRepository alunoRepository;
    private MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(AlunoRepository alunoRepository, MatriculaRepository matriculaRepository) {
        this.alunoRepository = alunoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula create(MatriculaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        return matricula;
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }
}
