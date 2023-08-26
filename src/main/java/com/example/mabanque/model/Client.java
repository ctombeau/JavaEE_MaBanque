package com.example.mabanque.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclient", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "phone")
    private String phone;

    @Column(name = "creepar", length = 100)
    private String creepar;

    @Column(name = "creele")
    private Instant creele;

    @Column(name = "modifiepar", length = 100)
    private String modifiepar;

    @Column(name = "modifiele")
    private Instant modifiele;

    @Column(name = "supprimepar", length = 100)
    private String supprimepar;

    @Column(name = "supprimele")
    private Instant supprimele;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreepar() {
        return creepar;
    }

    public void setCreepar(String creepar) {
        this.creepar = creepar;
    }

    public Instant getCreele() {
        return creele;
    }

    public void setCreele(Instant creele) {
        this.creele = creele;
    }

    public String getModifiepar() {
        return modifiepar;
    }

    public void setModifiepar(String modifiepar) {
        this.modifiepar = modifiepar;
    }

    public Instant getModifiele() {
        return modifiele;
    }

    public void setModifiele(Instant modifiele) {
        this.modifiele = modifiele;
    }

    public String getSupprimepar() {
        return supprimepar;
    }

    public void setSupprimepar(String supprimepar) {
        this.supprimepar = supprimepar;
    }

    public Instant getSupprimele() {
        return supprimele;
    }

    public void setSupprimele(Instant supprimele) {
        this.supprimele = supprimele;
    }

}