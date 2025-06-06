package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Propriedade;
import com.PI.AutoGynService.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePropriedade {

    @Autowired
    PropriedadeRepository propriedadeRepository;


    public void save(Propriedade propriedade){
        propriedadeRepository.save(propriedade);

    }
    public Propriedade findById(Long id){
        return propriedadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propriedade não encontrada com o ID: " + id));
    }
    public List<Propriedade> findAll(){
        return propriedadeRepository.findAll();
    }
    public Propriedade update(Propriedade propriedade, Long id) {
        Propriedade propriedade1 = propriedadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propriedade não encontrado com o ID: " + id));

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
}
