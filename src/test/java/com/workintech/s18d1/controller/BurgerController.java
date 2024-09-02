package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burgers")
public class BurgerController {

    private final BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }

    @GetMapping
    public List<Burger> getBurgers() {
        return burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgersById(@PathVariable long id){
        BurgerValidation.validateId(id);
        return burgerDaoImpl.findById(id);
    }

    @Transactional
    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger){
        BurgerValidation.validateBurger(burger);
        return burgerDaoImpl.save(burger);
    }

    @Transactional
    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable long id, @RequestBody Burger burger){
        BurgerValidation.validateId(id);
        BurgerValidation.validateBurger(burger);
        burger.setId(id);
        return burgerDaoImpl.update(burger);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable long id){
        BurgerValidation.validateId(id);
        burgerDaoImpl.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestParam double price){
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestParam BreadType breadType){
        return burgerDaoImpl.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestParam String content){
        return burgerDaoImpl.findByContent(content);
    }
}
