package com.example.S5_L1_Spring;

import com.example.S5_L1_Spring.entities.Ordine;
import com.example.S5_L1_Spring.entities.Pizza;
import com.example.S5_L1_Spring.entities.Topping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class S5L1SpringApplicationTests {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);


	@Test
	void testSum(){
		System.out.println("TEST 1");
		int result =2+2;
		assertEquals(4, result);
	}

	@ParameterizedTest
	@CsvSource({"margherita, Pizza Margherita, 4.99, 1104", "hawaiian, Hawaiian Pizza, 6.49, 1024", "salami, Salami Pizza, 5.99, 1160"})
	public void testParametriPizze(String Pizza, String expectedNome, Double expectedPrezzo, Integer expectedCalorie) {

		Pizza pizza = context.getBean(Pizza, Pizza.class);

		assertEquals(expectedNome, pizza.getNome());
		assertEquals(expectedPrezzo, pizza.getPrezzo());
		assertEquals(expectedCalorie, pizza.getCalorie());

		Topping Tomato = context.getBean("Tomato", Topping.class);
		Topping Cheese = context.getBean("Cheese", Topping.class);
		switch (Pizza){
			case "margherita":
				assertTrue(pizza.getToppings().contains(Tomato));
				assertTrue(pizza.getToppings().contains(Cheese));
				break;

			case "hawaiian":
				Topping Ham = context.getBean("Ham", Topping.class);
				Topping Pineapple = context.getBean("Pineapple", Topping.class);

				assertTrue(pizza.getToppings().contains(Tomato));
				assertTrue(pizza.getToppings().contains(Cheese));
				assertTrue(pizza.getToppings().contains(Ham));
				assertTrue(pizza.getToppings().contains(Pineapple));
				break;

			case "salami":
				Topping Salami = context.getBean("Salami", Topping.class);

				assertTrue(pizza.getToppings().contains(Tomato));
				assertTrue(pizza.getToppings().contains(Cheese));
				assertTrue(pizza.getToppings().contains(Salami));
				break;

		}

	}



	@Test
	public void testMargherita() {

		Pizza margherita = context.getBean("margherita", Pizza.class);
		Topping Tomato = context.getBean("Tomato", Topping.class);
		Topping Cheese = context.getBean("Cheese", Topping.class);

		assertEquals("Pizza Margherita", margherita.getNome());
		assertEquals(4.99, margherita.getPrezzo());
		assertEquals(1104, margherita.getCalorie());

		assertTrue(margherita.getToppings().contains(Tomato));
		assertTrue(margherita.getToppings().contains(Cheese));

	}
	@Test
	public void testHawaiian() {

		Pizza hawaiian = context.getBean("hawaiian", Pizza.class);
		Topping Tomato = context.getBean("Tomato", Topping.class);
		Topping Cheese = context.getBean("Cheese", Topping.class);
		Topping Ham = context.getBean("Ham", Topping.class);
		Topping Pineapple = context.getBean("Pineapple", Topping.class);

		assertEquals("Hawaiian Pizza", hawaiian.getNome());
		assertEquals(6.49, hawaiian.getPrezzo());
		assertEquals(1024, hawaiian.getCalorie());

		assertTrue(hawaiian.getToppings().contains(Tomato));
		assertTrue(hawaiian.getToppings().contains(Cheese));
		assertTrue(hawaiian.getToppings().contains(Ham));
		assertTrue(hawaiian.getToppings().contains(Pineapple));

	}
	@Test
	public void testSalami() {

		Pizza salami = context.getBean("salami", Pizza.class);
		Topping Tomato = context.getBean("Tomato", Topping.class);
		Topping Cheese = context.getBean("Cheese", Topping.class);
		Topping Salami = context.getBean("Salami", Topping.class);

		assertEquals("Salami Pizza", salami.getNome());
		assertEquals(5.99, salami.getPrezzo());
		assertEquals(1160, salami.getCalorie());

		assertTrue(salami.getToppings().contains(Tomato));
		assertTrue(salami.getToppings().contains(Cheese));
		assertTrue(salami.getToppings().contains(Salami));

	}

	@Test
	public void testCostoCoperto() {

		Double costoCoperto = context.getBean("costoCoperto", Double.class);

		assertEquals(2, costoCoperto);

	}


	@ParameterizedTest
	@CsvSource({"1, 16.28, 5", "2, 26.270000000000003, 7"})
	public void testOrdine(Integer nrOrdine, Double expectedTotale, Integer expectedCoperti) {

		Ordine ordine = context.getBean("ordine"+nrOrdine, Ordine.class);

		assertEquals(expectedTotale, ordine.getTotale());
		assertEquals(expectedCoperti, ordine.getNrCoperti());

	}

}
