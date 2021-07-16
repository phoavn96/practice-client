package com.example.practice716client.myservice;

import com.example.practice716client.service.ProductService;
import com.example.practice716client.service.ProductServiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Bean
    public ProductService studentService(){
        ProductServiceService pss = new ProductServiceService();
        ProductService ps = pss.getProductServicePort();
        return ps;
    }
}
