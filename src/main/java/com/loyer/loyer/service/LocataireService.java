package com.loyer.loyer.service;

import com.loyer.loyer.Model.Asset;
import com.loyer.loyer.Model.Locataire;
import com.loyer.loyer.Model.Loyer;
import com.loyer.loyer.exception.DoesExistException;
import com.loyer.loyer.repository.AssetRepository;
import com.loyer.loyer.repository.LocataireRepository;
import com.loyer.loyer.repository.LoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Locataire service
 * Create new locataire
 * Delete locataire
 */
@Service
public class LocataireService {
    private LocataireRepository locataireRepository;
    private AssetRepository assetRepository;
    private LoyerRepository loyerRepository;

    @Autowired
    public void setloyerRepository(LoyerRepository loyerRepository) {
        this.loyerRepository = loyerRepository;
    }

    @Autowired
    public void setAssetRepository(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Autowired
    public void setLocataireRepository(LocataireRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    /**
     *
     * @param locataireObject
     * @return
     */
    public Locataire createLocataire(Locataire locataireObject){
        Locataire locataire = locataireRepository.findByName(locataireObject.getName());
        if (locataire != null){
            throw new DoesExistException("Locataire");
        }else{
            return locataireRepository.save(locataireObject);
        }
    }
    public Loyer createLocataireLoyer(Long assetId,Long locataireId ,Loyer loyer){
        Optional<Locataire> locataire = locataireRepository.findById(locataireId);
        if (locataire.isEmpty()){
            throw new DoesExistException("Locataire");
        }else{
            Optional<Asset> asset = assetRepository.findById(assetId);
            if(asset.isEmpty()){
                throw new DoesExistException("Asset");
            }
            loyer.setAsset(asset.get());
            loyer.setLocataire(locataire.get());
           return loyerRepository.save(loyer);
        }
    }
//    public List<Loyer> getLocataireLoyers(Long assetId,Long locataireId ){
//        Optional<Locataire> locataire = locataireRepository.findById(locataireId);
//        if (locataire.isEmpty()){
//            throw new DoesExistException("Locataire");
//        }else{
//            Optional<Asset> asset = assetRepository.findById(assetId);
//            if(asset.isEmpty()){
//                throw new DoesExistException("Asset");
//            }
//            return loyerRepository.findByAssetIdAndLocataireId(assetId,locataireId);
//        }
//    }
    /**
     *
     * @return
     */
    public List<Locataire> getAll(){
        return locataireRepository.findAll();
    }

    public Locataire getLocataireById(Long id){
        Optional<Locataire> locataire = locataireRepository.findById(id);
        if (locataire.isEmpty()){
            throw new DoesExistException("Locataire");
        }else{
            return locataire.get();
        }
    }
    /**
     *
     * @param id
     * @param locataireObj
     * @return
     */
    public Locataire editLocataire(Long id, Locataire locataireObj){
        Locataire locataire = locataireRepository.getById(id);
        if (locataire == null){
            throw new DoesExistException("Locataire with id does not exist");
        }
        locataire.setName(locataireObj.getName());
        locataire.setDateEntree(locataireObj.getDateEntree());
        locataire.setDateSortie(locataireObj.getDateSortie());
        locataire.setTelephone(locataireObj.getTelephone());
        return locataireRepository.save(locataire);
    }

    public String deleteLocataire(Long id){
        Locataire locataire = locataireRepository.getById(id);
        if (locataire == null){
            throw new DoesExistException("Locataire with id does not exist");
        }
        locataireRepository.delete(locataire);
        return "Locataire deleted ";
    }

    /**
     *
     * @param locataireObject
     * @return
     */
    public Locataire getLocataireByName(Locataire locataireObject){
        Locataire locataire = locataireRepository.findByName(locataireObject.getName());
        if (locataire != null){
            throw new DoesExistException("Locataire");
        }else{
            return locataire;
        }
    }

    public Loyer addLoyerLocataire(Long locataireId, Long assetId, Loyer loyer){
        Optional<Locataire> locataire = locataireRepository.findById(locataireId);
        if (locataire.isEmpty()){
            throw new DoesExistException("Locataire with id does not exist");
        }
        else {
            Optional<Asset> asset = assetRepository.findById(assetId);
            if (asset.isEmpty()){
                throw new DoesExistException("Asset does not exist");
            }else{
                loyer.setLocataire(locataire.get());
                loyer.setAsset(asset.get());
                return  loyerRepository.save(loyer);
            }
        }
    }


    public List<Loyer> getLocataireLoyer(Long locataireId, Long assetId) {
        Optional<Locataire> locataire = locataireRepository.findById(locataireId);
        if (locataire.isEmpty()){
            throw new DoesExistException("Locataire with id does not exist");
        }else {
            Optional<Asset> asset = assetRepository.findById(assetId);
            if (asset.isEmpty()){
                throw new DoesExistException("Asset does not exist");
            }else{
                return loyerRepository.findAllByLocataireIdAndAssetId(locataireId,assetId);
            }

        }
    }
}
