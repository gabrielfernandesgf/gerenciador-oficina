package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.OficinaDTO;
import com.PI.AutoGynService.entity.Oficina;
import com.PI.AutoGynService.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOficina {
    @Autowired
    OficinaRepository oficinaRepository;

    public void save(Oficina oficina){
        oficinaRepository.save(oficina);
    }

    public Oficina findById(Long id){
        return oficinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oficina não encontrada com o ID: " + id));
    }

    public List<Oficina> findAll(){
        return oficinaRepository.findAll();
    }

    public Oficina update(OficinaDTO oficina, Long id) {
        Oficina oficina1 = oficinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrado com o ID: " + id));

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
}
