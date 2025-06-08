package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.PessoaJuridicaDTO;
import com.PI.AutoGynService.entity.PessoaJuridica;
import com.PI.AutoGynService.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePessoaJuridica {
    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    public void save(PessoaJuridica pessoaJuridica){
        pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaJuridica findById(Long id){
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    }

    public List<PessoaJuridica> findAll(){
        return pessoaJuridicaRepository.findAll();
    }

    public PessoaJuridica update(PessoaJuridicaDTO pessoaJuridica) {
        PessoaJuridica pessoaJuridica1 = pessoaJuridicaRepository.findById(pessoaJuridica.getId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + pessoaJuridica.getId()));

        if (pessoaJuridica.getCep() != null) {
            pessoaJuridica1.setCep(pessoaJuridica.getCep());
        }
        if (pessoaJuridica.getEmail() != null) {
            pessoaJuridica.setEmail(pessoaJuridica.getEmail());
        }
        if (pessoaJuridica.getNome() != null) {
            pessoaJuridica1.setNome(pessoaJuridica.getNome());
        }

        if (pessoaJuridica.getEndereco() != null) {
            pessoaJuridica.setEndereco(pessoaJuridica.getEndereco());
        }
        if (pessoaJuridica.getTelefone() != null) {
            pessoaJuridica1.setTelefone(pessoaJuridica.getTelefone());
        }
        if(pessoaJuridica.getCnpj() != null){
            pessoaJuridica1.setCnpj(pessoaJuridica.getCnpj());
        }
        if(pessoaJuridica.getContatoResponsavel() != null){
            pessoaJuridica1.setContatoResponsavel(pessoaJuridica.getContatoResponsavel());
        }
        if(pessoaJuridica.getNomeResposavel() != null){
            pessoaJuridica1.setNomeResposavel(pessoaJuridica.getNomeResposavel());
        }
        if(pessoaJuridica.getRazaoSocial() != null){
            pessoaJuridica1.setRazaoSocial(pessoaJuridica.getRazaoSocial());
        }
        if(pessoaJuridica.getInscricaoSocial() != null){
            pessoaJuridica1.setInscricaoSocial(pessoaJuridica.getInscricaoSocial());
        }

        return pessoaJuridicaRepository.save(pessoaJuridica1);
    }

    public void delete(Long id) {
        pessoaJuridicaRepository.deleteById(id);
    }
}
