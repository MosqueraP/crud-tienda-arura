package com.auraderm_db.AuraDerm2.repository;
import com.auraderm_db.AuraDerm2.model.Pedido;
import com.auraderm_db.AuraDerm2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
