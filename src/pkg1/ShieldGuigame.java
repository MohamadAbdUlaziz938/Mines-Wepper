package pkg1;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
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
import static pkg1.GUIGame.clickload;
import static pkg1.GUIGame.timerload;
import static pkg1.GUIGame.x;

public class ShieldGuigame extends GUIGame implements ActionListener {

    Click h = new Click();
    Integer numMines = Integer.parseInt(GUI1.mines);
    JLabel numberMines = new JLabel("1", JLabel.CENTER);
    JButton mines = new JButton();
    ImageIcon minsIcon1 = new ImageIcon("E:\\Mines12.png");
    ImageIcon armorIcon = new ImageIcon("E:\\armor15.png");

    Integer numshields;
    JLabel numbershields = new JLabel("");
    JButton shields = new JButton();
    ImageIcon shieldIcon = new ImageIcon("E:\\armor.png");
    JLabel viewTimer = new JLabel("0");
    JButton timer1 = new JButton();

    ImageIcon timerIcon = new ImageIcon("E:\\timer.png");

    ShieldGuigame(Initialize e, Score score, JPanel SinglePlayerPage, Player player, Player player2) {

        super(e, score, SinglePlayerPage, player, player2);
        SinglePlayerPage.add(timer1);
        SinglePlayerPage.add(viewTimer);

        SinglePlayerPage.add(numberMines);
        SinglePlayerPage.add(mines);
        SinglePlayerPage.add(numbershields);
        SinglePlayerPage.add(shields);
        numberMines.setBounds(333, 100, 150, 30);
        numberMines.setText(numMines.toString());
        numberMines.setFont(new Font("Arial", Font.BOLD, 30));
        mines.setIcon(minsIcon1);
        mines.setBackground(Color.LIGHT_GRAY);
        mines.setBounds(380, 30, minsIcon1.getIconWidth(), minsIcon1.getIconHeight());
        shields.setIcon(shieldIcon);
        shields.setBackground(Color.LIGHT_GRAY);
        shields.setBounds(300, 30, shieldIcon.getIconWidth(), shieldIcon.getIconHeight());
        numbershields.setBounds(333, 100, 150, 30);
        numbershields.setText("" + player.getArmorCount());
        numbershields.setFont(new Font("Arial", Font.BOLD, 30));

        timer1.setIcon(timerIcon);
        timer1.setBackground(Color.LIGHT_GRAY);
        timer1.setBounds(675, 30, timerIcon.getIconWidth(), timerIcon.getIconHeight());
        viewTimer.setBounds(700, 100, 150, 30);

        viewTimer.setFont(new Font("Arial", Font.BOLD, 30));

        gamePage_PlayerName1.setBounds(0, 40, 150, 30);

    }

    @Override
    public void display(Initialize e, Player player) {
        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked()) {
                    if (e.getelement(i, j).getStatus() == -1) {

                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(minsIcon);

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
                                            display(e, player);
                                            ffile = new StoreFile(e, player);

                                            try {
                                                out1.writeObject(ffile);
                                                out1.close();
                                                filee1.close();
                                                save();
                                            } catch (Exception es) {
                                                es.printStackTrace();
                                            }
                                            if (iswin(e)) {
                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                JOptionPane.showMessageDialog(null, "Congratulations,You have won");
                                                whenloss(e);
                                                endprint(e);
                                                interface2();
                                                return;

                                            }

                                            x++;
                                            s3 = 1;
                                            time(e);
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
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !timeOut) {
                                                if (!timerload) {
                                                    task.cancel();
                                                }

                                                h.testing(e, i, j, player);
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
                                                    ee.printStackTrace();
                                                }
                                                display(e, player);

                                                if (!timerload) {
                                                    task.cancel();
                                                }
                                                if (x == 3) {
                                                    timerload = false;
                                                }
                                                time(e);
                                            }

                                            if (e.getelement(i, j).getStatus() == -1 && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !timeOut) {

                                                numMines--;
                                                if (numMines >= 0) {
                                                    numberMines.setText(numMines.toString());
                                                }

                                            }

                                            if (iswin(e)) {
                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                task.cancel();
                                                JOptionPane.showMessageDialog(null, "Congratulations,You have won");
                                                whenloss(e);
                                                endprint(e);
                                                interface2();
                                                return;
                                            } else if (isLosss(e, i, j, player)) {
                                                try {

                                                    out.close();
                                                    filee.close();

                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                task.cancel();
                                                JOptionPane.showMessageDialog(null, "Sorry,You have failed");
                                                whenloss(e);
                                                endprint(e);
                                                interface2();

                                                return;
                                            }
//                                            else if (iswin1(e))
//                {}

                                            numshields = player.getArmorCount();
                                            if (numshields >= 0) {
                                                numbershields.setText(numshields.toString());
                                            }

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
                                    if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss1(e, player) && !timeOut) {
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
                                            ee.printStackTrace();
                                        }
                                        //if(!a)
                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                        }
                                        time(e);
                                    } else if (e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !timeOut) {
                                        if (!timerload) {
                                            task.cancel();
                                        }

                                        bottuns[i][j].setIcon(null);
                                        h.FLAG(e, i, j);
                                        //if(!a)
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
                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                        }
                                        time(e);
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
                //  b.setBackground(Color.WHITE);

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                 if(b.isEnabled())   
//              b.setBackground(Color.darkGray);
            }

        }
        );
//        gamePage_restart.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e1) {
//                restar(e,score);
//            }
//        });

    }

    @Override

    public void ApplyGame(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean iswin(Initialize e) {
        if (Click.count == e.getX() * e.getY() - e.getMinsNum() - 1) {
//            Click.count = 0;
            return true;
        }
        return false;
    }

    public boolean isLosss(Initialize e, int i, int j, Player player) {
        if (e.getelement(i, j).isClicked() && e.getelement(i, j).getStatus() == -1) {
            if (player.getArmorCount() > 0) {
                player.setArmorCount(player.getArmorCount() - 1);

//                  numbershields.setText(""+player.armorCount);
//                if (player.getArmorCount() != 0) {
//                    JOptionPane.showMessageDialog(null, "Attention,Number of your shields is : " + player.getArmorCount());
//                } else {
//                    JOptionPane.showMessageDialog(null, "Attention,You're no longer have any shield");
//                }
                return false;
            } else if (player.getArmorCount() == 0) {
                player.setArmorCount(player.getArmorCount() - 1);

                return true;
            }
        }
        return false;

    }

    public boolean isLosss1(Initialize e, Player player) {

        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked() && e.getelement(i, j).getStatus() == -1 && player.getArmorCount() == -1) {
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void time(Initialize e) {
        counter = Integer.parseInt(GUI1.time);
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("counter" + counter);
                viewTimer.setText(counter.toString());
                counter--;
                if (counter <= 0) {
                 
                    timer.cancel();
                    timeOut = true;
                    JOptionPane.showMessageDialog(null, "Sorry,You have lost , You have run out of your time");
                    whenloss(e);
                    endprint(e);
////////////
//                    date2 = new Date();
//                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2);
//                    saveScoreBoard(sb, player, player2);
                    try {
                        out.close();
                        filee.close();
                    } catch (Exception eee) {
                        eee.printStackTrace();
                    }

                    assist.delete();
                    interface2();
////////////
                    Turn++;
                    a = true;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

}
