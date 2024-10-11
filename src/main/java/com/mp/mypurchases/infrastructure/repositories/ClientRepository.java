package com.mp.mypurchases.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mp.mypurchases.domain.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
