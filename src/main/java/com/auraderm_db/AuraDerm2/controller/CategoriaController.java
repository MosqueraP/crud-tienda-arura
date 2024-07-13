package com.auraderm_db.AuraDerm2.controller;

import com.auraderm_db.AuraDerm2.model.Categoria;
import com.auraderm_db.AuraDerm2.service.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaServices categoriaServices;

    @GetMapping("/todos")
    public List<Categoria> getAllCategorias() {
        return categoriaServices.getAllCategoria();
    }

    @PostMapping("/add")
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaServices.saveCategoria(categoria);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaServices.deleteCategoria(id);
    }

    // Modificar los datos de categoria
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriactualizada) {
        boolean actualizado = categoriaServices.actualizarCategoria(id, categoriactualizada);
        if (actualizado) {
            return ResponseEntity.ok("Categoria editada correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
