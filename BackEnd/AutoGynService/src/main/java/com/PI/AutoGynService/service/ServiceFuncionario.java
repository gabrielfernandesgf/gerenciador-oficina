package com.PI.AutoGynService.service;

import com.PI.AutoGynService.dto.FuncionarioDTO;
import com.PI.AutoGynService.entity.Funcionario;
import com.PI.AutoGynService.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFuncionario {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public void save(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }

    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario update(FuncionarioDTO funcionario){
        Funcionario funcionario1 = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + funcionario.getId()));

        if(funcionario.getCpf() != null){
            funcionario1.setCpf(funcionario.getCpf());
        }
        if(funcionario.getDataEntrada() != null){
            funcionario1.setDataEntrada(funcionario.getDataEntrada());
        }
        if(funcionario.getEmail() != null){
            funcionario1.setEmail(funcionario.getEmail());
        }
        if(funcionario.getNome() != null){
            funcionario1.setNome(funcionario.getNome());
        }
        if(funcionario.getTelefone() != null){
            funcionario1.setTelefone(funcionario.getTelefone());
        }
        if(funcionario.getDataSaida() != null){
            funcionario1.setDataSaida(funcionario.getDataSaida());
        }
        return funcionarioRepository.save(funcionario1);
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
