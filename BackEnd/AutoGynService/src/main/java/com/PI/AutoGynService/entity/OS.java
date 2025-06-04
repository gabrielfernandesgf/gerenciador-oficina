package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class OS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "dataInicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "dataFim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "valoTotal", nullable = false)
    private Double valorTotal;

    @Column(name = "valorPago", nullable = false)
    private Double valorPago;

    @ManyToOne
    @JoinColumn(name = "placaVeiculo")
    private Veiculo veiculo;

    public OS() {
    }

    public OS(Long id, Status status, LocalDate dataInicio, LocalDate dataFim, Double valorTotal, Double valorPago, Veiculo veiculo) {
        this.id = id;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
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
        OS os = (OS) o;
        return Objects.equals(id, os.id) && status == os.status && Objects.equals(dataInicio, os.dataInicio) && Objects.equals(dataFim, os.dataFim) && Objects.equals(valorTotal, os.valorTotal) && Objects.equals(valorPago, os.valorPago) && Objects.equals(veiculo, os.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, dataInicio, dataFim, valorTotal, valorPago, veiculo);
    }

    @Override
    public String toString() {
        return "OS{" +
                "id=" + id +
                ", status=" + status +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", valorTotal=" + valorTotal +
                ", valorPago=" + valorPago +
                ", veiculo=" + veiculo +
                '}';
    }
}
