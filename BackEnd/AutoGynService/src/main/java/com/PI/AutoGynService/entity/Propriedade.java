package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataInicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "dataTermino", nullable = false)
    private LocalDate dataTermino;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "placaVeiculo")
    private Veiculo veiculo;

    public Propriedade() {
    }

    public Propriedade(Long id, LocalDate dataInicio, LocalDate dataTermino, Cliente cliente, Veiculo veiculo) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.cliente = cliente;
        this.veiculo = veiculo;
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

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propriedade that = (Propriedade) o;
        return Objects.equals(id, that.id) && Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataTermino, that.dataTermino) && Objects.equals(cliente, that.cliente) && Objects.equals(veiculo, that.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInicio, dataTermino, cliente, veiculo);
    }

    @Override
    public String toString() {
        return "Propriedade{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                '}';
    }
}
