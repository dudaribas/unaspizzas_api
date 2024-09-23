package com.unaspizzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unaspizzas.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
}