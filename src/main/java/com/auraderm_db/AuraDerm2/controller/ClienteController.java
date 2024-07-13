package com.auraderm_db.AuraDerm2.controller;

import com.auraderm_db.AuraDerm2.model.Cliente;
import com.auraderm_db.AuraDerm2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todos")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllCliente();
    }

    @PostMapping("/add")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    // Modificar los datos de los clientes
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizar) {
        boolean actualizado = clienteService.actualizarCliente(id, clienteActualizar);
        if (actualizado) {
            return ResponseEntity.ok("Cliente editado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
