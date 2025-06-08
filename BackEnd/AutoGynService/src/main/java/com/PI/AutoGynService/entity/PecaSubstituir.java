package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

@Entity
public class PecaSubstituir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descicao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valorUnitario", nullable = false)
    private Double valorUnitario;

    @Column(name = "valorTotal", nullable = false)
    private Double valorTotal;

    @ManyToOne
    private OS os;

    @ManyToOne
    private Peca peca;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
