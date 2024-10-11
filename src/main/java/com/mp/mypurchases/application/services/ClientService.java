package com.mp.mypurchases.application.services;

import java.util.Optional;

import java.util.List;

import com.mp.mypurchases.domain.entities.Client;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Client save(Client client);
    Client update(Long id, Client client);
    Optional<Client> delete(Long id);
}
