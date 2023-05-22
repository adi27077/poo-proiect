package com.company;

public class ItemFactory {
    private static ItemFactory instance;

    private ItemFactory() {
    }

    public static ItemFactory getInstance() {
        if(instance == null)
            instance = new ItemFactory();
        return instance;
    }

    public enum ItemType {
        Scut, Vesta, Sabiuta, Bagheta, Vitamine, Brad, Pelerina
    }

    public Item createItem(ItemType t) {
        return switch(t) {
            case Scut -> new ItemBuilder().withName("Scut").withDef(2).withSpecialDef(2).build();
            case Vesta -> new ItemBuilder().withName("Vestă").withHp(10).build();
            case Sabiuta -> new ItemBuilder().withName("Săbiuță").withAtk(3).build();
            case Bagheta -> new ItemBuilder().withName("Baghetă Magică").withSpecialAtk(3).build();
            case Vitamine -> new ItemBuilder().withName("Vitamine").withHp(2).withAtk(2).withSpecialAtk(2).build();
            case Brad -> new ItemBuilder().withName("Brad de Crăciun").withAtk(3).withDef(1).build();
            case Pelerina -> new ItemBuilder().withName("Pelerină").withSpecialDef(3).build();
        };
    }
}
