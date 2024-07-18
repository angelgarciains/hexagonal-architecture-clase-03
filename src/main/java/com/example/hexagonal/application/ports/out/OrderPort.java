package com.example.hexagonal.application.ports.out;

import com.example.hexagonal.domain.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderPort {

  Order save(Order order);
  List<Order> findAll();
  Optional<Order> findById(Long id);
  void deleteById(Long id);

}
