package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Peca;

import java.util.Objects;

public class PecaSubstituirDTO {
    private String descricao;
    private Integer quantidade;
    private Double valorUnitario;
    private Long osId;
    private Long pecaId;

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

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    public Long getPecaId() {
        return pecaId;
    }

    public void setPecaId(Long pecaId) {
        this.pecaId = pecaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PecaSubstituirDTO that = (PecaSubstituirDTO) o;
        return Objects.equals(descricao, that.descricao) && Objects.equals(quantidade, that.quantidade) && Objects.equals(valorUnitario, that.valorUnitario) && Objects.equals(osId, that.osId) && Objects.equals(pecaId, that.pecaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, quantidade, valorUnitario, osId, pecaId);
    }

    @Override
    public String toString() {
        return "PecaSubstituirDTO{" +
                "descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", osId=" + osId +
                ", pecaId=" + pecaId +
                '}';
    }
}
