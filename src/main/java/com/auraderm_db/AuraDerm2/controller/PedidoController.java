package com.auraderm_db.AuraDerm2.controller;

import com.auraderm_db.AuraDerm2.model.Pedido;
import com.auraderm_db.AuraDerm2.service.PedidoService;
import com.auraderm_db.AuraDerm2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/todos")
    public List<Pedido> getAllPedido(){
        return pedidoService.getAllPedido();
    }

    @PostMapping("/add")
    public Pedido savePedido(@RequestBody Pedido pedido){
        return pedidoService.savePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        try {
            productoService.deleteProducto(id);
            return ResponseEntity.ok("Producto eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el producto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoActualizar) {
        boolean actualizado = pedidoService.actualizarPedido(id, pedidoActualizar);
        if (actualizado) {
            return ResponseEntity.ok("Pedido editado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
