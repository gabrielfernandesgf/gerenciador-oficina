package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idMarca", nullable = false)
    private Marca marca;

    public Modelo() {
    }

    public Modelo(Long id, String nome, String descricao, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(id, modelo.id) && Objects.equals(nome, modelo.nome) && Objects.equals(descricao, modelo.descricao) && Objects.equals(marca, modelo.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, marca);
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca=" + marca +
                '}';
    }
}
