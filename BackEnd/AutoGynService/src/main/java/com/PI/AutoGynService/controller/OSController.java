package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.OSDTO;
import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Status;
import com.PI.AutoGynService.service.ServiceOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/os")
@CrossOrigin("*")
public class OSController {
    private final ServiceOS serviceOS;

    @Autowired
    public OSController(ServiceOS serviceOS) {
        this.serviceOS = serviceOS;
    }

    @GetMapping
    public List<OS> findAll() {
        return serviceOS.findAll();
    }

    @GetMapping("/{id}")
    public OS findById(@PathVariable Long id) {
        return serviceOS.findById(id);
    }

    @GetMapping("/placa/{placaVeiculo}")
    public List<OS> findByPlacaVeiculo(@PathVariable String placaVeiculo) {
        return serviceOS.findByPlacaVeiculo(placaVeiculo);
    }

    @GetMapping("/status/{status}")
    public List<OS> findByStatus(@PathVariable Status status) {
        return serviceOS.findByStatus(status);
    }

    @PostMapping
    public OS save(@RequestBody OSDTO osDTO) {
        return serviceOS.save(osDTO);
    }

    @PutMapping
    public OS update(@RequestBody OS os) {
        return serviceOS.update(os);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceOS.delete(id);
    }
}
