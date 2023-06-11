package pkg1;


import java.io.Serializable;
import java.util.Random;


public class Initialize implements Serializable{
     int  x,y,armorsNum;
    static  int minsNum;
    element E[][];
    int turn1=1;
    
//    public Initialize()
//    {}
public Initialize(int x,int y,int minesNum,int armorsNum)
    {
        this.x=x;
        this.y=y;
        this.minsNum=minesNum;
        this.armorsNum=armorsNum;
        this.E=new element[x][y];
        int i,j;
        for (i = 0; i < x; i++) 
         for (j = 0; j < y; j++)
          E[i][j]=new element();
        this.turn1=1;
    }


//public Initialize(Initialize e)
//{
//    e=new Initialize();
//    for(int i=0;i<this.x;i++)
//        for(int j=0;j<this.y;j++)
//        {
//            this.getelement(i, j).equals(e.getelement(i, j));
//        }
//    
//}
public Initialize()
{
}

public void reset()
{
    
    for (int i = 0; i < x; i++) 
         for (int j = 0; j < y; j++)
          E[i][j]=new element();
        
}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getArmorsNum() {
        return armorsNum;
    }

    public void setArmorsNum(int armorsNum) {
        this.armorsNum = armorsNum;
    }

    public void setMinsNum(int minsNum) {
        this.minsNum = minsNum;
    }

    public int getMinsNum() {
        return minsNum;
    }
    
    public void CreatMines()
    {
        Random rand=new Random();
        int i,j;
        
        for (int z = 0; z < this.minsNum; z++) // توزيع الألغام على المصفوفة
        {
            i=rand.nextInt(this.x);
            j=rand.nextInt(this.y);
            
            if(!E[i][j].isClicked()&&E[i][j].getStatus()!=-1&&!E[i][j].isArmor())
            E[i][j].setStatus(-1);
            
            else if(E[i][j].isClicked()||E[i][j].getStatus()==-1||E[i][j].isArmor())
                z=z-1;
            
         }
        //printafter();
      
    }
     public void CreatArmaors()
    {
        Random rand=new Random();
        int i,j;
        
        for (int z = 0; z < this.armorsNum; z++) // توزيع الألغام على المصفوفة
        {
            i=rand.nextInt(this.x);
            j=rand.nextInt(this.y);
            
            if(!E[i][j].isClicked()&&E[i][j].getStatus()!=-1&&!E[i][j].isArmor())
            E[i][j].setArmor(true);
            
            else if(E[i][j].isClicked()||E[i][j].getStatus()==-1||E[i][j].isArmor())
                z=z-1;
            
         }

    }
    
    
    public void check(int vx,int vy)
    {
        int ux=0,uy=0;
        int dx[] = {0,0,-1,1,-1,1,-1,1};
        int dy[] = {1,-1,0,0,-1,-1,1,1};
        int x=0;
    
          for (int i=0;i<8;i++)
            {
             ux = vx + dx[i] ;
             uy = vy + dy[i];
            if ( valid (ux,uy)&& E[ux][uy].getStatus()!=-1)
            {
                x=E[ux][uy].getStatus();
                x+=1;
                E[ux][uy].setStatus(x);
            }
            }  
    }
    
    public boolean valid (int x,int y)  
    {
        return x >= 0 && x < this.x && y >= 0 && y <this.y ;
    }
    
    public void puzzle()
    {
        int i,j;
        for (i = 0; i < this.x; i++) 
            for (j = 0; j < this.y; j++)
            if(E[i][j].getStatus()==-1)
                 check(i,j);   
    }
    
    
    public void printorigin()
    {
        
        int i,j;
        
              for (i = 0; i < this.x; i++)  //طباعة المصفوفة
        {
            System.out.println();
            for (j = 0; j < this.y; j++)
                    {
                   if(E[i][j].getStatus()==-1)
             System.out.print("B\t");
                   else if(E[i][j].getStatus()==0)
             System.out.print("O\t");
                 else
                      System.out.print(E[i][j].getStatus()+"\t");

                    }
        }
    }
    public void printvoid()
    {
        int i,j;
        for (i = 0; i < this.x; i++)  //طباعة المصفوفة
        {
            System.out.println();
            for (j = 0; j < this.y; j++)
                     System.out.print("O\t");
        }

    }
    public void printafter()
    {
          int i,j;
        
        for (i = 0; i < this.x; i++) 
        {
            System.out.println();
            for (j = 0; j < this.y; j++)
            {
                if(E[i][j].isClicked())
                {
                    if(E[i][j].getStatus()==-1)
             System.out.print("B\t");
                   else if(E[i][j].getStatus()==0)
             System.out.print("*\t");
                  
                       
                 else
                    System.out.print(E[i][j].getStatus()+"\t");
                }
                 else if(E[i][j].isFlag())
                         System.out.print("!\t");
//                 else if(!E[i][j].isFlag())
//                     System.out.print("O\t");
                else 
                System.out.print("O\t");
                    
            }
        
        }
       
    }
//    public  element setelement(int i,int j)
//    {
//    }
   
    public  element getelement(int i,int j)
    {
        return E[i][j];
    }
    
    
  public void printclicked()
  {
        int i,j;
        
        for (i = 0; i < this.x; i++) 
        {
            System.out.println();
            for (j = 0; j < this.y; j++)
            {
                if(E[i][j].isClicked())
                
                   System.out.print("*\t");
                else 
                System.out.print("O\t");
                    
            }
        
        }
  }
    
    
    
    
}
