package com.example.orderbook.order.controller;


import com.example.orderbook.order.entity.Order;
import com.example.orderbook.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @PostMapping("/create")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        // Implement logic to create and process the order
        orderService.processOrder(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooksFromBookCatalog() {
        List<Book> books = orderService.getAllBooksFromBookCatalog();
        return ResponseEntity.ok(books);
    }
}
