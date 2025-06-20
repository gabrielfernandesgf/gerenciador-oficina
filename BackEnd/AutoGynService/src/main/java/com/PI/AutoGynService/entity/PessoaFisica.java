package com.PI.AutoGynService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class PessoaFisica extends Cliente{
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "dataDeNascimento", nullable = false)
    private LocalDate dataDeNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(Long id, String nome, String email, String telefone, String endereco, String cep, String cpf, LocalDate dataDeNascimento) {
        super(id, nome, email, telefone, endereco, cep);
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(dataDeNascimento, that.dataDeNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, dataDeNascimento);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}
