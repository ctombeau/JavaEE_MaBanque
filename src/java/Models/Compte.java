/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ctombeau
 */
public class Compte {
    private int idcompte;
    private String numcompte;
    private double solde;
    private String devise;
    
    public Compte()
    {
        
    }

    public Compte(int idcompte, String numcompte, double solde, String devise) {
        this.idcompte = idcompte;
        this.numcompte = numcompte;
        this.solde = solde;
        this.devise = devise;
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
