package com.auraderm_db.AuraDerm2.controller;

import com.auraderm_db.AuraDerm2.model.Pedido;
import com.auraderm_db.AuraDerm2.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/todos")
    public List<Pedido> getAllPedido(){
        return pedidoService.getAllPedido();
    }

    @PostMapping("/add")
    public Pedido savePedido(@RequestBody Pedido pedido){
        return pedidoService.savePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
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
