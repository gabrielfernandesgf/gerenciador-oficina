package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Modelo;

import java.util.Objects;

public class VeiculoDTO {

    private String placa;

    private String chassi;

    private String renavan;

    private int anoFabricacao;

    private int anoModelo;

    private int quilometragem;

    private String identificadorPatrimonio;

    private Modelo modelo;

    public VeiculoDTO() {
    }

    public VeiculoDTO(String placa, String chassi, String renavan, int anoFabricacao, int anoModelo, int quilometragem, String identificadorPatrimonio, Modelo modelo) {
        this.placa = placa;
        this.chassi = chassi;
        this.renavan = renavan;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.quilometragem = quilometragem;
        this.identificadorPatrimonio = identificadorPatrimonio;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getIdentificadorPatrimonio() {
        return identificadorPatrimonio;
    }

    public void setIdentificadorPatrimonio(String identificadorPatrimonio) {
        this.identificadorPatrimonio = identificadorPatrimonio;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoDTO veiculo = (com.PI.AutoGynService.dto.VeiculoDTO) o;
        return anoFabricacao == veiculo.anoFabricacao && anoModelo == veiculo.anoModelo && quilometragem == veiculo.quilometragem && Objects.equals(placa, veiculo.placa) && Objects.equals(chassi, veiculo.chassi) && Objects.equals(renavan, veiculo.renavan) && Objects.equals(identificadorPatrimonio, veiculo.identificadorPatrimonio) && Objects.equals(modelo, veiculo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, chassi, renavan, anoFabricacao, anoModelo, quilometragem, identificadorPatrimonio, modelo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", chassi='" + chassi + '\'' +
                ", renavan='" + renavan + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                ", quilometragem=" + quilometragem +
                ", identificadorPatrimonio='" + identificadorPatrimonio + '\'' +
                ", modelo=" + modelo +
                '}';
    }
}
