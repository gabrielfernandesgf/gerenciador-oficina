package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Marca;

import java.util.Objects;

public class ModeloDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Marca marca;

    public ModeloDTO() {
    }

    public ModeloDTO(Long id, String nome, String descricao, Marca marca) {
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
        ModeloDTO modelo = (ModeloDTO) o;
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
