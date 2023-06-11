package pkg1;

import java.io.Serializable;

public class Click implements Serializable{
    
    public static int ux=0,uy=0;
    public static int count;


  
    
    public void testing(Initialize e,int i,int j,Player player)  //لاختبار الالعنصر كاملا
    {
        if(e.valid(i, j) && !e.getelement(i,j).isClicked())  //موجودة وليست مفتوحة
        {
            if(!e.getelement(i, j).isFlag()) // لا يوجد علامة على العنصر
            {
                player.setClickCount(player.getClickCount()+1);
                
            
             if(e.getelement(i, j).getStatus()==-1)    // لغم
             {
                 player.setMinesClickedCount(player.getMinesClickedCount()+1);
                 e.getelement(i, j).setScan(true);
                 e.getelement(i, j).setClicked(true);
             }
                          
             else if (e.getelement(i, j).getStatus()==0)  // فراغ
             {
                 count++;
                   if(e.getelement(i, j).isArmor())    // درع
                 player.setArmorCount(player.getArmorCount()+1);
                
                    e.getelement(i,j).setClicked(true);
                    e.getelement(i, j).setScan(true);
                   
                   check(e, i, j,player);
                   }
             else                                   // رقم
             {
                  count++;
                     if(e.getelement(i, j).isArmor())    // درع
             {
                 e.getelement(i, j).setScan(true);
                 e.getelement(i, j).setClicked(true);
                 player.setArmorCount(player.getArmorCount()+1);
                
             }
              
               else{
               e.getelement(i,j).setClicked(true);
               e.getelement(i, j).setScan(true);
             }
             }
            }
            else if(e.getelement(i,j).isFlag())
                System.out.println("you have already flaged it");
        }
        else
            System.out.println("you have alredy clicked it retry agaian");
   
    }
    
    public void testing(Initialize e,int i,int j,Player player,int Turn)  //لاختبار الالعنصر كاملا
    {
        if(e.valid(i, j) && !e.getelement(i,j).isClicked())  //موجودة وليست مفتوحة
        {
            if(!e.getelement(i, j).isFlag()) // لا يوجد علامة على العنصر
            {
                player.setClickCount(player.getClickCount()+1);
                
            
             if(e.getelement(i, j).getStatus()==-1)    // لغم
             {
                 player.setMinesClickedCount(player.getMinesClickedCount()+1);
                 if(Turn%2==0)
                       e.getelement(i, j).setColor(2);
                   else if(Turn%2!=0)
                       e.getelement(i, j).setColor(1);
                 e.getelement(i, j).setScan(true);
                 e.getelement(i, j).setClicked(true);
             }
                          
             else if (e.getelement(i, j).getStatus()==0)  // فراغ
             {
                 count++;
                   if(e.getelement(i, j).isArmor())    // درع
                 player.setArmorCount(player.getArmorCount()+1);
                   if(Turn%2==0)
                       e.getelement(i, j).setColor(2);
                   else if(Turn%2!=0)
                       e.getelement(i, j).setColor(1);
                
                    e.getelement(i,j).setClicked(true);
                    e.getelement(i, j).setScan(true);
                   check(e, i, j,player,Turn);

                   }
             else                                   // رقم
             {
                  count++;
                     if(e.getelement(i, j).isArmor())    // درع
             {
                 e.getelement(i, j).setScan(true);
                 e.getelement(i, j).setClicked(true);
                 player.setArmorCount(player.getArmorCount()+1);
                
             }
              
               else{
               e.getelement(i,j).setClicked(true);
               e.getelement(i, j).setScan(true);
             }
             }
            }
            else if(e.getelement(i,j).isFlag())
                System.out.println("you have already flaged it");
        }
        else
            System.out.println("you have alredy clicked it retry agaian");
   
    }
       public void check(Initialize e ,int vx,int vy,Player player) //اذا كان العنصر فاضي يقوم بتجهيز العناصر الثمانية المجاورة
    {
           
        
        int dx[] = {0,0,-1,1,-1,1,-1,1};
        int dy[] = {1,-1,0,0,-1,-1,1,1};
    
          for (int i=0;i<8;i++)
            {
             ux = vx + dx[i] ;
             uy = vy + dy[i];
            if ( e.valid(ux,uy)&& e.getelement(ux, uy).getStatus()!=-1 && !e.getelement(ux, uy).isClicked()&&!e.getelement(ux, uy).isFlag())   // موجود وليس لغم
            {
                                player.setClickCount(player.getClickCount()+1);
                
                count++;
               if(e.getelement(ux, uy).getStatus()!=0)                     // رقم
               {
                    if(e.getelement(ux, uy).isArmor())                     // درع
                      player.setArmorCount(player.getArmorCount()+1);
                    
                      e.getelement(ux, uy).setScan(false);
                      e.getelement(ux, uy).setClicked(true);
                    
               }
               
              else if(e.getelement(ux, uy).getStatus()==0)               // فراغ
               {
                         if(e.getelement(ux, uy).isArmor())                     // درع
                      player.setArmorCount(player.getArmorCount()+1);
               
                    
                       e.getelement(ux, uy).setScan(false);
                       e.getelement(ux, uy).setClicked(true);
                       check(e, ux, uy,player);

               }
                 
            }
    }
       }
           public void check(Initialize e ,int vx,int vy,Player player,int Turn) //اذا كان العنصر فاضي يقوم بتجهيز العناصر الثمانية المجاورة
    {
           
        
        int dx[] = {0,0,-1,1,-1,1,-1,1};
        int dy[] = {1,-1,0,0,-1,-1,1,1};
    
          for (int i=0;i<8;i++)
            {
             ux = vx + dx[i] ;
             uy = vy + dy[i];
            if ( e.valid(ux,uy)&& e.getelement(ux, uy).getStatus()!=-1 && !e.getelement(ux, uy).isClicked()&&!e.getelement(ux, uy).isFlag())   // موجود وليس لغم
            {
     player.setClickCount(player.getClickCount()+1);
                
                count++;
               if(e.getelement(ux, uy).getStatus()!=0)                     // رقم
               {
                    if(e.getelement(ux, uy).isArmor())                     // درع
                      player.setArmorCount(player.getArmorCount()+1);
                    if(Turn%2==0)
                       e.getelement(ux, uy).setColor(2);
                    else if(Turn%2!=0)
                       e.getelement(ux, uy).setColor(1);
                      e.getelement(ux, uy).setScan(false);
                      e.getelement(ux, uy).setClicked(true);
                    
               }
               
              else if(e.getelement(ux, uy).getStatus()==0)               // فراغ
               {
                         if(e.getelement(ux, uy).isArmor())                     // درع
                      player.setArmorCount(player.getArmorCount()+1);
                if(Turn%2==0)
                        e.getelement(ux, uy).setColor(2);
                    else if(Turn%2!=0)
                          e.getelement(ux, uy).setColor(1);
                       e.getelement(ux, uy).setScan(false);
                       e.getelement(ux, uy).setClicked(true);
                       check(e, ux, uy,player,Turn);
               }
                 
            }
    }
       }
   
  public void FLAG(Initialize e ,int i,int j)
  {
      if(!e.getelement(i, j).isClicked())
      {
          if(e.valid(i, j)&&e.getelement(i, j).isFlag())
       {
        e.getelement(i, j).setFlag(false);
       System.out.println("you have alreday removed flag");
       }
          else if(e.valid(i,j) &&!e.getelement(i, j).isFlag())
           e.getelement(i, j).setFlag(true);
       
       else
           System.out.println("you have already clicked it");
      }
      
  }
  
    
  
}
