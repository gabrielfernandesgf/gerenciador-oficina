package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Cliente;
import com.PI.AutoGynService.entity.Veiculo;

import java.time.LocalDate;
import java.util.Objects;

public class PropriedadeDTO {
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Long clienteId;
    private String placaVeiculo;

    public PropriedadeDTO() {}

    public PropriedadeDTO(LocalDate dataInicio, LocalDate dataTermino, Long clienteId, String placaVeiculo) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.clienteId = clienteId;
        this.placaVeiculo = placaVeiculo;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropriedadeDTO that = (PropriedadeDTO) o;
        return Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataTermino, that.dataTermino) && Objects.equals(clienteId, that.clienteId) && Objects.equals(placaVeiculo, that.placaVeiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataInicio, dataTermino, clienteId, placaVeiculo);
    }

    @Override
    public String toString() {
        return "PropriedadeDTO{" +
                "dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", clienteId=" + clienteId +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                '}';
    }
}
