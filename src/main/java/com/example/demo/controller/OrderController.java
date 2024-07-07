package com.example.demo.controller;

import com.example.demo.domain.CreateOrder;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder(
            @RequestBody NewOrderRequest request
    ) {
        orderService.newOrder(CreateOrder.builder()
                        .customerId(request.getCustomerId())
                        .storeId(request.getCustomerId())
                        .quantityByProduct(request.getProducts())
                .build());
        return Response.success(null);
    }
}
