package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Acessorio;
import com.PI.AutoGynService.entity.Veiculo;

import java.util.Objects;

public class VeiculoAcessorioDTO {
    private String veiculoPlaca;
    private Long acessorioId;

    public VeiculoAcessorioDTO() {}

    public VeiculoAcessorioDTO(String veiculoPlaca, Long acessorioId) {
        this.veiculoPlaca = veiculoPlaca;
        this.acessorioId = acessorioId;
    }

    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public Long getAcessorioId() {
        return acessorioId;
    }

    public void setAcessorioId(Long acessorioId) {
        this.acessorioId = acessorioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoAcessorioDTO that = (VeiculoAcessorioDTO) o;
        return Objects.equals(veiculoPlaca, that.veiculoPlaca) && Objects.equals(acessorioId, that.acessorioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(veiculoPlaca, acessorioId);
    }

    @Override
    public String toString() {
        return "VeiculoAcessorioDTO{" +
                "veiculoPlaca='" + veiculoPlaca + '\'' +
                ", acessorioId=" + acessorioId +
                '}';
    }
}
