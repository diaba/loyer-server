package com.loyer.loyer.controller;

import com.loyer.loyer.Model.Asset;
import com.loyer.loyer.service.AssetService;
import com.loyer.loyer.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/assets")
public class AssetController {
    @Autowired
    private AssetService assetService ;


    @GetMapping("")
    public List<Asset> getAssets(){
        return assetService.getAll();
    }

    @PostMapping("")
    public Asset createAsset(@RequestBody Asset asset){
        return assetService.createAsset(asset);
    }

    @GetMapping("/{assetId}")
    public Asset getAsset(@PathVariable Long assetId){
        return assetService.getAssetById(assetId);
    }
    @PutMapping("/{assetId}")
    public Asset editAsset(@PathVariable Long assetId, @RequestBody Asset asset){
        return assetService.editAsset(assetId, asset);
    }
    @DeleteMapping("/{assetId}")
    public String deleteAsset(@PathVariable Long assetId){
        return assetService.deleteAsset(assetId);
    }
}
