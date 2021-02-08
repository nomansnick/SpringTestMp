package com.example.demo.controller;

import com.example.demo.entity.SuperHero;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/superheroes")
public class SuperHeroController {

    private final SuperHeroService superHeroService;
    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @PostMapping("/newhero")
    public SuperHero saveHero(@RequestBody SuperHero superHero) {
        try {
            return superHeroService.saveHero(superHero);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("/heroes")
    public List<SuperHero> findAllHeroes() {
        return superHeroService.findAll();
    }

    @GetMapping("/hero/{id}")
    public SuperHero findHeroById(@PathVariable ("id") String id) {
        try {
            return superHeroService.findById(id);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @PutMapping("/changehero")
    public SuperHero changeHero(@RequestBody SuperHero superHero) {
        try {
            return superHeroService.modifyHero(superHero);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
