package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.VeiculoDTO;
import com.PI.AutoGynService.entity.Veiculo;
import com.PI.AutoGynService.service.ServiceVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculo")
@CrossOrigin("*")
public class VeiculoController {
    private final ServiceVeiculo serviceVeiculo;

    @Autowired
    public VeiculoController(ServiceVeiculo serviceVeiculo) {
        this.serviceVeiculo = serviceVeiculo;
    }

    @GetMapping
    public List<Veiculo> findAll() {
        return serviceVeiculo.findAll();
    }

    @GetMapping("/{id}")
    public Veiculo findByPlaca(@PathVariable String placa) {
        return serviceVeiculo.findByPlaca(placa);
    }

    @PostMapping
    public Veiculo save(@RequestBody VeiculoDTO veiculoDTO) {
        return serviceVeiculo.save(veiculoDTO);
    }

    @PutMapping
    public Veiculo update(@RequestBody Veiculo veiculo) {
        return serviceVeiculo.update(veiculo);
    }

    @DeleteMapping("/{placa}")
    public void delete(@PathVariable String placa) {
        serviceVeiculo.delete(placa);
    }
}
