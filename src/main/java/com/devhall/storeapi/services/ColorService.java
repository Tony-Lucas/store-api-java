package com.devhall.storeapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.Color;
import com.devhall.storeapi.repositories.ColorRepository;

import jakarta.transaction.Transactional;

@Service
public class ColorService {
    
    @Autowired
    private ColorRepository colorRepository;

    public Color getColorById(Long id){
        Optional<Color> color = this.colorRepository.findById(id);
        return color.orElseThrow(() -> new RuntimeException("Cor não encontrada"));
    }

    public List<Color> getAllColorsByUser_id(Long user_id){
        List<Color> color = this.colorRepository.findByUser_id(user_id);
        return color;
    }

    @Transactional
    public Color createColor(Color obj){
        Color color = this.colorRepository.save(obj);
        return color;
    }

    @Transactional
    public Color updateColor(Color obj){
        Color newColor = getColorById(obj.getId());
        newColor.setHex(obj.getHex());
        newColor.setRgb(obj.getRgb());
        newColor = this.colorRepository.save(newColor);
        return newColor;
    }

    public void deleteColor(Long id){
        getColorById(id);
        try {
            this.colorRepository.deleteById(id);
        } catch (Exception e) {
            
        }
    }

}
