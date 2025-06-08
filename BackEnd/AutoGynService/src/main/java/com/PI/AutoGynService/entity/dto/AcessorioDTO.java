package com.PI.AutoGynService.entity.dto;


import java.util.Objects;

public class AcessorioDTO {

    private Long id;

    private String nome;

    private String descricao;

    public AcessorioDTO() {
    }

    public AcessorioDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcessorioDTO acessorio = (AcessorioDTO) o;
        return Objects.equals(id, acessorio.id) && Objects.equals(nome, acessorio.nome) && Objects.equals(descricao, acessorio.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao);
    }

    @Override
    public String toString() {
        return "Acessorio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
