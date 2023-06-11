
package pkg1;

import java.io.Serializable;
import java.io.*;
import java.util.Date;
import sun.java2d.pipe.SpanShapeRenderer;


public class ScoreBoard implements Serializable{
    
    public Date date,date2;
    Integer score1;
    String name1;
    int id;
    boolean state;
    String path;

    public String getPath() {
        return path;
    }
    
    public ScoreBoard(int score1,String name1,Date date,Date date2)
    {
        this.name1=name1;
        this.score1=score1;
        this.date=date;
        this.date2=date2;
        
    }
   
    

    public ScoreBoard(Integer score1,String name1,Date date,Date date2,int id,boolean state) {
        this.score1=score1;
        this.name1=name1;
        this.date=date;
        this.date2=date2;
        this.id=id;
        this.state=state;
    }
       public ScoreBoard(Integer score1,String name1,Date date,Date date2,int id,boolean state,String path1) {
        this.score1=score1;
        this.name1=name1;
        this.date=date;
        this.date2=date2;
        this.id=id;
        this.state=state;
        this.path=path1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public boolean isState() {
        return state;
    }
  
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate2() {
        return date2;
    }

    public Integer getScore1() {
        return score1;
    }


    public String getName1() {
        return name1;
    }


    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

 

   
    
    
    
}
