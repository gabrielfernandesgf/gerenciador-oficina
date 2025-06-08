package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "valorUnitario", nullable = false)
    private Double valorUnitario;

    public Servico() {
    }

    public Servico(Long id, String nome, String descricao, Double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        Servico servico = (Servico) o;
        return Objects.equals(id, servico.id) && Objects.equals(nome, servico.nome) && Objects.equals(descricao, servico.descricao) && Objects.equals(valorUnitario, servico.valorUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, valorUnitario);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
