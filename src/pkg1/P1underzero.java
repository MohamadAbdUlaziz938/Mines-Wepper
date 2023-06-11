package pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.clickload;
import static pkg1.GUIGame.x;

public class P1underzero extends GUIGame {

    Integer numMines = Integer.parseInt(GUI1.mines);
    JLabel numberMines = new JLabel("1", JLabel.CENTER);
    JButton mines = new JButton();
    ImageIcon minsIcon1 = new ImageIcon("E:\\Mines12.png");
    FileInputStream incount;
    ObjectInputStream opcount;
    int adad;
     
    public P1underzero(Initialize e, Score score, JPanel p, Player player, Player player2) {
        super(e, score, p, player, player2);
        p.add(numberMines);
        p.add(mines);
        numberMines.setBounds(333, 100, 150, 30);
        numberMines.setText(numMines.toString());
        numberMines.setFont(new Font("Arial", Font.BOLD, 30));

        mines.setIcon(minsIcon1);
        mines.setBackground(Color.LIGHT_GRAY);
        mines.setBounds(380, 30, minsIcon1.getIconWidth(), minsIcon1.getIconHeight());
        gamePage_PlayerName1.setBounds(0, 40, 150, 30);

    }

    @Override
    public void display(Initialize e, Player player) {
        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked()) {
                    if (e.getelement(i, j).getStatus() == -1) {
                        bottuns[i][j].setBackground(Color.WHITE);

                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(minsIcon);
                        if (player.score < 10 && !isLosss(e)) {
                            JOptionPane.showMessageDialog(null, "Attention!: your score is under zero: " + player.score);
                        }

                        return;

                    } else if (e.getelement(i, j).getStatus() == 0) {
                        bottuns[i][j].setBackground(Color.WHITE);
                        bottuns[i][j].setEnabled(false);
                    } else {
                        bottuns[i][j].setBackground(Color.WHITE);
                        bottuns[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                        bottuns[i][j].setForeground(Color.BLACK);
                        bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                        bottuns[i][j].setEnabled(false);
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

                                            date = new Date();
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
                                            e.puzzle();

                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player);
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
                                                date2 = new Date();
                                   

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
                                                    scorearray=interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                return;
                                            }
                                            x++;
                                            s2 = 1;
                                            player.score = score.addScore(e);

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

                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !(player.score < 0) && !loss(e)) {
                                                h.testing(e, i, j, player);

                                                if (e.getelement(i, j).getStatus() == -1 && !e.getelement(i, j).isFlag()) {

                                                    numMines--;
                                                    numberMines.setText(numMines.toString());

                                                }
                                                player.score = (score.addScore(e));
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
                                                    JOptionPane.showMessageDialog(null, "Sorry,You have lost, Your score is : " + player.score);
                                                    whenloss(e);
                                                    endprint(e);
                                                   scorearray=interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    
                                                    
                                                    return;
                                                }
                                            } else if (iswin(e)) {
                                                player.score = (score.addScore(e)) + score.getLastO() * minesnumbernotclicked(e) + score.addFlagScore(e);
                                                date2 = new Date();
                                              
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
                                                    scorearray=interface3();
                                                  
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                return;
                                            } else if (loss(e)) {
                                                player.score = player.score + score.addFlagScore(e);
                                                if (player.score > 0) {
                                                    date2 = new Date();
                                                    scorearray=interface3();
                          ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your score is  : " + player.score);
                                                } else {
                                                    
                                                 
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    JOptionPane.showMessageDialog(null, "Sorry,You have lost,Your score is  : " + player.score);
                                                }
                                                assist.delete();
                                                whenloss(e);
                                                endprint(e);
                                                    scorearray=interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);

                                                return;

                                            } else if (iswin1(e)) {
                                                player.score = player.score + score.addFlagScore(e);
                                                if (player.score > 0) {
                                                    date2 = new Date();
                                                    scorearray=interface3();
                                                   ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your score is  : " + player.score);
                                                } else {
                                                    date2 = new Date();
                                                    scorearray=interface3();
                                                     ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    JOptionPane.showMessageDialog(null, "Sorry,You have lost,Your score is  : " + player.score);
                                                }
                                                assist.delete();

                                                whenloss(e);
                                                endprint(e);

                                                return;
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

                                    if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !(player.score < 0) && !loss(e)) {
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

                                    } else if (e.getelement(i, j).isFlag() && !iswin(e) && !(player.score < 0) && !loss(e)) {
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

                                    } else if (iswin1(e)) {
                                        player.score = player.score + score.addFlagScore(e);
                                        if (player.score > 0) {
                                            try {
                                                out.close();
                                                filee.close();
                                            } catch (Exception eee) {
                                                eee.printStackTrace();
                                            }
                                            JOptionPane.showMessageDialog(null, "Congratulation,You have won,Your score is  : " + player.score);
                                        } else {
                                            try {
                                                out.close();
                                                filee.close();
                                            } catch (Exception eee) {
                                                eee.printStackTrace();
                                            }
                                            JOptionPane.showMessageDialog(null, "Sorry,You have lost,Your score is  : " + player.score);
                                        }
                                        assist.delete();

                                        whenloss(e);
                                        endprint(e);
                                          scorearray=interface3();
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2,size,false,scorearray);
                                                    saveScoreBoard(sb, player, player2);

                                        return;
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

}
