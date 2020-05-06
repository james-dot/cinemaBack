package org.sid.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

//projection => personaliser spring data rest
@Projection(name="ticketProj", types=Ticket.class)
public interface PTicketProjection {
	
	public Long getId();
	public String getNomClient();
	public int getPrix();
	public Integer getCodePayement();
	public boolean getReserve();
	public Place getPlace();
}
