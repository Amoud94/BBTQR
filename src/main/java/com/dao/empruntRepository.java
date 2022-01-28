package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entites.Emprunt;

public interface empruntRepository extends JpaRepository<Emprunt, Long> {

	@Query("select emprunt from Emprunt emprunt where emprunt.usager.id like :x and emprunt.status=true")
	public List<Emprunt> L_userEmprunt(@Param("x") String id_user); 

	@Query("select emprunt from Emprunt emprunt where emprunt.usager.id like :x")
	public List<Emprunt> historiqueEmprunt(@Param("x") String id_user); 
	
	@Modifying
	@Query("delete from Emprunt emprunt where emprunt.usager.id = :x")
	public void deleteUserEmprunt(@Param("x") String id_user); 
}
