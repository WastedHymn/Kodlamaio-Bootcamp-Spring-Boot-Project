package com.kodlamaio.northwind.repository;

import com.kodlamaio.northwind.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {}
