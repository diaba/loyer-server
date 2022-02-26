package com.loyer.loyer.controller;
import com.loyer.loyer.Model.Loyer;
import com.loyer.loyer.service.LoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/loyers")
public class LoyerController {
    private LoyerService loyerService;

    @Autowired
    public void setLoyerService(LoyerService loyerService) {
        this.loyerService = loyerService;
    }

    @PostMapping
    public Loyer createLoyer(Loyer loyer){
        return loyerService.createloyer(loyer);
    }

    @GetMapping
    public List<Loyer> getLoyers(){
        return loyerService.getAll();
    }



}
