package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.application.ports.out.OrderPort;
import com.example.hexagonal.domain.model.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JpaOrderRepository implements OrderPort {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Order save(Order order) {
    if (order.getId() == null) {
      em.persist(order);
      return order;
    } else {
      return em.merge(order);
    }
  }

  @Override
  public List<Order> findAll() {
    return em.createQuery("SELECT o FROM Orders o", Order.class).getResultList();
  }

  @Override
  public Optional<Order> findById(Long id) {
    return Optional.ofNullable(em.find(Order.class, id));
  }

  @Override
  public void deleteById(Long id) {
    em.remove(em.find(Order.class,id));
  }
}
