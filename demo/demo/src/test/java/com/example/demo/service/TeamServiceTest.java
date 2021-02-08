/*package com.example.demo.service;

import com.example.demo.entity.Team;
import com.example.demo.enumPackage.Kind;
import com.example.demo.enumPackage.Universe;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Test
    void givenBadNameWhenCheckingThenThrowException() {
        Team team = givenBadName();

        Assertions.assertThrows(ValidationException.class, () -> teamService.saveTeam(team));
    }

    private Team givenBadName() {
        Team toCheck = new Team();
        toCheck.setName(null);
        toCheck.setKind(Kind.HERO);
        toCheck.setUniverse(Universe.DC);
        return toCheck;
    }
}*/