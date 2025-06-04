package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Veiculo {
    @Id
    private String placa;

    @Column(name = "chassi", nullable = false)
    private String chassi;

    @Column(name = "renavan", nullable = false)
    private String renavan;

    @Column(name = "anoFabricacao", nullable = false, length = 4)
    private int anoFabricacao;

    @Column(name = "anoModelo", nullable = false, length = 4)
    private int anoModelo;

    @Column(name = "quilometragem", nullable = false)
    private int quilometragem;

    @Column(name = "identificadorPatrimonio")
    private String identificadorPatrimonio;

    @ManyToOne
    @JoinColumn(name = "idModelo")
    private Modelo modelo;

    public Veiculo() {
    }

    public Veiculo(String placa, String chassi, String renavan, int anoFabricacao, int anoModelo, int quilometragem, String identificadorPatrimonio, Modelo modelo) {
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
        Veiculo veiculo = (Veiculo) o;
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
