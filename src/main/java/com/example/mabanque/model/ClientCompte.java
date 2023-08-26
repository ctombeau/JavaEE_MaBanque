package com.example.mabanque.model;

import javax.persistence.*;

@Entity
@Table(name = "client_compte")
public class ClientCompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclicompte", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idclient", nullable = false)
    private Client idclient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcompte", nullable = false)
    private Compte idcompte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Compte getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Compte idcompte) {
        this.idcompte = idcompte;
    }

}