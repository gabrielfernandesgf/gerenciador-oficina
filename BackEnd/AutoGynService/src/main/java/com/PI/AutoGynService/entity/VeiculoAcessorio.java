package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class VeiculoAcessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "placaVeiculo")
    private Veiculo veiculo;

    @ManyToOne
    private Acessorio acessorio;

    public VeiculoAcessorio() {
    }

    public VeiculoAcessorio(Long id, Veiculo veiculo, Acessorio acessorio) {
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
        VeiculoAcessorio that = (VeiculoAcessorio) o;
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
