package pkg1;

import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends ConsolGame {

    public int Turn;
    int score1;
    int score2;
    int flagScore1;
    int flagScore2;
    public ComputerPlayer(Initialize e,int a) {
        super();
        Score s=new Score();
        Click h = new Click();
        this.Turn = 1;
        
        if(a==1)
        {
        if (!firstin(e, h)) 
            convert(e, h);    
        }
        if(a==2)
        {
            if (!firstin2(e, h,s))
            convert2(e, h,s);
        }
        
    }

    @Override
    public boolean firstin(Initialize e, Click h) {
        e.printvoid();
        System.out.println("\n_____________________________");

        Scanner scn = new Scanner(System.in);
        String s;
        char ch, x;
        int i, j;

        do {
            System.out.println("\nenter your choice again that consists "
                    + "of two parts or three : flag,num,char\nOr num,char\n");
            System.out.println("the player one  :");
            s = scn.next();
            x = s.charAt(0);
            ch = s.toUpperCase().charAt(1);

            i = convertToNum(x);
            j = convetToStr(ch);
        } while (!e.valid(i, j));

        e.getelement(i, j).setClicked(true);
        e.getelement(i, j).setScan(true);
        e.CreatMines();
        e.puzzle();
        if (e.getelement(i, j).getStatus() == 0) 
            h.check(e, i, j,player);
        
        e.printafter();

        if (isLosss(e)) {
            System.out.println("\nloss ");
            return true;
        } else if (isWin(e)) {
            System.out.println("\nWin ");
            return true;
        }
        this.Turn += 1;
        return false;

    }

    @Override
    public void convert(Initialize e, Click h) {
        Random rand = new Random();

        Scanner scn = new Scanner(System.in);
        int j = 0, i = 0;
        String s;
        char ch, c;
        System.out.println("\nenter your choice again that consists "
                + "of two parts or three : flag,num,char\nOr num,char\n");

        int x = 1, z = 1;
        char f;
        do {
            if (this.Turn % 2 == 0) {
                System.out.print("computer player     :");
                i = rand.nextInt(e.getX());
                j = rand.nextInt(e.getY());
                if (!(e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag())) {
                    h.testing(e, i, j,player);
                    this.Turn += 1;
                }
            } else if (Turn % 2 != 0) {
                System.out.print("player one     :");
                s = scn.next();
                x = 1;
                z = 1;
                while (x == 1) {
                    if (s.length() == 2) {//s=scan2;
                        c = s.charAt(0);
                        ch = s.toUpperCase().charAt(1);
                        i = convertToNum(c);
                        j = convetToStr(ch);
                        if (i >= 0 && j >= 0) {
                            x = 2;
                        } else {
                            s = check1(s);
                        }
                    } else if (s.length() == 3) {
                        c = s.charAt(1);
                        ch = s.toUpperCase().charAt(2);
                        f = s.charAt(0);
                        i = convertToNum(c);
                        j = convetToStr(ch);
                        if (f == '_' & i >= 0 & j >= 0) {
                            x = 2;
                            z = 2;

                        } else {
                            s = check1(s);
                        }
                    } else {
                        s = check1(s);
                    }
                }
                if (z == 2) {
                    if (!e.getelement(i, j).isClicked()) {
                        h.FLAG(e, i, j);
                        this.Turn += 1;
                    }
                } else {
                    if (!(e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag())) {
                        h.testing(e, i, j,player);
                        this.Turn += 1;
                    }
                }

            }

            System.out.println("\n_____________________________");
            e.printafter();
            System.out.println("\n_____________________________");
        } while (!isWin(e) && !isLosss(e));

        if (isLosss(e)) {
            if (this.Turn % 2 == 0) {
                System.out.println("player 1 is loss And computer player is win");
            } else {
                System.out.println(" computer player is loss And player 1 is win");
            }
        } else if (isWin(e)) {
            if (this.Turn % 2 == 0) {
                System.out.println("player 1 is win And computer player is loss");
            } else {
                System.out.println(" computer player is win And player 1 is loss");
            }
        }

    }

    
    
    
    
    @Override
    public void convert2(Initialize e, Click h,Score score) {
        Random rand = new Random();

        Scanner scn = new Scanner(System.in);
        int j = 0, i = 0;
        String s;
        char ch, c;
        System.out.println("\nenter your choice again that consists "
                + "of two parts or three : flag,num,char\nOr num,char\n");

        int x = 1, z = 1;
        char f;
        do {
            if (this.Turn % 2 == 0) {
                System.out.print("computer player     :");
                i = rand.nextInt(e.getX());
                j = rand.nextInt(e.getY());
                if (!(e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag())) {
                    h.testing(e, i, j,player);
            score2=score2+(score.addScore(e)-(score1+score2));
                    this.Turn += 1;
                }
            } else if (Turn % 2 != 0) {
                System.out.print("player one     :");
                s = scn.next();
                x = 1;
                z = 1;
                while (x == 1) {
                    if (s.length() == 2) {//s=scan2;
                        c = s.charAt(0);
                        ch = s.toUpperCase().charAt(1);
                        i = convertToNum(c);
                        j = convetToStr(ch);
                        if (i >= 0 && j >= 0) {
                            x = 2;
                        } else {
                            s = check1(s);
                        }
                    } else if (s.length() == 3) {
                        c = s.charAt(1);
                        ch = s.toUpperCase().charAt(2);
                        f = s.charAt(0);
                        i = convertToNum(c);
                        j = convetToStr(ch);
                        if (f == '_' & i >= 0 & j >= 0) {
                            x = 2;
                            z = 2;

                        } else {
                            s = check1(s);
                        }
                    } else {
                        s = check1(s);
                    }
                }
                if (z == 2) {
                     if (!e.getelement(i, j).isClicked()) {
                    h.FLAG(e, i, j);
                    if (this.Turn % 2 == 0)
            flagScore2=flagScore2+(score.addFlagScore(e)-(flagScore2+flagScore1));
             else 
            flagScore1=flagScore1+(score.addFlagScore(e)-(flagScore1+flagScore2));
                    this.Turn += 1;
                }
                } else {
                    if (!(e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag())) {
                         h.testing(e, i, j,player);
                    if (this.Turn % 2 == 0)
            score2=score2+(score.addScore(e)-(score1+score2));
             else 
            score1=score1+(score.addScore(e)-(score2+score1));
                    this.Turn += 1;
                    }
                }

            }

            System.out.println("\n_____________________________");
            e.printafter();
            System.out.println("\n_____________________________");
        } while (!isWin(e));

         if (isWin(e)) {
            if(score1>score2)
{
    
    int scor=score1+(100*minesnumbernotclicked(e))+flagScore1; // +addflagscoore1
   System.out.println("the winner is player 1 the score1 is  :"+scor);

}
                 
else if(score1<score2)
{
     int scor=score2+(100*minesnumbernotclicked(e))+flagScore2; // +addflagscoorew
    System.out.println("the winner is Computer player the score is  :"+scor);
     
}
        }

    }

    @Override
    public boolean firstin2(Initialize e, Click h,Score score) {
        e.printvoid();
        System.out.println("\n_____________________________");

        Scanner scn = new Scanner(System.in);
        String s;
        char ch, x;
        int i, j;

        do {
            System.out.println("\nenter your choice again that consists "
                    + "of two parts or three : flag,num,char\nOr num,char\n");
            System.out.println("the player one");
            s = scn.next();
            x = s.charAt(0);
            ch = s.toUpperCase().charAt(1);

            i = convertToNum(x);
            j = convetToStr(ch);
        } while (!e.valid(i, j));

        e.getelement(i, j).setClicked(true);
        e.getelement(i, j).setScan(true);
        e.CreatMines();
        e.puzzle();
        if (e.getelement(i, j).getStatus() == 0) 
            h.check(e, i, j,player);
        
        e.printafter();

        if (isWin(e)) {
            int scor=(score.addFlagScore(e)+score.addScore(e))+(100*minesnumbernotclicked(e));
            System.out.println("the winner is player 1 the score1 is  :"+scor);
            return true;
        }
        score1=score.addScore(e);
        flagScore1=score.addFlagScore(e);
        this.Turn += 1;
        return false;

    }
}
