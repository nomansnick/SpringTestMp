package com.example.demo.service;

import com.example.demo.entity.Team;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team saveTeam(Team team) throws ValidationException {
        checker(team);
        return teamRepository.save(team);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findTeamById(String id) throws ValidationException {
        return teamRepository.findById(id).orElseThrow(() -> new ValidationException("BAD ID"));
    }

    public Team changeTeam(Team team) throws ValidationException {
        checker(team);
        Team changedTeam = findTeamById(team.getId());
        changedTeam.setKind(team.getKind());
        changedTeam.setName(team.getName());
        changedTeam.setUniverse(team.getUniverse());
        return teamRepository.save(changedTeam);
    }

    public void checker(Team team) throws ValidationException {
        Objects.requireNonNull(team);
        if (team.getName() == null || team.getName().length() < 1) {
            throw new ValidationException("BAD NAME");
        }
        if (team.getKind() == null) {
            throw new ValidationException("BAD KIND");
        }
        if (team.getUniverse() == null) {
            throw new ValidationException("BAD UNIVERSE");
        }
    }
}
