package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.VeiculoAcessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoAcessorioRepository extends JpaRepository<VeiculoAcessorio, Long> {
}
