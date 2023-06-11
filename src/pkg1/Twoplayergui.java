package pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.clickload;

public class Twoplayergui extends GUIGame {

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();

    public Twoplayergui(Initialize e, Score score, JPanel p, Player player, Player player2) {
        super(e, score, p, player, player2);
        gamePage_PlayerName1.setBounds(50, 60, 150, 30);
        gamePage_PlayerName1.setText(player.name);
        gamePage_PlayerName2.setBounds(600, 60, 150, 30);
        gamePage_PlayerName2.setText(player2.name);
        gamePage_PlayerName2.setFont(new Font("Arial", Font.BOLD, 25));
        p.add(btn1);
        p.add(btn2);
        btn1.setBounds(190, 60, 25, 25);
        btn2.setBounds(570, 60, 25, 25);
        btn1.setEnabled(false);
        btn1.setBackground(Color.GREEN);
        btn2.setEnabled(false);
        btn1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        btn2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
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

                        whenloss(e);

                    } else if (e.getelement(i, j).getStatus() == 0) {
                        if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getBackground() != Color.GREEN) {

                            bottuns[i][j].setBackground(Color.YELLOW);
                        } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getBackground() != Color.YELLOW) {
                            bottuns[i][j].setBackground(Color.GREEN);

                        }
                        bottuns[i][j].setEnabled(false);

                    } else {
                        if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getBackground() != Color.GREEN) {

                            bottuns[i][j].setBackground(Color.YELLOW);
                        } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getBackground() != Color.YELLOW) {
                            bottuns[i][j].setBackground(Color.GREEN);

                        }
                        bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                        bottuns[i][j].setEnabled(false);
                    }
                } else if (e.getelement(i, j).isFlag()) {
                    if (e.getelement(i, j).getColor() == 4) {
                        bottuns[i][j].setIcon(flagIcon2);
                    }
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
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player, Turn);

                                            }
                                            e.getelement(i, j).setColor(1);
                                            ffile = new StoreFile(e, player,player2);

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
                                            Turn += 1;
