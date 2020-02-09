package com.example.demo.model;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class Order {
    private long id;
    private String name;
    private double price;
}
