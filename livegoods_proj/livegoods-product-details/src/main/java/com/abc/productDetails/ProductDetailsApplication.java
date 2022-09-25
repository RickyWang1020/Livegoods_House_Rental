package com.abc.productDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// enable the cacheable annotation
@EnableCaching
@SpringBootApplication
public class ProductDetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductDetailsApplication.class, args);
    }
}
