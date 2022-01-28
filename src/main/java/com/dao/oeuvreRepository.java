package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entites.Oeuvre;

public interface oeuvreRepository extends JpaRepository<Oeuvre, Long> {

	@Query("select oeuvre from Oeuvre oeuvre where oeuvre.titre like :x")
	public List<Oeuvre> chercherOeuvre(@Param("x") String titre); 
}
