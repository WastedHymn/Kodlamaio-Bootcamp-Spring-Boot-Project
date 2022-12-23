package com.kodlamaio.northwind.service;

import com.kodlamaio.northwind.core.utilities.results.DataResult;
import com.kodlamaio.northwind.core.utilities.results.Result;
import com.kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import com.kodlamaio.northwind.core.utilities.results.SuccessResult;
import com.kodlamaio.northwind.entity.Product;
import com.kodlamaio.northwind.entity.dtos.ProductWithCategoryDto;
import com.kodlamaio.northwind.repository.ProductRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public DataResult<List<Product>> getAllProducts() {
        return new SuccessDataResult<List<Product>>(productRepository.findAll(), "Data has listed.");
    }

    public DataResult<List<Product>> getAllProductsSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(sort), "Data has been listed in descending order.");
    }

    public DataResult<List<Product>> getAllProducts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(pageable).getContent());
    }

    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Product added. " + product.getProductName());
    }

    public DataResult<Product> getByProductName(String productName) {
        System.out.println("SEARCHING BY PRODUCT NAME...");
        return new SuccessDataResult<Product>(this.productRepository.getByProductName(productName), "Product searched by name.");
    }

    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId), "Product searched by name AND category id.");
    }

    DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId), "Product searched by name OR category id.");
    }

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByCategoryIn(categories), "Product searched by categories id in.");
    }

    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameContains(productName), "Product searched by product name contains.");
    }

    DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameStartsWith(productName), "Product searched by product name starts with.");
    }

    //@Query("FROM Product WHERE category.categoryId=:categoryId AND productName=:productName")
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByNameAndCategory(productName, categoryId), "Product searched by product name and category.");
    }

    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productRepository.getProductWithCategoryDetails(), "Products have been listed with category details.");
    }
}
