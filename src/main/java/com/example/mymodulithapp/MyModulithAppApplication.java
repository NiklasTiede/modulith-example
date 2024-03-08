package com.example.mymodulithapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.mymodulithapp.product.ProductService;
import com.example.mymodulithapp.product.internal.Product;

@EnableAsync
@SpringBootApplication
public class MyModulithAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyModulithAppApplication.class, args)
                .getBean(ProductService.class)
                .create(new Product("baeldung", "course", 10));
    }
}
