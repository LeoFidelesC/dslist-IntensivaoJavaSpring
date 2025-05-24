package com.spring.dslist.services;

import com.spring.dslist.dto.GameMinDTO;
import com.spring.dslist.entities.Game;
import com.spring.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        }

    public List<GameMinDTO> findAll(){
            var result=gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
        }
}
