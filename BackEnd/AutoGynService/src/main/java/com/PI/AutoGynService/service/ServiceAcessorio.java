package com.PI.AutoGynService.service;


import com.PI.AutoGynService.dto.AcessorioDTO;
import com.PI.AutoGynService.entity.Acessorio;
import com.PI.AutoGynService.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAcessorio {

    @Autowired
    AcessorioRepository acessorioRepository;

    public void save(Acessorio acessorio){
        acessorioRepository.save(acessorio);
    }

    public Acessorio findById(Long id){
        return acessorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado com o ID: " + id));
    }

    public List<Acessorio> findAll(){
        return acessorioRepository.findAll();
    }

    public Acessorio updateAcessorio(AcessorioDTO acessorio, Long id){
        Acessorio acessorio1 = acessorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado com o ID: " + id));
        if(acessorio.getDescricao() != null){
            acessorio1.setDescricao(acessorio.getDescricao());
        }
        if (acessorio.getNome() != null){
            acessorio1.setNome(acessorio.getNome());
        }

        return acessorioRepository.save(acessorio1);

    }
}

