package com.company;

import java.util.Arrays;

public class Trainer {
    private String name;
    private int age;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Item[] items1 = new Item[3];
    private Item[] items2 = new Item[3];
    private Item[] items3 = new Item[3];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    public Item[] getItems1() {
        return items1;
    }

    public void setItems1(Item[] items1) {
        this.items1 = items1;
    }

    public Item[] getItems2() {
        return items2;
    }

    public void setItems2(Item[] items2) {
        this.items2 = items2;
    }

    public Item[] getItems3() {
        return items3;
    }

    public void setItems3(Item[] items3) {
        this.items3 = items3;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TRAINER: {\n");
        sb.append("Name: ").append(name).append('\n');
        sb.append("Age: ").append(age).append("\nPokemons:\n");
        sb.append("\t").append(pokemon1);
        sb.append("\n\tItems: ").append(items1 == null ? "None" : Arrays.asList(items1).toString());
        sb.append("\n\t").append(pokemon2);
        sb.append("\n\tItems: ").append(items2 == null ? "None" : Arrays.asList(items2).toString());
        sb.append("\n\t").append(pokemon3);
        sb.append("\n\tItems: ").append(items3 == null ? "None" : Arrays.asList(items3).toString());
        sb.append("\n}");
        return sb.toString();
    }
}
