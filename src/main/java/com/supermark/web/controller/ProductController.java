package com.supermark.web.controller;

import com.supermark.domain.Product;
import com.supermark.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    //inyeccion de servicio
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct (int productoId){
        return productService.getProduct(productoId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    public Product save (Product product){
        return productService.save(product);
    }

    public boolean delete(int productoId){
        return productService.delete(productoId);
    }
}
