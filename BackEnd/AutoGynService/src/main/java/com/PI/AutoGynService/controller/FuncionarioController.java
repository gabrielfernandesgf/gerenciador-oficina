package com.PI.AutoGynService.controller;

import com.PI.AutoGynService.dto.FuncionarioDTO;
import com.PI.AutoGynService.entity.Funcionario;
import com.PI.AutoGynService.service.ServiceFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funcionario")
@CrossOrigin("*")
public class FuncionarioController {
    private final ServiceFuncionario serviceFuncionario;

    @Autowired
    public FuncionarioController(ServiceFuncionario serviceFuncionario) {
        this.serviceFuncionario = serviceFuncionario;
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return serviceFuncionario.findAll();
    }

    @GetMapping("/{id}")
    public Funcionario findById(@PathVariable Long id) {
        return serviceFuncionario.findById(id);
    }

    @PostMapping
    public Funcionario save(@RequestBody FuncionarioDTO funcionarioDTO) {
        return serviceFuncionario.save(funcionarioDTO);
    }

    @PutMapping
    public Funcionario update(@RequestBody Funcionario funcionario) {
        return serviceFuncionario.update(funcionario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceFuncionario.delete(id);
    }
}
