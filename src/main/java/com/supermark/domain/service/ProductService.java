package com.supermark.domain.service;

import com.supermark.domain.Product;
import com.supermark.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Product> getAll(){
        return productoRepository.getAll();
    }

    public Optional<Product> getProduct(int productoId){
        return  productoRepository.getProduct(productoId);
    }

    public  Optional<List<Product>> getByCategory(int categoryId){
        return productoRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productoRepository.save(product);
    }

    public boolean delete(int productoId){

        return getProduct(productoId).map(product -> {
            productoRepository.delete(productoId);
            return true;
        }).orElse(false);

    }

}
