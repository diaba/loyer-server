package com.loyer.loyer.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String date;

    @Column
    private String description;

    @Column
    private double montant;

    // many to one maison
    @ManyToOne
    @JoinColumn(name = "maison_id")
    @JsonIgnore
    private Maison maison;

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", montant=" + montant +
                ", maison=" + maison +
                '}';
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Maintenance() {
    }

    // link to many to one with maison
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
