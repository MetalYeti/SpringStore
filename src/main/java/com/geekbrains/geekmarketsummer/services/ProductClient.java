package com.geekbrains.geekmarketsummer.services;

import com.geekbrains.geekmarketsummer.entites.CustomPage;
import com.geekbrains.geekmarketsummer.entites.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("geek-spring-cloud-product-service")
public interface ProductClient {

    @GetMapping("/product_service/products/product")
    List<Product> getAllProducts();

    @GetMapping("/product_service/products/product/{id}")
    Product getProductById(@PathVariable(name = "id") Long id);

    @GetMapping(value = "/product_service/products/product/page")
    CustomPage<Product> getProductsWithPagingAndFiltering(
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pageSize") int pageSize,
            @RequestParam(value = "word", required = false) String word,
            @RequestParam(value = "min", required = false) Double min,
            @RequestParam(value = "max", required = false) Double max);
}