c1=1;
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
                                                clickload=false;
                                            }
                                            
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                h.testing(e, i, j, player, Turn);
                                                try {
                                                    filee1 = new FileOutputStream(assist);
                                                    out1 = new ObjectOutputStream(filee1);
                                                    ffile = new StoreFile(e, player,player2);
                                                    out1.writeObject(ffile);
                                                    out1.close();
                                                    filee1.close();
                                                    save();
                                                } catch (Exception ee) {
                                                    ee.printStackTrace();
                                                }
                                            }
                                            if (Turn % 2 == 0) {
                                                e.getelement(i, j).setColor(2);
                                                if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    btn1.setBackground(Color.GREEN);
                                                    btn2.setBackground(null);
                                                }

                                            } else if (Turn % 2 != 0) {
                                                e.getelement(i, j).setColor(1);
                                                if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    btn1.setBackground(null);
                                                    btn2.setBackground(Color.YELLOW);
                                                }
                                            }
                                            display(e, player);
                                            if (iswin(e)) {
                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                if (Turn % 2 == 0) {
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won" + "\nSorry," + GUI1.name1 + "has lost");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                } else if (Turn % 2 != 0) {
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won " + "\nSorry," + GUI1.name2 + "has lost");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }
                                            } else if (isLosss(e)) {
                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                if (Turn % 2 == 0) {
                                                    JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name2 + "has lost " + "\nCongratulations," + GUI1.name1 + "has won");
                                                    endprint(e);
                                                    interface2();
                                                    
                                                    return;
                                                } else if (Turn % 2 != 0) {
                                                    JOptionPane.showMessageDialog(null, "Sorry," + GUI1.name1 + "has lost " + "\nCongratulations," + GUI1.name2 + "has won");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }
                                            }
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
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
                                                clickload=false;
                                            }
                                    if (Turn % 2 == 0) {
                                        btn2.setBackground(null);
                                        btn1.setBackground(Color.GREEN);
                                        if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss(e)) {
                                            bottuns[i][j].setIcon(flagIcon2);
                                            e.getelement(i, j).setColor(4);
                                            h.FLAG(e, i, j);
                                            try {
                                            filee1 = new FileOutputStream(assist);
                                            out1 = new ObjectOutputStream(filee1);
                                            ffile = new StoreFile(e, player,player2);
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
                                            e.getelement(i, j).setColor(0);
                                            h.FLAG(e, i, j);
                                            try {
                                            filee1 = new FileOutputStream(assist);
                                            out1 = new ObjectOutputStream(filee1);
                                            ffile = new StoreFile(e, player,player2);
                                            out1.writeObject(ffile);
                                            out1.close();
                                            filee1.close();
                                            save();
                                        } catch (Exception ee) {
                                            ee.printStackTrace();
                                        }
                                            Turn += 1;

                                        }
                                    } else if (Turn % 2 != 0) {
                                        btn1.setBackground(null);
                                        btn2.setBackground(Color.YELLOW);
                                        if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss(e)) {
                                            bottuns[i][j].setIcon(flagIcon1);
                                            e.getelement(i, j).setColor(3);
                                            h.FLAG(e, i, j);
                                            try {
                                            filee1 = new FileOutputStream(assist);
                                            out1 = new ObjectOutputStream(filee1);
                                            ffile = new StoreFile(e, player,player2);
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
                                            ffile = new StoreFile(e, player,player2);
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

    @Override
    public void whenloss(Initialize e) {

        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).getStatus() == -1) {

                    if (e.getelement(i, j).getColor() == 2 && bottuns[i][j].getIcon() != bombicon1) {
                        bottuns[i][j].setIcon(bombicon2);
                        if (e.getelement(i, j).isFlag() && bottuns[i][j].getIcon() != flagIcon1) {
                            bottuns[i][j].setIcon(flagmine);
                        }

                        bottuns[i][j].setBackground(Color.YELLOW);
                        bottuns[i][j].setEnabled(false);
                        btn1.setBackground(Color.GREEN);
                        btn2.setBackground(null);

                    } else if (e.getelement(i, j).getColor() == 1 && bottuns[i][j].getIcon() != bombicon2) {
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

//
//    @Override
//    public void whenloss(Initialize e) {
//
//        int i, j;
//        for (i = 0; i < e.getX(); i++) {
//            for (j = 0; j < e.getY(); j++) {
//                if (e.getelement(i, j).getStatus() == -1) {
//
//                    if (Turn % 2 == 0 && bottuns[i][j].getIcon() != bombicon1) {
//                        bottuns[i][j].setIcon(bombicon2);
//                        if (e.getelement(i, j).isFlag() && bottuns[i][j].getIcon() != flagIcon1) {
//                            bottuns[i][j].setIcon(flagmine);
//                        }
//
//                        bottuns[i][j].setBackground(Color.YELLOW);
//                        bottuns[i][j].setEnabled(false);
//                        btn1.setBackground(Color.GREEN);
//                        btn2.setBackground(null);
//                        //turn[i][j] = false;
//                                                    turn[i][j]='2';
//
//
//                    } else if (Turn % 2 != 0 && bottuns[i][j].getIcon() != bombicon2) {
//                        bottuns[i][j].setIcon(bombicon1);
//                        if (e.getelement(i, j).isFlag() && bottuns[i][j].getIcon() != flagIcon2) {
//                            bottuns[i][j].setIcon(flagmine);
//                        }
//
//                        bottuns[i][j].setBackground(Color.GREEN);
//                        bottuns[i][j].setEnabled(false);
//                        btn1.setBackground(null);
//                        btn2.setBackground(Color.YELLOW);
//                        //turn[i][j] = true;
//                                                    turn[i][j]='1';
//
//
//                    }
//
//                }
//            }
//        }
//    }
//    
//   @Override
//    public void displayload(Initialize e)
//    {
//        
//         int i, j;
//        for (i = 0; i < e.getX(); i++) {
//            for (j = 0; j < e.getY(); j++) {
//                if (e.getelement(i, j).isClicked()) {
//                    if (e.getelement(i, j).getStatus() == -1) {
//                        
//                        whenlossload(e);
//                        
//                    } else if (e.getelement(i, j).getStatus() == 0) {
//                        if (turn[i][j]=='2' && bottuns[i][j].getBackground() != Color.GREEN) {
//                                          
//                           btn2.setBackground(null);
//                            btn1.setBackground(Color.GREEN);
//                            bottuns[i][j].setBackground(Color.YELLOW);
//                          
//                        } else if (turn[i][j]=='1' && bottuns[i][j].getBackground() != Color.YELLOW) {
//                            bottuns[i][j].setBackground(Color.GREEN);
//                              btn1.setBackground(null);
//                            btn2.setBackground(Color.YELLOW);
//                        }
//                        bottuns[i][j].setEnabled(false);
//                        
//                    } else {
//                        if (turn[i][j]=='2' && bottuns[i][j].getBackground() != Color.GREEN) {
//                              btn2.setBackground(null);
//                            btn1.setBackground(Color.GREEN);
//                            bottuns[i][j].setBackground(Color.YELLOW);
//                        } else if (turn[i][j]=='1' && bottuns[i][j].getBackground() != Color.YELLOW) {
//                            bottuns[i][j].setBackground(Color.GREEN);
//                               btn1.setBackground(null);
//                            btn2.setBackground(Color.YELLOW);
//                        }
//                        bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
//                        bottuns[i][j].setEnabled(false);
//                    }
//                } else if (e.getelement(i, j).isFlag()) {
//                    bottuns[i][j].enableInputMethods(false);
//                    
//                }
//                
//            }
//        }
//        
//        
//
//    }
//    @Override
//    public void whenlossload(Initialize e)
//    {
//        int i, j;
//        for (i = 0; i < e.getX(); i++) {
//            for (j = 0; j < e.getY(); j++) {
//                if (e.getelement(i, j).getStatus() == -1) {
//                    
//                    if (turn[i][j]=='2' && bottuns[i][j].getIcon() != bombicon1) {
//                        bottuns[i][j].setIcon(bombicon2);
//                        if(e.getelement(i, j).isFlag()&&bottuns[i][j].getIcon()!=flagIcon1)
//                         bottuns[i][j].setIcon(flagmine);
//                        
//                        bottuns[i][j].setBackground(Color.YELLOW);
//                        bottuns[i][j].setEnabled(false);
//                         btn1.setBackground(Color.GREEN);
//                            btn2.setBackground(null);
//                            
//                        
//                    } else if (turn[i][j]=='1' && bottuns[i][j].getIcon() != bombicon2) {
//                        bottuns[i][j].setIcon(bombicon1);
//                        if(e.getelement(i, j).isFlag()&&bottuns[i][j].getIcon()!=flagIcon2)
//                        bottuns[i][j].setIcon(flagmine);
//                        
//                        bottuns[i][j].setBackground(Color.GREEN);
//                        bottuns[i][j].setEnabled(false);
//                          btn1.setBackground(null);
//                            btn2.setBackground(Color.YELLOW);
//                            
//                    }
//                    
//                }
//            }
//        } 
//    }
}
