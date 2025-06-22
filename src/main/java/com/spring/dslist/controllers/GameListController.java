package com.spring.dslist.controllers;

import com.spring.dslist.dto.GameListDTO;
import com.spring.dslist.dto.GameMinDTO;
import com.spring.dslist.dto.ReplacementDTO;
import com.spring.dslist.services.GameListService;
import com.spring.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO){
        gameListService.move(listId,replacementDTO.getSourceIndex(),replacementDTO.getDestinationIndex());

    }
}
