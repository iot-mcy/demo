package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者 mcy
 * 日期 2019/11/16 11:16
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getStr() {
        return "Hello World";
    }
}
