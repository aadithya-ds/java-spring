package com.example.orderbook.order.service;

import com.example.orderbook.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.Collections;
import java.util.List;


@Service
public class OrderService {



    @Autowired
    private RestTemplate restTemplate;

    public List<Book> getAllBooksFromBookCatalog() {
        // Make an HTTP request to the BookCatalog microservice to get all books
        ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/books",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {});

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle the error scenario
            return Collections.emptyList();
        }
    }

    public void processOrder(Order order) {
        System.out.println("Processing Order:");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Total Price: " + order.getTotalPrice());
        System.out.println("Items:"+order.getQuantity());

        System.out.println("Order processed successfully!");
    }

}
