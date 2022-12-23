package com.kodlamaio.northwind.controller;

import com.kodlamaio.northwind.core.utilities.results.DataResult;
import com.kodlamaio.northwind.core.utilities.results.Result;
import com.kodlamaio.northwind.entity.Product;
import com.kodlamaio.northwind.entity.dtos.ProductWithCategoryDto;
import com.kodlamaio.northwind.service.ProductService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/getAllProducts")
    public DataResult<List<Product>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getAllProductsByPage")
    public DataResult<List<Product>> getAllProductsByPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return productService.getAllProducts(pageNo, pageSize);
    }

    @GetMapping("/getAllProductsSorted")
    public DataResult<List<Product>> getAllProductsSorted() {
        return this.productService.getAllProductsSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/addProduct")
    public Result addProduct(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        System.out.println("PRODUCT NAME: " + productName);
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName) {
        return this.productService.getByProductNameContains(productName);
    }

}
