package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.ModeloDTO;
import com.PI.AutoGynService.entity.Marca;
import com.PI.AutoGynService.entity.Modelo;
import com.PI.AutoGynService.repository.MarcaRepository;
import com.PI.AutoGynService.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceModelo {
    @Autowired
    ModeloRepository modeloRepository;

    @Autowired
    MarcaRepository marcaRepository;

    public List<Modelo> findAll(){
        return modeloRepository.findAll();
    }

    public Modelo findById(Long id){
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com o ID: " + id));
    }

    public Modelo save(ModeloDTO modeloDTO){
        if (modeloDTO.getNome() == null || modeloDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (modeloDTO.getDescricao() == null || modeloDTO.getDescricao().trim().isEmpty())
            throw new RuntimeException("Descrição é obrigatória.");

        Marca marca = marcaRepository.findById(modeloDTO.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + modeloDTO.getMarcaId()));

        Modelo modelo = new Modelo();
        modelo.setNome(modeloDTO.getNome());
        modelo.setDescricao(modeloDTO.getDescricao());
        modelo.setMarca(marca);

        return modeloRepository.save(modelo);
    }

    public Modelo update(Modelo modelo){
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
