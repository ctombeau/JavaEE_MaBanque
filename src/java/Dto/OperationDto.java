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
public class OperationDto {
        private int idoperation;
        private int idcompte;
        private int idclient;
        private String type;
        private double montant;
        private Date dateop;
        private String validepar;
        private String nom;
        private String prenom;
        private String numcompte;
        private String devise;

    public OperationDto(int idoperation, String type, double montant, int idcompte, int idclient, Date dateop, String validepar, String nom, String prenom, String numcompte,String devise) {
        this.idoperation = idoperation;
        this.idcompte = idcompte;
        this.idclient = idclient;
        this.type = type;
        this.montant = montant;
        this.dateop = dateop;
        this.validepar = validepar;
        this.nom = nom;
        this.prenom = prenom;
        this.numcompte = numcompte;
        this.devise = devise;
    }
        
        public String NomComplet()
        {
             return nom + " " + prenom;
        }

    public int getIdoperation() {
        return idoperation;
    }

    public void setIdoperation(int idoperation) {
        this.idoperation = idoperation;
    }

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateop() {
        return dateop;
    }

    public void setDateop(Date dateop) {
        this.dateop = dateop;
    }

    public String getValidepar() {
        return validepar;
    }

    public void setValidepar(String validepar) {
        this.validepar = validepar;
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

    public String getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(String numcompte) {
        this.numcompte = numcompte;
    }
    
    
    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
        
        
}
