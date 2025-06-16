package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.PecaSubstituir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaSubstituirRepository extends JpaRepository<PecaSubstituir, Long> {
    List<PecaSubstituir> findByOsId(Long osId);
}
