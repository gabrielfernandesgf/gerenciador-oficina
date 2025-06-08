package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.AcessorioDTO;
import com.PI.AutoGynService.entity.Acessorio;
import com.PI.AutoGynService.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAcessorio {
    @Autowired
    AcessorioRepository acessorioRepository;

    public List<Acessorio> findAll(){
        return acessorioRepository.findAll();
    }

    public Acessorio findById(Long id){
        return acessorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado com o ID: " + id));
    }

    public Acessorio save(AcessorioDTO acessorioDTO){
        if (acessorioDTO.getNome() == null || acessorioDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (acessorioDTO.getDescricao() == null || acessorioDTO.getDescricao().trim().isEmpty())
            throw new RuntimeException("Descrição é obrigatória.");

        Acessorio acessorio = new Acessorio();
        acessorio.setNome(acessorioDTO.getNome());
        acessorio.setDescricao(acessorioDTO.getDescricao());

        return acessorioRepository.save(acessorio);
    }

    public Acessorio update(Acessorio acessorio){
        Acessorio acessorio1 = acessorioRepository.findById(acessorio.getId())
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado com o ID: " + acessorio.getId()));

        if(acessorio.getDescricao() != null) acessorio1.setDescricao(acessorio.getDescricao());
        if (acessorio.getNome() != null) acessorio1.setNome(acessorio.getNome());

        return acessorioRepository.save(acessorio1);
    }

    public void delete(Long id) {
        acessorioRepository.deleteById(id);
    }
}