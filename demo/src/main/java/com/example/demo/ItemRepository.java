package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByName(String name);

    // Custom query method to find items by price less than a specified value
    List<Item> findByPriceLessThan(double price);

    // Custom query method to find items by quantity greater than a specified value
    List<Item> findByQuantityGreaterThan(int quantity);

    @Override
    List<Item> findAll();

    Optional<Item> findById(Long id);

    default Item save(Item newItem) {
        return null;
    }
}
