package com.PI.AutoGynService.service;

import com.PI.AutoGynService.entity.dto.VeiculoAcessorioDTO;
import com.PI.AutoGynService.entity.VeiculoAcessorio;
import com.PI.AutoGynService.repository.VeiculoAcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVeiculoAcessorio {
    @Autowired
    VeiculoAcessorioRepository veiculoAcessorioRepository;

    public void save(VeiculoAcessorio veiculoAcessorio){
        veiculoAcessorioRepository.save(veiculoAcessorio);
    }

    public VeiculoAcessorio findById(Long id){
        return veiculoAcessorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo|Acessorio não encontrado com a placa: " + id));
    }

    public List<VeiculoAcessorio> findAll(){
        return veiculoAcessorioRepository.findAll();
    }

    public VeiculoAcessorio update(VeiculoAcessorioDTO veiculoAcessorio){
        VeiculoAcessorio veiculoAcessorio1 = veiculoAcessorioRepository.findById(veiculoAcessorio.getId())
                .orElseThrow(() -> new RuntimeException("Veiculo|Acessorio não encontrado com a placa: " + veiculoAcessorio.getId()));

        if(veiculoAcessorio.getAcessorio() != null){
            veiculoAcessorio1.setAcessorio(veiculoAcessorio.getAcessorio());
        }
        if(veiculoAcessorio.getVeiculo() != null){
            veiculoAcessorio1.setVeiculo(veiculoAcessorio.getVeiculo());
        }

        return veiculoAcessorioRepository.save(veiculoAcessorio1);
    }

    public void delete(Long id) {
        veiculoAcessorioRepository.deleteById(id);
    }
}
