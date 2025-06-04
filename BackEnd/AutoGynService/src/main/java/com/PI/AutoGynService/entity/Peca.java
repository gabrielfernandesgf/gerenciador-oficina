package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "fabricante", nullable = false, length = 100)
    private String fabricante;

    @Column(name = "volumeTamanho", nullable = false, length = 50)
    private String volumeTamanho;

    @Column(name = "quantidadeEstoque", nullable = false)
    private Integer quantidadeEstoque;

    @Column(name = "valorUnitario", nullable = false)
    private Double valorUnitario;

    public Peca() {
    }

    public Peca(Long id, String nome, String fabricante, String volumeTamanho, Integer quantidadeEstoque, Double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.volumeTamanho = volumeTamanho;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = valorUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getVolumeTamanho() {
        return volumeTamanho;
    }

    public void setVolumeTamanho(String volumeTamanho) {
        this.volumeTamanho = volumeTamanho;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peca peca = (Peca) o;
        return Objects.equals(id, peca.id) && Objects.equals(nome, peca.nome) && Objects.equals(fabricante, peca.fabricante) && Objects.equals(volumeTamanho, peca.volumeTamanho) && Objects.equals(quantidadeEstoque, peca.quantidadeEstoque) && Objects.equals(valorUnitario, peca.valorUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, fabricante, volumeTamanho, quantidadeEstoque, valorUnitario);
    }

    @Override
    public String toString() {
        return "Peca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", volumeTamanho='" + volumeTamanho + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
