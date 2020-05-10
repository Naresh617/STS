package com.naresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Orders;

@Repository
public interface OrdersRepostiory extends JpaRepository<Orders, Integer> {

}
