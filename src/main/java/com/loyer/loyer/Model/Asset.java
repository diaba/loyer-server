package com.loyer.loyer.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String type;

    @Column
    private String description;

    // one to many with loyer
    @OneToMany(mappedBy = "asset", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Loyer> loyerList;

    // many to one with maison
    @ManyToOne
    @JoinColumn(name = "maison_id")
    @JsonIgnore
    private Maison maison;

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", maison=" + maison +
                ", loyerList=" + loyerList +
                ", maison=" + maison +
                '}';
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Loyer> getLoyerList() {
        return loyerList;
    }

    public void setLoyerList(List<Loyer> loyerList) {
        this.loyerList = loyerList;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
