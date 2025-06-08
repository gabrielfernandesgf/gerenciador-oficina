package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.PessoaJuridicaDTO;
import com.PI.AutoGynService.entity.PessoaJuridica;
import com.PI.AutoGynService.service.ServicePessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoaJuridica")
@CrossOrigin("*")
public class PessoaJuridicaController {
    private final ServicePessoaJuridica servicePessoaJuridica;

    @Autowired
    public PessoaJuridicaController(ServicePessoaJuridica servicePessoaJuridica) {
        this.servicePessoaJuridica = servicePessoaJuridica;
    }

    @GetMapping
    public List<PessoaJuridica> findAll() {
        return servicePessoaJuridica.findAll();
    }

    @GetMapping("/{id}")
    public PessoaJuridica findById(@PathVariable Long id) {
        return servicePessoaJuridica.findById(id);
    }

    @PostMapping
    public PessoaJuridica save(@RequestBody PessoaJuridicaDTO pessoaJuridicaDTO) {
        return servicePessoaJuridica.save(pessoaJuridicaDTO);
    }

    @PutMapping
    public PessoaJuridica update(@RequestBody PessoaJuridica pessoaJuridica) {
        return servicePessoaJuridica.update(pessoaJuridica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePessoaJuridica.delete(id);
    }
}
