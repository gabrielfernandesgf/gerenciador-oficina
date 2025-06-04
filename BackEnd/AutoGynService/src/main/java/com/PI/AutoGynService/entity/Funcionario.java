package com.PI.AutoGynService.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "dataEntrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "dataSaida")
    private LocalDate dataSaida;

    @Column(name = "telefone", nullable = false, length = 13)
    private String telefone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    public Funcionario() {
    }

    public Funcionario(Long id, String cpf, String nome, LocalDate dataEntrada, LocalDate dataSaida, String telefone, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf) && Objects.equals(nome, that.nome) && Objects.equals(dataEntrada, that.dataEntrada) && Objects.equals(dataSaida, that.dataSaida) && Objects.equals(telefone, that.telefone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome, dataEntrada, dataSaida, telefone, email);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
