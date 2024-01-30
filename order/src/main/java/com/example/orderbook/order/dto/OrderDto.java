package com.example.orderbook.order.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int orderId;
    private  String title;
    private int quantity;
    private double totalPrice;
}
