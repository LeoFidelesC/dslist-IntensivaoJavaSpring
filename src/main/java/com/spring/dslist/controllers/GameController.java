package com.spring.dslist.controllers;

import com.spring.dslist.dto.GameMinDTO;
import com.spring.dslist.entities.Game;
import com.spring.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }
}
