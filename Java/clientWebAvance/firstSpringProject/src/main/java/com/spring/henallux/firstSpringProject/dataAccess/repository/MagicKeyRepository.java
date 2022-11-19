package com.spring.henallux.firstSpringProject.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.henallux.firstSpringProject.dataAccess.entity.MagicKeyEntity;

@Repository
public interface MagicKeyRepository extends JpaRepository<MagicKeyEntity, String>{
}
