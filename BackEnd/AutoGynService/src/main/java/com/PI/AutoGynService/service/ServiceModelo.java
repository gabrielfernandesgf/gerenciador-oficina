package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.ModeloDTO;
import com.PI.AutoGynService.entity.Modelo;
import com.PI.AutoGynService.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceModelo {
    @Autowired
    ModeloRepository modeloRepository;

    public void save(Modelo modelo){
        modeloRepository.save(modelo);
    }

    public Modelo findById(Long id){
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com o ID: " + id));
    }

    public List<Modelo> findAll(){
        return modeloRepository.findAll();
    }

    public Modelo update(ModeloDTO modelo){
        Modelo modelo1 = modeloRepository.findById(modelo.getId())
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com o ID: " + modelo.getId()));

        if(modelo.getDescricao() != null){
            modelo1.setDescricao(modelo.getDescricao());
        }
        if(modelo.getMarca() != null){
            modelo1.setMarca(modelo.getMarca());
        }
        if(modelo.getNome() != null){
            modelo1.setNome(modelo.getNome());
        }

        return modeloRepository.save(modelo1);
    }

    public void delete(Long id) {
        modeloRepository.deleteById(id);
    }
}
