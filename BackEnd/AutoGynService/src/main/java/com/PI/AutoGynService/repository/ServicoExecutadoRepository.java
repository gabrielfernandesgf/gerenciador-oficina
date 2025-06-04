package com.PI.AutoGynService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoExecutadoRepository extends JpaRepository<ServicoExecutadoRepository, Long> {
}
