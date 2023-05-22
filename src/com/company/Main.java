package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.initializePokemons();
        game.initializeItems();
        game.listPokemons();
        game.listItems();
        game.startGame();
    }
}
