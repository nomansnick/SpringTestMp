package com.example.demo.repository;

import com.example.demo.entity.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, String> {
}
