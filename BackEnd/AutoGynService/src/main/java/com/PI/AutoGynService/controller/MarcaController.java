package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.MarcaDTO;
import com.PI.AutoGynService.entity.Marca;
import com.PI.AutoGynService.service.ServiceMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marca")
@CrossOrigin("*")
public class MarcaController {
    private final ServiceMarca serviceMarca;

    @Autowired
    public MarcaController(ServiceMarca serviceMarca) {
        this.serviceMarca = serviceMarca;
    }

    @GetMapping
    public List<Marca> findAll() {
        return serviceMarca.findAll();
    }

    @GetMapping("/{id}")
    public Marca findById(@PathVariable Long id) {
        return serviceMarca.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Marca marca) {
        serviceMarca.save(marca);
    }

    @PutMapping
    public Marca update(@RequestBody MarcaDTO marcaDTO) {
        return serviceMarca.update(marcaDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceMarca.delete(id);
    }
}
