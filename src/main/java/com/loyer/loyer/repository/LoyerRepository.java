package com.loyer.loyer.repository;

import com.loyer.loyer.Model.Loyer;
import com.loyer.loyer.Model.LoyerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoyerRepository extends JpaRepository<Loyer, Long> {
   //double montant, String locataire, String maison, String asset, String maisonAddresse, String date, String telephone)
        @Query("SELECT new com.loyer.loyer.Model.LoyerRequest(l.montant,loc.name, m.name, a.description, m.name, l.date, loc.telephone) FROM Loyer l "
            + " JOIN Asset a ON a.id = l.id"
            + " JOIN Maison m ON m.id = a.id"
            + " JOIN Locataire loc ON loc.id = l.id")
    List<LoyerRequest> getJoinInformation();

    List<Loyer> findAllByLocataireIdAndAssetId(Long locataireId, Long assetId);

    //   List<Loyer> getAllByAssetA(Long assetId, Long locataireId);



//    @Query("SELECT new com.loyer.loyer.Model.LoyerRequest( l.date,  l.montant, a.description, loc.name, loc.telephone, m.name, m.localisation)"
//            + "FROM loyers l "
//            + " JOIN asset a ON a.id = l.asset_id"
//            + " JOIN maisons m ON m.id = a.maison_id"
//            + " JOIN locataire loc ON loc.id = l.locataire_id")
//    List<LoyerRequest> getJoinInformation();

//    @Query("select l.id, l.locataire, l.asset, l.date , l.description, l.montant from Loyer l where l.asset.id =: assetId AND l.locataire.id =:locataireId ")
//    List<Loyer> findByAssetIdAndLocataireId(@Param("assetId") Long assetId, @Param("locataireId") Long locataireId);
}

