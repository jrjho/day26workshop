package day26workshop.day26workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day26workshop.day26workshop.repositories.GameRepository;
import jakarta.json.JsonObject;

@Service
public class GamesService {

    @Autowired
    GameRepository gameRepo;

    public JsonObject getGames(Integer limitInput, Integer offsetInput) {
        return gameRepo.getGames(limitInput, offsetInput);
    }

    public JsonObject getGamesByRank(Integer limitInput, Integer offsetInput) {
        return gameRepo.getGamesByRank(limitInput, offsetInput);
    }

    public JsonObject getGameById(Integer gameId) {
        return gameRepo.getGameById(gameId);
    }
    
}
