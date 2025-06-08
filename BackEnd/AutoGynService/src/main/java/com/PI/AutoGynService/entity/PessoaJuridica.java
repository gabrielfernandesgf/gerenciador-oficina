package com.PI.AutoGynService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class PessoaJuridica extends Cliente{
    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "razaoSocial", nullable = false, length = 255)
    private String razaoSocial;

    @Column(name = "inscricaoEstadual", nullable = false, length = 255)
    private String inscricaoSocial;

    @Column(name = "nomeResponsavel", nullable = false, length = 100)
    private String nomeResposavel;

    @Column(name = "contatoResponsavel", nullable = false, length = 13)
    private String contatoResponsavel;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id, String nome, String email, String telefone, String endereco, String cep, String cnpj, String razaoSocial, String inscricaoSocial, String nomeResposavel, String contatoResponsavel) {
        super(id, nome, email, telefone, endereco, cep);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoSocial = inscricaoSocial;
        this.nomeResposavel = nomeResposavel;
        this.contatoResponsavel = contatoResponsavel;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoSocial() {
        return inscricaoSocial;
    }

    public void setInscricaoSocial(String inscricaoSocial) {
        this.inscricaoSocial = inscricaoSocial;
    }

    public String getNomeResposavel() {
        return nomeResposavel;
    }

    public void setNomeResposavel(String nomeResposavel) {
        this.nomeResposavel = nomeResposavel;
    }

    public String getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(String contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj) && Objects.equals(razaoSocial, that.razaoSocial) && Objects.equals(inscricaoSocial, that.inscricaoSocial) && Objects.equals(nomeResposavel, that.nomeResposavel) && Objects.equals(contatoResponsavel, that.contatoResponsavel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cnpj, razaoSocial, inscricaoSocial, nomeResposavel, contatoResponsavel);
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", inscricaoSocial='" + inscricaoSocial + '\'' +
                ", nomeResposavel='" + nomeResposavel + '\'' +
                ", contatoResponsavel='" + contatoResponsavel + '\'' +
                '}';
    }
}
