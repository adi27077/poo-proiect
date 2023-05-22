package com.company;

public class AbilityBuilder {
    private final Ability ability = new Ability();

    public Ability build() {
        return ability;
    }

    public AbilityBuilder withDmg(int dmg) {
        ability.setDmg(dmg);
        return this;
    }

    public AbilityBuilder withStun(boolean stun) {
        ability.setStun(stun);
        return this;
    }

    public AbilityBuilder withDodge(boolean dodge) {
        ability.setDodge(dodge);
        return this;
    }

    public AbilityBuilder withCd(int cd) {
        ability.setCd(cd);
        return this;
    }
}
