package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.OSDTO;
import com.PI.AutoGynService.dto.PecaSubstituirDTO;
import com.PI.AutoGynService.dto.ServicoExecutadoDTO;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.entity.PecaSubstituir;
import com.PI.AutoGynService.entity.ServicoExecutado;
import com.PI.AutoGynService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PI.AutoGynService.entity.Status;

import java.util.List;

@Service
public class ServiceOS {
    @Autowired
    OSRepository osRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    private PecaSubstituirRepository pecaSubstituirRepository;

    @Autowired
    private ServicoExecutadoRepository servicoExecutadoRepository;

    @Autowired
    private PecaRepository pecaRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<OS> findAll(){
        return osRepository.findAll();
    }

    public OS findById(Long id){
        return osRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada com o ID: " + id));
    }

    public List<OS> findByPlacaVeiculo(String placaVeiculo) {
        return osRepository.findByVeiculoPlaca(placaVeiculo);
    }

    public List<OS> findByStatus(Status status) {
        return osRepository.findByStatus(status);
    }

    public OS save(OSDTO osDTO) {
        if (osDTO.getStatus() == null)
            throw new RuntimeException("Informe o status da OS.");
        if (osDTO.getDataInicio() == null)
            throw new RuntimeException("Informe a data de início.");
        if (osDTO.getDataFim() == null)
            throw new RuntimeException("Informe a data de finalização.");
        if (osDTO.getValorPago() == null || osDTO.getValorPago() <= 0)
            throw new RuntimeException("Valor pago não informado.");

        Veiculo veiculo = veiculoRepository.findByPlaca(osDTO.getPlacaVeiculo())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado com a placa: " + osDTO.getPlacaVeiculo()));

        OS os = new OS();
        os.setStatus(osDTO.getStatus());
        os.setDataInicio(osDTO.getDataInicio());
        os.setDataFim(osDTO.getDataFim());
        os.setValorPago(osDTO.getValorPago());
        os.setVeiculo(veiculo);
        os.setValorTotal(0.0);

        OS savedOS = osRepository.save(os);

        if (osDTO.getPecasSubstituir() != null) {
            for (PecaSubstituirDTO dto : osDTO.getPecasSubstituir()) {
                PecaSubstituir peca = new PecaSubstituir();
                peca.setDescricao(dto.getDescricao());
                peca.setQuantidade(dto.getQuantidade());
                peca.setValorUnitario(dto.getValorUnitario());
                peca.setValorTotal(dto.getQuantidade() * dto.getValorUnitario());
                peca.setOs(savedOS);

                peca.setPeca(pecaRepository.findById(dto.getPecaId())
                        .orElseThrow(() -> new RuntimeException("Peça não encontrada com o ID: " + dto.getPecaId())));

                pecaSubstituirRepository.save(peca);
            }
        }

        if (osDTO.getServicosExecutados() != null) {
            for (ServicoExecutadoDTO dto : osDTO.getServicosExecutados()) {
                ServicoExecutado servico = new ServicoExecutado();
                servico.setDescricao(dto.getDescricao());
                servico.setQuantidade(dto.getQuantidade());
                servico.setValorUnitario(dto.getValorUnitario());
                servico.setValorTotal(dto.getQuantidade() * dto.getValorUnitario());
                servico.setOs(savedOS);

                servico.setServico(servicoRepository.findById(dto.getServicoId())
                        .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + dto.getServicoId())));

                if (dto.getFuncionarioId() != null) {
                    servico.setFuncionario(funcionarioRepository.findById(dto.getFuncionarioId())
                            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + dto.getFuncionarioId())));
                }

                servicoExecutadoRepository.save(servico);
            }
        }

        recalcularValorTotal(savedOS.getId());

        return osRepository.findById(savedOS.getId())
                .orElseThrow(() -> new RuntimeException("OS não encontrada após o save."));
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

    public void recalcularValorTotal(Long osId) {
        OS os = osRepository.findById(osId)
                .orElseThrow(() -> new RuntimeException("OS não encontrada com o ID: " + osId));

        // Soma total das peças substituídas
        double totalPecas = pecaSubstituirRepository.findByOsId(osId).stream()
                .mapToDouble(PecaSubstituir::getValorTotal)
                .sum();

        // Soma total dos serviços executados
        double totalServicos = servicoExecutadoRepository.findByOsId(osId).stream()
                .mapToDouble(ServicoExecutado::getValorTotal)
                .sum();

        os.setValorTotal(totalPecas + totalServicos);
        osRepository.save(os);
    }
}
