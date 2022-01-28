package com.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MAGAZINE")
public class Magazine extends Oeuvre {
	
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(String titre) {
		super(titre);
	}
	
}
