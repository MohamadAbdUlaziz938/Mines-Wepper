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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static pkg1.GUIGame.ch;
import static pkg1.GUIGame.clickload;

public class Towplayerguiscore extends Twoplayergui {

    JButton yes, No;
    JLabel l;
    Integer numMines = Integer.parseInt(GUI1.mines);
    JLabel numberMines = new JLabel("1", JLabel.CENTER);
    JButton mines = new JButton();
    ImageIcon minsIcon1 = new ImageIcon("E:\\Mines12.png");
    int z = 0;

    public Towplayerguiscore(Initialize e, Score score, JPanel p, Player player, Player player2) {
        super(e, score, p, player, player2);
        p.add(numberMines);
        p.add(mines);
        numberMines.setBounds(333, 100, 150, 30);
        numberMines.setText(numMines.toString());
        numberMines.setFont(new Font("Arial", Font.BOLD, 30));

        mines.setIcon(minsIcon1);
        mines.setBackground(Color.LIGHT_GRAY);
        mines.setBounds(380, 30, minsIcon1.getIconWidth(), minsIcon1.getIconHeight());

    }

    @Override
    public void display(Initialize e, Player player) {
        int i, j;
        for (i = 0; i < bottuns.length; i++) {
            for (j = 0; j < bottuns.length; j++) {
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
                            ;
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
                                            e.puzzle();
                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player, Turn);
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
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
                                            display(e, player);
                                            x++;

                                            if (iswin(e)) {

                                                int scor = (score.addScore(e)) + (score.getLastO() * minesnumbernotclicked(e));

                                                try {
                                                    out.close();
                                                    filee.close();
                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name1 + "has won, His score is : " + scor + "\nSorry," + GUI1.name2 + "has lost");
                                                endprint(e);
                                                date2 = new Date();
                                                scorearray = interface3();
                                                ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true, scorearray);

                                                saveScoreBoard(sb, player, player2);
                                                return;
                                            }
                                            player.score = score.addScore(e);
                                            Turn++;
                                            c3 = 1;
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
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !loss(e) && !iswin1(e)) {
                                                h.testing(e, i, j, player, Turn);
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
                                                if (e.getelement(i, j).getStatus() == -1) {
                                                    numMines--;
                                                    numberMines.setText(numMines.toString());

                                                }
                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.addScore(e) - (player.score + player2.score));
                                                } else {
                                                    player.score = player.score + (score.addScore(e) - (player2.score + player.score));
                                                }

                                                if (Turn % 2 == 0) {
                                                    e.getelement(i, j).setColor(2);
                                                    btn2.setBackground(null);
                                                    btn1.setBackground(Color.GREEN);
                                                } else if (Turn % 2 != 0) {
                                                    e.getelement(i, j).setColor(1);
                                                    btn1.setBackground(null);
                                                    btn2.setBackground(Color.YELLOW);
                                                }
                                                display(e, player);

                                            }

                                            if (iswin(e)) {

                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                } else if (Turn % 2 != 0) {
                                                    player.score = player.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                }
                                                player2.score += newflagsYellow(e, score);
                                                player.score += newflagGreen(e, score);
                                                if (player.score > player2.score) {

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
                                                    scorearray = interface3();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true, scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                } else if (player.score < player2.score) {

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won, His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost, His score is : " + player.score);
                                                    endprint(e);
                                                    date2 = new Date();
                                                    scorearray = interface3();
                                                    ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true, scorearray);
                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }
                                            } else if (loss(e)) {
                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                } else if (Turn % 2 != 0) {
                                                    player.score = player.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                }
                                                player2.score += newflagsYellow(e, score);
                                                player.score += newflagGreen(e, score);
                                                if (player.score > player2.score) {

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
                                                    scorearray = interface3();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true, scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                } else if (player.score < player2.score) {
                                                    ;
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won, His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost, His score is : " + player.score);
                                                    endprint(e);
                                                    date2 = new Date();
                                                    scorearray = interface3();
                                                    ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true, scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                }
                                            } else if (iswin1(e)) {
                                                if (Turn % 2 == 0) {
                                                    player2.score = player2.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                } else if (Turn % 2 != 0) {
                                                    player.score = player.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                                }
                                                player2.score += newflagsYellow(e, score);
                                                player.score += newflagGreen(e, score);
                                                if (player.score > player2.score) {

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
                                                    scorearray = interface3();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true, scorearray);

                                                    saveScoreBoard(sb, player, player2);
                                                    return;
                                                } else if (player.score < player2.score) {
                                                    date2 = new Date();
                                                    scorearray = interface3();
                                                    ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true, scorearray);

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
                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !loss(e) && !iswin1(e)) {
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
                    z++;
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
                                    if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !iswin1(e) && !loss(e)) {
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
                                        } else if (Turn % 2 != 0) {
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
                                            bottuns[i][j].setIcon(flagIcon1);
                                            e.getelement(i, j).setColor(3);

                                        }
                                        Turn += 1;
                                    } else if (e.getelement(i, j).isFlag() && !iswin(e) && !iswin1(e) && !loss(e)) {
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
                                        } else if (Turn % 2 != 0) {
                                            btn1.setBackground(null);
                                            btn2.setBackground(Color.YELLOW);
                                            e.getelement(i, j).setColor(0);
                                        }
                                        Turn += 1;

                                    }
                                    if (iswin1(e)) {
                                        if (Turn % 2 == 0) {
                                            player2.score = player2.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                        } else if (Turn % 2 != 0) {
                                            player.score = player.score + (score.getLastO() * minesnumbernotclicked(e)); // +addflagscoorew
                                        }
                                        player2.score += newflagsYellow(e, score);
                                        player.score += newflagGreen(e, score);
                                        if (player.score > player2.score) {

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
                                            scorearray = interface3();
                                            ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, true, scorearray);

                                            saveScoreBoard(sb, player, player2);

                                            return;
                                        } else if (player.score < player2.score) {

                                            try {
                                                out.close();
                                                filee.close();
                                            } catch (Exception eee) {
                                                eee.printStackTrace();
                                            }
                                            assist.delete();
                                            JOptionPane.showMessageDialog(null, "Congratulations," + GUI1.name2 + "has won, His score is : " + player2.score + "\nSorry," + GUI1.name1 + "has lost, His score is : " + player.score);
                                            endprint(e);
                                            date2 = new Date();

                                            scorearray = interface3();
                                            ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true, scorearray);

                                            saveScoreBoard(sb, player, player2);
                                            return;
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
//    public void reset()
//    {
//                   player2.setArmorCount(0);
//                   player2.setClickCount(0);
//                   player2.setFlagScore(0);
//                   player2.setMinesClickedCount(0);
//                   player2.setScor(0);
//                   player2.setScore(0);
//    }

    public int newflagGreen(Initialize e, Score score) {
        int x = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getX(); j++) {
                if (e.getelement(i, j).isFlag()) {
                    if (bottuns[i][j].getIcon() == flagIcon1) //green
                    {
                        if (e.getelement(i, j).getStatus() == -1) {
                            x += score.getWflag();
                        } else {
                            x -= score.getLflag();
                        }

                    }

                }
            }
        }

        return x;

    }

    public int newflagsYellow(Initialize e, Score score) {
        int x = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getX(); j++) {
                if (e.getelement(i, j).isFlag()) {

                    if (bottuns[i][j].getIcon() == flagIcon2) {
                        if (e.getelement(i, j).getStatus() == -1) {
                            x += score.getWflag();
                        } else {
                            x -= score.getLflag();
                        }
                    }

                }
            }
        }

        return x;

    }

}
