package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.ServicoExecutadoDTO;
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
    public void save(@RequestBody ServicoExecutado servicoExecutado) {
        serviceServicoExecutado.save(servicoExecutado);
    }

    @PutMapping
    public ServicoExecutado update(@RequestBody ServicoExecutadoDTO servicoExecutadoDTO, @PathVariable Long id) {
        return serviceServicoExecutado.update(servicoExecutadoDTO, id);
    }
}
