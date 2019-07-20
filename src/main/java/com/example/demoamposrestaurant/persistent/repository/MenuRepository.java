package com.example.demoamposrestaurant.persistent.repository;

import com.example.demoamposrestaurant.persistent.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
