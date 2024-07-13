package com.auraderm_db.AuraDerm2.service;

import com.auraderm_db.AuraDerm2.model.Pedido;
import com.auraderm_db.AuraDerm2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    //traer todos los pedidos
    public List<Pedido> getAllPedido(){
        return pedidoRepository.findAll();
    }
    //guardar pedido
    public Pedido savePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    //eliminar pedido
    public void deletePedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public boolean actualizarPedido(Long id, Pedido pedidoActualizar) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setFecha(pedidoActualizar.getFecha());
            pedidoRepository.save(pedido);
            return true;
        } else {
            return false;
        }
    }

}

