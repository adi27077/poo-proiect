package com.company;

public class ItemBuilder {
    private final Item item = new Item();

    public Item build() {
        return item;
    }

    public ItemBuilder withName(String name) {
        item.setName(name);
        return this;
    }

    public ItemBuilder withHp(int hp) {
        item.setHp(hp);
        return this;
    }

    public ItemBuilder withAtk(int atk) {
        item.setAtk(atk);
        return this;
    }

    public ItemBuilder withSpecialAtk(int specialAtk) {
        item.setSpecialAtk(specialAtk);
        return this;
    }

    public ItemBuilder withDef(int def) {
        item.setDef(def);
        return this;
    }

    public ItemBuilder withSpecialDef(int specialDef) {
        item.setSpecialDef(specialDef);
        return this;
    }

}
