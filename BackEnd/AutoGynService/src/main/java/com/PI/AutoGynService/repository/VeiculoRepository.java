package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

    Optional<Veiculo> findByPlaca(String placa);
    Void deleteByPlaca(String placa);
}
