package com.loyer.loyer.Model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "maisons")
public class Maison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    @Override
    public String toString() {
        return "Maison{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", assetList=" + assetList +
                ", maintenanceList=" + maintenanceList +
                ", localisation='" + localisation + '\'' +
                '}';
    }

    public void setMaintenanceList(List<Maintenance> maintenanceList) {
        this.maintenanceList = maintenanceList;
    }

    // one to many asset && maintenance
    @OneToMany(mappedBy = "maison", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Asset> assetList;

    @OneToMany(mappedBy = "maison", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Maintenance> maintenanceList;

    public Maison() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Column
    private String localisation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
