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

    public List<PessoaJuridica> findAll(){
        return pessoaJuridicaRepository.findAll();
    }

    public PessoaJuridica findById(Long id){
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    }

    public PessoaJuridica save(PessoaJuridicaDTO pessoaJuridicaDTO){
        if (pessoaJuridicaDTO.getCnpj() == null || pessoaJuridicaDTO.getCnpj().length() != 14)
            throw new RuntimeException("CNPJ informado não é válido.");
        if (pessoaJuridicaDTO.getInscricaoSocial() == null || pessoaJuridicaDTO.getInscricaoSocial().trim().isEmpty())
            throw new RuntimeException("Informe a inscrição estadual.");
        if (pessoaJuridicaDTO.getRazaoSocial() == null || pessoaJuridicaDTO.getRazaoSocial().trim().isEmpty())
            throw new RuntimeException("Informe a razão social.");
        if (pessoaJuridicaDTO.getNomeResposavel() == null || pessoaJuridicaDTO.getNomeResposavel().trim().isEmpty())
            throw new RuntimeException("Informe o nome do responsável.");
        if (pessoaJuridicaDTO.getContatoResponsavel() == null || pessoaJuridicaDTO.getContatoResponsavel().trim().isEmpty())
            throw new RuntimeException("Informe o contato do responsável.");

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj(pessoaJuridicaDTO.getCnpj());
        pessoaJuridica.setInscricaoSocial(pessoaJuridicaDTO.getInscricaoSocial());
        pessoaJuridica.setRazaoSocial(pessoaJuridicaDTO.getRazaoSocial());
        pessoaJuridica.setNomeResposavel(pessoaJuridicaDTO.getNomeResposavel());
        pessoaJuridica.setContatoResponsavel(pessoaJuridicaDTO.getContatoResponsavel());

        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaJuridica update(PessoaJuridica pessoaJuridica) {
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
