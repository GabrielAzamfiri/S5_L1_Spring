package com.example.S5_L1_Spring;


import com.example.S5_L1_Spring.entities.Bevande;
import com.example.S5_L1_Spring.entities.Menu;
import com.example.S5_L1_Spring.entities.Pizza;
import com.example.S5_L1_Spring.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Annotazione OBBLIGATORIA se vogliamo che questa classe venga presa in considerazione all'avvio dell'applicazione
public class PizzaConfig {

    @Bean
    public Topping Cheese(){
        return new Topping("Cheese", 0.69 , 92);
    }
    @Bean
    public Topping Tomato(){
        return new Topping("Tomato", 0.69 , 92);
    }

    @Bean
    public Topping Ham(){
        return new Topping("Ham", 0.99 , 35);
    }
    @Bean
    public Topping Onions(){
        return new Topping("Onions", 0.69 , 22);
    }
    @Bean
    public Topping Pineapple(){
        return new Topping("Pineapple", 0.79 , 24);
    }
    @Bean
    public Topping Salami(){
        return new Topping("Salami", 0.99 , 86);
    }


    @Bean
    public Bevande Lemonade(){
        return new Bevande("Lemonade", 1.29,128, 0.33);
    }

    @Bean
    public Bevande Water(){
        return new Bevande("Water", 1.29,0, 0.33);
    }

    @Bean
    public Bevande Wine(){
        return new Bevande("Wine", 7.49,607, 0.75);
    }


    @Bean
    public Pizza margherita(){
       Pizza margherita = new Pizza("Pizza Margherita", 4.99,1104);
       margherita.addTopping(Tomato());
       margherita.addTopping(Cheese());

       return margherita;
    }

    @Bean
    public Pizza hawaiian(){
        Pizza hawaiian = new Pizza("Hawaiian Pizza", 6.49,1024);
        hawaiian.addTopping(Tomato());
        hawaiian.addTopping(Cheese());
        hawaiian.addTopping(Ham());
        hawaiian.addTopping(Pineapple());

        return hawaiian;
    }

    @Bean
    public Pizza salami(){
        Pizza salami = new Pizza("Salami Pizza", 5.99,1160);
        salami.addTopping(Tomato());
        salami.addTopping(Cheese());
        salami.addTopping(Salami());

        return salami;
    }

    @Bean
    public Menu menu(){
        Menu menu = new Menu();
        menu.addPizze(margherita());
        menu.addPizze(hawaiian());
        menu.addPizze(salami());

        menu.addTopping(Cheese());
        menu.addTopping(Tomato());
        menu.addTopping(Ham());
        menu.addTopping(Onions());
        menu.addTopping(Pineapple());
        menu.addTopping(Salami());

        menu.addDrink(Lemonade());
        menu.addDrink(Water());
        menu.addDrink(Wine());
       return menu;
    }
}
