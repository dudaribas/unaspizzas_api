package com.unaspizzas_api.repository;

import com.unaspizzas_api.model.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    public List<Pizza> findAllByCategoryIdPizzaCategory(Long idPizzaCategory);

}