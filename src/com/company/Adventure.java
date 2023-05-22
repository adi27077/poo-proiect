package com.company;

import java.util.ArrayList;

public class Adventure {
    private final Trainer trainer1;
    private final Trainer trainer2;

    public Adventure(Trainer trainer1, Trainer trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
    }

    public void printAdventureInfo() {
        Logger bl = BattleLogger.getInstance();
        bl.log("========================Aventura========================");
        bl.log(trainer1.toString());
        bl.log(trainer2.toString());
    }

    public void start() {
        Duel duel1 = new Duel(trainer1.getName(), trainer2.getName(),
                trainer1.getPokemon1(), trainer2.getPokemon1(),
                trainer1.getItems1(), trainer2.getItems1(), "Duel 1: Pokemon1 vs Pokemon1");
        duel1.printDuelInfo();
        duel1.start();

        Duel duel2 = new Duel(trainer1.getName(), trainer2.getName(),
                trainer1.getPokemon2(), trainer2.getPokemon2(),
                trainer1.getItems2(), trainer2.getItems2(), "Duel 2: Pokemon2 vs Pokemon2");
        duel2.printDuelInfo();
        duel2.start();

        Duel duel3 = new Duel(trainer1.getName(), trainer2.getName(),
                trainer1.getPokemon3(), trainer2.getPokemon3(),
                trainer1.getItems3(), trainer2.getItems3(), "Duel 3: Pokemon3 vs Pokemon3");
        duel3.printDuelInfo();
        duel3.start();

        Pokemon mostPowerfulPokemon1 = getMostPowerfulPokemon(trainer1);
        Pokemon mostPowerfulPokemon2 = getMostPowerfulPokemon(trainer2);
        Item[] mostPowerfulItems1 = getItemsOfPokemon(trainer1, mostPowerfulPokemon1);
        Item[] mostPowerfulItems2 = getItemsOfPokemon(trainer2, mostPowerfulPokemon2);

        Duel duel4 = new Duel(trainer1.getName(), trainer2.getName(),
                mostPowerfulPokemon1, mostPowerfulPokemon2,
                mostPowerfulItems1, mostPowerfulItems2, "Duel 4: Cel mai bun vs cel mai bun");
        duel4.printDuelInfo();
        duel4.start();
    }

    private Pokemon getMostPowerfulPokemon(Trainer trainer) {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(trainer.getPokemon1());
        pokemonList.add(trainer.getPokemon2());
        pokemonList.add(trainer.getPokemon3());
        pokemonList.sort((p1, p2) -> {
            if(p1.power() == p2.power())
                return p1.getName().compareTo(p2.getName());
            return p2.power() - p1.power();
        });
        return pokemonList.get(0);
    }

    private Item[] getItemsOfPokemon(Trainer trainer, Pokemon pokemon) {
        if(pokemon.equals(trainer.getPokemon1()))
            return trainer.getItems1();
        else if(pokemon.equals(trainer.getPokemon2()))
            return trainer.getItems2();
        else
            return trainer.getItems3();
    }
}
