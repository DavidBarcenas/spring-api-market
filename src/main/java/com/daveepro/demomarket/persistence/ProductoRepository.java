package com.daveepro.demomarket.persistence;

import com.daveepro.demomarket.persistence.crud.ProductoCrudRepository;
import com.daveepro.demomarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>)productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLeesThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProduct) {
        return productoCrudRepository.findById(idProduct);
    }

    public Producto saveProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void deleteProducto(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
