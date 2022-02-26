package com.loyer.loyer.service;

import com.loyer.loyer.Model.Asset;
import com.loyer.loyer.exception.DoesExistException;
import com.loyer.loyer.repository.AssetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AssetService {
    private AssetRepository assetRepository;

    @Autowired
    public void setAssetRepository(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }
    /**
     *
     * @param assetObject
     * @return
     */
    public Asset createAsset(Asset assetObject){
            return assetRepository.save(assetObject);
    }

    /**
     *
     * @return
     */
    public List<Asset> getAll(){
        return assetRepository.findAll();
    }



    public Asset getAssetById(Long id){
        Optional<Asset> asset = assetRepository.findById(id);
        if (asset.isEmpty()){
            throw new DoesExistException("asset");
        }else{
            return asset.get();
        }
    }
    /**
     *
     * @param id
     * @param assetObj
     * @return
     */
    public Asset editAsset(Long id, Asset assetObj){
        Asset asset = assetRepository.getById(id);
        if (asset == null){
            throw new DoesExistException("asset with id does not exist");
        }
        asset.setDescription(assetObj.getDescription());
        asset.setType(assetObj.getType());
        return assetRepository.save(asset);
    }

    public String deleteAsset(Long id){
        Asset asset = assetRepository.getById(id);
        if (asset == null){
            throw new DoesExistException("asset with id does not exist");
        }
        assetRepository.delete(asset);
        return "asset deleted ";
    }
}
