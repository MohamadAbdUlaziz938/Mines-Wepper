package pkg1;

import java.io.Serializable;

public class Score implements Serializable{

    Integer count=0;
    Integer flagScore = 0;

    Score() {
        B = 250;
        O = 10;
        auto = 1;
        lastO = 100;
        this.Wflag = 5;
        this.Lflag = 1;
    }

    public int getB() {
        return B;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setB(int B) {
        this.B = B;
    }

    public void setO(int O) {
        this.O = O;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public void setLastO(int lastO) {
        this.lastO = lastO;
    }

    public void setWflag(int Wflag) {
        this.Wflag = Wflag;
    }

    public void setLflag(int Lflag) {
        this.Lflag = Lflag;
    }

    public int getO() {
        return O;
    }

    public int getAuto() {
        return auto;
    }

    public int getLastO() {
        return lastO;
    }

    public int getWflag() {
        return Wflag;
    }

    public int getLflag() {
        return Lflag;
    }

    private int B;
    private int O;
    private int auto;
    private int lastO;
    private int Wflag;
    private int Lflag;

    public void restScore() {
        count = 0;       /////////////////////////
        flagScore = 0;
//        B = 250;
//        O = 10;
//        auto = 1;
//        lastO = 100;
//        Wflag = 5;
//        Lflag = 1;

    }

    public int addScore(Initialize e) {
        count = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (!e.getelement(i, j).isFlag()) {
                    if (e.getelement(i, j).isClicked()) {
                        if (!e.getelement(i, j).isScan()) //تلقائي
                        {
                            this.count += getAuto();
                        } else if (e.getelement(i, j).isScan()) // غير تلقائي هناك حالات مختلفة
                        {

                            if (e.getelement(i, j).getStatus() == 0) {
                                this.count += getO();
                            } else if (e.getelement(i, j).getStatus() == -1) {
                                this.count -= getB();

                            } else {
                                this.count += e.getelement(i, j).getStatus();
                            }

                        }
                    }

                }
            }
        }
        return this.count;

    }

    public Integer addFlagScore(Initialize e) {

        flagScore=0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isFlag()) {
                    if (e.getelement(i, j).getStatus() == -1) {
                        flagScore += getWflag();
                    } else {
                        flagScore -= getLflag();
                    }
                }
            }
        }
        return flagScore;
    }

    public Integer getCount() {
        return this.count;
    }

    public int addScore(Initialize e,Player player) {
                 count = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (!e.getelement(i, j).isFlag()) {
                    if (e.getelement(i, j).isClicked()) {
                        if (!e.getelement(i, j).isScan()) //تلقائي
                        {
                            this.count += getAuto();
                        } else if (e.getelement(i, j).isScan()) // غير تلقائي هناك حالات مختلفة
                        {

                            if (e.getelement(i, j).getStatus() == 0) {
                                this.count += getO();
                            } else if (e.getelement(i, j).getStatus() == -1) {
                                if(player.getArmorCount()<0)
                                {
                                this.count -= getB();
                                player.setArmorCount(player.getArmorCount()+1);    
                                }
                                
                                

                            } else {
                                this.count += e.getelement(i, j).getStatus();
                            }

                        }
                    }

                }
            }
        }
        return this.count;

    }
}
