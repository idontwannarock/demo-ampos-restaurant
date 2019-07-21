package com.example.demoamposrestaurant.persistent.repository;

import com.example.demoamposrestaurant.persistent.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
