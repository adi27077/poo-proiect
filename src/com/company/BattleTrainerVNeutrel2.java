package com.company;

import java.util.Random;

public class BattleTrainerVNeutrel2 implements Battle {
    private final String trainer1;
    private final String trainer2;
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;
    private final Item item1;
    private final Item item2;

    public BattleTrainerVNeutrel2(String trainer1, String trainer2, Pokemon pokemon1,
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
        bl.log("========Tip Batalie: Trainer vs Neutrel2========");
        bl.log(pokemon1.getName() + " (" + trainer1 + ") vs Neutrel2");

        if(item1 != null) {
            pokemon1.useItem(item1);
            bl.log(pokemon1.getName() + " foloseste " + item1);
        }

        int hp1 = pokemon1.getHp();
        int hp2 = pokemon2.getHp();

        Pokemon neutrel2 = Game.getInstance().getNeutrel2();
        int hpNeutrel21 = neutrel2.getHp();
        int hpNeutrel22 = neutrel2.getHp();

        Random r = new Random();

        bl.log(pokemon1.toString());
        bl.log(neutrel2.toString());

        int p1Ability1cd = 0;
        int p1Ability2cd = 0;

        boolean p2Stunned = false, p2StunnedNextRound = false, p1Dodge;

        while(hp1 > 0 && hpNeutrel21 > 0) {
            int atkType = r.nextInt(0, 3);
            String atk1 = "", atk2;
            int dmg1to2 = 0, dmg2to1;

            p1Dodge = false;

            switch (atkType) {
                case 0 -> {
                    if(pokemon1.getNormalAtk() != 0) {
                        dmg1to2 = pokemon1.getNormalAtk() - neutrel2.getDef();
                        atk1 = pokemon1.getName() + " atac normal";
                    } else {
                        dmg1to2 = pokemon1.getSpecialAtk() - neutrel2.getSpecialDef();
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
                            dmg1to2 = pokemon1.getNormalAtk() - neutrel2.getDef();
                            atk1 = pokemon1.getName() + " atac normal";
                        } else {
                            dmg1to2 = pokemon1.getSpecialAtk() - neutrel2.getSpecialDef();
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
                            dmg1to2 = pokemon1.getNormalAtk() - neutrel2.getDef();
                            atk1 = pokemon1.getName() + " atac normal";
                        } else {
                            dmg1to2 = pokemon1.getSpecialAtk() - neutrel2.getSpecialDef();
                            atk1 = pokemon1.getName() + " atac special";
                        }
                    }
                }
            }

            if(!p2Stunned) {
                dmg2to1 = neutrel2.getNormalAtk() - pokemon1.getDef();
                atk2 = "Neutrel2 atac normal";
            } else {
                dmg2to1 = 0;
                atk2 = "Neutrel2 nu face nimic";
            }
            if(p1Dodge)
                dmg2to1 = 0;

            hp1 -= Math.max(dmg2to1, 0);
            hpNeutrel21 -= Math.max(dmg1to2, 0);

            String logText = atk1 + " / " + atk2 + "\n" + pokemon1.getName() + " HP: " + hp1 +
                    ((p1Dodge) ? " (dodge) " : " ") +
                    ((p1Ability1cd != 0) ? (", Abilitate 1 cooldown " + p1Ability1cd + " ") : " ") +
                    ((p1Ability2cd != 0) ? (", Abilitate 2 cooldown " + p1Ability2cd + " ") : " ") +
                    "\nNeutrel2 HP: " + Math.max(hpNeutrel21, 0) +
                    ((p2StunnedNextRound) ? " (stunned)\n" : "\n");

            bl.log(logText);

            p2Stunned = p2StunnedNextRound;
            p2StunnedNextRound = false;
            if(p1Ability1cd != 0)
                p1Ability1cd--;
            if(p1Ability2cd != 0)
                p1Ability2cd--;

        }
        if(item1 != null)
            pokemon1.removeItemBonus(item1);
        if(hp1 > 0) {
            pokemon1.statsUp();
            bl.log(trainer1 + " (" + pokemon1.getName() + ") castiga lupta.");
            bl.log(pokemon1.getName() + " primeste +1 la toate caracteristicile:\n" + pokemon1);
        } else {
            bl.log(trainer1 + " (" + pokemon1.getName() + ") pierde lupta contra Neutrel2");
        }

