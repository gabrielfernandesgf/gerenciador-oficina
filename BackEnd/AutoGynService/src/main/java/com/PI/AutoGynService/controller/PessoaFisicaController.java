package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.entity.dto.PessoaFisicaDTO;
import com.PI.AutoGynService.entity.PessoaFisica;
import com.PI.AutoGynService.service.ServicePessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoaFisica")
@CrossOrigin("*")
public class PessoaFisicaController {
    private final ServicePessoaFisica servicePessoaFisica;

    @Autowired
    public PessoaFisicaController(ServicePessoaFisica servicePessoaFisica) {
        this.servicePessoaFisica = servicePessoaFisica;
    }

    @GetMapping
    public List<PessoaFisica> findAll() {
        return servicePessoaFisica.findAll();
    }

    @GetMapping("/{id}")
    public PessoaFisica findById(@PathVariable Long id) {
        return servicePessoaFisica.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PessoaFisica pessoaFisica) {
        servicePessoaFisica.save(pessoaFisica);
    }

    @PutMapping
    public PessoaFisica update(@RequestBody PessoaFisicaDTO pessoaFisicaDTO, @PathVariable Long id) {
        return servicePessoaFisica.update(pessoaFisicaDTO, id);
    }
}
