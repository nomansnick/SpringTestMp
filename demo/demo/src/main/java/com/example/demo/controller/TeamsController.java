package com.example.demo.controller;

import com.example.demo.entity.Team;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamsController {

    private final TeamService teamService;

    @Autowired
    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/newteam")
    public Team saveTeam(@RequestBody Team team) {
        try {
            return teamService.saveTeam(team);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("/team/{id}")
    public Team findTeamById(@PathVariable("id") String id) {
        try {
            return teamService.findTeamById(id);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("/teams")
    public List<Team> findAllTeams() {
        return teamService.findAll();
    }

    @PutMapping("/changeteam")
    public Team changeTeam(@RequestBody Team team) {
        try {
            return teamService.changeTeam(team);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
