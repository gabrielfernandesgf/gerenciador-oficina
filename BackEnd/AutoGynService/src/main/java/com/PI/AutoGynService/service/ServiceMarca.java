package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.MarcaDTO;
import com.PI.AutoGynService.entity.Marca;
import com.PI.AutoGynService.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMarca {
    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> findAll(){
        return marcaRepository.findAll();
    }

    public Marca findById(Long id){
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com o ID: " + id));
    }

    public Marca save(MarcaDTO marcaDTO){
        if (marcaDTO.getNome() == null || marcaDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (marcaDTO.getDescricao() == null || marcaDTO.getDescricao().trim().isEmpty())
            throw new RuntimeException("Descrição é obrigatória.");

        Marca marca = new Marca();
        marca.setNome(marcaDTO.getNome());
        marca.setDescricao(marcaDTO.getDescricao());

        return marcaRepository.save(marca);
    }

    public Marca update(Marca marca){
        Marca marca1 = marcaRepository.findById(marca.getId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com o ID: " + marca.getId()));

        if(marca.getDescricao() != null){
            marca1.setDescricao(marca.getDescricao());
        }
        if(marca.getNome() != null){
            marca1.setNome(marca.getNome());
        }
        return marcaRepository.save(marca1);
    }

    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }
}
