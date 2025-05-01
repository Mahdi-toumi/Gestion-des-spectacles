package com.enicarthage.Spectacles.Reservation.Model;


import com.enicarthage.Spectacles.Billet.Model.Billet;
import com.enicarthage.Spectacles.User.Model.User;
import com.enicarthage.Spectacles.spectacle.Model.Spectacle;
import jakarta.persistence.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDSPEC")
    private Spectacle spectacle;

    @ManyToOne
    @JoinColumn(name = "IDCLIENT", nullable = true)
    private User client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDBILLET")
    private Billet billet;

    @Column(name= "QUANTITE_BILLET",nullable = false)
    private int quantiteBillet;



    // Constructeurs
    public Reservation() {}

    public Reservation(Spectacle spectacle, User client, Billet billet,int quantiteBillet) {
        this.spectacle = spectacle;
        this.client = client;
        this.billet = billet;
        this.quantiteBillet = quantiteBillet;
    }

    // Getters et Setters


    public int getQuantiteBillet() {
        return quantiteBillet;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantiteBillet(int quantiteBillet) {
        this.quantiteBillet = quantiteBillet;
    }

    public Long getId() {
        return id;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

}

