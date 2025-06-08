package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.ClienteDTO;
import com.PI.AutoGynService.entity.Cliente;
import com.PI.AutoGynService.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin("*")
public class ClienteController {
    private final ServiceCliente serviceCliente;

    @Autowired
    public ClienteController(ServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente;
    }

    @GetMapping
    public List<Cliente> findAll() {
        return serviceCliente.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return serviceCliente.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody ClienteDTO clienteDTO) {
        return serviceCliente.save(clienteDTO);
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        return serviceCliente.update(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceCliente.delete(id);
    }
}
