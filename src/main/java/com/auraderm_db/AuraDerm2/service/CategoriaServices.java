package com.auraderm_db.AuraDerm2.service;


import com.auraderm_db.AuraDerm2.model.Categoria;
import com.auraderm_db.AuraDerm2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {
    @Autowired
    private CategoryRepository categoryRepository;

    //traer todos las categoria
    public List<Categoria> getAllCategoria(){
        return categoryRepository.findAll();
    }
    //guardar categoria
    public Categoria saveCategoria(Categoria categoria){
        return categoryRepository.save(categoria);
    }

    //eliminar categoria
    public void deleteCategoria(Long id){
        categoryRepository.deleteById(id);
    }

    // actualizar categoria
    public boolean actualizarCategoria(Long id, Categoria categoriaActualizada) {
        Optional<Categoria> categoriaExistente = categoryRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNombre(categoriaActualizada.getNombre());
            categoryRepository.save(categoria);
            return true;
        } else {
            return false;
        }

}
}


