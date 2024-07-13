package com.auraderm_db.AuraDerm2.service;
import com.auraderm_db.AuraDerm2.model.Categoria;
import com.auraderm_db.AuraDerm2.model.Producto;
import com.auraderm_db.AuraDerm2.repository.CategoriaRepository;
import com.auraderm_db.AuraDerm2.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public boolean updateProducto(Long id, Producto productoActualizar) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setDescripcion(productoActualizar.getDescripcion());
            producto.setNombre(productoActualizar.getNombre());
            producto.setPrecio(productoActualizar.getPrecio());
            producto.setStock(productoActualizar.getStock());
            producto.setCategoria(productoActualizar.getCategoria());
            productoRepository.save(producto);
            return true;
        }
        return false;
    }
}