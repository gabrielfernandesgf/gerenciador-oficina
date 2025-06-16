package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.OS;
import com.PI.AutoGynService.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OSRepository extends JpaRepository<OS, Long> {
    List<OS> findByVeiculoPlaca(String placaVeiculo);
    List<OS> findByStatus(Status status);
}