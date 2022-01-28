package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entites.Reservation;


public interface reservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query("select reservation from Reservation reservation where reservation.usager.id  = :x and reservation.status = true")
	public List<Reservation> L_userReservation(@Param("x") String id_user); 
	
	@Query("select reservation from Reservation reservation where reservation.usager.id  = :x")
	public List<Reservation> historiqueReservation(@Param("x") String id_user); 
	
	@Query("select reservation from Reservation reservation where reservation.usager.id  = :x and reservation.oeuvre.id = :a and reservation.status = true")
	public Reservation checkReservation(@Param("x") String id_user,@Param("a") long id_oeuvre); 
	
	@Modifying
	@Query("Delete from Reservation reservation where reservation.usager.id like :x")
	public void deleteUserReservation(@Param("x") String id_user); 
}
