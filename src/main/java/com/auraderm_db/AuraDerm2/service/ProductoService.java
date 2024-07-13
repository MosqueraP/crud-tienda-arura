package com.auraderm_db.AuraDerm2.service;
import com.auraderm_db.AuraDerm2.model.Producto;
import com.auraderm_db.AuraDerm2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    //traer todos los productos
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }


    //guardar producto
    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }

    //eliminar producto
    public void deleteProducto(Long id) {
        try {
            logger.info("Intentando eliminar producto con id: {}", id);
            productoRepository.deleteById(id);
            logger.info("Producto eliminado correctamente con id: {}", id);
        } catch (Exception e) {
            logger.error("Error al eliminar producto con id: {}", id, e);
            throw e;
        }
    }

    public boolean actualizarProducto(Long id, Producto productoActualizar) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setDescripcion(productoActualizar.getDescripcion());
            producto.setNombre(productoActualizar.getNombre());
            producto.setPrecio(productoActualizar.getPrecio());
            producto.setStock(productoActualizar.getStock());
            productoRepository.save(producto);
            return true;
        } else {
            return false;
        }
    }


}
