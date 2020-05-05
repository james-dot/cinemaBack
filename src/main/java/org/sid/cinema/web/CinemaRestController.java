package org.sid.cinema.web;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
	
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping(path="/imageFilm/{id}",produces=MediaType.IMAGE_JPEG_VALUE)//pour retourne image en a besoin du ann path
	public byte[] image(@PathVariable (name="id") Long id) throws Exception{//pour recupere id en a besoin du ann PathVariable
		Film f=filmRepository.findById(id).get();
		String photoName = f.getPhoto();
		File file= new File(System.getProperty("user.home")+"/cinema/images/"+photoName);//return ce chemin C:\Users\HP 820/cinema/images/photo.jpg
		Path path= Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){//les donnees des tickets ils sont envoyer dans la corps de la requete
		List<Ticket> listTickets = new ArrayList<>();
		ticketForm.getTickets().forEach(idTicket ->{
			Ticket ticket = ticketRepository.findById(idTicket).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setReserve(true);
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		return listTickets;
	}
}

@Data
class TicketForm{
	private String nomClient;
	private List<Long> tickets = new ArrayList<>();
}

