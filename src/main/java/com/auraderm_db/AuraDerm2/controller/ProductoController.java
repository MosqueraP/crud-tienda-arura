package com.auraderm_db.AuraDerm2.controller;
import com.auraderm_db.AuraDerm2.model.Producto;
import com.auraderm_db.AuraDerm2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/todos")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.getProductoById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        boolean updated = productoService.updateProducto(id, producto);
        if (updated) {
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete-id/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok("Producto eliminado exitosamente");
    }
}