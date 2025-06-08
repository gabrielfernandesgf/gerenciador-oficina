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

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

    public Servico findById(Long id){
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));
    }

    public Servico save(ServicoDTO servicoDTO){
        if (servicoDTO.getNome() == null || servicoDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Informe o nome do serviço.");
        if (servicoDTO.getDescricao() == null || servicoDTO.getDescricao().trim().isEmpty())
            throw new RuntimeException("Informe uma descrição para o serviço.");
        if (servicoDTO.getValorUnitario() <= 0)
            throw new RuntimeException("Valor unitário inválido.");

        Servico servico = new Servico();
        servico.setNome(servicoDTO.getNome());
        servico.setDescricao(servicoDTO.getDescricao());
        servico.setValorUnitario(servicoDTO.getValorUnitario());

        return servicoRepository.save(servico);
    }

    public Servico upadate(Servico servico){
        Servico servico1 = servicoRepository.findById(servico.getId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + servico.getId()));

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

    public void delete(Long id) {
        servicoRepository.deleteById(id);
    }
}
