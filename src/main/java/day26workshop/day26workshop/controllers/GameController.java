package day26workshop.day26workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import day26workshop.day26workshop.services.GamesService;
import jakarta.json.JsonObject;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GamesService gamesSvc;

    //application_form_urlencoded_value
    @GetMapping(path = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGames(@RequestParam(required = false) Integer limit, @RequestParam(required = false)Integer offset) {

        if (limit == null) {
            limit = 20;
        }
        if (offset == null) {
            offset = 0;
        }
        JsonObject responseObject = gamesSvc.getGames(limit, offset);

        return ResponseEntity.ok(responseObject.toString());
    }

    @GetMapping(path = "/games/rank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGamesByRank(@RequestParam(required = false) Integer limit, @RequestParam(required = false)Integer offset) {

        if (limit == null) {
            limit = 20;
        }
        if (offset == null) {
            offset = 0;
        }
        JsonObject responseObject = gamesSvc.getGamesByRank(limit, offset);

        return ResponseEntity.ok(responseObject.toString());
    }

    @GetMapping(path = "/games/{game_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGamesByRank(@PathVariable("game_id") String gameId) {

        Integer intId = Integer.parseInt(gameId);
        System.out.printf("Int ID is: %d\n",intId);

        try{
        JsonObject responseObject = gamesSvc.getGameById(intId);
        return ResponseEntity.ok(responseObject.toString());

        
        //exception not completed
        }catch(Exception e){
            // JsonObject responseObject = Json.createObjectBuilder()
            // .add("message", e.getMessage())
            // .build();

			return ResponseEntity.status(400).body("Invalid game id");
        }
        // return ResponseEntity.ok(responseObject.toString());
    }
    


}
