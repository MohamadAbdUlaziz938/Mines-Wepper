package pkg1;

import java.util.Scanner;

public class ConsolGame extends Game {
Player player;
    public ConsolGame(Initialize e,int a) {
        Score s = new Score();
        Click h = new Click();

        if(a==1)
        {
            if (!firstin(e, h))
                convert(e, h);
        }
        
        if(a==2)
        {
            if (!firstin2(e, h, s))
            convert2(e, h, s);
        }

    }

    public ConsolGame() {

    }

    public boolean isLosss(Initialize e) {

        for (int i = 0; i < e.getX(); i++) 
            for (int j = 0; j < e.getY(); j++) 
                if (e.getelement(i, j).isClicked() && e.getelement(i, j).getStatus() == -1) {
                    return true;
                }
        return false;
    }

    public boolean isWin(Initialize e) {

        if (Click.count == e.getX() * e.getY() - e.getMinsNum() - 1) 
            return true;
        
        return false;
    }
    public class AnonymousInner {
            public void mymethod() {
               System.out.println (
    "\nenter your choice again that consists "
                + "of two parts or three : flag,num,char\nOr num,char\n");
            }
        };


    public void convert(Initialize e, Click h) {

        Scanner scn = new Scanner(System.in);
        int j = 0, i = 0;
        String s;
        char ch, c, q;
      AnonymousInner inner=new AnonymousInner();
      inner.mymethod();
        int x = 1, z = 1;
        char f;
        do {
            s = scn.next();
            x = 1;
            z = 1;
            while (x == 1) {
                if (s.length() == 2) {
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
            if (z == 2)
                h.FLAG(e, i, j);
              else 
                h.testing(e, i, j,player);

            System.out.println("\n_____________________________");
            e.printafter();
            System.out.println("\n_____________________________");

        } while (!isWin(e) && !isLosss(e));
        if (isLosss(e))
        {
            System.out.println("You have lost ");
            
        }
        
            else if (isWin(e))
            {System.out.println("You have Won ");
            e.printafter();
            }

    }

    public int convertToNum(char c) {
        int i = 0;
        for (int k = '1'; k <= '9'; k++) {
            if (c == k) {
                i = k - '1' + 1;
            }
        }
        i--;
        return i;
    }

    public int convetToStr(char c) {
        int i = 0;
        for (int k = 'A'; k <= 'Z'; k++) {
            if (c == k) {
                i = k - 'A' + 1;
            }
        }
        i--;
        return i;
    }

    public String check1(String s) {
        try {
            throw new Exception("repeat input your choice again that consists of three parts  : flag,num,char\n or two parts: num,char");
        } catch (Exception e) {
            Scanner scn = new Scanner(System.in);
            System.out.println(e.getMessage());
            s = scn.next();
            return s;
        }

    }

    @Override
    public void ApplyGame(Object obj) {

    }

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
           // e.printorigin();
            //e.printafter();
            for(int q=0;q<9;q++)
                for(int qq=0;qq<9;qq++)
                {if(e.getelement(q, qq).getStatus()==-1)
                    System.out.println("B");
                else
                    System.out.println("o");
                }
            return true;
        } else if (isWin(e)) {
            System.out.println("\nYou have Won ");
            return true;
        }
        return false;
    }

    public void convert2(Initialize e,Click h,Score score)
    {
        Scanner scn = new Scanner(System.in);
        int j = 0, i = 0;
        String s;
        char ch, c, q;
        System.out.println("\nenter your choice again that consists "
                + "of two parts or three : flag,num,char\nOr num,char\n");

        int x = 1, z = 1;
        char f;
        do {
            s = scn.next();
            x = 1;
            z = 1;
            while (x == 1) {
                if (s.length() == 2) {
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
                h.FLAG(e, i, j);
            } else {
                h.testing(e, i, j,player);

            }

            System.out.println("\n_____________________________");
            e.printafter();
            System.out.println("\n_____________________________");

        } while (!isWin(e));
         if (isWin(e)) {
             int scor=(score.addFlagScore(e)+score.addScore(e))+(100*minesnumbernotclicked(e));
             if(scor>0)
            System.out.println(" You have Won your ,score is  :"+scor);
             else if(scor<0)
                 System.out.println(" YOu have lost, your score is  :"+scor);
        }
    }
    public boolean firstin2(Initialize e,Click h,Score score)
    {
        e.printvoid();
        System.out.println("\n_____________________________");

        Scanner scn = new Scanner(System.in);
        String s;
        char ch, x;
        int i, j;

        do {
            System.out.println("\nenter your choice again that consists "
                    + "of two parts or three : flag,num,char\nOr num,char\n");

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
             
             int scor=(score.addFlagScore(e)+score.addScore(e))+(100*minesnumbernotclicked(e));///مافيني ضيف فلاك هون
             if(scor>0)
    System.out.println("You have won ,Your score is  :"+scor);
      

             
            return true;
                  }    
        return false;

    }
    
    public int minesnumbernotclicked(Initialize e)
    {
        int count=0;
        for(int i=0;i<e.getX();i++)
         for(int j=0;j<e.getY();j++)
             if(!e.getelement(i, j).isClicked())
                 if(!e.getelement(i, j).isFlag())
                 if(e.getelement(i, j).getStatus()==-1)
                    count++;
        return count;
    }
}
