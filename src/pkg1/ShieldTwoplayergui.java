package pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.clickload;
import static pkg1.GUIGame.timerload;
import static pkg1.GUIGame.x;

public class ShieldTwoplayergui extends GUIGame {
//Player player2;

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    Integer numMines = Integer.parseInt(GUI1.mines);
    JLabel numberMines = new JLabel("1", JLabel.CENTER);
    JButton mines = new JButton();
    ImageIcon minsIcon1 = new ImageIcon("E:\\Mines12.png");
    ImageIcon armorIcon = new ImageIcon("E:\\armor15.png");

    JLabel numbershields = new JLabel("");
    JButton shields = new JButton();
    ImageIcon shieldIcon = new ImageIcon("E:\\armor12.png");

    Integer numshields1;
    JLabel numbershields1 = new JLabel("");
    JButton shields1 = new JButton();
    ImageIcon shieldIcon1 = new ImageIcon("E:\\armor.png");
    JLabel viewTimer = new JLabel("0");
    JButton timer1 = new JButton();
    ImageIcon timerIcon = new ImageIcon("E:\\timer.png");

    public ShieldTwoplayergui(Initialize e, Score score, JPanel p, Player player, Player player2) {
        super(e, score, p, player, player2);

        gamePage_PlayerName1.setBounds(50, 60, 150, 30);
        gamePage_PlayerName1.setText(player.name);
        gamePage_PlayerName2.setBounds(600, 60, 150, 30);
        gamePage_PlayerName2.setText(player2.name);
        gamePage_PlayerName2.setFont(new Font("Arial", Font.BOLD, 25));
        p.add(numbershields);
        p.add(shields);
        p.add(numbershields1);
        p.add(shields1);
        p.add(btn1);
        p.add(btn2);
        p.add(timer1);
        p.add(viewTimer);

        btn1.setBounds(190, 60, 25, 25);
        btn2.setBounds(570, 60, 25, 25);
        btn1.setEnabled(false);
        btn1.setBackground(Color.GREEN);
        btn2.setEnabled(false);
        btn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        btn2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        p.add(numberMines);
        p.add(mines);
        numberMines.setBounds(333, 100, 150, 30);
        numberMines.setText(numMines.toString());
        numberMines.setFont(new Font("Arial", Font.BOLD, 30));

        mines.setIcon(minsIcon1);
        mines.setBackground(Color.LIGHT_GRAY);
        mines.setBounds(380, 30, minsIcon1.getIconWidth(), minsIcon1.getIconHeight());

        shields.setIcon(shieldIcon);
        shields.setBackground(Color.LIGHT_GRAY);
        shields.setBounds(300, 30, shieldIcon.getIconWidth(), shieldIcon.getIconHeight());
        numbershields.setBounds(470, 100, 150, 30);
        numbershields.setText("" + player2.getArmorCount());
        numbershields.setFont(new Font("Arial", Font.BOLD, 30));

        shields1.setIcon(shieldIcon1);
        shields1.setBackground(Color.LIGHT_GRAY);
        shields1.setBounds(457, 30, shieldIcon.getIconWidth(), shieldIcon.getIconHeight());
        numbershields1.setBounds(333, 100, 150, 30);
        numbershields1.setText("" + player.getArmorCount());
        numbershields1.setFont(new Font("Arial", Font.BOLD, 30));

        timer1.setIcon(timerIcon);
        timer1.setBackground(Color.LIGHT_GRAY);
        timer1.setBounds(40, 130, timerIcon.getIconWidth(), timerIcon.getIconHeight());
        viewTimer.setBounds(60, 195, 150, 30);

        viewTimer.setFont(new Font("Arial", Font.BOLD, 30));
        if (x != 0) {
            if (Turn % 2 == 0) {

                btn1.setBackground(Color.GREEN);
                btn2.setBackground(null);

            } else if (Turn % 2 != 0) {

                btn1.setBackground(null);
                btn2.setBackground(Color.YELLOW);

            }
        }
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

                        } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != bombicon2) {
                            bottuns[i][j].setBackground(Color.GREEN);
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(bombicon1);

                        }
                    } else if (e.getelement(i, j).getStatus() == 0) {
                        if (e.getelement(i, j).isArmor()) {
                            if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getIcon() != armorIcon) {
                                bottuns[i][j].setIcon(armorIcon);
                                bottuns[i][j].setBackground(Color.YELLOW);
                                bottuns[i][j].setEnabled(false);
                                if (e.getelement(i, j).getStatus() > 0) {
                                    bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                                }

                            } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != armorIcon) {
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
                            bottuns[i][j].setEnabled(false);

                        }
                    } else {
                        if (e.getelement(i, j).isArmor()) {
                            if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getIcon() != armorIcon) {
                                bottuns[i][j].setBackground(Color.YELLOW);
                                bottuns[i][j].setEnabled(false);
                                bottuns[i][j].setIcon(armorIcon);

                            } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != armorIcon) {
                                bottuns[i][j].setBackground(Color.GREEN);
                                bottuns[i][j].setEnabled(false);
                                bottuns[i][j].setIcon(armorIcon);
                            }
                        } else {
                            if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getBackground() != Color.GREEN) {
                                btn2.setBackground(null);
                                btn1.setBackground(Color.GREEN);
                                bottuns[i][j].setBackground(Color.YELLOW);
                            } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getBackground() != Color.YELLOW) {
                                bottuns[i][j].setBackground(Color.GREEN);
                            }

                        }
                        bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                        bottuns[i][j].setEnabled(false);
                    }
                } else if (e.getelement(i, j).isFlag()) {
                    if (e.getelement(i, j).getColor() == 4) {
                        bottuns[i][j].setIcon(flagIcon2);
                    } else if (e.getelement(i, j).getColor() == 3) {
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

                            for (int i = 0; i < bottuns.length; i++) {
                                for (int j = 0; j < bottuns[0].length; j++) {
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

                                            e.getelement(i, j).setClicked(true);
                                            e.getelement(i, j).setScan(true);
                                            e.CreatMines();
                                            e.CreatArmaors();
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player, Turn);
                                                numshields1 = player.getArmorCount();
                                                numbershields1.setText(numshields1.toString());
                                            }
                                            e.getelement(i, j).setColor(1);
                                            ffile = new StoreFile(e, player, player2);

                                            try {
                                                out1.writeObject(ffile);
                                                out1.close();
                                                filee1.close();
                                                save();
                                            } catch (Exception es) {
                                                es.printStackTrace();
                                            }
                                            display(e, player);
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
                                            if (iswin(e)) {
                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won" + "\nSorry," + GUI1.name2 + "has lost");
                                                endprint(e);
                                                interface2();
                                                return;
                                            }
                                            x++;
                                            c4 = 1;
                                            Turn += 1;
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

                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {

                                                if (!timerload) {
                                                    task.cancel();
                                                } else if (!timerload2) {
                                                    task2.cancel();
                                                }

                                                if (Turn % 2 == 0) {
                                                    h.testing(e, i, j, player2, Turn);
                                                    numshields = player2.getArmorCount();
                                                    if (numshields >= 0) {
                                                        numbershields.setText(numshields.toString());

                                                    }

                                                } else if (Turn % 2 != 0) {
                                                    h.testing(e, i, j, player, Turn);
                                                    numshields1 = player.getArmorCount();
                                                    if (numshields1 >= 0) {
                                                        numbershields1.setText(numshields1.toString());
                                                    }

                                                }
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

                                                time(e);
                                            }
                                            if (e.getelement(i, j).getStatus() == -1 && !e.getelement(i, j).isFlag() && numMines >= 0 && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {
                                                numMines--;
                                                if (numMines >= 0) {
                                                    numberMines.setText(numMines.toString());
                                                }

                                            }

                                            if (Turn % 2 == 0) {
                                                e.getelement(i, j).setColor(2);
                                                display(e, player2);
                                                if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {

                                                    btn2.setBackground(null);
                                                  btn1.setBackground(Color.GREEN);

                                                }
                                            } else if (Turn % 2 != 0) {
                                                e.getelement(i, j).setColor(1);
                                                display(e, player);
                                                if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {

                                                    btn1.setBackground(null);
                                                    btn2.setBackground(Color.YELLOW);
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
                                                if (Turn % 2 == 0) {
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won" + "\nSorry," + GUI1.name1 + "has lost");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                } else if (Turn % 2 != 0) {
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won " + "\nSorry," + GUI1.name2 + "has lost");
                                                    endprint(e);
                                                    interface2();

                                                    return;
                                                }

                                            } else if (Turn % 2 == 0) {

                                                if (isLosss(e, i, j, player2)) {
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name2 + "has lost " + "\nCongratulations," + GUI1.name1 + "has won");
                                                    whenloss(e);
                                                    endprint(e);
                                                    interface2();

                                                    return;
                                                }
                                                numshields = player2.getArmorCount();
                                                if (numshields >= 0) {
                                                    numbershields.setText(numshields.toString());
                                                }
                                            } else if (Turn % 2 != 0) {

                                                if (isLosss(e, i, j, player)) {
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost " + "\nCongratulations," + GUI1.name2 + "has won");
                                                    whenloss(e);

                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }
                                                numshields1 = player.getArmorCount();
                                                if (numshields1 >= 0) {
                                                    numbershields1.setText(numshields1.toString());
                                                }

                                            }

                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {
                                                Turn++;
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

                                    if (Turn % 2 == 0 && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {
                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload2) {
                                            task2.cancel();
                                        }
                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload2) {
                                            task2.cancel();
                                        }

                                        btn2.setBackground(null);
                                        btn1.setBackground(Color.GREEN);
                                        if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2)) {
                                            bottuns[i][j].setIcon(flagIcon2);
                                            e.getelement(i, j).setColor(4);
                                            h.FLAG(e, i, j);
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
                                            e.getelement(i, j).setColor(0);
                                            Turn += 1;

                                        }

                                        if (!timerload) {
                                            task.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                        } else if (!timerload) {
                                            task2.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                        }
                                        time(e);
                                    } else if (Turn % 2 != 0 && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2) && !timeOut) {

                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload) {
                                            task2.cancel();
                                        }

                                        btn1.setBackground(null);
                                        btn2.setBackground(Color.YELLOW);
                                        if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss1(e, player) && !isLosss1(e, player2)) {
                                            bottuns[i][j].setIcon(flagIcon1);
                                            h.FLAG(e, i, j);
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
                                            e.getelement(i, j).setColor(3);
                                            Turn += 1;
                                        } else if (e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                            bottuns[i][j].setIcon(null);
                                            h.FLAG(e, i, j);
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
                                            e.getelement(i, j).setColor(0);
                                            Turn += 1;
                                        }

                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload2) {
                                            task2.cancel();
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
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        }
        );

    }

    public boolean isLosss(Initialize e, int i, int j, Player player) {
        if (e.getelement(i, j).isClicked() && e.getelement(i, j).getStatus() == -1) {
            if (player.getArmorCount() > 0) {
                player.setArmorCount(player.getArmorCount() - 1);

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
    public void whenloss(Initialize e) {

        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).getStatus() == -1) {

                    if (Turn % 2 == 0 && bottuns[i][j].getIcon() != bombicon1) {
                        bottuns[i][j].setIcon(bombicon2);
                        if (e.getelement(i, j).isFlag() && bottuns[i][j].getIcon() != flagIcon1) {
                            bottuns[i][j].setIcon(flagmine);
                        }

                        bottuns[i][j].setBackground(Color.YELLOW);
                        bottuns[i][j].setEnabled(false);
                        btn1.setBackground(Color.GREEN);
                        btn2.setBackground(null);

                    } else if (Turn % 2 != 0 && bottuns[i][j].getIcon() != bombicon2) {
                        bottuns[i][j].setIcon(bombicon1);
                        if (e.getelement(i, j).isFlag() && bottuns[i][j].getIcon() != flagIcon2) {
                            bottuns[i][j].setIcon(flagmine);
                        }

                        bottuns[i][j].setBackground(Color.GREEN);
                        bottuns[i][j].setEnabled(false);
                        btn1.setBackground(null);
                        btn2.setBackground(Color.YELLOW);
                    }

                }
            }
        }
    }

    @Override
    public void time(Initialize e) {

        if (attemp1 == 2) {
            try {
                out.close();
                filee.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }
            assist.delete();
            task.cancel();
            timeOut = true;
            JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost " + "\nCongratulations," + GUI1.name2 + "has won" + "\nBecause " + GUI1.name1 + "has lost a lot of time");
            interface2();
            endprint(e);
            return;

        } else if (attemp2 == 2) {
             try {
                out.close();
                filee.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }
            assist.delete();
            task.cancel();
            timeOut = true;
            JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name2 + "has lost " + "\nCongratulations," + GUI1.name1 + "has won" + "\nBecause " + GUI1.name2 + "has lost a lot of time");
            interface2();
            endprint(e);
            return;

        }
        counter = Integer.parseInt(GUI1.time);

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                viewTimer.setText(counter.toString());

                System.out.println("counter  " + counter);

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
                    if (Turn % 2 == 0) {
                        btn2.setBackground(Color.YELLOW);
                        btn1.setBackground(null);

                    } else if (Turn % 2 != 0) {
                        btn1.setBackground(Color.GREEN);
                        btn2.setBackground(null);

                    }

                    a = true;
                    counter = Integer.parseInt(GUI1.time);

                    if (attemp1 == 2) {
                        try {
                out.close();
                filee.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }
                        task.cancel();
                      timeOut = true;
                        JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost " + "\nCongratulations," + GUI1.name2 + "has won" + "\nBecause " + GUI1.name1 + "has lost a lot of time");
                        interface2();
                        endprint(e);
                        return;

                    } else if (attemp2 == 2) {
                        try {
                out.close();
                filee.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }
                        task.cancel();
                        timeOut = true;
                        JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name2 + "has lost " + "\nCongratulations," + GUI1.name1 + "has won" + "\nBecause " + GUI1.name2 + "has lost a lot of time");
                        interface2();
                        endprint(e);
                        return;

                    }
                    timer2 = new Timer();
                    task2 = new TimerTask() {

                        @Override
                        public void run() {

                            System.out.println("counter2  " + counter);
                            viewTimer.setText(counter.toString());
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
                                if (Turn % 2 == 0) {
                                    btn2.setBackground(Color.YELLOW);
                                    btn1.setBackground(null);
                                } else if (Turn % 2 != 0) {
                                    btn1.setBackground(Color.GREEN);
                                    btn2.setBackground(null);
                                }

                                if (!task.cancel()) {
                                    task.cancel();
                                } else if (!task2.cancel()) {
                                    task2.cancel();
                                }
                                time(e);
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
