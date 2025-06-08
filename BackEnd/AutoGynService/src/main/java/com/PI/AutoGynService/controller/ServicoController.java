package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.ServicoDTO;
import com.PI.AutoGynService.entity.Servico;
import com.PI.AutoGynService.service.ServiceServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/servico")
@CrossOrigin("*")
public class ServicoController {
    private final ServiceServico serviceServico;

    @Autowired
    public ServicoController(ServiceServico serviceServico) {
        this.serviceServico = serviceServico;
    }

    @GetMapping
    public List<Servico> findAll() {
        return serviceServico.findAll();
    }

    @GetMapping("/{id}")
    public Servico findById(@PathVariable Long id) {
        return serviceServico.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Servico servico) {
        serviceServico.save(servico);
    }

    @PutMapping
    public Servico update(@RequestBody ServicoDTO servicoDTO) {
        return serviceServico.upadate(servicoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceServico.delete(id);
    }
}
