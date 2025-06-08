package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.ClienteDTO;
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
    public void save(@RequestBody Cliente cliente) {
        serviceCliente.save(cliente);
    }

    @PutMapping
    public Cliente update(@RequestBody ClienteDTO clienteDTO) {
        return serviceCliente.update(clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceCliente.delete(id);
    }
}
