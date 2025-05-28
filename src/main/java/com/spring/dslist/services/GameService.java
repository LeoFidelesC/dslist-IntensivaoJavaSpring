package com.spring.dslist.services;

import com.spring.dslist.dto.GameDTO;
import com.spring.dslist.dto.GameMinDTO;
import com.spring.dslist.entities.Game;
import com.spring.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result=gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
            var result=gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
        }
}
