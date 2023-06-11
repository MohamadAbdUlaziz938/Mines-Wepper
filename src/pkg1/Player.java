
package pkg1;

import java.io.Serializable;

public class Player implements Serializable{
    String name;
    int armorCount;
    int clickCount;
    int minesClickedCount;
    int score;
    int scor;
    int flagScore;
    
  

    public Player(String name, int armorCount, int clickCount, int minesClickedCount,int score,int scor,int flagScore) {
        this.name = name;
        this.armorCount = armorCount;
        this.clickCount = clickCount;
        this.minesClickedCount = minesClickedCount;
        this.score=score;
        this.flagScore=flagScore;
        this.scor=scor;
                }
    public Player()
    {
        this.name = "PlayerOne";
        this.armorCount = 0;
        this.clickCount = 0;
        this.minesClickedCount = 0;
        this.score=0;
        this.flagScore=0;
        this.scor=0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArmorCount(int armorCount) {
        this.armorCount = armorCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public void setMinesClickedCount(int minesClickedCount) {
        this.minesClickedCount = minesClickedCount;
    }

    public String getName() {
        return name;
    }

    public int getArmorCount() {
        return armorCount;
    }

    public int getClickCount() {
        return clickCount;
    }

    public int getMinesClickedCount() {
        return minesClickedCount;
    }
    
    public int getScore() {
        return minesClickedCount;
    }

    public int getScor() {
        return scor;
    }

    public void setScor(int scor) {
        this.scor = scor;
    }

    public void setFlagScore(int flagScore) {
        this.flagScore = flagScore;
    }

    public int getFlagScore() {
        return flagScore;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    
}
