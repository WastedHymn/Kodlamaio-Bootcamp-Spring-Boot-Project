package com.kodlamaio.northwind.controller;

import com.kodlamaio.northwind.core.utilities.results.DataResult;
import com.kodlamaio.northwind.core.utilities.results.Result;
import com.kodlamaio.northwind.entity.Product;
import com.kodlamaio.northwind.service.ProductService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiv1")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAllProducts")
    public DataResult<List<Product>> getAll() {
        return productService.getAllProduct();
    }

    @PostMapping("/addProduct")
    public Result addProduct(@RequestBody Product product) {
        return this.productService.add(product);
    }
}
