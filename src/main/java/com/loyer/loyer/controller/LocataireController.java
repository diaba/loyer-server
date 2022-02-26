package com.loyer.loyer.controller;

import com.loyer.loyer.Model.Locataire;
import com.loyer.loyer.Model.Loyer;
import com.loyer.loyer.service.LocataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path = "/locataires")
public class LocataireController {
    private LocataireService locataireService;

    @Autowired
    public void setLocataireService(LocataireService locataireService) {
        this.locataireService = locataireService;
    }

    @GetMapping("/api")
    public String helloWorld(){
        return "Home Page";
    }

    /**
     *
     * @param locataire
     * @return
     */
    @PostMapping("")
    public Locataire createLocataire(@RequestBody Locataire locataire){
        return locataireService.createLocataire(locataire);
    }

    @PostMapping ("/{locataireId}/assets/{assetId}")
    public Loyer addLoyerLocataire(@PathVariable Long locataireId, @PathVariable Long assetId, @RequestBody Loyer loyer){
        return locataireService.addLoyerLocataire(locataireId,assetId,loyer);
    }
    @GetMapping ("/{locataireId}/assets/{assetId}")
    public List<Loyer> getLocataireLoyer(@PathVariable Long locataireId, @PathVariable Long assetId){
        return locataireService.getLocataireLoyer(locataireId,assetId);
    }

    @GetMapping("")
    public List<Locataire> getLocataires(){
        return locataireService.getAll();
    }

    @GetMapping("/{locataireId}")
    public Locataire getLocataire(@PathVariable Long locataireId){
        return locataireService.getLocataireById(locataireId);
    }
    @PutMapping("/{locataireId}")
    public Locataire editLocataire(@PathVariable Long locataireId, @RequestBody Locataire locataire){
        return locataireService.editLocataire(locataireId, locataire);
    }
    @DeleteMapping("/{locataireId}")
    public String deleteLocataire(@PathVariable Long locataireId){
        return locataireService.deleteLocataire(locataireId);
    }

}
