package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.OSDTO;
import com.PI.AutoGynService.entity.OS;
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

    @PostMapping
    public void save(@RequestBody OS os) {
        serviceOS.save(os);
    }

    @PutMapping
    public OS update(@RequestBody OSDTO osdto) {
        return serviceOS.update(osdto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceOS.delete(id);
    }
}
