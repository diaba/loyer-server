package com.loyer.loyer.Model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Locataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    // one to many with loyer
    @OneToMany(mappedBy = "locataire", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Loyer> loyerList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locataire() {
    }


    public String getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column
    private String dateEntree;

    @Column
    private String dateSortie;

    @Column
    private String telephone;

    public List<Loyer> getLoyerList() {
        return loyerList;
    }

    public void setLoyerList(List<Loyer> loyerList) {
        this.loyerList = loyerList;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Locataire{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loyerList=" + loyerList +
                ", dateEntree='" + dateEntree + '\'' +
                ", dateSortie='" + dateSortie + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
