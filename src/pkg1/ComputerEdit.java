package pkg1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ComputerEdit extends GUIGame {

    Random rand = new Random();
    int z = 0;

    public ComputerEdit(Initialize e, Score score, JPanel p, Player player,Player player2) {
        super(e, score, p, player,player2);
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
                        if (Turn % 2 == 0 && bottuns[i][j].getBackground() != Color.GREEN) {
                            bottuns[i][j].setBackground(Color.YELLOW);
                        } else if (Turn % 2 != 0 && bottuns[i][j].getBackground() != Color.YELLOW) {
                            bottuns[i][j].setBackground(Color.GREEN);
                        }
                        bottuns[i][j].setEnabled(false);

                    } else {
                        if (Turn % 2 == 0 && bottuns[i][j].getBackground() != Color.GREEN) {
                            bottuns[i][j].setBackground(Color.YELLOW);
                        } else if (Turn % 2 != 0 && bottuns[i][j].getBackground() != Color.YELLOW) {
                            bottuns[i][j].setBackground(Color.GREEN);
                        }
                        bottuns[i][j].setText(e.getelement(i, j).getStatus().toString());
                        bottuns[i][j].setEnabled(false);
                    }
                } else if (e.getelement(i, j).isFlag()) {
                    bottuns[i][j].enableInputMethods(false);

                }

            }
        }

    }

    @Override
    public void initEvent(JButton b, Initialize e, Score score, Player player,Player player2) {

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

                                            e.getelement(i, j).setClicked(true);
                                            e.getelement(i, j).setScan(true);
                                            e.CreatMines();
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player);
                                            }
                                            display(e, player);
                                            if (iswin(e)) {
                                                JOptionPane.showMessageDialog(null, "player one has won");
                                                return;
                                            }
                                            x++;
                                            Turn++;
                                            System.out.println("turn" + Turn);
                                            System.out.println("i 2 j" + i + "  " + j);

                                        } else {

                                            if (Turn % 2 == 0) {

                                                while (e.getelement(i, j).isClicked()) {
                                                    z++;
                                                    i = rand.nextInt(e.getX() - 1);
                                                    j = rand.nextInt(e.getY() - 1);
                                                }
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    h.testing(e, i, j, player);
                                                    // 
                                                }
                                                display(e, player);
                                                System.out.println("z" + z);

                                            } else if (Turn % 2 != 0) {
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    h.testing(e, i, j, player);
                                                }
                                                display(e, player);
                                            }

                                            if (iswin(e)) {
                                                if (Turn % 2 == 0) {
                                                    JOptionPane.showMessageDialog(null, "Computer Player has won");
                                                    return;
                                                } else if (Turn % 2 != 0) {
                                                    JOptionPane.showMessageDialog(null, GUI1.name1 + " has won");
                                                    return;
                                                }

                                            } else if (isLosss(e)) {
                                                if (Turn % 2 == 0) {
                                                    JOptionPane.showMessageDialog(null, "Computer player has lost");
                                                    return;
                                                } else if (Turn % 2 != 0) {
                                                    JOptionPane.showMessageDialog(null, GUI1.name1 + " has lost");
                                                    return;
                                                }

                                            }
                                            Turn += 1;

                                        }
                                        /* if(iswin(e)||isLosss(e))
                                         break;*/
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

//                                    if (Turn % 2 == 0) {
//                                     
//                                    } 
                                    if (Turn % 2 != 0) {
                                        if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss(e)) {
                                            bottuns[i][j].setIcon(flagIcon1);
                                            h.FLAG(e, i, j);
                                            Turn += 1;
                                            System.out.println("flag  " + Turn);
                                        } else if (e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                            bottuns[i][j].setIcon(null);
                                            h.FLAG(e, i, j);
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

    public void whenloss(Initialize e) {

        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).getStatus() == -1) {
                    if (Turn % 2 == 0 && bottuns[i][j].getIcon() != bombicon1) {
                        bottuns[i][j].setBackground(Color.YELLOW);
                        if (e.getelement(i, j).isFlag()) {
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(flagmine);
                        } else {
                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(bombicon2);
                        }

                    } else if (Turn % 2 != 0 && bottuns[i][j].getIcon() != bombicon2) {
                        bottuns[i][j].setBackground(Color.GREEN);
                        if (e.getelement(i, j).isFlag()) {
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(flagmine);
                        } else {
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(bombicon1);
                        }

                    }

                }
            }
        }
    }

    
}


