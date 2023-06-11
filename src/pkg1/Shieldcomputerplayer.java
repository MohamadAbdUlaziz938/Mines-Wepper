package pkg1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.Turn;
import static pkg1.GUIGame.clickload;
import static pkg1.GUIGame.counter;
import static pkg1.GUIGame.timerload;

public class Shieldcomputerplayer extends ShieldGuigame {

    Random rand = new Random();
    boolean dont = false;
    Thread thread = new Thread() {
        public void run() {
            int random = rand.nextInt(8);
            random=2;

            try {
                for (int i = 0; i < random; i++) {
                    thread.sleep(1 * 1000);
                    counter--;
                    viewTimer.setText(counter.toString());
                }
                counter--;
            } catch (Exception e) {

            } finally {
                thread.stop();
            }

        }
    };

    public Shieldcomputerplayer(Initialize e, Score score, JPanel SinglePlayerPage, Player player, Player player2) {
        super(e, score, SinglePlayerPage, player, player2);
    }

    @Override
    public void display(Initialize e, Player player) {
        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked()) {
                    if (e.getelement(i, j).getStatus() == -1) {

                        if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getIcon() != bombicon1) {
                            bottuns[i][j].setBackground(Color.YELLOW);
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(bombicon2);

                        } else if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getIcon() != bombicon2) {
                            bottuns[i][j].setBackground(Color.GREEN);
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(bombicon1);

                        }

                    } else if (e.getelement(i, j).getStatus() == 0) {
                        if (e.getelement(i, j).isArmor()) {
                            if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != armorIcon) {
                                bottuns[i][j].setIcon(armorIcon);
                                bottuns[i][j].setBackground(Color.GREEN);
                                bottuns[i][j].setEnabled(false);
                                if (e.getelement(i, j).getStatus() > 0) {
                                    bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                                }

                            }
                        } else {
                            if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getBackground() != Color.GREEN) {
                                bottuns[i][j].setBackground(Color.YELLOW);
                            } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getBackground() != Color.YELLOW) {
                                bottuns[i][j].setBackground(Color.GREEN);
                            }
                        }
                        bottuns[i][j].setEnabled(false);

                    } else {
                        if (e.getelement(i, j).isArmor()) {
                            if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != armorIcon) {
                                bottuns[i][j].setBackground(Color.GREEN);
                                bottuns[i][j].setEnabled(false);
                                bottuns[i][j].setIcon(armorIcon);
                            }
                        } else {
                            if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getBackground() != Color.GREEN) {
                                bottuns[i][j].setBackground(Color.YELLOW);
                            } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getBackground() != Color.YELLOW) {
                                bottuns[i][j].setBackground(Color.GREEN);
                            }

                        }
                        bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                        bottuns[i][j].setEnabled(false);
                    }
                } else if (e.getelement(i, j).isFlag()) {
                    if (e.getelement(i, j).getColor() == 3) {
                        bottuns[i][j].setIcon(flagIcon1);
                    }
                    bottuns[i][j].enableInputMethods(false);

                }

            }
        }

    }

    @Override
    public void initEvent(JButton b, Initialize e, Score score, Player player, Player player2) {

        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e1) {
                if (SwingUtilities.isLeftMouseButton(e1)) {

                    b.addActionListener(new ActionListener() {         // كلما قام المستخدم بالنقر على الزر سيتم تنفيذ الأمر الموضوع من جديد
                        @Override
                        public void actionPerformed(ActionEvent event) {
                            x++;

                            for (int i = 0; i < e.getX(); i++) {
                                for (int j = 0; j < e.getY(); j++) {
                                    if (event.getSource().equals(bottuns[i][j]) || (Turn % 2 == 0)) {
                                        if (x == 1) {
                                            if (!file.exists()) {
                                                try {
                                                    fos = new FileOutputStream(file);
                                                    oos = new ObjectOutputStream(fos);
                                                    ch = 'w';
                                                } catch (Exception exc) {
                                                }
                                            } else {
                                                try {
                                                    fis = new FileInputStream(file);
                                                    ois = new ObjectInputStream(fis);
                                                    ch = 'r';
                                                } catch (Exception exc) {

                                                }
                                            }

                                            try {
                                                filee = new FileOutputStream(main);
                                                out = new ObjectOutputStream(filee);

                                            } catch (Exception ex) {
                                            }

                                            try {
                                                filee1 = new FileOutputStream(assist);
                                                out1 = new ObjectOutputStream(filee1);

                                            } catch (Exception ex) {
                                            }
                                            date = new Date();

                                            e.getelement(i, j).setClicked(true);
                                            e.getelement(i, j).setScan(true);
                                            e.CreatMines();
                                            e.CreatArmaors();
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player, Turn);
                                                numshields = player.getArmorCount();
                                                numbershields.setText(numshields.toString());
                                            }
                                            e.getelement(i, j).setColor(1);
                                            display(e, player);
                                            ffile = new StoreFile(e, player, player2);
                                            try {
                                                out1.writeObject(ffile);
                                                out1.close();
                                                filee1.close();
                                                save();
                                            } catch (Exception es) {
                                                es.printStackTrace();
                                            }
                                            if (iswin(e)) {
                                                date2 = new Date();
                                                ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

                                                saveScoreBoard(sb, player, player2);
                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                JOptionPane.showMessageDialog(null, "player one has won");
                                                whenloss(e);
                                                interface2();
                                                endprint(e);
                                                return;
                                            }
                                            Turn++;
                                            k2 = 1;
                                            time(e, player, player2);
                                            x++;
                                        } else {

                                            if (clickload == true) {
                                                try {
                                                    filee = new FileOutputStream(main);
                                                    out = new ObjectOutputStream(filee);

                                                } catch (Exception ex) {
                                                }

                                                try {
                                                    filee1 = new FileOutputStream(assist);
                                                    out1 = new ObjectOutputStream(filee1);

                                                } catch (Exception ex) {
                                                }
                                                clickload = false;
                                            }
                                            if (!timerload) {
                                                task.cancel();
                                            } else if (!timerload2) {
                                                task2.cancel();
                                            }

                                            if (Turn % 2 == 0) {

                                            } else if (Turn % 2 != 0) {
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player)) {
                                                    h.testing(e, i, j, player, Turn);
                                                    if (e.getelement(i, j).getStatus() == -1 && !e.getelement(i, j).isFlag()) {

                                                        numMines--;
                                                        if (numMines >= 0) {
                                                            numberMines.setText(numMines.toString());
                                                        }
                                                        player.setArmorCount(player.getArmorCount() - 1);
                                                    }
                                                    numshields = player.getArmorCount();
                                                    if (numshields >= 0) {
                                                        numbershields.setText(numshields.toString());
                                                    }

                                                }
                                                e.getelement(i, j).setColor(1);;
                                                display(e, player);
                                                Turn += 1;
                                                if (iswin(e)) {
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

                                                    saveScoreBoard(sb, player, player2);
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();

                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won");
                                                    whenloss(e);
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }
                                                if (isLosss1(e, player)) {
                                                    ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                                    saveScoreBoard(sb, player, player2);
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "sorry," + GUI1.name1 + "has loss");
                                                    whenloss(e);
                                                    interface2();
                                                    endprint(e);
                                                    return;
                                                }

                                                numshields = player.getArmorCount();
                                                if (numshields >= 0) {
                                                    numbershields.setText(numshields.toString());
                                                }

                                            }
                                            if (!timerload) {
                                                task.cancel();
                                            } //                                                if (x == 3) {
                                            //                                                    timerload = false;
                                            //                                                }
                                            else if (!timerload2) {
                                                task2.cancel();
                                            }
                                            if (x == 3) {
                                                timerload = false;
                                                timerload2 = false;

                                            }
                                            time(e,player, player2);

                                        }

                                    }
                                }
                            }
                        }
                    });
                }
                if (SwingUtilities.isRightMouseButton(e1)) {

                    for (int i = 0; i < bottuns.length; i++) {
                        for (int j = 0; j < bottuns[0].length; j++) {
                            if (e1.getSource().equals(bottuns[i][j])) {

                                if (!iswin(e) && !isLosss(e) && !timeOut && !isLosss1(e, player)) {
                                    if (x > 1) {

                                        if (clickload == true) {
                                            try {
                                                filee = new FileOutputStream(main);
                                                out = new ObjectOutputStream(filee);

                                            } catch (Exception ex) {
                                            }

                                            try {
                                                filee1 = new FileOutputStream(assist);
                                                out1 = new ObjectOutputStream(filee1);

                                            } catch (Exception ex) {
                                            }
                                            clickload = false;
                                        }

                                        if (Turn % 2 == 0) {
                                            
                                        } else if (Turn % 2 != 0) {
                                            if (!timerload) {
                                                task.cancel();
                                            } else if (!timerload2) {
                                                task2.cancel();
                                            }
                                            
                                            if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss(e) && !timeOut) {
                                                bottuns[i][j].setIcon(flagIcon1);
                                                h.FLAG(e, i, j);
                                                e.getelement(i, j).setColor(3);
                                                try {
                                                    filee1 = new FileOutputStream(assist);
                                                    out1 = new ObjectOutputStream(filee1);
                                                    ffile = new StoreFile(e, player, player2);
                                                    out1.writeObject(ffile);
                                                    out1.close();
                                                    filee1.close();
                                                    save();
                                                } catch (Exception ee) {
                                                    ee.printStackTrace();
                                                }
                                                Turn += 1;

                                            } else if (e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                bottuns[i][j].setIcon(null);
                                                h.FLAG(e, i, j);
                                                e.getelement(i, j).setColor(0);
                                                try {
                                                    filee1 = new FileOutputStream(assist);
                                                    out1 = new ObjectOutputStream(filee1);
                                                    ffile = new StoreFile(e, player, player2);
                                                    out1.writeObject(ffile);
                                                    out1.close();
                                                    filee1.close();
                                                    save();
                                                } catch (Exception ee) {
                                                    ee.printStackTrace();
                                                }
                                                Turn += 1;
                                            }
                                        }
                                        time(e, player, player2);

                                    }
                                }

                            }
                        }
                    }

                }

            }

            @Override

            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        }
        );

    }

    public void whenloss(Initialize e) {

        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).getStatus() == -1) {
                    if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getIcon() != bombicon1) {
                        bottuns[i][j].setBackground(Color.YELLOW);
                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(bombicon2);

                    } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != bombicon2) {
                        bottuns[i][j].setBackground(Color.GREEN);
                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(bombicon1);
                    }

                }
            }
        }
    }

    public boolean isLosssco(Initialize e) {

        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked() && e.getelement(i, j).getStatus() == -1) {
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void time(Initialize e, Player player, Player player2) {

        if (attemp1 == 2) {

            ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

            saveScoreBoard(sb, player, player2);
            try {
                out.close();
                filee.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }
            assist.delete();
            task.cancel();
            timeOut = true;
            JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost " + "\nCongratulations,computer player has won" + "\nBecause " + GUI1.name1 + "has lost a lot of time");
            whenloss(e);
            endprint(e);
            interface2();
            return;

        } else if (attemp2 == 2) {
            ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

            saveScoreBoard(sb, player, player2);
            try {
                out.close();
                filee.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }
            assist.delete();
            task.cancel();
            timeOut = true;
            JOptionPane.showMessageDialog(null, "Sorry, computer player has lost " + "\nCongratulations," + GUI1.name1 + "has won" + "\nBecause computer player has lost a lot of time");
            whenloss(e);
            endprint(e);
            interface2();
            return;
        }
        counter = Integer.parseInt(GUI1.time);

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                viewTimer.setText(counter.toString());

                int i = 0, j = 0;

                if (Turn % 2 == 0) {
                    if (x == 2) {
                        if (e.getelement(e.getX() - 1, e.getY() - 1).isClicked() && !iswin(e)) {

                            thread.run();
                            while (e.getelement(i, j).isClicked() || e.getelement(i, j).isArmor() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                i = rand.nextInt(e.getX());
                                j = rand.nextInt(e.getY());

                            }
                            if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e)) {
                                h.testing(e, i, j, player2, Turn);
                            }
                            e.getelement(i, j).setColor(2);
                            display(e, player2);
                            if (iswin(e)) {
                                ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                saveScoreBoard(sb, player, player2);
                                try {
                                    out.close();
                                    filee.close();
                                } catch (Exception eee) {
                                    eee.printStackTrace();
                                }
                                assist.delete();
                                endtime();
                                JOptionPane.showMessageDialog(null, "Computer player has won");
                                whenloss(e);
                                interface2();
                                endprint(e);
                                return;
                            }
                            Turn += 1;
                            x++;

                        } else {
System.out.println("2");
                            thread.run();
                            while (e.getelement(i, j).isClicked() || e.getelement(i, j).isArmor() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                i = rand.nextInt(e.getX());
                                j = rand.nextInt(e.getY());

                            }
                            if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                h.testing(e, i, j, player2, Turn);
                            }
                            e.getelement(i, j).setColor(2);
                            display(e, player2);
                            if (iswin(e)) {
                                ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

                                saveScoreBoard(sb, player, player2);
                                try {
                                    out.close();
                                    filee.close();
                                } catch (Exception eee) {
                                    eee.printStackTrace();
                                }
                                assist.delete();
                                endtime();
                                JOptionPane.showMessageDialog(null, "Computer player has won");
                                whenloss(e);
                                interface2();
                                endprint(e);
                                return;
                            }
                            Turn += 1;
                            x++;
                        }
                        endtime();
                        time(e, player, player2);
                    } else {
                        if (e.getelement(e.getX() - 1, e.getY() - 1).isClicked() && !iswin(e)) {

                            thread.run();
                            while (e.getelement(i, j).isClicked() || e.getelement(i, j).isArmor() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                i = rand.nextInt(e.getX());
                                j = rand.nextInt(e.getY());

                            }
                            if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e)) {
                                h.testing(e, i, j, player2, Turn);
                            }
                            e.getelement(i, j).setColor(2);
                            display(e, player2);
                            if (iswin(e)) {
                                ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                saveScoreBoard(sb, player, player2);
                                try {
                                    out.close();
                                    filee.close();
                                } catch (Exception eee) {
                                    eee.printStackTrace();
                                }
                                assist.delete();
                                endtime();
                                JOptionPane.showMessageDialog(null, "Computer player has won");
                                whenloss(e);
                                interface2();
                                endprint(e);
                                return;
                            }
                            Turn += 1;
                            x++;
                        } else {

                            thread.run();
                            while (e.getelement(i, j).isClicked() || e.getelement(i, j).isArmor() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                i = rand.nextInt(e.getX());
                                j = rand.nextInt(e.getY());

                            }
                            if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                h.testing(e, i, j, player, Turn);
                            }
                            e.getelement(i, j).setColor(2);
                            display(e, player2);
                            if (iswin(e)) {
                                ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false);

                                saveScoreBoard(sb, player, player2);
                                try {
                                    out.close();
                                    filee.close();
                                } catch (Exception eee) {
                                    eee.printStackTrace();
                                }
                                assist.delete();
                                endtime();
                                JOptionPane.showMessageDialog(null, "Computer player has won");
                                whenloss(e);
                                interface2();
                                endprint(e);
                                return;
                            }
                            Turn += 1;
                            x++;
                        }
                        endtime();
                        time(e, player, player2);

                    }

                }
                counter--;
                if (counter <= 0) {
                    timer.cancel();
                    timer.purge();

                    if (Turn % 2 == 0) {
                        attemp2++;
                    } else if (Turn % 2 != 0) {
                        attemp1++;
                    }

                    Turn++;

                    a = true;
                    counter = Integer.parseInt(GUI1.time);

                    if (attemp1 == 2) {
                        ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                        saveScoreBoard(sb, player, player2);
                        try {
                            out.close();
                            filee.close();
                        } catch (Exception eee) {
                            eee.printStackTrace();
                        }
                        assist.delete();
                        timeOut = true;
                        task.cancel();
                        JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost " + "\nCongratulations, computer player has won" + "\nBecause " + GUI1.name1 + "has lost a lot of time");
                        whenloss(e);
                        endprint(e);
                        interface2();
                        return;

                    } else if (attemp2 == 2) {
                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

                        saveScoreBoard(sb, player, player2);
                        try {
                            out.close();
                            filee.close();
                        } catch (Exception eee) {
                            eee.printStackTrace();
                        }
                        assist.delete();
                        timeOut = true;
                        task.cancel();
                        JOptionPane.showMessageDialog(null, "Sorry, computer player has lost " + "\nCongratulations," + GUI1.name1 + "has won" + "\nBecause computer player has lost a lot of time");
                        whenloss(e);
                        interface2();
                        endprint(e);
                        return;

                    }
                    timer2 = new Timer();
                    task2 = new TimerTask() {

                        @Override
                        public void run() {

                            viewTimer.setText(GUI1.time.toString());

                            int i = 0, j = 0;
                            if (Turn % 2 == 0) {
                                if (x > 2) {

                                    thread.run();
                                    while (e.getelement(i, j).isClicked() || e.getelement(i, j).isArmor() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                        i = rand.nextInt(e.getX());
                                        j = rand.nextInt(e.getY());
                                    }
                                    if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e)) {
                                        for (int l = 0; l < e.getX(); l++) {
                                            for (int ll = 0; ll < e.getY(); ll++) {
                                                if (e.getelement(l, ll).getStatus() == -1 && bottuns[l][ll].getIcon() == bombicon2) {
                                                    int z = 1;

                                                    return;
                                                }
                                            }
                                        }

                                        h.testing(e, i, j, player2, Turn);
                                        if (e.getelement(i, j).getStatus() == -1 && !e.getelement(i, j).isFlag()) {
                                            numMines--;
                                            numberMines.setText(numMines.toString());
                                        }
                                        e.getelement(i, j).setColor(2);
                                        display(e, player2);
                                        if (iswin(e)) {
                                            ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                            saveScoreBoard(sb, player, player2);
                                            try {
                                                out.close();
                                                filee.close();
                                            } catch (Exception eee) {
                                                eee.printStackTrace();
                                            }
                                            assist.delete();
                                            endtime();
                                            JOptionPane.showMessageDialog(null, "Computer Player has won");
                                            endprint(e);
                                            return;

                                        } else if (Turn % 2 == 0) {

                                            for (int l = 0; l < e.getX(); l++) {
                                                for (int ll = 0; ll < e.getY(); ll++) {
                                                    if (e.getelement(l, ll).getStatus() == -1 && bottuns[l][ll].getIcon() == bombicon2) {
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true);

                                                        saveScoreBoard(sb, player, player2);
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        endtime();
                                                        JOptionPane.showMessageDialog(null, "Computer player has lost");
                                                        endprint(e);
                                                        interface2();
                                                        whenloss(e);
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                        Turn++;
                                    }
                                }
                                endtime();
                                time(e, player, player2);
                            }
                            counter--;
                            if (counter <= 0) {
                                timer2.cancel();
                                timer2.purge();

                                if (Turn % 2 == 0) {
                                    attemp2++;
                                } else if (Turn % 2 != 0) {
                                    attemp1++;

                                }

                                Turn++;

                                if (!task.cancel()) {
                                    task.cancel();
                                } else if (!task2.cancel()) {
                                    task2.cancel();
                                }
                                time(e, player, player2);
                            }

                        }

                    };
                    timer2.scheduleAtFixedRate(task2, 0, 1000);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

}
