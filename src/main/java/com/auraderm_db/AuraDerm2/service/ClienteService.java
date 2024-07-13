package com.auraderm_db.AuraDerm2.service;

import com.auraderm_db.AuraDerm2.model.Cliente;
import com.auraderm_db.AuraDerm2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //traer todos los cliente
    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }
    //guardar cliente
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //eliminar cliente
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public boolean actualizarCliente(Long id, Cliente clienteActualizar) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizar.getNombre());
            cliente.setCorreo(clienteActualizar.getCorreo());
            cliente.setDireccion(clienteActualizar.getDireccion());
            cliente.setTelefono(clienteActualizar.getTelefono());
            clienteRepository.save(cliente);
            return true;
        } else {
            return false;
        }
    }

}

