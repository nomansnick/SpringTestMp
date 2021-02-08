package com.example.demo.service;

import com.example.demo.entity.SuperHero;
import com.example.demo.entity.Team;
import com.example.demo.enumPackage.Kind;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.SuperHeroRepository;
import com.example.demo.repository.TeamRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SuperHeroService {

    private final SuperHeroRepository superHeroRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository, TeamRepository teamRepository) {
        this.superHeroRepository = superHeroRepository;
        this.teamRepository = teamRepository;
    }

    public SuperHero saveHero(SuperHero superHero) throws ValidationException {
        Checker(superHero);
        return superHeroRepository.save(superHero);
    }

    public List<SuperHero> findAll() {
        return superHeroRepository.findAll();
    }

    public SuperHero findById(String id) throws ValidationException {
        return superHeroRepository.findById(id).orElseThrow(()-> new ValidationException("BAD ID"));
    }

    public SuperHero modifyHero(SuperHero superHero) throws ValidationException {
        Checker(superHero);
        SuperHero changedHero = findById(superHero.getId());
        changedHero.setHero(superHero.isHero());
        changedHero.setTeam(superHero.getTeam());
        changedHero.setName(superHero.getName());
        changedHero.setUniverse(superHero.getUniverse());
        return superHeroRepository.save(changedHero);
    }

    public void Checker(SuperHero superHero) throws ValidationException {
        Objects.requireNonNull(superHero);
        if (superHero.getName() == null || superHero.getName().length() < 1) {
            throw new ValidationException("BAD NAME");
        }
        if (superHero.getTeam().getId() == null) {
            throw new ValidationException("BAD TEAM");
        }
        if (superHero.getUniverse() == null) {
            throw new ValidationException("BAD UNIVERSE");
        }
        if (superHero.getUniverse() != superHero.getTeam().getUniverse()) {
            throw new ValidationException("UNIVERSE MISMATCH");
        }

        if (superHero.isHero() && superHero.getTeam().getKind() != Kind.HERO) {
            throw new ValidationException("ALIGNMENT MISMATCH");
        }
        if (!superHero.isHero() && superHero.getTeam().getKind() != Kind.VILLAIN) {
            throw new ValidationException("ALIGNMENT MISMATCH");
        }

    }
}
