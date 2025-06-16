package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.VeiculoDTO;
import com.PI.AutoGynService.entity.Modelo;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.repository.ModeloRepository;
import com.PI.AutoGynService.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVeiculo {
    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    ModeloRepository modeloRepository;

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo findByPlaca(String placa){
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + placa));
    }

    public Veiculo save(VeiculoDTO veiculoDTO){
        if (veiculoDTO.getPlaca() == null || veiculoDTO.getPlaca().trim().isEmpty())
            throw new RuntimeException("Placa não informada.");
        if (veiculoDTO.getChassi() == null || veiculoDTO.getChassi().trim().isEmpty())
            throw new RuntimeException("Chassi não informado.");
        if (veiculoDTO.getRenavan() == null || veiculoDTO.getRenavan().trim().isEmpty())
            throw new RuntimeException("Informe o RENAVAM do veículo");
        if (veiculoDTO.getAnoFabricacao() <= 1950 || veiculoDTO.getAnoFabricacao() >= 2026)
            throw new RuntimeException("Ano de fabricação inválido.");
        if (veiculoDTO.getAnoModelo() <= 1950 || veiculoDTO.getAnoModelo() >= 2026)
            throw new RuntimeException("Ano de modelo inválido.");
        if (veiculoDTO.getQuilometragem() < 0)
            throw new RuntimeException("Quilometragem inválida");
        if(!validarPlaca(veiculoDTO.getPlaca()))
            throw new RuntimeException("Placa invalida");



        Modelo modelo = modeloRepository.findById(veiculoDTO.getModeloID())
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com o ID: " + veiculoDTO.getModeloID()));

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setChassi(veiculoDTO.getChassi());
        veiculo.setRenavan(veiculoDTO.getRenavan());
        veiculo.setAnoFabricacao(veiculoDTO.getAnoFabricacao());
        veiculo.setAnoModelo(veiculoDTO.getAnoModelo());
        veiculo.setQuilometragem(veiculoDTO.getQuilometragem());
        veiculo.setIdentificadorPatrimonio(veiculoDTO.getIdentificadorPatrimonio());
        veiculo.setModelo(modelo);

        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(Veiculo veiculo){
        Veiculo veiculo1 = veiculoRepository.findByPlaca(veiculo.getPlaca())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + veiculo.getPlaca()));

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

    public void delete(String placa) {
        veiculoRepository.deleteByPlaca(placa);
    }

    public static boolean validarPlaca(String placa) {

        placa = placa.trim().toUpperCase();

        if (placa.length() != 7) {
            return false;
        }

        // Regex para formato antigo: 3 letras + 4 números
        String regexAntigo = "^[A-Z]{3}[0-9]{4}$";

        // Regex para formato Mercosul: 3 letras + 1 número + 1 letra + 2 números
        String regexMercosul = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";

        return placa.matches(regexAntigo) || placa.matches(regexMercosul);
    }
}
