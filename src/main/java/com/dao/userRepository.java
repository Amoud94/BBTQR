package com.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entites.Usager;

public interface userRepository extends JpaRepository<Usager, String> {
	@Query("select user from Usager user where user.id like :x")
	public Page<Usager> chercher(@Param("x") String motCle,Pageable pageable); 
	
//	@Query("update Usager set nom =: a, prenom =: b, adresse =: c, telephone =: d, mail =: e where  id like :x") 
//	public void maj(@Param("a") String nom , @Param("b") String prenom,@Param("c") String adresse , @Param("d") String telephone,@Param("e") String mail , @Param("x") String id);
}
