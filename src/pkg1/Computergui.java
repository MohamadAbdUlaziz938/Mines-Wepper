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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static pkg1.GUIGame.Turn;
import static pkg1.GUIGame.clickload;

public class Computergui extends GUIGame {

    Random rand = new Random();
    Thread t;
    boolean dont = false;

    public Computergui(Initialize e, Score score, JPanel p, Player player, Player player2) {

        super(e, score, p, player, player2);

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
                                            e.puzzle();

                                            if (e.getelement(i, j).getStatus() == 0) {
                                                h.check(e, i, j, player, Turn);
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
                                                interface2();
                                                endprint(e);
                                                return;
                                            }
                                            x++;
                                            Turn++;
                                            k1 = 1;

                                            if (e.getelement(e.getX() - 1, e.getY() - 1).isClicked() && !iswin(e)) {
                                                while (e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                                    i = rand.nextInt(e.getX());
                                                    j = rand.nextInt(e.getY());

                                                }
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    h.testing(e, i, j, player, Turn);
                                                }
                                                 e.getelement(i, j).setColor(2);
                                                display(e, player);
                                                if (iswin(e)) {
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                                    saveScoreBoard(sb, player, player2);
                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, "Computer player has won");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }
                                                Turn += 1;
                                                return;
                                            }
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
                                            if (Turn % 2 == 0) {

                                                while (e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                                    i = rand.nextInt(e.getX());
                                                    j = rand.nextInt(e.getY());

                                                }
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
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
                                                }
                                                 e.getelement(i, j).setColor(2);
                                                display(e, player);
                                                Turn += 1;
                                                return;

                                            } else if (Turn % 2 != 0) {
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
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
                                                }
                                                e.getelement(i, j).setColor(1);
                                                display(e, player);
                                                Turn += 1;

                                                if (e.getelement(e.getX() - 1, e.getY() - 1).isClicked() && !dont && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    while (e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag() || e.getelement(i, j).getStatus() == -1) {
                                                        i = rand.nextInt(e.getX());
                                                        j = rand.nextInt(e.getY());

                                                    }
                                                    if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
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
                                                    }
                                                    e.getelement(i, j).setColor(2);
                                                    display(e, player);
                                                    Turn += 1;
                                                    dont = true;
                                                    return;
                                                }
                                            }

                                            if (iswin(e)) {
                                                if (Turn % 2 != 0) {
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                                    saveScoreBoard(sb, player, player2);

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, "Computer Player has won");
                                                    interface2();
                                                    endprint(e);

                                                    return;
                                                } else if (Turn % 2 == 0) {
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
                                                    JOptionPane.showMessageDialog(null, GUI1.name1 + " has won");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }

                                            } else if (isLosss(e)) {
                                                if (Turn % 2 != 0) {
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
                                                    JOptionPane.showMessageDialog(null, "Computer player has lost");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                } else if (Turn % 2 == 0) {
                                                    date2 = new Date();
                                                    ScoreBoard sb = new ScoreBoard(player.score, player.getName(), date, date2, size, false);

                                                    saveScoreBoard(sb, player, player2);

                                                    try {
                                                        out.close();
                                                        filee.close();
                                                    } catch (Exception eee) {
                                                        eee.printStackTrace();
                                                    }
                                                    assist.delete();
                                                    JOptionPane.showMessageDialog(null, GUI1.name1 + " has lost");
                                                    endprint(e);
                                                    interface2();
                                                    return;
                                                }

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
                        for (int j = 0; j < bottuns.length; j++) {
                            if (e1.getSource().equals(bottuns[i][j]) || Turn % 2 == 0) {

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

                                    if (Turn % 2 != 0) {
                                        if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss(e)) {
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
                                            if (Turn % 2 == 0) {

                                                while (e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag() /* || e.getelement(i, j).getStatus() == -1*/) {

                                                    i = rand.nextInt(e.getX());
                                                    j = rand.nextInt(e.getY());
                                                }
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    h.testing(e, i, j, player,Turn);
                                                    e.getelement(i, j).setColor(2);
                                                    display(e, player);
                                                    Turn += 1;
                                                }
                                                if (iswin(e)) {
                                                    if (Turn % 2 != 0) {
                                                        date2 = new Date();
                                                        ScoreBoard sb = new ScoreBoard(player.score, player2.getName(), date, date2, size, true);

                                                        saveScoreBoard(sb, player, player2);

                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Computer Player has won");
                                                        interface2();
                                                        endprint(e);

                                                        return;
                                                    }

                                                } else if (isLosss(e)) {
                                                    if (Turn % 2 != 0) {
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
                                                        JOptionPane.showMessageDialog(null, "Computer player has lost");
                                                        interface2();
                                                        endprint(e);

                                                        return;
                                                    }

                                                }
                                                return;
                                            }
                                        }
                                        if (e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
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

                                            if (Turn % 2 == 0) {
                                                i = rand.nextInt(e.getX());
                                                j = rand.nextInt(e.getY());
                                                while (e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag()/* || e.getelement(i, j).getStatus() == -1*/) {

                                                    i = rand.nextInt(e.getX());
                                                    j = rand.nextInt(e.getY());
                                                }
                                                if (!e.getelement(i, j).isClicked() && !e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                    h.testing(e, i, j, player,Turn);
                                                    display(e, player);
                                                    Turn += 1;

                                                }
                                                if (iswin(e)) {
                                                    if (Turn % 2 != 0) {
                                                        date2 = new Date();
                                                        ScoreBoard sb = new ScoreBoard(player2.score, player2.getName(), date, date2, size, true);

                                                        saveScoreBoard(sb, player, player2);

                                                        try {
                                                            out.close();
                                                            filee.close();
                                                        } catch (Exception eee) {
                                                            eee.printStackTrace();
                                                        }
                                                        assist.delete();
                                                        JOptionPane.showMessageDialog(null, "Computer Player has won");
                                                        interface2();
                                                        endprint(e);
                                                        return;
                                                    }

                                                } else if (isLosss(e)) {
                                                    if (Turn % 2 != 0) {
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
                                                        JOptionPane.showMessageDialog(null, "Computer player has lost");
                                                        interface2();
                                                        endprint(e);
                                                        return;
                                                    }

                                                }
                                                return;

                                            }
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
                    if (e.getelement(i, j).color == 2 && bottuns[i][j].getIcon() != bombicon1) {
                        bottuns[i][j].setBackground(Color.YELLOW);
                        if (e.getelement(i, j).isFlag()) {
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(flagmine);
                        } else {
                            bottuns[i][j].setEnabled(false);
                            bottuns[i][j].setIcon(bombicon2);
                        }

                    } else if (e.getelement(i, j).color == 1 && bottuns[i][j].getIcon() != bombicon2) {
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
