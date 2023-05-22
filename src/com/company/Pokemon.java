package com.company;

import java.util.Objects;

public class Pokemon {
    private String name;
    private int hp;
    private int normalAtk;
    private int specialAtk;
    private int def;
    private int specialDef;
    private Ability ability1;
    private Ability ability2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getNormalAtk() {
        return normalAtk;
    }

    public void setNormalAtk(int normalAtk) {
        this.normalAtk = normalAtk;
    }

    public int getSpecialAtk() {
        return specialAtk;
    }

    public void setSpecialAtk(int specialAtk) {
        this.specialAtk = specialAtk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpecialDef() {
        return specialDef;
    }

    public void setSpecialDef(int specialDef) {
        this.specialDef = specialDef;
    }

    public Ability getAbility1() {
        return ability1;
    }

    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("POKEMON: {\n");
        sb.append("\tName: ").append(name).append('\n');
        sb.append("\tHP: ").append(hp).append('\n');
        sb.append("\tNormal Attack: ").append((normalAtk != 0) ? normalAtk : "N/A").append('\n');
        sb.append("\tSpecial Attack: ").append((specialAtk != 0) ? specialAtk : "N/A").append('\n');
        sb.append("\tDef: ").append(def).append('\n');
        sb.append("\tSpecial Def: ").append(specialDef).append('\n');
        sb.append("\tAbility 1: ").append(Objects.requireNonNullElse(ability1, "N/A")).append('\n');
        sb.append("\tAbility 2: ").append(Objects.requireNonNullElse(ability2, "N/A")).append('\n');
        sb.append("\t}");
        return sb.toString();
    }

    public Pokemon getClone() {
        return new PokemonBuilder().withName(name)
                .withHp(hp).withNormalAtk(normalAtk)
                .withSpecialAtk(specialAtk).withDef(def)
                .withSpecialDef(specialDef).withAbility1(ability1)
                .withAbility2(ability2)
                .build();
    }

    public void useItem(Item item) {
        hp += item.getHp();
        if(normalAtk != 0)
            normalAtk += item.getAtk();
        if(specialAtk != 0)
            specialAtk += item.getSpecialAtk();
        def += item.getDef();
        specialDef += item.getSpecialDef();
    }

    public void removeItemBonus(Item item) {
        hp -= item.getHp();
        if(normalAtk != 0)
            normalAtk -= item.getAtk();
        if(specialAtk != 0)
            specialAtk -= item.getSpecialAtk();
        def -= item.getDef();
        specialDef -= item.getSpecialDef();
    }

    public void statsUp() {
        hp++;
        if(normalAtk != 0)
            normalAtk++;
        if(specialAtk != 0)
            specialAtk++;
        def++;
        specialDef++;
    }

    public int power() {
        return hp + normalAtk + specialAtk + def + specialDef;
    }
}
