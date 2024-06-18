package com.reservation.security.repository;

import com.reservation.security.entity.RolEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, Integer>{
    public RolEntity findById(int id);
    public Optional<RolEntity> findByName(String name);
}
