package pkg1;

import java.io.*;

public class StoreFile implements Serializable{
    public Initialize e;
    public Player player,player2;
    public Score score,score2;
    

    public void setE(Initialize e) {
        this.e = e;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    public StoreFile(Initialize e1,Player player1)
    {e=e1;
    player=player1;
//    player2=playerr2;
   
    }
    public StoreFile()
    {
    e=null;
    player=null;
    
    }
    public StoreFile(int a,int i,int j)
    {//c=a;
    }
    public StoreFile(Initialize e1,Player player1,Score score1)
    {e=e1;
    player=player1;
    score=score1;
    }
       public StoreFile(Initialize e1,Player player1,Player playerr2)
    {e=e1;
    player=player1;
    player2=playerr2;
   
    } 
        public StoreFile(Initialize e1)
    {e=e1;
  
   
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Score getScore2() {
        return score2;
    }

    public void setScore2(Score score2) {
        this.score2 = score2;
    }

    public Score getScore() {
        return score;
    }



    public Initialize getE() {
        return e;
    }

    public Player getPlayer() {
        return player;
    }
}
