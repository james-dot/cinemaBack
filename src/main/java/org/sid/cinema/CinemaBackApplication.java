package org.sid.cinema;

import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaBackApplication implements CommandLineRunner{

	@Autowired
	private ICinemaInitService cinemaInitService;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CinemaBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//inclure le id dans le resultat du recherche
		restConfiguration.exposeIdsFor(Film.class,Salle.class);
			cinemaInitService.initVilles();
			cinemaInitService.initCinemas();
			cinemaInitService.initSalles();
			cinemaInitService.initPlaces();
			cinemaInitService.initSeances();
			cinemaInitService.initCategories();
			cinemaInitService.initFilms();
			cinemaInitService.initProjections();
			cinemaInitService.initTickets();
	}

}
