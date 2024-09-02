package com.example.S5_L1_Spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Topping extends Prodotto{

    public Topping(String nome, Double prezzo, Integer calorie) {
        super(nome, prezzo, calorie);
    }

    @Override
    public String toString() {
        return  nome + "                                                             " +   prezzo + "                 " +  calorie ;
    }
}
