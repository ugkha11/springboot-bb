package com.demo.springbootbb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springbootbb.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
