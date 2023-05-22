package com.company;

import java.util.Random;

public class BattleTrainerVTrainer implements Battle {
    private final String trainer1;
    private final String trainer2;
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;
    private final Item item1;
    private final Item item2;

    public BattleTrainerVTrainer(String trainer1, String trainer2, Pokemon pokemon1,
                                 Pokemon pokemon2, Item item1, Item item2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public void execute() {
        Logger bl = BattleLogger.getInstance();
        bl.log("========Tip Batalie: Trainer vs Trainer========");
        bl.log(pokemon1.getName() + " (" + trainer1 + ") vs " +
                pokemon2.getName() + " (" + trainer2 + ")");

        if(item1 != null) {
            pokemon1.useItem(item1);
            bl.log(pokemon1.getName() + " foloseste " + item1);
        }
        if(item2 != null) {
            pokemon2.useItem(item2);
            bl.log(pokemon2.getName() + " foloseste " + item2);
        }

        int hp1 = pokemon1.getHp();
        int hp2 = pokemon2.getHp();

        Random r = new Random();

        bl.log(pokemon1.toString());
        bl.log(pokemon2.toString());

        int p1Ability1cd = 0;
        int p1Ability2cd = 0;
        int p2Ability1cd = 0;
        int p2Ability2cd = 0;

        boolean p1Stunned = false, p1StunnedNextRound = false, p1Dodge;
        boolean p2Stunned = false, p2StunnedNextRound = false, p2Dodge;

        while(hp1 > 0 && hp2 > 0) {
            int atkType = r.nextInt(0, 3);
            String atk1 = "", atk2 = "";
            int dmg1to2 = 0, dmg2to1 = 0;

            p1Dodge = false;
            p2Dodge = false;

            if(p1Stunned) {
                atk1 = pokemon1.getName() + " nu face nimic";
            } else switch (atkType) {
                case 0 -> {
                    if(pokemon1.getNormalAtk() != 0) {
                        dmg1to2 = pokemon1.getNormalAtk() - pokemon2.getDef();
                        atk1 = pokemon1.getName() + " atac normal";
                    } else {
                        dmg1to2 = pokemon1.getSpecialAtk() - pokemon2.getSpecialDef();
                        atk1 = pokemon1.getName() + " atac special";
                    }
                }
                case 1 -> {
                    if(p1Ability1cd == 0) {
                        dmg1to2 = pokemon1.getAbility1().getDmg();
                        p1Dodge = pokemon1.getAbility1().isDodge();
                        p2StunnedNextRound = pokemon1.getAbility1().isStun();
                        p1Ability1cd = pokemon1.getAbility1().getCd();
                        atk1 = pokemon1.getName() + " abilitate 1";
                    } else {
                        if(pokemon1.getNormalAtk() != 0) {
                            dmg1to2 = pokemon1.getNormalAtk() - pokemon2.getDef();
                            atk1 = pokemon1.getName() + " atac normal";
                        } else {
                            dmg1to2 = pokemon1.getSpecialAtk() - pokemon2.getSpecialDef();
                            atk1 = pokemon1.getName() + " atac special";
                        }
                    }
                }
                case 2 -> {
                    if(p1Ability2cd == 0) {
                        dmg1to2 = pokemon1.getAbility2().getDmg();
                        p1Dodge = pokemon1.getAbility2().isDodge();
                        p2StunnedNextRound = pokemon1.getAbility2().isStun();
                        p1Ability2cd = pokemon1.getAbility2().getCd();
                        atk1 = pokemon1.getName() + " abilitate 2";
                    } else {
                        if(pokemon1.getNormalAtk() != 0) {
                            dmg1to2 = pokemon1.getNormalAtk() - pokemon2.getDef();
                            atk1 = pokemon1.getName() + " atac normal";
                        } else {
                            dmg1to2 = pokemon1.getSpecialAtk() - pokemon2.getSpecialDef();
                            atk1 = pokemon1.getName() + " atac special";
                        }
                    }
                }
            }

            atkType = r.nextInt(0, 3);

            if(p2Stunned) {
                atk2 = pokemon2.getName() + " nu face nimic";
            } else switch (atkType) {
                case 0 -> {
                    if(pokemon2.getNormalAtk() != 0) {
                        dmg2to1 = pokemon2.getNormalAtk() - pokemon1.getDef();
                        atk2 = pokemon2.getName() + " atac normal";
                    } else {
                        dmg2to1 = pokemon2.getSpecialAtk() - pokemon1.getSpecialDef();
                        atk2 = pokemon2.getName() + " atac special";
                    }
                }
                case 1 -> {
                    if(p2Ability1cd == 0) {
                        dmg2to1 = pokemon2.getAbility1().getDmg();
                        p2Dodge = pokemon2.getAbility1().isDodge();
                        p1StunnedNextRound = pokemon2.getAbility1().isStun();
                        p2Ability1cd = pokemon2.getAbility1().getCd();
                        atk2 = pokemon2.getName() + " abilitate 1";
                    } else {
                        if(pokemon2.getNormalAtk() != 0) {
                            dmg2to1 = pokemon2.getNormalAtk() - pokemon1.getDef();
                            atk2 = pokemon2.getName() + " atac normal";
                        } else {
                            dmg2to1 = pokemon2.getSpecialAtk() - pokemon1.getSpecialDef();
                            atk2 = pokemon2.getName() + " atac special";
                        }
                    }
                }
                case 2 -> {
                    if(p2Ability2cd == 0) {
                        dmg2to1 = pokemon2.getAbility2().getDmg();
                        p2Dodge = pokemon2.getAbility2().isDodge();
                        p1StunnedNextRound = pokemon2.getAbility2().isStun();
                        p2Ability2cd = pokemon2.getAbility2().getCd();
                        atk2 = pokemon2.getName() + " abilitate 2";
                    } else {
                        if(pokemon2.getNormalAtk() != 0) {
                            dmg2to1 = pokemon2.getNormalAtk() - pokemon1.getDef();
                            atk2 = pokemon2.getName() + " atac normal";
                        } else {
                            dmg2to1 = pokemon2.getSpecialAtk() - pokemon1.getSpecialDef();
                            atk2 = pokemon2.getName() + " atac special";
                        }
                    }
                }
            }

            if(p1Dodge)
                dmg2to1 = 0;
            if(p2Dodge)
                dmg1to2 = 0;

            hp1 -= Math.max(dmg2to1, 0);
            hp2 -= Math.max(dmg1to2, 0);

            String logText = atk1 + " / " + atk2 + "\n" +
                    pokemon1.getName() + " HP: " + Math.max(hp1, 0) +
                    ((p1Dodge) ? " (dodge) " : " ") +
                    ((p1StunnedNextRound) ? " (stunned)" : " ") +
                    ((p1Ability1cd != 0) ? (", Abilitate 1 cooldown " + p1Ability1cd + " ") : " ") +
                    ((p1Ability2cd != 0) ? (", Abilitate 2 cooldown " + p1Ability2cd + " ") : " ") +
                    "\n" + pokemon2.getName()+ " HP: " + Math.max(hp2, 0) +
                    ((p2Dodge) ? " (dodge) " : " ") +
                    ((p2StunnedNextRound) ? " (stunned)" : " ") +
                    ((p2Ability1cd != 0) ? (", Abilitate 1 cooldown " + p2Ability1cd + " ") : " ") +
                    ((p2Ability2cd != 0) ? (", Abilitate 2 cooldown " + p2Ability2cd + "\n") : "\n");

            bl.log(logText);

            p2Stunned = p2StunnedNextRound;
            p2StunnedNextRound = false;
            p1Stunned = p1StunnedNextRound;
            p1StunnedNextRound = false;
            if(p1Ability1cd != 0)
                p1Ability1cd--;
            if(p1Ability2cd != 0)
                p1Ability2cd--;
            if(p2Ability1cd != 0)
                p2Ability1cd--;
            if(p2Ability2cd != 0)
                p2Ability2cd--;

        }

        if(item1 != null)
            pokemon1.removeItemBonus(item1);
        if(item2 != null)
            pokemon2.removeItemBonus(item2);

        if(hp1 > 0) {
            pokemon1.statsUp();
            bl.log(trainer1 + " (" + pokemon1.getName() + ") castiga lupta.");
            bl.log(pokemon1.getName() + " primeste +1 la toate caracteristicile:\n" + pokemon1);
        } else if(hp2 > 0) {
            pokemon2.statsUp();
            bl.log(trainer2 + " (" + pokemon2.getName() + ") castiga lupta.");
            bl.log(pokemon2.getName() + " primeste +1 la toate caracteristicile:\n" + pokemon2);
        } else {
            bl.log("Egalitate intre cei 2 antrenori");
        }

    }

}
