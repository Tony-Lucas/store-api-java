package com.devhall.storeapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.DeliverAdress;

@Repository
public interface DeliverAdressRepository extends JpaRepository<DeliverAdress,Long> {
    
    Optional<List<DeliverAdress>> findDeliverAdressByUser_id(Long user_id);

}
