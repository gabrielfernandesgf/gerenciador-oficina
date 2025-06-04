package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
}
