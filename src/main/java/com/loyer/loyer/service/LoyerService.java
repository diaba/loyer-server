package com.loyer.loyer.service;

import com.loyer.loyer.Model.Loyer;
import com.loyer.loyer.Model.LoyerRequest;
import com.loyer.loyer.exception.DoesExistException;
import com.loyer.loyer.repository.LoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoyerService {

    private LoyerRepository loyerRepository;

    @Autowired
    public void setloyerRepository(LoyerRepository loyerRepository) {
        this.loyerRepository = loyerRepository;
    }

    /**
     *
     * @param loyerObject
     * @return
     */
    public Loyer createloyer(Loyer loyerObject){

            return loyerRepository.save(loyerObject);
    }

    /**
     *
     * @return
     */
    public List<Loyer> getAll(){
        return loyerRepository.findAll();
    }



    public Loyer getloyerById(Long id){
        Optional<Loyer> Loyer = loyerRepository.findById(id);
        if (Loyer.isEmpty()){
            throw new DoesExistException("Loyer");
        }else{
            return Loyer.get();
        }
    }


    public String deleteloyer(Long id){
        Loyer Loyer = loyerRepository.getById(id);
        if (Loyer == null){
            throw new DoesExistException("Loyer with id does not exist");
        }
        loyerRepository.delete(Loyer);
        return "Loyer deleted ";
    }

}
