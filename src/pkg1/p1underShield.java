package pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.ch;
import static pkg1.GUIGame.clickload;
import static pkg1.GUIGame.counter;
import static pkg1.GUIGame.timerload;
import static pkg1.GUIGame.x;

public class p1underShield extends ShieldGuigame {

    public p1underShield(Initialize e, Score score, JPanel p, Player player, Player player2) {
        super(e, score, p, player, player2);

    }

    @Override
    public void display(Initialize e, Player player) {

        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked()) {
                    if (e.getelement(i, j).getStatus() == -1) {

                        bottuns[i][j].setBackground(Color.WHITE);
                        bottuns[i][j].setIcon(minsIcon);
                        bottuns[i][j].setEnabled(false);
                        if (player.score < 10 && player.score > 0) {
                            JOptionPane.showMessageDialog(null, "Attention!: your score is under zero: " + player.score);
                            return;
                        }

                    } else if (e.getelement(i, j).getStatus() == 0) {
                        if (e.getelement(i, j).isArmor()) {

                            bottuns[i][j].setIcon(armorIcon);
                            bottuns[i][j].setBackground(Color.WHITE);
                            bottuns[i][j].setEnabled(false);
                            if (e.getelement(i, j).getStatus() > 0) {
                                bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                            }

                        } else {
                            bottuns[i][j].setBackground(Color.WHITE);
                            bottuns[i][j].setEnabled(false);
                        }

                    } else {
                        if (e.getelement(i, j).isArmor()) {
                            bottuns[i][j].setIcon(armorIcon);
                            bottuns[i][j].setBackground(Color.WHITE);
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());

                        } else {
                            bottuns[i][j].setBackground(Color.WHITE);
                            bottuns[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                            bottuns[i][j].setForeground(Color.BLACK);
                            bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                            bottuns[i][j].setEnabled(false);
                        }

                    }
                } else if (e.getelement(i, j).isFlag()) {
                    bottuns[i][j].setIcon(flagIcon);
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
                                    if (event.getSource().equals(bottuns[i][j])) {
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
                                            player.setClickCount(player.getClickCount() + 1);
                                            e.getelement(i, j).setClicked(true);
                                            e.getelement(i, j).setScan(true);
                                            e.CreatMines();
                                            e.CreatArmaors();
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player);
                                                numshields = player.getArmorCount();
                                                numbershields.setText(numshields.toString());
                                            }
                                            ffile = new StoreFile(e, player);

                                            try {
                                                out1.writeObject(ffile);
                                                out1.close();
                                                filee1.close();
                                                save();
                                            } catch (Exception es) {
                                                es.printStackTrace();
                                            }
                                            display(e, player);
                                            if (iswin(e)) {

                                                player.scor = (score.addScore(e)) + (score.getLastO() * minesnumbernotclicked(e));

                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your score is  : " + player.scor);
                                                whenloss(e);
                                                endprint(e);
                                                scorearray = interface3();
                                                date2 = new Date();
                                                ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                saveScoreBoard(sb, player, player2);

                                                return;

                                            }
                                            x++;
                                            s4 = 1;
                                            player.score = score.addScore(e);
                                            time(e, player, player2);

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
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !(player.score < 0) && !loss(e) && !timeOut) {
                                                if (!timerload) {
                                                    task.cancel();
                                                }
                                                h.testing(e, i, j, player);
                                                numshields = player.getArmorCount();
                                                numbershields.setText(numshields.toString());
                                                if (e.getelement(i, j).getStatus() == -1 && !e.getelement(i, j).isFlag() && !(player.score < 0) && !loss(e)) {

                                                    numMines--;
                                                    if (numMines >= 0) {
                                                        numberMines.setText(numMines.toString());
                                                    }
                                                    player.setArmorCount(player.getArmorCount() - 1);

                                                }
                                                player.score = (score.addScore(e, player));
                                                numshields = player.getArmorCount();
                                                if (numshields >= 0) {
                                                    numbershields.setText(numshields.toString());
                                                }
                                                try {
                                                    filee1 = new FileOutputStream(assist);
                                                    out1 = new ObjectOutputStream(filee1);
                                                    ffile = new StoreFile(e, player);
                                                    out1.writeObject(ffile);
                                                    out1.close();
                                                    filee1.close();
                                                    save();
                                                } catch (Exception ee) {
                                                }

                                                display(e, player);
                                                if (!timerload) {
                                                    task.cancel();
                                                }
                                                if (x == 3) {
                                                    timerload = false;
                                                }
                                                time(e, player, player2);
                                            }

                                            if (player.score < 0) {
                                                player.score = player.score + score.addFlagScore(e);
                                                if (player.score < 0) {

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }

                                                    assist.delete();
                                                    task.cancel();
                                                    JOptionPane.showMessageDialog(null, "Sorry,You have lost, Your score is : " + player.score);
                                                    whenloss(e);
                                                    endprint(e);
                                                    scorearray = interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }

                                            } else if (iswin(e)) {
                                                player.score = (score.addScore(e, player)) + score.getLastO() * minesnumbernotclicked(e) + score.addFlagScore(e);
                                                if (player.armorCount > 0) {
                                                    player.score = player.score + (player.armorCount * 50);

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }

                                                    assist.delete();
                                                    task.cancel();
                                                    JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your remaining shields  are " + player.armorCount + "shield" + "\neach one you will get it 50 point so that your score is " + player.score);
                                                    whenloss(e);
                                                    endprint(e);
                                                    scorearray = interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }

                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }

                                                assist.delete();
                                                task.cancel();
                                                JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your score is  : " + player.score);
                                                whenloss(e);
                                                endprint(e);
                                                scorearray = interface3();
                                                date2 = new Date();
                                                ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                saveScoreBoard(sb, player, player2);
                                                return;
                                            } else if (loss(e)) {
                                                player.score = player.score + score.addFlagScore(e);
                                                if (player.score > 0) {
                                                    if (player.armorCount > 0) {
                                                        player.score = player.score + (player.armorCount * 50);

                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }

                                                        assist.delete();
                                                        task.cancel();
                                                        JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your remaining shields  are " + player.armorCount + "shield" + "\neach one you will get it 50 point so that your score is " + player.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                        scorearray = interface3();
                                                        date2 = new Date();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                        saveScoreBoard(sb, player, player2);
                                                        return;

                                                    }

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }

                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your score is  : " + player.score);
                                                    whenloss(e);
                                                    endprint(e);
                                                    scorearray = interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                } else {

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }

                                                    assist.delete();
                                                    task.cancel();
                                                    JOptionPane.showMessageDialog(null, "Sorry,You have lost,Your score is  : " + player.score);
                                                    whenloss(e);
                                                    endprint(e);
                                                    scorearray = interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }
                                            }
