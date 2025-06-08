package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.PecaDTO;
import com.PI.AutoGynService.entity.Peca;
import com.PI.AutoGynService.service.ServicePeca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/peca")
@CrossOrigin("*")
public class PecaController {
    private final ServicePeca servicePeca;

    @Autowired
    public PecaController(ServicePeca servicePeca) {
        this.servicePeca = servicePeca;
    }

    @GetMapping
    public List<Peca> findAll() {
        return servicePeca.findAll();
    }

    @GetMapping("/{id}")
    public Peca findById(@PathVariable Long id) {
        return servicePeca.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Peca peca) {
        servicePeca.save(peca);
    }

    @PutMapping
    public Peca update(@RequestBody PecaDTO pecaDTO, @PathVariable Long id) {
        return servicePeca.update(pecaDTO, id);
    }
}
