package com.example.hexagonal.application.service;

import com.example.hexagonal.application.ports.in.OrderUseCase;
import com.example.hexagonal.application.ports.out.OrderPort;
import com.example.hexagonal.domain.model.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService implements OrderUseCase {

  OrderPort orderPort;

  @Inject
  public OrderService(OrderPort orderPort) {
    this.orderPort = orderPort;
  }

  public Order save(Order order) {
    return orderPort.save(order);
  }

  public List<Order> findAll() {
    return orderPort.findAll();
  }

  public Optional<Order> findById(Long id) {
    return orderPort.findById(id);
  }

  public void deleteById(Long id) {
    orderPort.deleteById(id);
  }

}
