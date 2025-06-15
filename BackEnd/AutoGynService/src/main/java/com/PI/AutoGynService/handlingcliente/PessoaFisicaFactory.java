package com.PI.AutoGynService.handlingcliente;

import com.PI.AutoGynService.entity.PessoaFisica;

public class PessoaFisicaFactory implements ClienteFactory {
    @Override
    public PessoaFisica criarCliente() {
        return new PessoaFisica();
    }
}