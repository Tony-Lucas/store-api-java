package com.devhall.storeapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.DeliverAdress;
import com.devhall.storeapi.repositories.DeliverAdressRepository;

import jakarta.transaction.Transactional;

@Service
public class DeliverAdressService {
    
    @Autowired
    private DeliverAdressRepository deliverAdressRepository;

    public DeliverAdress getDeliverAdressById(Long id){
        Optional<DeliverAdress> deliver_adress = this.deliverAdressRepository.findById(id);
        return deliver_adress.orElseThrow(() -> new RuntimeException("Endereço de entrega não encontrado"));
    }

    public List<DeliverAdress> getAllDeliverAdressesByUser_id(Long user_id){

        Optional<List<DeliverAdress>> deliver_adresses = this.deliverAdressRepository.findDeliverAdressByUser_id(user_id);

        return deliver_adresses.orElseThrow(() -> new RuntimeException("Endereços de entrega não encontrado"));
       
    }

    @Transactional
    public DeliverAdress createDeliverAdress(DeliverAdress deliver_adress){
        deliver_adress.setId(null);
        DeliverAdress created_deliver_adress = this.deliverAdressRepository.save(deliver_adress);
        return created_deliver_adress;
    }

    @Transactional
    public DeliverAdress updateDeliverAdress(DeliverAdress deliver_adress){
        DeliverAdress newDeliverAdress = getDeliverAdressById(deliver_adress.getId());
        newDeliverAdress.setArea(deliver_adress.getArea());
        newDeliverAdress.setCity(deliver_adress.getCity());
        newDeliverAdress.setComplement(deliver_adress.getComplement());
        newDeliverAdress.setHouse_number(deliver_adress.getHouse_number());
        newDeliverAdress.setState(deliver_adress.getState());
        newDeliverAdress.setStreet_adress(deliver_adress.getStreet_adress());
        newDeliverAdress.setZip_code(deliver_adress.getZip_code());
        newDeliverAdress = this.deliverAdressRepository.save(newDeliverAdress);

        return newDeliverAdress;
    }

    public void deleteDeliverAdress(Long id){
        getDeliverAdressById(id);
        try {
            this.deliverAdressRepository.deleteById(id);
        } catch (Exception e) {
            
        }
    }
    
}
