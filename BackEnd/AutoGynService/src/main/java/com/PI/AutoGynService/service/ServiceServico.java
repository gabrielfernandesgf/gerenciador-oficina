package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.ServicoDTO;
import com.PI.AutoGynService.entity.Servico;
import com.PI.AutoGynService.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServico {

    @Autowired
    ServicoRepository servicoRepository;

    public void save(Servico servico){
        servicoRepository.save(servico);
    }

    public Servico findById(Long id){
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));
    }

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

    public Servico upadate(ServicoDTO servico, Long id){
        Servico servico1 = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));

        if(servico.getDescricao() != null){
            servico1.setDescricao(servico.getDescricao());
        }
        if(servico.getNome() != null){
            servico1.setNome(servico.getNome());
        }
        if(servico.getValorUnitario() != null){
            servico1.setValorUnitario(servico.getValorUnitario());
        }
        return servicoRepository.save(servico1);
    }
}
