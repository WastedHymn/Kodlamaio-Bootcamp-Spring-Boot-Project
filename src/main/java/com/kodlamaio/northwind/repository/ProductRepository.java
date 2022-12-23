package com.kodlamaio.northwind.repository;

import com.kodlamaio.northwind.entity.Product;
import com.kodlamaio.northwind.entity.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("FROM Product WHERE category.categoryId=:categoryId AND productName=:productName")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("Select new com.kodlamaio.northwind.entity.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category  c Inner JOIN c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
