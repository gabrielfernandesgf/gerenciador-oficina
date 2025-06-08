package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.OficinaDTO;
import com.PI.AutoGynService.entity.Oficina;
import com.PI.AutoGynService.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOficina {
    @Autowired
    OficinaRepository oficinaRepository;

    public List<Oficina> findAll(){
        return oficinaRepository.findAll();
    }

    public Oficina findById(Long id){
        return oficinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oficina não encontrada com o ID: " + id));
    }

    public Oficina save(OficinaDTO oficinaDTO){
        if (oficinaDTO.getNome() == null || oficinaDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (oficinaDTO.getEmail() == null || oficinaDTO.getEmail().trim().isEmpty())
            throw new RuntimeException("Email é obrigatório.");
        if (oficinaDTO.getEndereco() == null || oficinaDTO.getEndereco().trim().isEmpty())
            throw new RuntimeException("Endereço é obrigatório.");

        Oficina oficina = new Oficina();
        oficina.setNome(oficinaDTO.getNome());
        oficina.setEmail(oficinaDTO.getEmail());
        oficina.setEndereco(oficinaDTO.getEndereco());

        return oficinaRepository.save(oficina);
    }

    public Oficina update(Oficina oficina) {
        Oficina oficina1 = oficinaRepository.findById(oficina.getId())
                .orElseThrow(() -> new RuntimeException("OS não encontrado com o ID: " + oficina.getId()));

        if (oficina.getNome() != null) {
            oficina1.setNome(oficina.getNome());
        }
        if (oficina.getEndereco() != null) {
            oficina1.setEndereco(oficina.getEndereco());
        }
        if (oficina.getEmail() != null) {
            oficina1.setEmail(oficina.getEmail());
        }

        return oficinaRepository.save(oficina1);
    }

    public void delete(Long id) {
        oficinaRepository.deleteById(id);
    }
}
