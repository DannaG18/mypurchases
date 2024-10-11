package com.mp.mypurchases.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.mp.mypurchases.application.services.ClientService;
import com.mp.mypurchases.domain.entities.Client;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:5173") 
public class ClientController {
        
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client); 
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }
}
