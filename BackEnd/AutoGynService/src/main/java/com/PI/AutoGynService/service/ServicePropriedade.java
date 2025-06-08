package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.PropriedadeDTO;
import com.PI.AutoGynService.entity.Cliente;
import com.PI.AutoGynService.entity.Propriedade;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.repository.ClienteRepository;
import com.PI.AutoGynService.repository.PropriedadeRepository;
import com.PI.AutoGynService.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePropriedade {
    @Autowired
    PropriedadeRepository propriedadeRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    public List<Propriedade> findAll(){
        return propriedadeRepository.findAll();
    }

    public Propriedade findById(Long id){
        return propriedadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propriedade não encontrada com o ID: " + id));
    }

    public Propriedade save(PropriedadeDTO propriedadeDTO){
        if (propriedadeDTO.getDataInicio() == null || propriedadeDTO.getDataInicio().toString().trim().isEmpty())
            throw new RuntimeException("Data de início é obrigatória.");
        if (propriedadeDTO.getDataTermino() == null || propriedadeDTO.getDataTermino().toString().trim().isEmpty())
            throw new RuntimeException("Informe a data de termino da propriedade.");

        Cliente cliente = clienteRepository.findById(propriedadeDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + propriedadeDTO.getClienteId()));

        Veiculo veiculo = veiculoRepository.findById(propriedadeDTO.getPlacaVeiculo())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + propriedadeDTO.getPlacaVeiculo()));

        Propriedade propriedade = new Propriedade();
        propriedade.setCliente(cliente);
        propriedade.setVeiculo(veiculo);
        propriedade.setDataInicio(propriedadeDTO.getDataInicio());
        propriedade.setDataTermino(propriedadeDTO.getDataTermino());

        return propriedadeRepository.save(propriedade);
    }

    public Propriedade update(Propriedade propriedade) {
        Propriedade propriedade1 = propriedadeRepository.findById(propriedade.getId())
                .orElseThrow(() -> new RuntimeException("Propriedade não encontrado com o ID: " + propriedade.getId()));

        if(propriedade.getCliente() != null){
            propriedade1.setCliente(propriedade.getCliente());
        }
        if(propriedade.getVeiculo() != null){
            propriedade1.setVeiculo(propriedade.getVeiculo());
        }
        if(propriedade.getDataInicio() != null){
            propriedade1.setDataInicio(propriedade.getDataInicio());
        }
        if(propriedade.getDataTermino() != null){
            propriedade1.setDataTermino(propriedade.getDataTermino());
        }

        return propriedadeRepository.save(propriedade1);
    }

    public void delete(Long id) {
        propriedadeRepository.deleteById(id);
    }
}
