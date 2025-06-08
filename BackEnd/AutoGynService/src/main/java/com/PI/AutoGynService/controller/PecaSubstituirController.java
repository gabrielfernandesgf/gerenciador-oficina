package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.PecaSubstituirDTO;
import com.PI.AutoGynService.entity.PecaSubstituir;
import com.PI.AutoGynService.service.ServicePecaSubstituir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pecaSubstituir")
@CrossOrigin("*")
public class PecaSubstituirController {
    private final ServicePecaSubstituir servicePecaSubstituir;

    @Autowired
    public PecaSubstituirController(ServicePecaSubstituir servicePecaSubstituir) {
        this.servicePecaSubstituir = servicePecaSubstituir;
    }

    @GetMapping
    public List<PecaSubstituir> findAll() {
        return servicePecaSubstituir.findAll();
    }

    @GetMapping("/{id}")
    public PecaSubstituir findById(@PathVariable Long id) {
        return servicePecaSubstituir.findById(id);
    }

    @PostMapping
    public PecaSubstituir save(@RequestBody PecaSubstituirDTO pecaSubstituirDTO) {
        return servicePecaSubstituir.save(pecaSubstituirDTO);
    }

    @PutMapping
    public PecaSubstituir update(@RequestBody PecaSubstituir pecaSubstituir) {
        return servicePecaSubstituir.update(pecaSubstituir);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePecaSubstituir.delete(id);
    }
}
