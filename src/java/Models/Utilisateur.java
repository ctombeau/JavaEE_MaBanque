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
public class Utilisateur {
    private int id;
    private String email;
    private String name;
    private String password;
    private String profil;
  
    public Utilisateur( String email, String name, String password,String profil) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.profil = profil;
    }
    
    public Utilisateur(int id, String email, String name, String password,String profil) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.profil = profil;
    }

    public Utilisateur() {
      
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
