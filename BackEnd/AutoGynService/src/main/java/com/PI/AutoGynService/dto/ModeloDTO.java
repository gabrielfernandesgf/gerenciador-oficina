package com.PI.AutoGynService.dto;

import com.PI.AutoGynService.entity.Marca;

import java.util.Objects;

public class ModeloDTO {
    private String nome;
    private String descricao;
    private Long marcaId;

    public ModeloDTO() {}

    public ModeloDTO(String nome, String descricao, Long marcaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.marcaId = marcaId;
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

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloDTO modeloDTO = (ModeloDTO) o;
        return Objects.equals(nome, modeloDTO.nome) && Objects.equals(descricao, modeloDTO.descricao) && Objects.equals(marcaId, modeloDTO.marcaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, marcaId);
    }

    @Override
    public String toString() {
        return "ModeloDTO{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marcaId=" + marcaId +
                '}';
    }
}
