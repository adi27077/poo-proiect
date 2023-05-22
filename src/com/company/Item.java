package com.company;

public class Item {
    private String name;
    private int hp;
    private int atk;
    private int specialAtk;
    private int def;
    private int specialDef;

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

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ITEM: {");
        sb.append("Name='").append(name).append('\'');
        if(hp != 0)
            sb.append(", HP +").append(hp);
        if(atk != 0)
            sb.append(", Attack +").append(atk);
        if(specialAtk != 0)
            sb.append(", Special Attack +").append(specialAtk);
        if(def != 0)
            sb.append(", Def +").append(def);
        if(specialDef != 0)
            sb.append(", Special Def +").append(specialDef);
        sb.append('}');
        return sb.toString();
    }
}
