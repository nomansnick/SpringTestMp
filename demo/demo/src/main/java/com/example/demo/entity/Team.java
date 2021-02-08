package com.example.demo.entity;

import com.example.demo.enumPackage.Kind;
import com.example.demo.enumPackage.Universe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NOT_A_TEAM")
public class Team {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Universe universe;
    private Kind kind;
    private String name;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<SuperHero> heroList;

    public List<SuperHero> getHeroList() {
        return heroList;
    }
    public void setHeroList(List<SuperHero> heroList) {
        this.heroList = heroList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", universe=" + universe +
                ", kind=" + kind +
                ", name='" + name + '\'' +
                ", heroList=" + heroList +
                '}';
    }
}
