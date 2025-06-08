package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.PessoaFisicaDTO;
import com.PI.AutoGynService.entity.PessoaFisica;
import com.PI.AutoGynService.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePessoaFisica {
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    public List<PessoaFisica> findAll(){
        return pessoaFisicaRepository.findAll();
    }

    public PessoaFisica findById(Long id){
        return pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    }

    public PessoaFisica save(PessoaFisicaDTO pessoaFisicaDTO){
        if (pessoaFisicaDTO.getCpf() == null || pessoaFisicaDTO.getCpf().length() != 11)
            throw new RuntimeException("CPF inválido.");
        if (pessoaFisicaDTO.getDataDeNascimento() == null || pessoaFisicaDTO.getDataDeNascimento().toString().trim().isEmpty())
            throw new RuntimeException("Data de nascimento inválida");

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf(pessoaFisicaDTO.getCpf());
        pessoaFisica.setDataDeNascimento(pessoaFisicaDTO.getDataDeNascimento());

        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaFisica update(PessoaFisica pessoaFisica) {
        PessoaFisica pessoaFisica1 = pessoaFisicaRepository.findById(pessoaFisica.getId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + pessoaFisica.getId()));

        if (pessoaFisica.getCpf() != null) {
            pessoaFisica1.setCpf(pessoaFisica.getCpf());
        }
        if (pessoaFisica.getCep() != null) {
            pessoaFisica1.setCep(pessoaFisica.getCep());
        }
        if (pessoaFisica.getEmail() != null) {
            pessoaFisica1.setEmail(pessoaFisica.getEmail());
        }
        if (pessoaFisica.getNome() != null) {
            pessoaFisica1.setNome(pessoaFisica.getNome());
        }
        if (pessoaFisica.getDataDeNascimento() != null) {
            pessoaFisica1.setDataDeNascimento(pessoaFisica.getDataDeNascimento());
        }
        if (pessoaFisica.getEndereco() != null) {
            pessoaFisica1.setEndereco(pessoaFisica.getEndereco());
        }
        if (pessoaFisica.getTelefone() != null) {
            pessoaFisica1.setTelefone(pessoaFisica.getTelefone());
        }

        return pessoaFisicaRepository.save(pessoaFisica1);
    }

    public void delete(Long id) {
        pessoaFisicaRepository.deleteById(id);
    }
}
