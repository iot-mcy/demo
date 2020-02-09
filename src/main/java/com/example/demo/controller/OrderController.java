package com.example.demo.controller;

import com.example.demo.model.AjaxResponse;
import com.example.demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class OrderController {

    @GetMapping("/order/{id}")
    public AjaxResponse getOrderByOrderID(@PathVariable long id) {
        log.info("getOrderByOrderID:", id);
        Order order = Order.builder().id(id).name("阳光玫瑰").price(36.9).build();
        return AjaxResponse.success(order);
    }
}
