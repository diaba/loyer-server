package com.loyer.loyer.repository;

import com.loyer.loyer.Model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