//                                            else if(iswin1(e))
//                                            {}
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

                                if (x > 1) {
                                    if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !(player.score < 0) && !loss(e) && !timeOut) {
                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        bottuns[i][j].setIcon(flagIcon);
                                        h.FLAG(e, i, j);

                                        try {
                                            filee1 = new FileOutputStream(assist);
                                            out1 = new ObjectOutputStream(filee1);
                                            ffile = new StoreFile(e, player);
                                            out1.writeObject(ffile);
                                            out1.close();
                                            filee1.close();
                                            save();
                                        } catch (Exception ee) {
                                        }
                                        //if (!a) 
                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                        }
                                        time(e, player, player2);

                                    } else if (e.getelement(i, j).isFlag() && !iswin(e) && !(player.score < 0) && !loss(e) && !timeOut) {
                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        bottuns[i][j].setIcon(null);
                                        h.FLAG(e, i, j);
                                        try {
                                            filee1 = new FileOutputStream(assist);
                                            out1 = new ObjectOutputStream(filee1);
                                            ffile = new StoreFile(e, player);
                                            out1.writeObject(ffile);
                                            out1.close();
                                            filee1.close();
                                            save();
                                        } catch (Exception ee) {
                                        }
                                        //if (!a)
                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
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
                //        b.setBackground(Color.WHITE);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                //  b.setBackground(Color.darkGray);
            }

        }
        );

    }

    public int minesnumbernotclicked(Initialize e) {
        int count = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (!e.getelement(i, j).isClicked()) {
                    if (!e.getelement(i, j).isFlag()) {
                        if (e.getelement(i, j).getStatus() == -1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;

    }

    @Override
    public boolean isLosss(Initialize e, int i, int j, Player player) {
        if (e.getelement(i, j).isClicked() && e.getelement(i, j).getStatus() == -1) {
            if (player.getArmorCount() > 0) {
//                player.setArmorCount(player.getArmorCount() - 1);
                if (player.getArmorCount() != 0) {
                    JOptionPane.showMessageDialog(null, "Attention,Number of your shields is : " + player.getArmorCount());
                } else {
                    JOptionPane.showMessageDialog(null, "Attention,You're no longer have any shield");
                }

                return false;
            } else if (player.getArmorCount() == 0) {
                player.setArmorCount(player.getArmorCount() - 1);

                return true;
            }
        }
        return false;

    }

    @Override
    public void time(Initialize e, Player player, Player player2) {
        counter = Integer.parseInt(GUI1.time);
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

                viewTimer.setText(counter.toString());
                counter--;
                if (counter <= 0) {

                    timer.cancel();
                    timeOut = true;
                    JOptionPane.showMessageDialog(null, "Sorry,You have lost , You have run out of your time");
                    whenloss(e);
                    endprint(e);
                    try {
                        out.close();
                        filee.close();
                    } catch (Exception eee) {
                        eee.printStackTrace();
                    }

                    assist.delete();
                    date2 = new Date();
                    scorearray = interface3();
                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false, scorearray);

                    saveScoreBoard(sb, player, player2);
////////////
                    Turn++;
                    a = true;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

}
