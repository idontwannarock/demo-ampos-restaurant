package com.example.demoamposrestaurant.persistent.repository;

import com.example.demoamposrestaurant.persistent.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findByNameContainingOrDescriptionContainingOrTypes_NameContaining(String nameKeyword, String descKeyword, String typeNameKeyword, Pageable pageable);
}
