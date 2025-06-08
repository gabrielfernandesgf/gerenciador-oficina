package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.ServicoExecutadoDTO;
import com.PI.AutoGynService.entity.ServicoExecutado;
import com.PI.AutoGynService.service.ServiceServicoExecutado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/servicoExecutado")
@CrossOrigin("*")
public class ServicoExecutadoController {
    private final ServiceServicoExecutado serviceServicoExecutado;

    @Autowired
    public ServicoExecutadoController(ServiceServicoExecutado serviceServicoExecutado) {
        this.serviceServicoExecutado = serviceServicoExecutado;
    }

    @GetMapping
    public List<ServicoExecutado> findAll() {
        return serviceServicoExecutado.findAll();
    }

    @GetMapping("/{id}")
    public ServicoExecutado findById(@PathVariable Long id) {
        return serviceServicoExecutado.findById(id);
    }

    @PostMapping
    public ServicoExecutado save(@RequestBody ServicoExecutadoDTO servicoExecutadoDTO) {
        return serviceServicoExecutado.save(servicoExecutadoDTO);
    }

    @PutMapping
    public ServicoExecutado update(@RequestBody ServicoExecutado servicoExecutado) {
        return serviceServicoExecutado.update(servicoExecutado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceServicoExecutado.delete(id);
    }
}
