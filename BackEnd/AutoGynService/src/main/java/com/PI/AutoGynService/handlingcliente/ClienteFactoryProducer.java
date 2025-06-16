package com.PI.AutoGynService.handlingcliente;

public class ClienteFactoryProducer {
    public static ClienteFactory getFactory(String tipo) {
        if ("pf".equalsIgnoreCase(tipo)) {
            return new PessoaFisicaFactory();
        } else if ("pj".equalsIgnoreCase(tipo)) {
            return new PessoaJuridicaFactory();
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + tipo);
    }
}
