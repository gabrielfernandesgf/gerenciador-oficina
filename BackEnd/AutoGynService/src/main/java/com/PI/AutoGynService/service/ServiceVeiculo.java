package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.VeiculoDTO;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVeiculo {

    @Autowired
    VeiculoRepository veiculoRepository;

    public void save(Veiculo veiculo){
        veiculoRepository.save(veiculo);
    }

    public Veiculo findById(String placa){
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + placa));
    }

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo save(VeiculoDTO veiculo, String placa){
        Veiculo veiculo1 = veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + placa));

        if(veiculo.getAnoFabricacao() != 0){
            veiculo1.setAnoFabricacao(veiculo.getAnoFabricacao());
        }
        if(veiculo.getChassi() != null){
            veiculo1.setChassi(veiculo.getChassi());
        }
        if(veiculo.getAnoModelo() != 0){
            veiculo1.setAnoModelo(veiculo.getAnoModelo());
        }
        if(veiculo.getModelo() != null){
            veiculo1.setModelo(veiculo.getModelo());
        }
        if(veiculo.getPlaca() != null){
            veiculo1.setPlaca(veiculo.getPlaca());
        }
        if(veiculo.getIdentificadorPatrimonio() != null){
            veiculo1.setIdentificadorPatrimonio(veiculo.getIdentificadorPatrimonio());
        }
        if(veiculo.getQuilometragem() != 0){
            veiculo1.setQuilometragem(veiculo.getQuilometragem());
        }
        if(veiculo.getRenavan() != null){
            veiculo1.setRenavan(veiculo.getRenavan());
        }
        return veiculoRepository.save(veiculo1);
    }
}
