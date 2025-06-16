package com.PI.AutoGynService.handlingcliente;

import com.PI.AutoGynService.entity.PessoaJuridica;

public class PessoaJuridicaFactory implements ClienteFactory {
    @Override
    public PessoaJuridica criarCliente() {
        return new PessoaJuridica();
    }
}
