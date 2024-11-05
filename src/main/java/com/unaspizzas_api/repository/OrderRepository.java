package com.unaspizzas_api.repository;

import com.unaspizzas_api.model.entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findAllByUserIdUser(Long idUser);

    List<Order> findAllByStatusOrderIdStatusOrderIn(List<Long> idStatusOrder);

}
