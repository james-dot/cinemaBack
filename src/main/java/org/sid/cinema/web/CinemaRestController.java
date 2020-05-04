package org.sid.cinema.web;

import java.util.List;

import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaRestController {
	
	@Autowired 
	private FilmRepository filmRepository;
	//avec cette recherche l'app est blocké car cette methode retourn au meme temps les projections et les categories 
	//pour resoudre ce probleme sur la class film en ajoute annotation @JsonProperty sur la collection des projections .....
	@GetMapping("/listFilms") //creation manuelle mais deja en a avec cette annotation @RepositoryRestResource
	public List<Film> films(){
		return filmRepository.findAll();
	}
}
