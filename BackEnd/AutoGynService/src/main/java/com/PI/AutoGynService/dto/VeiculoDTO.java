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
    private Long modeloID;

    public VeiculoDTO() {}

    public VeiculoDTO(String placa, String chassi, String renavan, int anoFabricacao, int anoModelo, int quilometragem, String identificadorPatrimonio, Long modeloID) {
        this.placa = placa;
        this.chassi = chassi;
        this.renavan = renavan;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.quilometragem = quilometragem;
        this.identificadorPatrimonio = identificadorPatrimonio;
        this.modeloID = modeloID;
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

    public Long getModeloID() {
        return modeloID;
    }

    public void setModeloID(Long modeloID) {
        this.modeloID = modeloID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoDTO that = (VeiculoDTO) o;
        return anoFabricacao == that.anoFabricacao && anoModelo == that.anoModelo && quilometragem == that.quilometragem && Objects.equals(placa, that.placa) && Objects.equals(chassi, that.chassi) && Objects.equals(renavan, that.renavan) && Objects.equals(identificadorPatrimonio, that.identificadorPatrimonio) && Objects.equals(modeloID, that.modeloID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, chassi, renavan, anoFabricacao, anoModelo, quilometragem, identificadorPatrimonio, modeloID);
    }

    @Override
    public String toString() {
        return "VeiculoDTO{" +
                "placa='" + placa + '\'' +
                ", chassi='" + chassi + '\'' +
                ", renavan='" + renavan + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                ", quilometragem=" + quilometragem +
                ", identificadorPatrimonio='" + identificadorPatrimonio + '\'' +
                ", modeloID=" + modeloID +
                '}';
    }
}
