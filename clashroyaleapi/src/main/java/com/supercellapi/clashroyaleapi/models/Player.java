package com.supercellapi.clashroyaleapi.models;

/**
 * author LucasDonizeti
 */
public class Player {
    private String tag;
    private String name;
    private int expLevel;
    private int trophies;
    private int bestTrophies;
    private int wins;
    private int losses;
    private int battleCount;
    private Clan clan;

    @Override
    public String toString() {
        return "Player{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", expLevel=" + expLevel +
                ", trophies=" + trophies +
                ", bestTrophies=" + bestTrophies +
                ", wins=" + wins +
                ", losses=" + losses +
                ", battleCount=" + battleCount +
                ", clan=" + clan +
                '}';
    }


    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpLevel() {
        return expLevel;
    }

    public void setExpLevel(int expLevel) {
        this.expLevel = expLevel;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getBestTrophies() {
        return bestTrophies;
    }

    public void setBestTrophies(int bestTrophies) {
        this.bestTrophies = bestTrophies;
    }

    public int getWin() {
        return wins;
    }

    public void setWin(int win) {
        this.wins = win;
    }

    public int getLoses() {
        return losses;
    }

    public void setLoses(int loses) {
        this.losses = loses;
    }

    public int getBattleCount() {
        return battleCount;
    }

    public void setBattleCount(int battleCount) {
        this.battleCount = battleCount;
    }
}
