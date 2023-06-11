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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.ch;
import static pkg1.GUIGame.clickload;
import static pkg1.GUIGame.timerload;

public class ShieldUnderzero extends ShieldTowplayerguiscore {

    public ShieldUnderzero(Initialize e, Score score, JPanel p, Player player, Player player2) {
        super(e, score, p, player, player2);
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
                                            e.CreatArmaors();
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player, Turn);
                                                numshields1 = player.getArmorCount();
                                                numbershields1.setText(numshields1.toString());
                                            }
                                            e.getelement(i, j).setColor(1);
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
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
                                            x++;

                                            if (iswin(e)) {
                                                player.score = (score.addScore(e)) + (score.getLastO() * minesnumbernotclicked(e));
                                                if (player.armorCount > 0) {
                                                    player.score = player.score + (player.armorCount * 50);
                                            
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won,his remaining shields are :" + player.armorCount + "every one will get it 50 point ,His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost, His score is : " + "0");
                                                    endprint(e);
                                                            date2 = new Date();
                                                    scorearray=interface3();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

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
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won, His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost, His score is : " + "0");
                                                    endprint(e);
                                                        date2 = new Date();
                                                    scorearray=interface3();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }

//                                               
                                            }

                                            player.score = score.addScore(e);
                                            Turn++;
                                            c5 = 1;
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
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !(player2.score < 0 || player.score < 0) && !loss(e) && !timeOut) {
                                                if (!timerload) {
                                                    task.cancel();
                                                } else if (!timerload2) {
                                                    task2.cancel();
                                                }
                                                if (Turn % 2 == 0) {
                                                    h.testing(e, i, j, player2, Turn);
                                                    numshields = player2.getArmorCount();
                                                    numbershields.setText(numshields.toString());
                                                    if (e.getelement(i, j).getStatus() == -1 && !iswin(e) && !(player2.score < 0 || player.score < 0) && !loss(e)) {
//
                                                        numMines--;
                                                        if (numMines >= 0) {
                                                            numberMines.setText(numMines.toString());
                                                        }
                                                        player2.setArmorCount(player2.getArmorCount() - 1);

                                                    }
                                                    numshields = player2.getArmorCount();
                                                    if (numshields >= 0) {
                                                        numbershields.setText(numshields.toString());
                                                    }

                                                } else if (Turn % 2 != 0) {
                                                    h.testing(e, i, j, player, Turn);
                                                    if (e.getelement(i, j).getStatus() == -1 && !(player2.score < 0 || player.score < 0) && !loss(e)) {
//
                                                        numMines--;
                                                        if (numMines >= 0) {
                                                            numberMines.setText(numMines.toString());
                                                        }
                                                        player.setArmorCount(player.getArmorCount() - 1);

                                                    }
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

                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.addScore(e, player2) - (player.score + player2.score));
                                                } else {
                                                    player.score = player.score + (score.addScore(e, player) - (player2.score + player.score));
                                                }
                                                if (Turn % 2 == 0) {
                                                    e.getelement(i, j).setColor(2);
                                                    btn2.setBackground(null);
                                                    btn1.setBackground(Color.GREEN);
                                                    display(e, player);
                                                } else if (Turn % 2 != 0) {
                                                    btn1.setBackground(null);
                                                    btn2.setBackground(Color.YELLOW);
                                                    e.getelement(i, j).setColor(1);
                                                    display(e, player);
                                                }

                                                if (!timerload) {
                                                    task.cancel();
                                                } else if (!timerload2) {
                                                    task2.cancel();
                                                }
                                                if (x == 3) {
                                                    timerload = false;
                                                    timerload2 = false;

                                                }
                                                time(e, player, player2);
                                            }

                                            if (player2.score < 0) {

                                                player2.scor = player2.score + newflagsYellow(e, score);
                                                if (player2.scor < 0) {
                                                
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name2 + "has lost, His score is : " + player2.scor + "\nHis regular score is :  " + (player2.scor + score.getB()) + "\nCongratulations," + GUI1.name1 + "has won");
                                                    whenloss(e);
                                                    endprint(e);
                                                        date2 = new Date();
                                                    scorearray=interface3();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }

                                            } else if (player.score < 0) {

                                                player.scor = player.score + newflagGreen(e, score);
                                                if (player.scor < 0) {
                                                 
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    endtime();
                                                    JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost,His score is : " + player.scor + "\nHis regular score is :  " + (player.scor + score.getB()));
                                                    whenloss(e);
                                                    endprint(e);
                                                       date2 = new Date();
                                                    scorearray=interface3();
                                                    ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }

                                            } else if (iswin(e)) {
                                                endtime();
                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                } else if (Turn % 2 != 0) {
                                                    player.score = player.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                }
                                                player2.score += player2.score + newflagsYellow(e, score);
                                                player.score += player.score + newflagGreen(e, score);
                                                if (player.armorCount > 0) {
                                                    player.score = player.score + (player.armorCount * 50);
                                                }
                                                if (player2.armorCount > 0) {
                                                    player.score = player.score + (player.armorCount * 50);
                                                }

                                                if (player.score > player2.score) {
                                                    if (player.armorCount > 0 && player2.armorCount > 0) {

                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score);
                                                        endprint(e);
                                                                                                                date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player.armorCount > 0) {
                                               
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost, His score is : " + player2.score);
                                                        endprint(e);
                                                                 date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player2.armorCount > 0) {
                                                   
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won, His score is : " + player.score + "\nSorry," + +player.score + "\nSorry," + GUI1.name2 + "has lost,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score);
                                                        endprint(e);
                                                             date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

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
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won, His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost, His score is : " + player2.score);
                                                        endprint(e);
                                                             date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    }
                                                } else if (player.score < player2.score) {
                                                    if (player.armorCount > 0 && player2.armorCount > 0) {
                                                   
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score);
                                                        endprint(e);
                                                             date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player.armorCount > 0) {
                                                  
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won ,His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score);
                                                        endprint(e);
                                                              date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player2.armorCount > 0) {
                                                      
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score + "\nSorry," + +player.score + "\nSorry ,His score is : " + player.score);
                                                        endprint(e);
                                                          date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);
                                                        

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else {
                                                        date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won, His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost, His score is : " + player.score);
                                                        endprint(e);
                                                        return;
                                                    }
                                                }

                                            } else if (loss(e)) {
                                                endtime();
                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                } else if (Turn % 2 != 0) {
                                                    player.score = player.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                }
                                                player2.score += newflagsYellow(e, score);
                                                player.score += newflagGreen(e, score);

                                                if (player.armorCount > 0) {
                                                    player.score = player.score + (player.armorCount * 50);
                                                }
                                                if (player2.armorCount > 0) {
                                                    player.score = player.score + (player.armorCount * 50);
                                                }

                                                if (player.score > player2.score) {

                                                    if (player.armorCount > 0 && player2.armorCount > 0) {
                                                      
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                          date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player.armorCount > 0) {
                                                   
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost, His score is : " + player2.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                             date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player2.armorCount > 0) {
                                                   
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won, His score is : " + player.score + "\nSorry," + +player.score + "\nSorry," + GUI1.name2 + "has lost,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                             date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

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
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won, His score is : " + player.score + "\nSorry," + GUI1.name2 + "has lost, His score is : " + player2.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                               date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    }

                                                } else if (player.score < player2.score) {
                                                    if (player.armorCount > 0 && player2.armorCount > 0) {
                                                 
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                               date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player.armorCount > 0) {
                                                     
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won ,His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost,his remaining shields are :" + player.armorCount + " every one will get it 50 point ,His score is : " + player.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                           date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    } else if (player2.armorCount > 0) {
                                                  
                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won,his remaining shields are :" + player2.armorCount + " every one will get it 50 point ,His score is : " + player2.score + "\nSorry," + +player.score + "\nSorry ,His score is : " + player.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                              date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);
                                                        

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
                                                        JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won, His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost, His score is : " + player.score);
                                                        whenloss(e);
                                                        endprint(e);
                                                          date2 = new Date();
                                                        scorearray=interface3();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true,scorearray);
                                                        

                                                        saveScoreBoard(sb, player, player2);
                                                        return;
                                                    }

                                                }
                                            }
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !(player2.score < 0 || player.score < 0) && !loss(e) && !timeOut) {
                                                Turn += 1;
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
                                    if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !(player2.score < 0 || player.score < 0) && !loss(e) && !timeOut) {
                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload2) {
                                            task2.cancel();
                                        }
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
                                        if (Turn % 2 == 0) {
                                            btn2.setBackground(null);
                                            btn1.setBackground(Color.GREEN);
                                            bottuns[i][j].setIcon(flagIcon2);
                                            e.getelement(i, j).setColor(4);
                                        } else {
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
                                            bottuns[i][j].setIcon(flagIcon1);
                                            e.getelement(i, j).setColor(3);

                                        }
                                        Turn += 1;
                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload2) {
                                            task2.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                        }
                                        time(e, player, player2);
                                    } else if (e.getelement(i, j).isFlag() && !iswin(e) && !(player2.score < 0 || player.score < 0) && !loss(e) && !timeOut) {
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
                                        if (Turn % 2 == 0) {
                                            btn2.setBackground(null);
                                            btn1.setBackground(Color.GREEN);
                                            e.getelement(i, j).setColor(0);

                                        } else {
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
                                            e.getelement(i, j).setColor(0);

                                        }
                                        Turn += 1;
                                        if (!timerload) {
                                            task.cancel();
                                        } else if (!timerload2) {
                                            task2.cancel();
                                        }
                                        if (x == 2) {
                                            timerload = false;
                                            timerload2 = false;

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

//    @Override
//    public void reset() {
//        player2.setFlagScore(0);
//        player2.setScor(0);
//        player2.setScore(0);
//    }
}
