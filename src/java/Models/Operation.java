/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author ctombeau
 */
public class Operation {
    private int idoperation;
    private int idcompte;
    private int idclient;
    private String type;
    private double montant;
    private Date dateop;
    private String validepar;
    

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public Operation()
    {
        
    }
    
     public Operation(int idoperation,String type , double montant,int idcompte, int idclient, Date dateop, String validepar) {
        this.idoperation = idoperation;
        this.idcompte = idcompte;
        this.idclient = idclient;
        this.type = type;
        this.montant = montant;
        this.dateop = dateop;
        this.validepar = validepar;
    }

    public Operation(String type , double montant,int idcompte, int idclient, Date dateop, String validepar) {
        this.idoperation = idoperation;
        this.idcompte = idcompte;
        this.idclient = idclient;
        this.type = type;
        this.montant = montant;
        this.dateop = dateop;
        this.validepar = validepar;
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
    
    
}
