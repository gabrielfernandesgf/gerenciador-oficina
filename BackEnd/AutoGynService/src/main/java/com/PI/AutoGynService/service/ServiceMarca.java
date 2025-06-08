package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.MarcaDTO;
import com.PI.AutoGynService.entity.Marca;
import com.PI.AutoGynService.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMarca {
    @Autowired
    MarcaRepository marcaRepository;

    public void save(Marca marca){
        marcaRepository.save(marca);
    }

    public Marca findById(Long id){
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com o ID: " + id));
    }

    public List<Marca> findAll(){
        return marcaRepository.findAll();
    }

    public Marca update(MarcaDTO marca){
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
