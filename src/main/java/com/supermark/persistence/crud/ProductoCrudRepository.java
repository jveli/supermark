package com.supermark.persistence.crud;

import com.supermark.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository  extends CrudRepository<Producto,Integer> {

    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?",nativeQuery = true)

    List<Producto> findByIdCategoria(int idCategoria);

    Optional<List<Producto>> findByCantidaStockLessThanAndEstado(int cantidaStock, boolean estado);


}
