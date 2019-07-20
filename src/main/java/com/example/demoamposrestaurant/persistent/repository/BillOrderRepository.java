package com.example.demoamposrestaurant.persistent.repository;

import com.example.demoamposrestaurant.persistent.domain.BillOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillOrderRepository extends JpaRepository<BillOrder, Long> {
}
