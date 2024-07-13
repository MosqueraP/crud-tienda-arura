package com.auraderm_db.AuraDerm2.controller;

import com.auraderm_db.AuraDerm2.model.Pedido_producto;
import com.auraderm_db.AuraDerm2.service.PedidoProductoService;
import com.auraderm_db.AuraDerm2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos-productos")
public class PedidoProductoController {
    @Autowired
    private PedidoProductoService pedidoProductoService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/todos")
    public List<Pedido_producto> getAllPedidProd(){
        return pedidoProductoService.getAllPedProd();
    }

    @PostMapping("/add")
    public Pedido_producto saveProducto(@RequestBody Pedido_producto pedido){
        return pedidoProductoService.savePedProd(pedido);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        try {
            productoService.deleteProducto(id);
            return "Producto eliminado correctamente.";
        } catch (Exception e) {
            return "Error al eliminar el producto: " + e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPedidoProducto(@PathVariable Long id, @RequestBody Pedido_producto pedidoProductoActualizar) {
        boolean actualizado = pedidoProductoService.actualizarPedidoProducto(id, pedidoProductoActualizar);
        if (actualizado) {
            return ResponseEntity.ok("Pedido de producto editado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

