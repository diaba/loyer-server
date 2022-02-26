package com.loyer.loyer.controller;

import com.loyer.loyer.Model.Asset;
import com.loyer.loyer.Model.Maintenance;
import com.loyer.loyer.Model.Maison;
import com.loyer.loyer.service.MaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/maisons")
public class MaisonController {
    private MaisonService maisonService;

    @Autowired
    public void setMaisonService(MaisonService maisonService) {
        this.maisonService = maisonService;
    }

    @GetMapping("")
    public List<Maison> getMaisons(){
        return maisonService.getMaisons();
    }

    @GetMapping("/{maisonId}/assets")
    public List<Asset> getMaisonAssets( @PathVariable Long maisonId){
        return maisonService.getMaisonAssets(maisonId);
    }

    @GetMapping("/{maisonId}/maintenances")
    public List<Maintenance> getMaisonMaintenance( @PathVariable Long maisonId){
        return maisonService.getMaisonMaintenances(maisonId);
    }

    @GetMapping("/{maisonId}")
    public Maison getMaison(@PathVariable Long maisonId){
        return maisonService.getMaisonById(maisonId);
    }


    @PostMapping("")
    public Maison createMaison(@RequestBody Maison maison){
        return maisonService.createMaison(maison);
    }

    @PostMapping("/{maisonId}/assets")
    public Asset createMaisonAsset(@RequestBody Asset asset, @PathVariable Long maisonId){
        return maisonService.createMaisonAsset(maisonId,asset);
    }

    @PostMapping("/{maisonId}/maintenances")
    public Maintenance createMaisonMaintenance(@RequestBody Maintenance maintenance, @PathVariable Long maisonId){
        return maisonService.createMaisonMaintenance(maisonId,maintenance);
    }



    @PutMapping("/{maisonId}")
    public Maison editMaison(@PathVariable Long maisonId, @RequestBody Maison maison){
        return maisonService.editMaison(maisonId, maison);
    }
    @DeleteMapping("/{maisonId}")
    public String deleteMaison(@PathVariable Long maisonId){
        return maisonService.deleteMaison(maisonId);
    }
}
