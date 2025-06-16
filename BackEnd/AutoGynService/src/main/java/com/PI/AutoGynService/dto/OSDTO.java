package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Status;
import com.PI.AutoGynService.entity.Veiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class OSDTO {
    private Status status;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valorPago;
    private String placaVeiculo;
    private List<PecaSubstituirDTO> pecasSubstituir;
    private List<ServicoExecutadoDTO> servicosExecutados;

    public OSDTO() {}

    public OSDTO(Status status, LocalDate dataInicio, LocalDate dataFim, Double valorPago, String placaVeiculo, List<PecaSubstituirDTO> pecasSubstituir, List<ServicoExecutadoDTO> servicosExecutados) {
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorPago = valorPago;
        this.placaVeiculo = placaVeiculo;
        this.pecasSubstituir = pecasSubstituir;
        this.servicosExecutados = servicosExecutados;
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

    public List<PecaSubstituirDTO> getPecasSubstituir() {
        return pecasSubstituir;
    }

    public void setPecasSubstituir(List<PecaSubstituirDTO> pecasSubstituir) {
        this.pecasSubstituir = pecasSubstituir;
    }

    public List<ServicoExecutadoDTO> getServicosExecutados() {
        return servicosExecutados;
    }

    public void setServicosExecutados(List<ServicoExecutadoDTO> servicosExecutados) {
        this.servicosExecutados = servicosExecutados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OSDTO osdto = (OSDTO) o;
        return status == osdto.status && Objects.equals(dataInicio, osdto.dataInicio) && Objects.equals(dataFim, osdto.dataFim) && Objects.equals(valorPago, osdto.valorPago) && Objects.equals(placaVeiculo, osdto.placaVeiculo) && Objects.equals(pecasSubstituir, osdto.pecasSubstituir) && Objects.equals(servicosExecutados, osdto.servicosExecutados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, dataInicio, dataFim, valorPago, placaVeiculo, pecasSubstituir, servicosExecutados);
    }

    @Override
    public String toString() {
        return "OSDTO{" +
                "status=" + status +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", valorPago=" + valorPago +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", pecasSubstituir=" + pecasSubstituir +
                ", servicosExecutados=" + servicosExecutados +
                '}';
    }
}
