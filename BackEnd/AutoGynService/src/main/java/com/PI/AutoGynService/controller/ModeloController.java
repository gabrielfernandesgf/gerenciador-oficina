package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.ModeloDTO;
import com.PI.AutoGynService.entity.Modelo;
import com.PI.AutoGynService.service.ServiceModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/modelo")
@CrossOrigin("*")
public class ModeloController {
    private final ServiceModelo serviceModelo;

    @Autowired
    public ModeloController(ServiceModelo serviceModelo) {
        this.serviceModelo = serviceModelo;
    }

    @GetMapping
    public List<Modelo> findAll() {
        return serviceModelo.findAll();
    }

    @GetMapping("/{id}")
    public Modelo findById(@PathVariable Long id) {
        return serviceModelo.findById(id);
    }

    @PostMapping
    public Modelo save(@RequestBody ModeloDTO modeloDTO) {
        return serviceModelo.save(modeloDTO);
    }

    @PutMapping
    public Modelo update(@RequestBody Modelo modelo) {
        return serviceModelo.update(modelo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceModelo.delete(id);
    }
}
