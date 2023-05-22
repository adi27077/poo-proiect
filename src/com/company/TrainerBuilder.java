package com.company;

public class TrainerBuilder {
    private final Trainer trainer = new Trainer();

    public Trainer build() {
        return trainer;
    }

    public TrainerBuilder withName(String name) {
        trainer.setName(name);
        return this;
    }

    public TrainerBuilder withAge(int age) {
        trainer.setAge(age);
        return this;
    }

    public TrainerBuilder withPokemon1(Pokemon pokemon) {
        trainer.setPokemon1(pokemon);
        return this;
    }

    public TrainerBuilder withPokemon2(Pokemon pokemon) {
        trainer.setPokemon2(pokemon);
        return this;
    }

    public TrainerBuilder withPokemon3(Pokemon pokemon) {
        trainer.setPokemon3(pokemon);
        return this;
    }

    public TrainerBuilder withItems1(Item[] items) {
        trainer.setItems1(items);
        return this;
    }

    public TrainerBuilder withItems2(Item[] items) {
        trainer.setItems2(items);
        return this;
    }

    public TrainerBuilder withItems3(Item[] items) {
        trainer.setItems3(items);
        return this;
    }
}
