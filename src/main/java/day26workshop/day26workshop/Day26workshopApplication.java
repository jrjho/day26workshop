package day26workshop.day26workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import day26workshop.day26workshop.repositories.GameRepository;

@SpringBootApplication
public class Day26workshopApplication implements CommandLineRunner {

	@Autowired
	GameRepository gameRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day26workshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gameRepo.getGamesByRank(20, 1);
        
		// System.out.printf(">>%s\n",results);

		// for (Game doc : results){
		// 			System.out.printf(">>%s\n",doc);
		// 		}

	}

}
