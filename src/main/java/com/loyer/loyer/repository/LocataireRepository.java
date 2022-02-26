package com.loyer.loyer.repository;

import com.loyer.loyer.Model.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocataireRepository extends JpaRepository<Locataire, Long> {
    Locataire findByName(String name);
}
