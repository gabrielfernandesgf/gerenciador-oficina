package com.PI.AutoGynService.entity.dto;

import com.PI.AutoGynService.entity.Acessorio;
import com.PI.AutoGynService.entity.Veiculo;

import java.util.Objects;

public class VeiculoAcessorioDTO {

    private Long id;

    private Veiculo veiculo;

    private Acessorio acessorio;

    public VeiculoAcessorioDTO() {
    }

    public VeiculoAcessorioDTO(Long id, Veiculo veiculo, Acessorio acessorio) {
        id = id;
        this.veiculo = veiculo;
        this.acessorio = acessorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoAcessorioDTO that = (VeiculoAcessorioDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(veiculo, that.veiculo) && Objects.equals(acessorio, that.acessorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, veiculo, acessorio);
    }

    @Override
    public String toString() {
        return "VeiculoAcessorio{" +
                "id=" + id +
                ", veiculo=" + veiculo +
                ", acessorio=" + acessorio +
                '}';
    }
}
