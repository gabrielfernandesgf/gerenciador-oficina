package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ServicoExecutado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataInicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "dataFim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valorUnitario", nullable = false)
    private Double valorUnitario;

    @Column(name = "valorTotal", nullable = false)
    private Double valorTotal;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    private OS os;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "funcionarioId")
    private Funcionario funcionario;

    public ServicoExecutado() {
    }

    public ServicoExecutado(Long id, LocalDate dataInicio, LocalDate dataFim, Integer quantidade, Double valorUnitario, Double valorTotal, String descricao, OS os, Servico servico, Funcionario funcionario) {
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
        ServicoExecutado that = (ServicoExecutado) o;
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
