package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.ServicoExecutadoDTO;
import com.PI.AutoGynService.entity.Propriedade;
import com.PI.AutoGynService.entity.ServicoExecutado;
import com.PI.AutoGynService.repository.ServicoExecutadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServicoExecutado {

    @Autowired
    ServicoExecutadoRepository servicoExecutadoRepository;

    public void save(ServicoExecutado servicoExecutado) {
        servicoExecutadoRepository.save(servicoExecutado);

    }

    public ServicoExecutado findById(Long id) {
        return servicoExecutadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço executado não encontrada com o ID: " + id));
    }

    public List<ServicoExecutado> findAll() {
        return servicoExecutadoRepository.findAll();
    }

    public ServicoExecutado update(ServicoExecutadoDTO servicoExecutado, Long id) {
        ServicoExecutado servicoExecutado1 = servicoExecutadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço executado não encontrado com o ID: " + id));

        if (servicoExecutado.getServico() != null) {
            servicoExecutado1.setServico(servicoExecutado.getServico());
        }
        if (servicoExecutado.getDataFim() != null) {
            servicoExecutado1.setDataFim(servicoExecutado.getDataFim());
        }
        if (servicoExecutado.getDataInicio() != null) {
            servicoExecutado1.setDataInicio(servicoExecutado.getDataInicio());
        }
        if (servicoExecutado.getQuantidade() != null) {
            servicoExecutado1.setQuantidade(servicoExecutado.getQuantidade());
        }
        if (servicoExecutado.getOs() != null) {
            servicoExecutado1.setOs(servicoExecutado.getOs());
        }
        if (servicoExecutado.getFuncionario() != null) {
            servicoExecutado1.setFuncionario(servicoExecutado.getFuncionario());
        }
        if (servicoExecutado.getDescricao() != null) {
            servicoExecutado1.setDescricao(servicoExecutado.getDescricao());
        }
        if (servicoExecutado.getValorTotal() != null) {
            servicoExecutado1.setValorTotal(servicoExecutado.getValorTotal());
        }
        if (servicoExecutado.getValorUnitario() != null) {
            servicoExecutado1.setValorUnitario(servicoExecutado.getValorUnitario());
        }
        return servicoExecutadoRepository.save(servicoExecutado1);
    }
}
