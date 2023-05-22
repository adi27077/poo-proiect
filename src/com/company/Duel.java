package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Duel {
    private final String trainer1;
    private final String trainer2;
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;
    private final Item[] items1;
    private final Item[] items2;
    private final String duelType;
    private final ArrayList<Battle> battles = new ArrayList<>();

    public Duel(String trainer1, String trainer2, Pokemon pokemon1,
                Pokemon pokemon2, Item[] items1, Item[] items2, String duelType) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.items1 = items1;
        this.items2 = items2;
        this.duelType = duelType;
    }

    public void start() {
        Random r = new Random();
        int[] battleTypes = r.ints(3, 0, 3).toArray();
        battleTypes[battleTypes.length - 1] = 0;

        int itemIndex1, itemIndex2;
        boolean finalBattle = false;

        if(items1 != null)
            itemIndex1 = items1.length - 1;
        else
            itemIndex1 = -1;
        if(items2 != null)
            itemIndex2 = items2.length - 1;
        else
            itemIndex2 = -1;

        for(int battleType : battleTypes) {
            if(finalBattle)
                break;
            switch (battleType) {
                case 0 -> {
                    battles.add(new BattleTrainerVTrainer(trainer1, trainer2, pokemon1, pokemon2,
                            (itemIndex1 > -1) ? items1[itemIndex1--] : null,
                            (itemIndex2 > -1) ? items2[itemIndex2--] : null));
                    finalBattle = true;
                }
                case 1 -> battles.add(new BattleTrainerVNeutrel1(trainer1, trainer2, pokemon1, pokemon2,
                        (itemIndex1 > -1) ? items1[itemIndex1--] : null,
                        (itemIndex2 > -1) ? items2[itemIndex2--] : null));
                case 2 -> battles.add(new BattleTrainerVNeutrel2(trainer1, trainer2, pokemon1, pokemon2,
                        (itemIndex1 > -1) ? items1[itemIndex1--] : null,
                        (itemIndex2 > -1) ? items2[itemIndex2--] : null));
            }
        }

        battles.forEach(Battle::execute);
    }

    public void printDuelInfo() {
        Logger bl = BattleLogger.getInstance();
        bl.log("==========" + duelType + "==========");
    }


}
