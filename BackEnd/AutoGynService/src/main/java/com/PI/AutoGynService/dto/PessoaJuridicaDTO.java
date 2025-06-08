package com.PI.AutoGynService.dto;

import java.util.Objects;

public class PessoaJuridicaDTO extends ClienteDTO {
    private String cnpj;
    private String razaoSocial;
    private String inscricaoSocial;
    private String nomeResposavel;
    private String contatoResponsavel;

    public PessoaJuridicaDTO() {}

    public PessoaJuridicaDTO(String nome, String email, String telefone, String endereco, String cep, String cnpj, String razaoSocial, String inscricaoSocial, String nomeResposavel, String contatoResponsavel) {
        super(nome, email, telefone, endereco, cep);
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
        PessoaJuridicaDTO that = (PessoaJuridicaDTO) o;
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
