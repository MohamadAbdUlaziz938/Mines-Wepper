package pkg1;

import org.omg.CORBA.INITIALIZE;
import static pkg1.GUI1.mines;
import static pkg1.GUI1.sh1;

public class Main {
    public static void main(String[] args) {
          Initialize e1=new Initialize(36,36 ,5 , 0);
        Score score=new Score();
        Player player =new Player("PlayerOne", 0, 0, 0, 0, 0, 0);
        Player player2 =new Player("PlayerTwo", 0, 0,0, 0, 0, 0);
        //PlayGame p=new PlayGame();
        //p.AcceptGame(new ConsolGame(e,1));
        //p.AcceptGame(new Towplayer(e,2));
       // p.AcceptGame(new ComputerPlayer(e,1));
        new GUI1(e1, score,player,player2);
        //p.AcceptGame(new Computergui(e));
        
        
        
        
    }
}

  
