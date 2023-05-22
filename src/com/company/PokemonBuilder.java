package com.company;

public class PokemonBuilder {
    private final Pokemon pokemon = new Pokemon();

    public Pokemon build() {
        return pokemon;
    }

    public PokemonBuilder withName(String name) {
        pokemon.setName(name);
        return this;
    }

    public PokemonBuilder withHp(int hp) {
        pokemon.setHp(hp);
        return this;
    }

    public PokemonBuilder withNormalAtk(int normalAtk) {
        pokemon.setNormalAtk(normalAtk);
        return this;
    }

    public PokemonBuilder withSpecialAtk(int specialAtk) {
        pokemon.setSpecialAtk(specialAtk);
        return this;
    }

    public PokemonBuilder withDef(int def) {
        pokemon.setDef(def);
        return this;
    }

    public PokemonBuilder withSpecialDef(int specialDef) {
        pokemon.setSpecialDef(specialDef);
        return this;
    }

    public PokemonBuilder withAbility1(Ability ability1) {
        pokemon.setAbility1(ability1);
        return this;
    }

    public PokemonBuilder withAbility2(Ability ability2) {
        pokemon.setAbility2(ability2);
        return this;
    }
}
