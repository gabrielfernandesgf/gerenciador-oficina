package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.PessoaFisicaDTO;
import com.PI.AutoGynService.entity.PessoaFisica;
import com.PI.AutoGynService.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePessoaFisica {
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    public void save(PessoaFisica pessoaFisica){
        pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaFisica findById(Long id){
        return pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    }

    public List<PessoaFisica> findAll(){
        return pessoaFisicaRepository.findAll();
    }

    public PessoaFisica update(PessoaFisicaDTO pessoaFisica, Long id) {
        PessoaFisica pessoaFisica1 = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));

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
}
