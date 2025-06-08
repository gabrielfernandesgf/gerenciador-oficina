package com.PI.AutoGynService.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;

    public Oficina() {
    }

    public Oficina(Long id, String nome, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oficina oficina = (Oficina) o;
        return Objects.equals(id, oficina.id) && Objects.equals(nome, oficina.nome) && Objects.equals(email, oficina.email) && Objects.equals(endereco, oficina.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, endereco);
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
