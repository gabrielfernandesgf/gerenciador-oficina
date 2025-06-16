package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.PecaSubstituirDTO;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Peca;
import com.PI.AutoGynService.entity.PecaSubstituir;
import com.PI.AutoGynService.repository.OSRepository;
import com.PI.AutoGynService.repository.PecaRepository;
import com.PI.AutoGynService.repository.PecaSubstituirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePecaSubstituir {
    @Autowired
    PecaSubstituirRepository pecaSubstituirRepository;

    @Autowired
    PecaRepository pecaRepository;

    @Autowired
    OSRepository osRepository;

    @Autowired
    ServiceOS serviceOS;

    public List<PecaSubstituir> findAll(){
        return pecaSubstituirRepository.findAll();
    }

    public PecaSubstituir findById(Long id){
        return pecaSubstituirRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça à substituir não encontrada com o ID: " + id));
    }

    public PecaSubstituir save(PecaSubstituirDTO pecaSubstituirDTO){
        if (pecaSubstituirDTO.getDescricao() == null || pecaSubstituirDTO.getDescricao().trim().isEmpty())
            throw new RuntimeException("Informe uma descrição.");
        if (pecaSubstituirDTO.getQuantidade() <= 0)
            throw new RuntimeException("Quantidade inválida.");
        if (pecaSubstituirDTO.getValorUnitario() <= 0)
            throw new RuntimeException("Valor unitário deve ser positivo.");

        Peca peca = pecaRepository.findById(pecaSubstituirDTO.getPecaId())
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com o ID: " + pecaSubstituirDTO.getPecaId()));

        OS os = osRepository.findById(pecaSubstituirDTO.getOsId())
                .orElseThrow(() -> new RuntimeException("OS não encontrada com o ID: " + pecaSubstituirDTO.getOsId()));

        PecaSubstituir pecaSubstituir = new PecaSubstituir();
        pecaSubstituir.setDescricao(pecaSubstituirDTO.getDescricao());
        pecaSubstituir.setQuantidade(pecaSubstituirDTO.getQuantidade());
        pecaSubstituir.setValorUnitario(pecaSubstituirDTO.getValorUnitario());
        pecaSubstituir.setValorTotal(pecaSubstituir.getValorTotal() * pecaSubstituir.getQuantidade());
        pecaSubstituir.setPeca(peca);
        pecaSubstituir.setOs(os);

        serviceOS.recalcularValorTotal(pecaSubstituirDTO.getOsId());

        return pecaSubstituirRepository.save(pecaSubstituir);
    }

    public PecaSubstituir update(PecaSubstituir pecaSubstituir) {
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

        serviceOS.recalcularValorTotal(pecaSubstituir.getOs().getId());

        return pecaSubstituirRepository.save(pecaSubstituir1);
    }

    public void delete(Long id) {
        pecaSubstituirRepository.deleteById(id);
    }
}
