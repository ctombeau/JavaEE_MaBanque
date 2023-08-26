package com.example.mabanque.service;

import com.example.mabanque.dto.ClientCompteDto;
import com.example.mabanque.model.Client;
import com.example.mabanque.model.ClientCompte;

import java.util.List;

public interface IBanqueService {

    public List<ClientCompteDto> listCompteClient();
}
