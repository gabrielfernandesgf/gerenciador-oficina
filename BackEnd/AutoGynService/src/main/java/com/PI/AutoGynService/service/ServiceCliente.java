package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.ClienteDTO;
import com.PI.AutoGynService.entity.Cliente;
import com.PI.AutoGynService.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCliente {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente save(ClienteDTO clienteDTO){
        if (clienteDTO.getNome() == null || clienteDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (clienteDTO.getEmail() == null || clienteDTO.getEmail().trim().isEmpty())
            throw new RuntimeException("Email é obrigatório");
        if (clienteDTO.getTelefone() == null || clienteDTO.getTelefone().trim().isEmpty())
            throw new RuntimeException("Telefone é obrigatório.");
        if (clienteDTO.getEndereco() == null || clienteDTO.getEndereco().trim().isEmpty())
            throw new RuntimeException("Endereço é obrigatório.");
        if (clienteDTO.getCep() == null || clienteDTO.getCep().trim().isEmpty())
            throw new RuntimeException("CEP é obrigatório.");

        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setCep(clienteDTO.getCep());

        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente update(Cliente cliente){
        Cliente cliente1 = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + cliente.getId()));

        if(cliente.getCep() != null){
            cliente1.setCep(cliente.getCep());
        }
        if(cliente.getEmail() != null){
            cliente1.setEmail(cliente.getEmail());
        }
        if(cliente.getEndereco() != null){
            cliente1.setEndereco(cliente.getEndereco());
        }
        if(cliente.getNome() != null){
            cliente1.setNome(cliente.getNome());
        }
        if(cliente.getTelefone() != null){
            cliente1.setTelefone(cliente.getTelefone());
        }

        return clienteRepository.save(cliente1);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
