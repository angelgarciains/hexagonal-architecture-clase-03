package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.application.ports.in.OrderUseCase;
import com.example.hexagonal.application.service.OrderService;
import com.example.hexagonal.domain.model.Order;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Optional;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {


    OrderUseCase orderUseCase;

  @Inject
  public OrderResource(OrderUseCase orderUseCase) {
    this.orderUseCase = orderUseCase;
  }

    @POST
    public Response createOrder(Order order) {
    Order createOrder = orderUseCase.save(order);
    return Response.status(Status.CREATED).entity(createOrder).build();
  }

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") Long id) {
    Optional<Order> order = orderUseCase.findById(id);
    return order.map(value -> Response.ok(value).build())
        .orElse(Response.status(Status.NOT_FOUND).build());
  }

    @GET
    public Response getAllOrders() {
    List<Order> orders = orderUseCase.findAll();
    return Response.ok(orders).build();
  }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(Long id){
      orderUseCase.deleteById(id);
    return Response.noContent().build();

  }

}
