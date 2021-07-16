package com.example.practice716client.controller;

import com.example.practice716client.service.Product;
import com.example.practice716client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping
    public String listProduct(Model model){
        model.addAttribute("listProduct",productService.getAllProducts());
        return "list";
    }

    @GetMapping(value = "/create")
    public String createView(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }


    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product p, Model model){

        productService.addProduct(p);
        model.addAttribute("listProduct",productService.getAllProducts());
        return "list";
    }

}
