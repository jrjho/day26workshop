package day26workshop.day26workshop.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import day26workshop.day26workshop.models.Game;
import day26workshop.day26workshop.models.SearchGameId;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@Repository
public class GameRepository {

    public static final String C_GAME = "game";

    @Autowired
    MongoTemplate mongoTemplate;


//     db.getCollection("game").find({
  
//         gid : {$exists : true}
       
//    }).skip(1).limit(20).sort({gid:1})

    public JsonObject getGames(Integer limitInput, Integer offsetInput) {

        Criteria criteria = Criteria.where("gid").exists(true);
        Query query = Query.query(criteria).with(Sort.by(Sort.Direction.ASC,"gid")).skip(offsetInput).limit(limitInput);

        List<Game> listOfGames = mongoTemplate.find(query, Game.class, C_GAME);

        JsonObjectBuilder gameInJson = Json.createObjectBuilder();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (Game game : listOfGames) {
            gameInJson.add("gid", game.getGid());
            gameInJson.add("name", game.getName());
            jsonArrayBuilder.add(gameInJson);
        }

        JsonObject task = Json.createObjectBuilder()
				.add("games",jsonArrayBuilder)
				.add("offset", offsetInput)
				.add("limit", limitInput)
				.add("total", listOfGames.size())
                .add("timestamp", LocalDate.now().toString())
				.build();
        //------------------------------------------------------------
        System.out.printf(">>> Games2 %s\n", task.toString());

        return task;
    }
  
    public JsonObject getGamesByRank(Integer limitInput, Integer offsetInput ){

        Criteria criteria = Criteria.where("ranking").exists(true);
        Query query = Query.query(criteria).with(Sort.by(Sort.Direction.ASC,"ranking")).skip(offsetInput).limit(limitInput);
       
        System.out.printf(">>> limit %d\n", limitInput);
        System.out.printf(">>> offset %d\n", offsetInput);

        List<Game> listOfGames = mongoTemplate.find(query, Game.class, C_GAME);

        JsonObjectBuilder gameInJson = Json.createObjectBuilder();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (Game game : listOfGames) {
            gameInJson.add("gid", game.getGid());
            gameInJson.add("name", game.getName());
            gameInJson.add("ranking", game.getRanking());
            jsonArrayBuilder.add(gameInJson);
        }

        JsonObject task = Json.createObjectBuilder()
            .add("games",jsonArrayBuilder)
			.add("offset", offsetInput)
			.add("limit", limitInput)
			.add("total", listOfGames.size())
            .add("timestamp", LocalDate.now().toString())
			.build();

        return task;
    }

    public JsonObject getGameById(Integer id){

        Criteria criteria = Criteria.where("gid").is(id);
        Query query = Query.query(criteria);
        List<SearchGameId> listOfGames = mongoTemplate.find(query, SearchGameId.class, C_GAME);

        JsonObject task = Json.createObjectBuilder()
        .add("game_id", id)
        .add("name", listOfGames.get(0).getName())
        .add("year", listOfGames.get(0).getYear())
        .add("ranking", listOfGames.get(0).getRanking())
        .add("users_rated", listOfGames.get(0).getUsers_rated())
        .add("url", listOfGames.get(0).getUrl())
        .add("thumbnail", listOfGames.get(0).getImage())
        .add("timestamp", LocalDate.now().toString())
        .build();
        System.out.printf("listofGame is: %s\n",task.toString());

        return task;

    


        // MatchOperation filterCountry = Aggregation.match(Criteria.where("gid").is(id));
        // ProjectionOperation propertyName = Aggregation.project("gid","name" ,"year","ranking","users_rated","url","image")
        //         .andExclude("_id");
        // Aggregation pipeline = Aggregation.newAggregation(filterCountry, propertyName);
        // AggregationResults<Document> results = mongoTemplate.aggregate(
		// 		pipeline, C_GAME, Document.class);

        // List<SearchGameId> nameList = new ArrayList<>();
		// for (Document d: results){
		// 	nameList.add(d.);
		// 	nameList.add(d.getString("listing_url"));
		// }

	// 	System.out.printf("name list: %s\n", nameList);
	// 	return nameList;

    }
    

    // public static JsonObject toJson(Document doc) {
	// 	JsonReader reader = Json.createReader(new StringReader(doc.toJson()));
	// 	return reader.readObject();
	// }

    // public static SearchGameId toSearchGameId(JsonObject obj) {
	// 	SearchGameId javaObj = new SearchGameId();
	// 	javaObj.setGid(obj.getInt("id"));
	// 	javaObj.setName(obj.getString("name"));
	// 	javaObj.setYear(obj.getInt("year"));
	// 	return javaObj;
	// }

    // public List<String> searchAccomodationByCountry(String country, String searchTerms) {

	// 	String[] terms = searchTerms.split(" ");
	// 	MatchOperation searchByDescription = Aggregation.match(
	// 			TextCriteria.forDefaultLanguage().matchingAny(terms));

	// 	MatchOperation filterCountry = Aggregation.match(
	// 			Criteria.where("address.country").is(country));

	// 	ProjectionOperation propertyName = Aggregation.project("name" ,"listing_url")
	// 			.andExclude("_id");

	// 	SortOperation orderByName = Aggregation.sort(
	// 			Sort.by(Direction.ASC,  "name"));

	// 	Aggregation pipeline = Aggregation.newAggregation(
	// 				searchByDescription, filterCountry, propertyName, orderByName);

	// 	AggregationResults<Document> results = template.aggregate(
	// 			pipeline, C_LOCATIONS, Document.class);

	// 	List<String> nameList = new ArrayList<>();
	// 	for (Document d: results){
	// 		nameList.add(d.getString("name"));
	// 		nameList.add(d.getString("listing_url"));
	// 	}

	// 	System.out.printf("name list: %s\n", nameList);
	// 	return nameList;
	// }

}
