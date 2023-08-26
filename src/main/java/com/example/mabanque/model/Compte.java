package com.example.mabanque.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompte", nullable = false)
    private Integer id;

    @Column(name = "numcompte", length = 100)
    private String numcompte;

    @Column(name = "solde", nullable = false, precision = 10, scale = 3)
    private BigDecimal solde;

    @Column(name = "devise", nullable = false, length = 20)
    private String devise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(String numcompte) {
        this.numcompte = numcompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

}