        bl.log(pokemon2.getName() + " (" + trainer2 + ") vs Neutrel2");
        if(item2 != null) {
            pokemon2.useItem(item2);
            bl.log(pokemon2.getName() + " foloseste " + item2);
        }
        bl.log(pokemon2.toString());
        bl.log(neutrel2.toString());

        p2Stunned = false;

        p1Ability1cd = 0;
        p1Ability2cd = 0;

        while(hp2 > 0 && hpNeutrel22 > 0) {
            int atkType = r.nextInt(0, 3);
            String atk1 = "", atk2;
            int dmg1to2 = 0, dmg2to1;

            p1Dodge = false;

            switch (atkType) {
                case 0 -> {
                    if(pokemon2.getNormalAtk() != 0) {
                        dmg1to2 = pokemon2.getNormalAtk() - neutrel2.getDef();
                        atk1 = pokemon2.getName() + " atac normal";
                    } else {
                        dmg1to2 = pokemon2.getSpecialAtk() - neutrel2.getSpecialDef();
                        atk1 = pokemon2.getName() + " atac special";
                    }
                }
                case 1 -> {
                    if(p1Ability1cd == 0) {
                        dmg1to2 = pokemon2.getAbility1().getDmg();
                        p1Dodge = pokemon2.getAbility1().isDodge();
                        p2StunnedNextRound = pokemon2.getAbility1().isStun();
                        p1Ability1cd = pokemon2.getAbility1().getCd();
                        atk1 = pokemon2.getName() + " abilitate 1";
                    } else {
                        if(pokemon2.getNormalAtk() != 0) {
                            dmg1to2 = pokemon2.getNormalAtk() - neutrel2.getDef();
                            atk1 = pokemon2.getName() + " atac normal";
                        } else {
                            dmg1to2 = pokemon2.getSpecialAtk() - neutrel2.getSpecialDef();
                            atk1 = pokemon2.getName() + " atac special";
                        }
                    }
                }
                case 2 -> {
                    if(p1Ability2cd == 0) {
                        dmg1to2 = pokemon2.getAbility2().getDmg();
                        p1Dodge = pokemon2.getAbility2().isDodge();
                        p2StunnedNextRound = pokemon2.getAbility2().isStun();
                        p1Ability2cd = pokemon2.getAbility2().getCd();
                        atk1 = pokemon2.getName() + " abilitate 2";
                    } else {
                        if(pokemon2.getNormalAtk() != 0) {
                            dmg1to2 = pokemon2.getNormalAtk() - neutrel2.getDef();
                            atk1 = pokemon2.getName() + " atac normal";
                        } else {
                            dmg1to2 = pokemon2.getSpecialAtk() - neutrel2.getSpecialDef();
                            atk1 = pokemon2.getName() + " atac special";
                        }
                    }
                }
            }

            if(!p2Stunned) {
                dmg2to1 = neutrel2.getNormalAtk() - pokemon2.getDef();
                atk2 = "Neutrel2 atac normal";
            } else {
                dmg2to1 = 0;
                atk2 = "Neutrel2 nu face nimic";
            }
            if(p1Dodge)
                dmg2to1 = 0;

            hp2 -= Math.max(dmg2to1, 0);
            hpNeutrel22 -= Math.max(dmg1to2, 0);

            String logText = atk1 + " / " + atk2 + "\n" + pokemon2.getName() + " HP: " + hp2 +
                    ((p1Dodge) ? " (dodge) " : " ") +
                    ((p1Ability1cd != 0) ? (", Abilitate 1 cooldown " + p1Ability1cd + " ") : " ") +
                    ((p1Ability2cd != 0) ? (", Abilitate 2 cooldown " + p1Ability2cd + " ") : " ") +
                    "\nNeutrel2 HP: " + Math.max(hpNeutrel22, 0) +
                    ((p2StunnedNextRound) ? " (stunned)\n" : "\n");

            bl.log(logText);

            p2Stunned = p2StunnedNextRound;
            p2StunnedNextRound = false;
            if(p1Ability1cd != 0)
                p1Ability1cd--;
            if(p1Ability2cd != 0)
                p1Ability2cd--;
        }
        if(item2 != null)
            pokemon2.removeItemBonus(item2);
        if(hp2 > 0) {
            pokemon2.statsUp();
            bl.log(trainer2 + " (" + pokemon2.getName() + ") castiga lupta.");
            bl.log(pokemon2.getName() + " primeste +1 la toate caracteristicile:\n" + pokemon2);
        } else {
            bl.log(trainer2 + " (" + pokemon2.getName() + ") pierde lupta contra Neutrel2");
        }
    }
}
