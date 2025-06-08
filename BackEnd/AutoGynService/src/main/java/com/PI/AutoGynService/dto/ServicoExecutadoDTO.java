package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Funcionario;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Servico;

import java.time.LocalDate;
import java.util.Objects;

public class ServicoExecutadoDTO {

    private Long id;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Integer quantidade;

    private Double valorUnitario;

    private Double valorTotal;

    private String descricao;

    private OS os;

    private Servico servico;

    private Funcionario funcionario;

    public ServicoExecutadoDTO() {
    }

    public ServicoExecutadoDTO(Long id, LocalDate dataInicio, LocalDate dataFim, Integer quantidade, Double valorUnitario, Double valorTotal, String descricao, OS os, Servico servico, Funcionario funcionario) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.os = os;
        this.servico = servico;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoExecutadoDTO that = (ServicoExecutadoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataFim, that.dataFim) && Objects.equals(quantidade, that.quantidade) && Objects.equals(valorUnitario, that.valorUnitario) && Objects.equals(valorTotal, that.valorTotal) && Objects.equals(descricao, that.descricao) && Objects.equals(os, that.os) && Objects.equals(servico, that.servico) && Objects.equals(funcionario, that.funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInicio, dataFim, quantidade, valorUnitario, valorTotal, descricao, os, servico, funcionario);
    }

    @Override
    public String toString() {
        return "ServicoExecutado{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", descricao='" + descricao + '\'' +
                ", os=" + os +
                ", servico=" + servico +
                ", funcionario=" + funcionario +
                '}';
    }
}
