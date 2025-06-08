package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.PecaSubstituirDTO;
import com.PI.AutoGynService.entity.PecaSubstituir;
import com.PI.AutoGynService.repository.PecaSubstituirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePecaSubstituir {
    @Autowired
    PecaSubstituirRepository pecaSubstituirRepository;

    public void save(PecaSubstituir pecaSubstituir){
        pecaSubstituirRepository.save(pecaSubstituir);
    }

    public PecaSubstituir findById(Long id){
        return pecaSubstituirRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça à substituir não encontrada com o ID: " + id));
    }

    public List<PecaSubstituir> findAll(){
        return pecaSubstituirRepository.findAll();
    }

    public PecaSubstituir update(PecaSubstituirDTO pecaSubstituir) {
        PecaSubstituir pecaSubstituir1 = pecaSubstituirRepository.findById(pecaSubstituir.getId())
                .orElseThrow(() -> new RuntimeException("Peça à substituir não encontrada com o ID: " + pecaSubstituir.getId()));

        if (pecaSubstituir.getDescricao() != null) {
            pecaSubstituir1.setDescricao(pecaSubstituir.getDescricao());
        }
        if (pecaSubstituir.getOs() != null) {
            pecaSubstituir1.setOs(pecaSubstituir.getOs());
        }
        if (pecaSubstituir.getPeca() != null) {
            pecaSubstituir1.setPeca(pecaSubstituir.getPeca());
        }
        if (pecaSubstituir.getValorUnitario() != null) {
            pecaSubstituir1.setValorUnitario(pecaSubstituir.getValorUnitario());
        }
        if (pecaSubstituir.getQuantidade() != null) {
            pecaSubstituir1.setQuantidade(pecaSubstituir.getQuantidade());
        }
        if (pecaSubstituir.getValorTotal() != null) {
            pecaSubstituir1.setValorTotal(pecaSubstituir.getValorTotal());
        }

        return pecaSubstituirRepository.save(pecaSubstituir1);
    }

    public void delete(Long id) {
        pecaSubstituirRepository.deleteById(id);
    }
}
