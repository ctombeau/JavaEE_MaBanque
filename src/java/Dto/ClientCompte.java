/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.Date;

/**
 *
 * @author ctombeau
 */
public class ClientCompte {
     private int idclient;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String adresse;
    private String phone;
    private String creepar;
    private Date creele;
    private String modifiepar;
    private Date modifiele;
    private String supprimepar;
    private Date supprimele;
    private int idcompte;
    private String numcompte;
    private double solde;
    private String devise;

    public ClientCompte(int idclient, String nom, String prenom, Date date_naissance, String adresse, String phone, String creepar, Date creele, String modifiepar, Date modifiele, String supprimepar, Date supprimele, int idcompte, String numcompte, double solde, String devise) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.phone = phone;
        this.creepar = creepar;
        this.creele = creele;
        this.modifiepar = modifiepar;
        this.modifiele = modifiele;
        this.supprimepar = supprimepar;
        this.supprimele = supprimele;
        this.idcompte = idcompte;
        this.numcompte = numcompte;
        this.solde = solde;
        this.devise = devise;
    }
    
    
    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
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

    public Date getCreele() {
        return creele;
    }

    public void setCreele(Date creele) {
        this.creele = creele;
    }

    public String getModifiepar() {
        return modifiepar;
    }

    public void setModifiepar(String modifiepar) {
        this.modifiepar = modifiepar;
    }

    public Date getModifiele() {
        return modifiele;
    }

    public void setModifiele(Date modifiele) {
        this.modifiele = modifiele;
    }

    public String getSupprimepar() {
        return supprimepar;
    }

    public void setSupprimepar(String supprimepar) {
        this.supprimepar = supprimepar;
    }

    public Date getSupprimele() {
        return supprimele;
    }

    public void setSupprimele(Date supprimele) {
        this.supprimele = supprimele;
    }

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public String getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(String numcompte) {
        this.numcompte = numcompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
    
     
}
