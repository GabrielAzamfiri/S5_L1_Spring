package com.example.S5_L1_Spring.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Prodotto {

    protected String nome;

    protected Double prezzo;

    protected Integer calorie;

    public Prodotto(String nome, Double prezzo, Integer calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}
