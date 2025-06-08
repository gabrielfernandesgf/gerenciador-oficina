package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.PessoaFisicaDTO;
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
    public PessoaFisica save(@RequestBody PessoaFisicaDTO pessoaFisicaDTO) {
        return servicePessoaFisica.save(pessoaFisicaDTO);
    }

    @PutMapping
    public PessoaFisica update(@RequestBody PessoaFisica pessoaFisica) {
        return servicePessoaFisica.update(pessoaFisica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePessoaFisica.delete(id);
    }
}
