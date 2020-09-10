package com.daveepro.demomarket.persistence.crud;

import com.daveepro.demomarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
