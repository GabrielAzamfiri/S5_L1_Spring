package com.example.S5_L1_Spring.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Bevande extends Prodotto{
    private Double litri;

    public Bevande(String nome, Double prezzo, Integer calorie, Double litri) {
        super(nome, prezzo, calorie);
        this.litri = litri;
    }

    @Override
    public String toString() {
        return
              nome + "                       (" + litri + ")                "  + prezzo + "                     " + calorie ;
    }
}
