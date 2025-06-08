package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.ServicoExecutado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoExecutadoRepository extends JpaRepository<ServicoExecutado, Long> {
}
