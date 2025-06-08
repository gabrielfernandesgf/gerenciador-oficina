package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.OficinaDTO;
import com.PI.AutoGynService.entity.Oficina;
import com.PI.AutoGynService.service.ServiceOficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/oficina")
@CrossOrigin("*")
public class OficinaController {
    private final ServiceOficina serviceOficina;

    @Autowired
    public OficinaController(ServiceOficina serviceOficina) {
        this.serviceOficina = serviceOficina;
    }

    @GetMapping
    public List<Oficina> findAll() {
        return serviceOficina.findAll();
    }

    @GetMapping("/{id}")
    public Oficina findById(@PathVariable Long id) {
        return serviceOficina.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Oficina oficina) {
        serviceOficina.save(oficina);
    }

    @PutMapping
    public Oficina update(@RequestBody OficinaDTO oficinaDTO) {
        return serviceOficina.update(oficinaDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceOficina.delete(id);
    }
}
