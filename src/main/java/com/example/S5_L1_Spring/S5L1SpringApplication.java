package com.example.S5_L1_Spring;

import com.example.S5_L1_Spring.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class S5L1SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S5L1SpringApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(S5L1SpringApplication.class);


		Menu menu = context.getBean(Menu.class);

	
		menu.vediMenu();




	}

}
