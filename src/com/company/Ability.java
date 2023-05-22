package com.company;

public class Ability {
    private int dmg;
    private boolean stun;
    private boolean dodge;
    private int cd;

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public boolean isDodge() {
        return dodge;
    }

    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("DMG: ").append(dmg);
        sb.append(", Stun: ").append(stun ? "YES" : "NO");
        sb.append(", Dodge: ").append(dodge ? "YES" : "NO");
        sb.append(", CD: ").append(cd);
        sb.append('}');
        return sb.toString();
    }
}

