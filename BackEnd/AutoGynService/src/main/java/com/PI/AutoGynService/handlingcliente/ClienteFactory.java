package com.PI.AutoGynService.handlingcliente;

import com.PI.AutoGynService.entity.Cliente;

//O Factory Method é um padrão criacional que fornece uma interface
//para criar objetos, mas permite que as subclasses decidam qual classe instanciar.
//Ele encapsula a lógica de criação e delega isso a uma "fábrica".
public interface ClienteFactory {
    Cliente criarCliente();
}
