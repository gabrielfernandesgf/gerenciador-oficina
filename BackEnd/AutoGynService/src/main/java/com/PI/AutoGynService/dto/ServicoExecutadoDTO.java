package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Funcionario;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Servico;

import java.time.LocalDate;
import java.util.Objects;

public class ServicoExecutadoDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer quantidade;
    private Double valorUnitario;
    private String descricao;
    private Long osId;
    private Long servicoId;
    private Long funcionarioId;

    public ServicoExecutadoDTO() {}

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoExecutadoDTO that = (ServicoExecutadoDTO) o;
        return Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataFim, that.dataFim) && Objects.equals(quantidade, that.quantidade) && Objects.equals(valorUnitario, that.valorUnitario) && Objects.equals(descricao, that.descricao) && Objects.equals(osId, that.osId) && Objects.equals(servicoId, that.servicoId) && Objects.equals(funcionarioId, that.funcionarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataInicio, dataFim, quantidade, valorUnitario, descricao, osId, servicoId, funcionarioId);
    }

    @Override
    public String toString() {
        return "ServicoExecutadoDTO{" +
                "dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", descricao='" + descricao + '\'' +
                ", osId=" + osId +
                ", servicoId=" + servicoId +
                ", funcionarioId=" + funcionarioId +
                '}';
    }
}
