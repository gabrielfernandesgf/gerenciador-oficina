package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.PecaDTO;
import com.PI.AutoGynService.entity.Oficina;
import com.PI.AutoGynService.entity.Peca;
import com.PI.AutoGynService.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePeca {

    @Autowired
    PecaRepository pecaRepository;

    public void save(Peca peca){
        pecaRepository.save(peca);
    }
    public Peca findById(Long id){
        return pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com o ID: " + id));
    }
    public List<Peca> findAll(){
        return pecaRepository.findAll();
    }
    public Peca update(PecaDTO peca, Long id){
        Peca peca1 = pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com o ID: " + id));

        if (peca.getNome() != null) {
            peca1.setNome(peca.getNome());
        }
        if (peca.getFabricante() != null) {
            peca1.setFabricante(peca.getFabricante());
        }
        if (peca.getQuantidadeEstoque() != null) {
            peca1.setQuantidadeEstoque(peca.getQuantidadeEstoque());
        }
        if (peca.getValorUnitario() != null) {
            peca1.setValorUnitario(peca.getValorUnitario());
        }
        if (peca.getVolumeTamanho() != null) {
            peca1.setVolumeTamanho(peca.getVolumeTamanho());
        }


        return pecaRepository.save(peca1);
    }
}
