package com.loyer.loyer.service;

import com.loyer.loyer.Model.Asset;
import com.loyer.loyer.Model.Maintenance;
import com.loyer.loyer.Model.Maison;
import com.loyer.loyer.Model.Maison;
import com.loyer.loyer.exception.DoesExistException;
import com.loyer.loyer.repository.AssetRepository;
import com.loyer.loyer.repository.MaintenanceRepository;
import com.loyer.loyer.repository.MaisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaisonService {
    private MaisonRepository maisonRepository;
    private AssetRepository assetRepository;
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    public void setMaintenanceRepository(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Autowired
    public void setAssetRepository(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }


    @Autowired
    public void setMaisonRepository(MaisonRepository maisonRepository) {
        this.maisonRepository = maisonRepository;
    }

    public Maison createMaison(Maison maison){
        return maisonRepository.save(maison);
    }

    public List<Maison> getMaisons(){
        return maisonRepository.findAll();
    }
    public List<Asset> getMaisonAssets(Long id){
        Optional<Maison> maison = maisonRepository.findById(id);
        if (maison.isEmpty()){
            throw new DoesExistException("Maison");
        }else {
            return maison.get().getAssetList();
        }
    }
    public List<Maintenance> getMaisonMaintenances(Long id){
        Optional<Maison> maison = maisonRepository.findById(id);
        if (maison.isEmpty()){
            throw new DoesExistException("Maison");
        }else {
            return maison.get().getMaintenanceList();
        }
    }
    public Maison getMaisonById(Long id){
        Optional<Maison> maison = maisonRepository.findById(id);
        if (maison.isEmpty()){
            throw new DoesExistException("Maison");
        }else{
            return maison.get();
        }
    }
    /**
     *
     * @param id
     * @param maisonObj
     * @return
     */
    public Maison editMaison(Long id, Maison maisonObj){
        Maison maison = maisonRepository.getById(id);
        if (maison == null){
            throw new DoesExistException("Maison with id does not exist");
        }
        maison.setName(maisonObj.getName());
        maison.setLocalisation(maisonObj.getLocalisation());
        return maisonRepository.save(maison);
    }

    public String deleteMaison(Long id){
        Maison maison = maisonRepository.getById(id);
        if (maison == null){
            throw new DoesExistException("Maison with id does not exist");
        }
        maisonRepository.delete(maison);
        return "Maison deleted ";
    }
    public Asset createMaisonAsset(Long id, Asset assetObj){
        Optional<Maison> maison = maisonRepository.findById(id);
        if (maison.isEmpty()){
            throw new DoesExistException("Maison does not exist");
        }
        assetObj.setMaison(maison.get());
        return assetRepository.save(assetObj);
    }
    public Maintenance createMaisonMaintenance(Long id, Maintenance maintenanceObj){
        Optional<Maison> maison = maisonRepository.findById(id);
        if (maison.isEmpty()){
            throw new DoesExistException("Maison does not exist");
        }
        maintenanceObj.setMaison(maison.get());
        return maintenanceRepository.save(maintenanceObj);
    }

}

