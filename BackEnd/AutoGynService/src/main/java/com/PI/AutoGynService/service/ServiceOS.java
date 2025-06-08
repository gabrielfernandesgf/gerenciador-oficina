package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.OSDTO;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.repository.OSRepository;
import com.PI.AutoGynService.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOS {
    @Autowired
    OSRepository osRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    public List<OS> findAll(){
        return osRepository.findAll();
    }

    public OS findById(Long id){
        return osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada com o ID: " + id));
    }

    public OS save(OSDTO osDTO){
        if (osDTO.getStatus() == null)
            throw new RuntimeException("Informe o status da OS.");
        if (osDTO.getDataInicio() == null || osDTO.getDataInicio().toString().trim().isEmpty())
            throw new RuntimeException("Informe a data de início.");
        if (osDTO.getDataFim() == null || osDTO.getDataFim().toString().trim().isEmpty())
            throw new RuntimeException("Informe a data de finalização.");
        if (osDTO.getValorTotal() <= 0)
            throw new RuntimeException("Valor total não informado.");
        if (osDTO.getValorPago() <= 0)
            throw new RuntimeException("Valor pago não informado.");

        Veiculo veiculo = veiculoRepository.findByPlaca(osDTO.getPlacaVeiculo())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + osDTO.getPlacaVeiculo()));

        OS os = new OS();
        os.setStatus(osDTO.getStatus());
        os.setDataInicio(osDTO.getDataInicio());
        os.setDataFim(osDTO.getDataFim());
        os.setValorTotal(osDTO.getValorTotal());
        os.setValorPago(osDTO.getValorPago());
        os.setVeiculo(veiculo);

        return osRepository.save(os);
    }

    public OS update(OS os) {
        OS os1 = osRepository.findById(os.getId())
                .orElseThrow(() -> new RuntimeException("OS não encontrado com o ID: " + os.getId()));

        if (os.getStatus() != null) {
            os1.setStatus(os.getStatus());
        }
        if (os.getDataInicio() != null) {
            os1.setDataInicio(os.getDataInicio());
        }
        if (os.getDataFim() != null) {
            os1.setDataFim(os.getDataFim());
        }

        return osRepository.save(os1);
    }

    public void delete(Long id) {
        osRepository.deleteById(id);
    }
}
