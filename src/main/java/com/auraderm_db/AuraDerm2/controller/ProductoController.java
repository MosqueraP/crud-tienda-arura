package com.auraderm_db.AuraDerm2.controller;
import com.auraderm_db.AuraDerm2.model.Producto;
import com.auraderm_db.AuraDerm2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/todos")
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @PostMapping("/add")
    public Producto saveProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizar) {
        boolean actualizado = productoService.actualizarProducto(id, productoActualizar);
        if (actualizado) {
            return ResponseEntity.ok("Producto editado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
