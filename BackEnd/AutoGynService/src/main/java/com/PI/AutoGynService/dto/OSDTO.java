package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Status;
import com.PI.AutoGynService.entity.Veiculo;

import java.time.LocalDate;
import java.util.Objects;

public class OSDTO {
    private Status status;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valorPago;
    private String placaVeiculo;

    public OSDTO() {}

    public OSDTO(Status status, LocalDate dataInicio, LocalDate dataFim, Double valorPago, String placaVeiculo) {
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorPago = valorPago;
        this.placaVeiculo = placaVeiculo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
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
        OSDTO osdto = (OSDTO) o;
        return status == osdto.status && Objects.equals(dataInicio, osdto.dataInicio) && Objects.equals(dataFim, osdto.dataFim) && Objects.equals(valorPago, osdto.valorPago) && Objects.equals(placaVeiculo, osdto.placaVeiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, dataInicio, dataFim, valorPago, placaVeiculo);
    }

    @Override
    public String toString() {
        return "OSDTO{" +
                "status=" + status +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", valorPago=" + valorPago +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                '}';
    }
}
