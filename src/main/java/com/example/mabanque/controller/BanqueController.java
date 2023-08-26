package com.example.mabanque.controller;

import com.example.mabanque.dto.ClientCompteDto;
import com.example.mabanque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BanqueController {

    @Autowired
    private IBanqueService banqueService;

    @RequestMapping("/comptes")
    public String listCompte(Model model){

        List<ClientCompteDto> clientCompteDtoList = banqueService.listCompteClient();
        System.out.println(clientCompteDtoList.size());
        model.addAttribute("comptes", clientCompteDtoList);
        return "compte";
    }

}
