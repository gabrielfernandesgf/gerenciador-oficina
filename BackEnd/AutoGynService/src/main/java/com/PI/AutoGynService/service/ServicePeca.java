package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.PecaDTO;
import com.PI.AutoGynService.entity.Peca;
import com.PI.AutoGynService.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePeca {
    @Autowired
    PecaRepository pecaRepository;

    public List<Peca> findAll(){
        return pecaRepository.findAll();
    }

    public Peca findById(Long id){
        return pecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com o ID: " + id));
    }

    public Peca save(PecaDTO pecaDTO){
        if (pecaDTO.getNome() == null || pecaDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (pecaDTO.getFabricante() == null || pecaDTO.getFabricante().trim().isEmpty())
            throw new RuntimeException("Fabricante é obrigatório.");
        if (pecaDTO.getVolumeTamanho() == null || pecaDTO.getVolumeTamanho().trim().isEmpty())
            throw new RuntimeException("Informe o volume|tamanho da peça.");
        if (pecaDTO.getValorUnitario() <= 0)
            throw new RuntimeException("Valor unitário é inválido.");
        if (pecaDTO.getQuantidadeEstoque() < 0)
            throw new RuntimeException("Quantidade em estoque é inválida.");

        Peca peca = new Peca();
        peca.setNome(pecaDTO.getNome());
        peca.setFabricante(pecaDTO.getFabricante());
        peca.setVolumeTamanho(pecaDTO.getVolumeTamanho());
        peca.setValorUnitario(pecaDTO.getValorUnitario());
        peca.setQuantidadeEstoque(pecaDTO.getQuantidadeEstoque());

        return pecaRepository.save(peca);
    }

    public Peca update(Peca peca){
        Peca peca1 = pecaRepository.findById(peca.getId())
                .orElseThrow(() -> new RuntimeException("Peça não encontrada com o ID: " + peca.getId()));

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

    public void delete(Long id) {
        pecaRepository.deleteById(id);
    }
}
