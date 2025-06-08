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

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
    }

    public Funcionario save(FuncionarioDTO funcionarioDTO){
        if (funcionarioDTO.getNome() == null || funcionarioDTO.getNome().trim().isEmpty())
            throw new RuntimeException("Nome é obrigatório.");
        if (funcionarioDTO.getCpf() == null || funcionarioDTO.getCpf().trim().isEmpty())
            throw new RuntimeException("CPF é obrigatório.");
        if (funcionarioDTO.getEmail() == null || funcionarioDTO.getEmail().trim().isEmpty())
            throw new RuntimeException("Email é obrigatório.");
        if (funcionarioDTO.getTelefone() == null || funcionarioDTO.getTelefone().trim().isEmpty())
            throw new RuntimeException("Telefone é obrigatório");
        if (funcionarioDTO.getDataEntrada() == null || funcionarioDTO.getDataEntrada().toString().trim().isEmpty())
            throw new RuntimeException("Data de entrada é obrigatória.");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setDataEntrada(funcionarioDTO.getDataEntrada());
        funcionario.setDataSaida(funcionarioDTO.getDataSaida());

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario){
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
