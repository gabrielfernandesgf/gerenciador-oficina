package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.ServicoExecutadoDTO;
import com.PI.AutoGynService.entity.Funcionario;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Servico;
import com.PI.AutoGynService.entity.ServicoExecutado;
import com.PI.AutoGynService.repository.FuncionarioRepository;
import com.PI.AutoGynService.repository.OSRepository;
import com.PI.AutoGynService.repository.ServicoExecutadoRepository;
import com.PI.AutoGynService.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.List;

@Service
public class ServiceServicoExecutado {
    @Autowired
    ServicoExecutadoRepository servicoExecutadoRepository;

    @Autowired
    OSRepository osRepository;

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<ServicoExecutado> findAll() {
        return servicoExecutadoRepository.findAll();
    }

    public ServicoExecutado findById(Long id) {
        return servicoExecutadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço executado não encontrada com o ID: " + id));
    }

    public ServicoExecutado save(ServicoExecutadoDTO servicoExecutadoDTO) {
        if (servicoExecutadoDTO.getDataInicio() == null || servicoExecutadoDTO.getDataInicio().toString().trim().isEmpty())
            throw new RuntimeException("Informe uma data de início válida.");
        if (servicoExecutadoDTO.getDataFim() == null || servicoExecutadoDTO.getDataFim().toString().trim().isEmpty())
            throw new RuntimeException("Informe uma data de termino válida.");
        if (servicoExecutadoDTO.getQuantidade() <= 0)
            throw new RuntimeException("Quantidade inválida.");
        if (servicoExecutadoDTO.getDescricao() == null || servicoExecutadoDTO.getDescricao().trim().isEmpty())
            throw new RuntimeException("Informe uma descrição do servicço executado.");
        if (servicoExecutadoDTO.getValorUnitario() <= 0)
            throw new RuntimeException("Informe um valor unitário positivo.");

        OS os = osRepository.findById(servicoExecutadoDTO.getOsId())
                .orElseThrow(() -> new RuntimeException("Os não encontrada com o ID: " + servicoExecutadoDTO.getServicoId()));

        Servico servico = servicoRepository.findById(servicoExecutadoDTO.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + servicoExecutadoDTO.getServicoId()));

        Funcionario funcionario = funcionarioRepository.findById(servicoExecutadoDTO.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + servicoExecutadoDTO.getFuncionarioId()));

        ServicoExecutado servicoExecutado = new ServicoExecutado();
        servicoExecutado.setDescricao(servicoExecutadoDTO.getDescricao());
        servicoExecutado.setQuantidade(servicoExecutadoDTO.getQuantidade());
        servicoExecutado.setValorUnitario(servicoExecutadoDTO.getValorUnitario());
        servicoExecutado.setValorTotal(servicoExecutadoDTO.getValorUnitario() * servicoExecutadoDTO.getQuantidade());
        servicoExecutado.setDataInicio(servicoExecutadoDTO.getDataInicio());
        servicoExecutado.setDataFim(servicoExecutado.getDataFim());
        servicoExecutado.setOs(os);
        servicoExecutado.setFuncionario(funcionario);
        servicoExecutado.setServico(servico);

        return servicoExecutadoRepository.save(servicoExecutado);
    }

    public ServicoExecutado update(ServicoExecutado servicoExecutado) {
        ServicoExecutado servicoExecutado1 = servicoExecutadoRepository.findById(servicoExecutado.getId())
                .orElseThrow(() -> new RuntimeException("Serviço executado não encontrado com o ID: " + servicoExecutado.getId()));

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

    public void delete(Long id) {
        servicoExecutadoRepository.deleteById(id);
    }
}
