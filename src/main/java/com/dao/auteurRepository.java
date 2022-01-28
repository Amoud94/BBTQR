package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entites.Auteur;

public interface auteurRepository extends JpaRepository<Auteur, Long> {

}
