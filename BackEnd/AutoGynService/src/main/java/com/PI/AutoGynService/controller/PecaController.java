package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.PecaDTO;
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
    public Peca save(@RequestBody PecaDTO pecaDTO) {
        return servicePeca.save(pecaDTO);
    }

    @PutMapping
    public Peca update(@RequestBody Peca peca) {
        return servicePeca.update(peca);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePeca.delete(id);
    }
}
