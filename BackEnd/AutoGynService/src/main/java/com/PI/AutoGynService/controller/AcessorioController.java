package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.AcessorioDTO;
import com.PI.AutoGynService.entity.Acessorio;
import com.PI.AutoGynService.service.ServiceAcessorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/acessorio")
@CrossOrigin("*")
public class AcessorioController {
    private final ServiceAcessorio serviceAcessorio;

    @Autowired
    public AcessorioController(ServiceAcessorio serviceAcessorio) {
        this.serviceAcessorio = serviceAcessorio;
    }

    @GetMapping
    public List<Acessorio> findAll() {
        return serviceAcessorio.findAll();
    }

    @GetMapping("/{id}")
    public Acessorio findById(@PathVariable Long id) {
        return serviceAcessorio.findById(id);
    }

    @PostMapping
    public Acessorio save(@RequestBody AcessorioDTO acessorio) {
        return serviceAcessorio.save(acessorio);
    }

    @PutMapping
    public Acessorio update(@RequestBody Acessorio acessorio) {
        return serviceAcessorio.update(acessorio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceAcessorio.delete(id);
    }
}
