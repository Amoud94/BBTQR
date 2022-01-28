package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.dao.userRepository;
import com.entites.Usager;

@SpringBootApplication
public class BbtqrDemo3Application {

	public static void main(String[] args) {
	
	ApplicationContext ctx = SpringApplication.run(BbtqrDemo3Application.class, args);
	
	userRepository  UR = ctx.getBean(userRepository.class);

	UR.save(new Usager("I710210","root","Admin","beni mellal","060000009","root@mail.com"));
	}
}

