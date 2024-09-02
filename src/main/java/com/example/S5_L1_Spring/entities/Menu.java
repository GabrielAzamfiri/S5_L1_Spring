package com.example.S5_L1_Spring.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Menu {
  private List<Prodotto> prodottiMenu;

    public Menu() {
        this.prodottiMenu = new ArrayList<>();
    }

    public void addProdotto ( Prodotto prodotto){
        this.prodottiMenu.add(prodotto);
    }
    public void vediMenu(){
        prodottiMenu.forEach(System.out::println);
    }
}
