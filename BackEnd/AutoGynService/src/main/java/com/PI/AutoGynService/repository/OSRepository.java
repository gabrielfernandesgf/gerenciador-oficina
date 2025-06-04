package com.PI.AutoGynService.repository;

import com.PI.AutoGynService.entity.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OS, Long> {
}
