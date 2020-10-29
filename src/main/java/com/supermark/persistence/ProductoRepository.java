package com.supermark.persistence;

import com.supermark.domain.Product;
import com.supermark.domain.repository.ProductRepository;
import com.supermark.persistence.crud.ProductoCrudRepository;
import com.supermark.persistence.entity.Producto;
import com.supermark.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    /*
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }
     */



    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    /*
     public Optional<List<Producto>> getEscasos(int cantidad){
        return  productoCrudRepository.findByCantidaStockLessThanAndEstado(cantidad,true);
    }
     */
    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
     Optional<List<Producto>> productos =  productoCrudRepository.findByCantidaStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    /*
     public  Optional<Producto> getProducto(int idProducto){
        return
    }
     */

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    /*
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
     */

    @Override
    public Product save(Product product) {
       Producto producto = mapper.toProducto(product);

        return mapper.toProduct(productoCrudRepository.save(producto));
    }









    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }




}
