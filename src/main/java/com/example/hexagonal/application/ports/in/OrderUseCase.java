package com.example.hexagonal.application.ports.in;

import com.example.hexagonal.domain.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderUseCase {

  public Order save(Order order);

  public Optional<Order> findById(Long id);

  public List<Order> findAll();

  public void deleteById(Long id);
}
