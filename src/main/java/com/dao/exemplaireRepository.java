package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entites.Exemplaire;


public interface exemplaireRepository extends JpaRepository<Exemplaire, Long>{

	@Query("select exemplaire from Exemplaire exemplaire where exemplaire.oeuvre.id like :x and exemplaire.etat = 'neuf' or exemplaire.etat = 'abime'")
	public List<Exemplaire> chercherExemplaire(@Param("x") Long id); 
	
	@Query("select exemplaire from Exemplaire exemplaire where exemplaire.oeuvre.titre like :x")
	public List<Exemplaire> chercherExemplaire(@Param("x") String titre); 
	
	@Query("select exemplaire from Exemplaire exemplaire where exemplaire.disponible = true and exemplaire.etat = 'neuf' or exemplaire.etat = 'abime'")
	public List<Exemplaire> listExemplaire(); 
}

