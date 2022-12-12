package com.kodlamaio.northwind.service;

import com.kodlamaio.northwind.core.utilities.results.DataResult;
import com.kodlamaio.northwind.core.utilities.results.Result;
import com.kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import com.kodlamaio.northwind.core.utilities.results.SuccessResult;
import com.kodlamaio.northwind.entity.Product;
import com.kodlamaio.northwind.repository.ProductRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public DataResult<List<Product>> getAllProduct() {
        return new SuccessDataResult<List<Product>>(productRepository.findAll(), "Data has listed.");
    }

    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Product added. " + product.getProductName());
    }
}
