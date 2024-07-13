package com.auraderm_db.AuraDerm2.service;

import com.auraderm_db.AuraDerm2.model.Pedido_producto;
import com.auraderm_db.AuraDerm2.repository.PedidoProductoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoProductoService {
    @Autowired
    private PedidoProductoRepositoy pedidoProductoRepository;

    //traer todos los pedidos productos
    public List<Pedido_producto> getAllPedProd(){
        return pedidoProductoRepository.findAll();
    }
    //guardar pedidos productos
    public Pedido_producto savePedProd(Pedido_producto pedido){
        return pedidoProductoRepository.save(pedido);
    }

    //eliminar pedido
    public void deletePedProd(Long id){
        pedidoProductoRepository.deleteById(id);
    }

    public boolean actualizarPedidoProducto(Long id, Pedido_producto pedidoProductoActualizar) {
        Optional<Pedido_producto> pedidoProductoExistente = pedidoProductoRepository.findById(id);
        if (pedidoProductoExistente.isPresent()) {
            Pedido_producto pedidoProducto = pedidoProductoExistente.get();
            pedidoProducto.setCantidad(pedidoProductoActualizar.getCantidad());
            pedidoProductoRepository.save(pedidoProducto);
            return true;
        } else {
            return false;
        }
    }

}

