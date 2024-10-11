package com.mp.mypurchases.application.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mp.mypurchases.domain.entities.Client;
import com.mp.mypurchases.infrastructure.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly=true)
    @Override
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
        Optional<Client> dbClient = repository.findById(id);
        if (dbClient.isPresent()) {
            Client newClient = dbClient.get();
            newClient.setName(client.getName());
            newClient.setLastName(client.getLastName());
            newClient.setTelephone(client.getTelephone());
            newClient.setAddress(client.getAddress());
            newClient.setEmail(client.getEmail());

            return repository.save(newClient);
        }
        return null;
    }

    @Override
    public Optional<Client> delete(Long id) {
        Optional<Client> client = repository.findById(id);
        client.ifPresent(target -> {
            repository.delete(target);
        });
        return client;
    }
}
