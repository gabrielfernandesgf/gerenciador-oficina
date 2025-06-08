package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.PropriedadeDTO;
import com.PI.AutoGynService.entity.Propriedade;
import com.PI.AutoGynService.service.ServicePropriedade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/propriedade")
@CrossOrigin("*")
public class PropriedadeController {
    private final ServicePropriedade servicePropriedade;

    @Autowired
    public PropriedadeController(ServicePropriedade servicePropriedade) {
        this.servicePropriedade = servicePropriedade;
    }

    @GetMapping
    public List<Propriedade> findAll() {
        return servicePropriedade.findAll();
    }

    @GetMapping("/{id}")
    public Propriedade findById(@PathVariable Long id) {
        return servicePropriedade.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Propriedade propriedade) {
        servicePropriedade.save(propriedade);
    }

    @PutMapping
    public Propriedade update(@RequestBody PropriedadeDTO propriedadeDTO) {
        return servicePropriedade.update(propriedadeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePropriedade.delete(id);
    }
}
