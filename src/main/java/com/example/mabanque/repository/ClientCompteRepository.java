package com.example.mabanque.repository;

import com.example.mabanque.model.ClientCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCompteRepository extends JpaRepository<ClientCompte, Integer> {

}
