package com.example.cardapio.controller;

import com.example.cardapio.dto.FoodRequestDto;
import com.example.cardapio.dto.FoodResponseDto;
import com.example.cardapio.model.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    public List<FoodResponseDto> getAll(){
        return this.repository
                .findAll()
                .stream()
                .map(FoodResponseDto::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDto data){
        Food foodData = new Food(data);
        this.repository.save(foodData);
        return;
    }

}
