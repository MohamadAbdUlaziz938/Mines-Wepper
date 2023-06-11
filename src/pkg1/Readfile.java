/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author NEW--LAPTOP--2318887
 */
public class Readfile {
    static int p1=0,p2=0,p3=0,p4=0;
    static int q1=0,q2=0,q3=0,q4=0,q5=0,q6=0;
     static int o1=0,o2=0;
    public static  StoreFile loadfile()
    { StoreFile file=null;
        try{        

        JFileChooser open=new JFileChooser();
//            FileNameExtensionFilter filter=new FileNameExtensionFilter("Text Files", "Game");

//        open.setFileFilter(filter);
        int filetoOpen=open.showOpenDialog(open);
        if(filetoOpen!=JFileChooser.APPROVE_OPTION)  
        return null;
       String path=open.getSelectedFile().toString(); 
       if(path.endsWith("PlayerOneMi"))
           p1=1;
      else if(path.endsWith("PlayerOneSc"))
           p2=1;
      else if(path.endsWith("PlayerOneMiSh"))
           p3=1;
      
           else   if(path.endsWith("PlayerOneScSh"))
                  p4=1;
      else if(path.endsWith("TwoPlayersMi"))
           q1=1; 
       else if(path.endsWith("TwoPlayersSc"))
           q2=1;
       else if(path.endsWith("TwoPlayersScZ"))
           q3=1; 
        else if(path.endsWith("TwoPlayersMiSh"))
           q4=1;
        else if(path.endsWith("TwoPlayersScSh"))
           q5=1;
        else if(path.endsWith("TwoPlayersScShZ"))
           q6=1;
        else if(path.endsWith("ComPlayerMi"))
           o1=1;
        else if(path.endsWith("ComPlayerMiSh"))
           o2=1;
        FileInputStream fis=new FileInputStream(path);
    ObjectInputStream in=new ObjectInputStream(fis);
    file=(StoreFile) in.readObject();
   in.close();
   fis.close();
     }catch(Exception es){es.printStackTrace();}

    return file;
    }
    public static  StoreFile temploadfile()
    { StoreFile tempfile=null;
        try{        
if(GUIGame.temp1.exists())
{FileInputStream fis=new FileInputStream(GUIGame.temp1);
    ObjectInputStream in=new ObjectInputStream(fis);
    tempfile=(StoreFile) in.readObject();
   in.close();
   fis.close();}
     }catch(Exception es){es.printStackTrace();}

    return tempfile;
    }
    

  
    
}
