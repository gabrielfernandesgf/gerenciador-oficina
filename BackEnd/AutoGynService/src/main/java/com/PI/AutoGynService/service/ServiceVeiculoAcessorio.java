package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.VeiculoAcessorioDTO;
import com.PI.AutoGynService.entity.Acessorio;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.entity.VeiculoAcessorio;
import com.PI.AutoGynService.repository.AcessorioRepository;
import com.PI.AutoGynService.repository.VeiculoAcessorioRepository;
import com.PI.AutoGynService.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVeiculoAcessorio {
    @Autowired
    VeiculoAcessorioRepository veiculoAcessorioRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    AcessorioRepository acessorioRepository;

    public List<VeiculoAcessorio> findAll(){
        return veiculoAcessorioRepository.findAll();
    }

    public VeiculoAcessorio findById(Long id){
        return veiculoAcessorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo|Acessorio não encontrado com a placa: " + id));
    }

    public VeiculoAcessorio save(VeiculoAcessorioDTO veiculoAcessorioDTO){
        Acessorio acessorio = acessorioRepository.findById(veiculoAcessorioDTO.getAcessorioId())
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado com o ID: " + veiculoAcessorioDTO.getAcessorioId()));

        Veiculo veiculo = veiculoRepository.findByPlaca(veiculoAcessorioDTO.getVeiculoPlaca())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com a placa: " + veiculoAcessorioDTO.getVeiculoPlaca()));

        VeiculoAcessorio veiculoAcessorio = new VeiculoAcessorio();
        veiculoAcessorio.setAcessorio(acessorio);
        veiculoAcessorio.setVeiculo(veiculo);

        return veiculoAcessorioRepository.save(veiculoAcessorio);
    }

    public VeiculoAcessorio update(VeiculoAcessorio veiculoAcessorio){
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
