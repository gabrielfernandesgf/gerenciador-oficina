package com.PI.AutoGynService.dto;

import java.util.Objects;

public class MarcaDTO {
    private String nome;
    private String descricao;

    public MarcaDTO() {
    }

    public MarcaDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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
        MarcaDTO marcaDTO = (MarcaDTO) o;
        return Objects.equals(nome, marcaDTO.nome) && Objects.equals(descricao, marcaDTO.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    @Override
    public String toString() {
        return "MarcaDTO{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
