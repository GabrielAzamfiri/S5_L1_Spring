package com.example.S5_L1_Spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Pizza extends Prodotto{

    private List<Topping> toppings;

    public Pizza(String nome, Double prezzo, Integer calorie) {
        super(nome, prezzo, calorie);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }



    @Override
    public String toString() {
        String toppingList = toppings.isEmpty() ? "" : " (" + toppings.stream().map(topping -> topping.nome).collect(Collectors.joining(", ")) + ")";
        return
                nome + toppingList +"                              "+ calorie  +"                " + prezzo;
    }
}
