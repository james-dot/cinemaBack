package org.sid.cinema.dao;

import org.sid.cinema.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//cree api rest avec cette annotation :toutes les methodes qui sont hérité de JPARep sont accessible via une api rest 
@RepositoryRestResource
@CrossOrigin("*")
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
