package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.VeiculoAcessorioDTO;
import com.PI.AutoGynService.entity.VeiculoAcessorio;
import com.PI.AutoGynService.service.ServiceVeiculoAcessorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculoAcessorio")
@CrossOrigin("*")
public class VeiculoAcessorioController {
    private final ServiceVeiculoAcessorio serviceVeiculoAcessorio;

    @Autowired
    public VeiculoAcessorioController(ServiceVeiculoAcessorio serviceVeiculoAcessorio) {
        this.serviceVeiculoAcessorio = serviceVeiculoAcessorio;
    }

    @GetMapping
    public List<VeiculoAcessorio> findAll() {
        return serviceVeiculoAcessorio.findAll();
    }

    @GetMapping("/{id}")
    public VeiculoAcessorio findById(@PathVariable Long id) {
        return serviceVeiculoAcessorio.findById(id);
    }

    @PostMapping
    public void save(@RequestBody VeiculoAcessorio veiculoAcessorio) {
        serviceVeiculoAcessorio.save(veiculoAcessorio);
    }

    @PutMapping
    public VeiculoAcessorio update(@RequestBody VeiculoAcessorioDTO veiculoAcessorioDTO) {
        return serviceVeiculoAcessorio.update(veiculoAcessorioDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceVeiculoAcessorio.delete(id);
    }
}
