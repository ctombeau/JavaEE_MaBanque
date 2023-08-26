package com.example.mabanque.service;

import com.example.mabanque.dto.ClientCompteDto;
import com.example.mabanque.model.ClientCompte;
import com.example.mabanque.repository.ClientCompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BanqueServiceImpl implements IBanqueService{

    @Autowired
    private ClientCompteRepository clientCompteRepository;

    @Override
    public List<ClientCompteDto> listCompteClient() {
       List<ClientCompte> clientComptes= clientCompteRepository.findAll();
       List<ClientCompteDto> clientCompteDtos = new ArrayList<>();
       if(clientComptes!=null && !clientComptes.isEmpty()){
           for (ClientCompte clientCompte:clientComptes) {
               ClientCompteDto clientCompteDto = new ClientCompteDto();
               clientCompteDto.setId(clientCompte.getId());
               clientCompteDto.setIdClient(clientCompte.getIdclient().getId());
               clientCompteDto.setNomComplet(clientCompte.getIdclient().getNom()+" "+clientCompte.getIdclient().getPrenom());
               clientCompteDto.setNumcompte(clientCompte.getIdcompte().getNumcompte());
               clientCompteDto.setSolde(clientCompte.getIdcompte().getSolde());
               clientCompteDto.setDevise(clientCompte.getIdcompte().getDevise());
               clientCompteDtos.add(clientCompteDto);
           }
       }

        return clientCompteDtos;
    }
}
