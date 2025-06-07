package com.PI.AutoGynService.dto;

import java.util.Objects;

public class MarcaDTO {

    private Long id;

    private String nome;

    private String descricao;

    public MarcaDTO() {
    }

    public MarcaDTO(Long id, String nome, String descricao) {
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
        com.PI.AutoGynService.dto.MarcaDTO marca = (com.PI.AutoGynService.dto.MarcaDTO) o;
        return Objects.equals(id, marca.id) && Objects.equals(nome, marca.nome) && Objects.equals(descricao, marca.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao);
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
