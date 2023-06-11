
package pkg1;

import java.io.Serializable;


public class element implements Serializable{
    
  private  int status;
    private boolean clicked;
    private boolean flag;
    private boolean armor;
    private boolean scan;
    public int color;
    private int turn;

    
    public element()
    {
        this.status=0;
        this.clicked=false;
        this.flag=false;
        this.armor=false;
        this.color=0;
           this.turn=2;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Integer getStatus() {
        return this.status;
    }

    public boolean isClicked() {
        return this.clicked;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isScan() {
        return scan;
    }

    public void setScan(boolean scan) {
        this.scan = scan;
    }

    public boolean isArmor() {
        return armor;
    }

    public void setArmor(boolean armor) {
        this.armor = armor;
    }

    
    

}
