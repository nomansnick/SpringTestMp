package com.example.demo.entity;

import com.example.demo.enumPackage.Universe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "NOT_A_SUPERHERO")
public class SuperHero {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Universe universe;
    private boolean hero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Team team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public boolean isHero() {
        return hero;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", universe=" + universe +
                ", hero=" + hero +
                ", team=" + (team != null ? team.getId() : "null") +
                '}';
    }
}
