package pkg1;

import com.sun.glass.ui.MenuBar;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemColor;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import static pkg1.GUI1.sh1;
import java.io.*;
import javax.swing.JFileChooser;
import pkg1.StartPage;
import javax.swing.MenuElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class GUIGame extends Game implements Serializable {

    private static void removeAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    ArrayList<ScoreBoard> array;
    File file;
    FileOutputStream fos;
    ObjectOutputStream oos;
    FileInputStream fis;
    ObjectInputStream ois;
    Date date;
    Date date2;
    static char ch;
    static int qu = 0;
    StoreFile ffile = new StoreFile();
    Initialize dd;
    CardLayout card;
    Container container;
    StartPage startPage;
    JPanel GUIGame;
    Click h = new Click();
    static Integer numshields;
    int d = (int) Math.sqrt(Integer.parseInt(GUI1.dim.toString()));
    JLabel gamePage_PlayerName1 = new JLabel("", JLabel.CENTER);
    JLabel gamePage_PlayerName2 = new JLabel("", JLabel.CENTER);
    JPanel gamePage_boardPanel = new JPanel(new GridLayout(20, 20, 8, 8));
//   JButton gamePage_back = new JButton("Main menue");
    JMenuItem save = new JMenuItem("Save");
    Timer timer = new Timer();
    TimerTask task;
    static Integer counter = Integer.valueOf(GUI1.time);
    static int Turn;
    static boolean end = false;
    boolean a = false;
    boolean timeOut = false;
    String scorearray;
    Timer timer2;
    TimerTask task2;
    int attemp1;
    int attemp2;
    JButton[][] bottuns;
    Random randm = new Random();
    JPanel SinglePlayerPage;
    JMenuItem quick = new JMenuItem("Quick Save");
    JMenuItem mainmenu = new JMenuItem("MainMenu");
    JMenuItem close = new JMenuItem("Exit");
    JMenu File = new JMenu("File");
    static File temp1 = new File("TempFile");

    public File getTemp1() {
        return temp1;
    }
//       bottuns = new JButton[d][d];
//        SinglePlayerPage.add(gamePage_boardPanel);
//        SinglePlayerPage.setSize(45 * d, 45 * d);
    ImageIcon minsIcon = new ImageIcon("E:\\front.png");
    ImageIcon flagIcon = new ImageIcon("E:\\back.png");
    ImageIcon flagIcon2 = new ImageIcon("E:\\yellow.png");
    ImageIcon flagIcon1 = new ImageIcon("E:\\green.png");
    ImageIcon bombicon2 = new ImageIcon("E:\\Byellow.png");
    ImageIcon bombicon1 = new ImageIcon("E:\\Bgreen.png");
    ImageIcon flagmine = new ImageIcon("E:\\flagmine‫‬.png");
    static int x = 0;
    byte y = 0;
    static int s1 = 0, s2 = 0, s3 = 0, s4 = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0,k1=0,k2=0;
    static int choice = 0;
    int size = 0;
    static boolean clickload = false;
    File main;
    File assist;
    static boolean timerload = false;
    static boolean timerload2 = false;
    ObjectOutputStream out;
    FileOutputStream filee;
    StoreFile sf;
    ObjectOutputStream out1;
    FileOutputStream filee1;
    JButton next = new JButton("Next");

    GUIGame(Initialize e, Score score, JPanel SinglePlayerPage, Player player, Player player2) {
        Turn = e.turn1;
        array = new ArrayList<>();
        file = new File("hani.txt");
        int d = (int) Math.sqrt(Integer.parseInt(GUI1.dim.toString()));
        bottuns = new JButton[e.getX()][e.getY()];
        SinglePlayerPage.setSize(45 * e.getX(), 45 * e.getY());
        e.setMinsNum((int) Integer.parseInt(GUI1.mines));
//        score.setB((int) Integer.parseInt(GUI1.Bomb));
//        score.setO((int) Integer.parseInt(GUI1.O));
//        score.setAuto((int) Integer.parseInt(GUI1.auto));
//        player.setArmorCount((int) Integer.parseInt(GUI1.armor));
//        int armor = (int) Integer.parseInt(GUI1.armor);
//        score.setLastO((int) Integer.parseInt(GUI1.lastO));
//        score.setWflag((int) Integer.parseInt(GUI1.Wflag));
//        score.setLflag((int) Integer.parseInt(GUI1.Lflag));
//        gamePage_back.setBackground(Color.red);
        SinglePlayerPage.add(gamePage_boardPanel);
//        SinglePlayerPage.add(gamePage_back);
        JMenuBar menu = new JMenuBar();
        SinglePlayerPage.add(menu);
        menu.add(File);
        assist = new File("AssistGame");
        main = new File("BasicGame");
        File.add(save);
        File.add(quick);
        File.add(mainmenu);
        File.add(close);
        if (choice != 0) {
            next = new JButton("Next");
            SinglePlayerPage.add(next);
            next.setBounds(650, 650, 110, 30);
            next.setBackground(Color.PINK);
        }

        SinglePlayerPage.add(gamePage_PlayerName2);
        SinglePlayerPage.add(gamePage_PlayerName1);
        gamePage_boardPanel.setLayout(new GridLayout(e.getX(), e.getY()));
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                bottuns[i][j] = new JButton();
                initEvent(bottuns[i][j], e, score, player, player2);
                bottuns[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
                bottuns[i][j].setBackground(Color.darkGray);
                gamePage_boardPanel.add(bottuns[i][j]);
            }
        }
        gamePage_boardPanel.setBounds(160, 160, 45 * e.getX(), 45 * e.getY());
        gamePage_boardPanel.setLocation(400 - (45 * e.getX() / 2), 400 - (45 * e.getY() / 2));
        gamePage_PlayerName1.setBounds(320, 40, 150, 30);
        gamePage_PlayerName1.setText(player.getName());

        //    gamePage_PlayerScore.setText(""+score.getCount().toString()+score.addFlagScore(e).toString());
        gamePage_PlayerName1.setFont(new Font("Arial", Font.BOLD, 25));

//        gamePage_back.setBounds(15, 650, 110, 30);
        menu.setBounds(5, 5, 30, 30);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                JFrame framem = new JFrame("Options");
                framem.setSize(220, 100);
                framem.setLocationRelativeTo(null);
                framem.setResizable(false);
                framem.setVisible(true);
                framem.setLayout(null);
                JLabel minesl = new JLabel("Are you sure to quit your game?");
                JButton ok = new JButton("Yse");
                JButton no = new JButton("No");

                minesl.setBounds(10, 10, 300, 20);
                Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                Color defaultButtonBackgroundColor = Color.white;
                Color defaultButtonTextColor = Color.red;

//framem.setBackground(Color.red);
//minesm.setBackground(Color.white);
//ok.setBackground(Color.red);
                ok.setFont(defaultFont);
                ok.setBackground(defaultButtonBackgroundColor);
                ok.setForeground(defaultButtonTextColor);
                ok.setBounds(10, 40, 60, 25);
                no.setFont(defaultFont);
                no.setBackground(defaultButtonBackgroundColor);
                no.setForeground(defaultButtonTextColor);
                no.setBounds(130, 40, 60, 25);

                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {

                        framem.setVisible(false);
                        System.exit(0);
                    }
                });
                no.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {

                        framem.setVisible(false);

                    }
                });
                framem.add(ok);
                framem.add(no);
                framem.add(minesl);

            }
        });

    }

    public void display(Initialize e, Player player) {
        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked()) {
                    if (e.getelement(i, j).getStatus() == -1) {

                        for (int k = 0; k < e.getX(); k++) {
                            for (int kk = 0; kk < e.getY(); kk++) {
                                if (e.getelement(i, j).getStatus() == -1) {
                                    bottuns[i][j].setEnabled(false);
                                    bottuns[i][j].setIcon(minsIcon);
                                }
                            }
                        }

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

    public void restar(Initialize e, Score score, Player player, Player player2) {
        GUI1.dim = "36";
        GUI1.mines = "5";
        GUI1.name1 = "PlayerOne";
        GUI1.name2 = "PlayerTwo";
        GUI1.O = "10";
        GUI1.Bomb = "250";
        GUI1.lastO = "100";
        GUI1.Lflag = "1";
        GUI1.Wflag = "5";
        GUI1.auto = "1";
        GUI1.armor = "0";
        GUI1.time = "10";
        GUI1.sh1 = 0;/////
        Turn = 1;
        x = 0;
        s1 = 0;
        choice = 0;
        s2 = 0;
        player2 = new Player();
        player = new Player();
        end = false;
        timerload = false;
        timerload2 = false;
        e.reset();
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                bottuns[i][j].setEnabled(true);
                bottuns[i][j].setText(null);
                bottuns[i][j].setIcon(null);
                bottuns[i][j].setBackground(null);
                bottuns[i][j].setBackground(Color.darkGray);

            }
        }
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                e.getelement(i, j).setColor(0);
            }
        }
        Click.count = 0;
        player.setArmorCount(0);
        player.setClickCount(0);
        player.setFlagScore(0);
        player.setMinesClickedCount(0);
        player.setScor(0);
        player.setScore(0);
//        new Towplayerguiscore(e, score, gamePage_boardPanel, player).reset();
//        new Underzero(e, score, gamePage_boardPanel, player).reset();

        score.restScore();

        player2.setArmorCount(0);
        player2.setClickCount(0);
        player2.setFlagScore(0);
        player2.setMinesClickedCount(0);
        player2.setScor(0);
        player2.setScore(0);
//        e.CreatMines();
//        e.CreatArmaors();
//        e.puzzle();
        try {
            if (!task.cancel()) {
                task.cancel();
            }

        } catch (Exception ec) {

        }

        try {
            if (!task2.cancel()) {
                task2.cancel();
            }
        } catch (Exception ex) {
        }
        counter = 0;

    }

  

    public JLabel getGamePage_PlayerName1() {
        return gamePage_PlayerName1;
    }

    public JLabel getGamePage_PlayerName2() {
        return gamePage_PlayerName2;
    }

    public void setGamePage_PlayerName2(String name) {
        this.gamePage_PlayerName2.setText(name);
    }

    public void setGamePage_PlayerName1(String name) {
        this.gamePage_PlayerName2.setText(name);
    }

//    public JButton getGamePage_back() {
//        return gamePage_back;
//    }
    public void initEvent(JButton b, Initialize e, Score score, Player player, Player player2) {
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e1) {
                if (SwingUtilities.isLeftMouseButton(e1)) {
                    if (end == true) {
                        endprint(e);
                    }
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
                                            s1 = 1;
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

                                            if (!e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
                                                h.testing(e, i, j, player);

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
                                                JOptionPane.showMessageDialog(null, "Congratulations,You have won");
                                                whenloss(e);
                                                endprint(e);
                                                interface2();
                                                return;
                                            } else if (isLosss(e)) {

                                                try {

                                                    out.close();
                                                    filee.close();

                                                } catch (Exception eee) {
                                                    eee.printStackTrace();
                                                }
                                                assist.delete();
                                                JOptionPane.showMessageDialog(null, "Sorry,You have failed");
                                                whenloss(e);
                                                endprint(e);
                                                interface2();

                                                return;
                                            } else if (iswin1(e)) {
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
                                    if (!e.getelement(i, j).isFlag() && !e.getelement(i, j).isClicked() && !iswin(e) && !isLosss(e)) {
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
                                    } else if (e.getelement(i, j).isFlag() && !iswin(e) && !isLosss(e)) {
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
                                    }
                                    if (iswin1(e)) {
                                        try {
                                            out.close();
                                            filee.close();
                                        } catch (Exception er) {
                                        }
                                        JOptionPane.showMessageDialog(null, "Congratulations,You have won");
                                        whenloss(e);
                                        endprint(e);
                                        assist.delete();
                                        interface2();
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
                //  b.setBackground(Color.WHITE);

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                 if(b.isEnabled())   
//              b.setBackground(Color.darkGray);
            }

        }
        );
    }

    @Override

    public void ApplyGame(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//
//    @Override

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean iswin(Initialize e) {
        if (Click.count == e.getX() * e.getY() - e.getMinsNum() - 1) {
            //Click.count=0;
            return true;
        }
        return false;
    }

    public boolean isLosss(Initialize e) {

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

    public boolean loss(Initialize e) {
        int count = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).getStatus() == -1) {
                    if (e.getelement(i, j).isClicked()) {
                        count++;
                    }
                }
            }
        }
        if (count == e.getMinsNum()) {
            return true;
        }
        return false;
    }

    public boolean iswin1(Initialize e) {
        int count = 0;
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).isClicked() || e.getelement(i, j).isFlag()) {
                    count++;
                }
            }
        }
        if (count == e.getX() * e.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public void endprint(Initialize e) {
        for (int i = 0; i < e.getX(); i++) {
            for (int j = 0; j < e.getY(); j++) {
                bottuns[i][j].setEnabled(false);
            }
        }

    }

    public void time(Initialize e) {

    }

    public void time(Initialize e, Player player, Player player2) {

    }

    public void time(Initialize e, Player player2) {

    }

    public void endtime() {
        try
        {
            if (!task.cancel()) {
            task.cancel();
        }
        }catch(Exception eu){try {
            if (!task2.cancel()) {
                task2.cancel();
            }
        } catch (Exception ex) {
        }}
        

        try {
            if (!task2.cancel()) {
                task2.cancel();
            }
        } catch (Exception ex) {
             try
        {
            if (!task.cancel()) {
            task.cancel();
        }
        }catch(Exception eu){}
            
        }
    }

    public void whenloss(Initialize e) {

        int i, j;
        for (i = 0; i < e.getX(); i++) {
            for (j = 0; j < e.getY(); j++) {
                if (e.getelement(i, j).getStatus() == -1) {
                    if (e.getelement(i, j).isFlag()) {
                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(flagmine);
                    } else {
                        bottuns[i][j].setEnabled(false);
                        bottuns[i][j].setIcon(bombicon2);
                    }

                }
            }
        }
    }

    public void savefile(StoreFile stof) {
        JFileChooser save = new JFileChooser();
        Readfile rf = new Readfile();
        int filetosave = save.showOpenDialog(save);
        if (filetosave != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String path = save.getSelectedFile().toString();
        try {
            ObjectOutputStream out;
            if (rf.p2 == 2) {
                path = path + ".PlayerOneSc";
            } else if (rf.p1 == 2) {
                path = path + ".PlayerOneMi";
            } else if (rf.p3 == 2) {
                path = path + ".PlayerOneMiSh";

            } else if (rf.p4 == 2) {
                path = path + ".PlayerOneScSh";
            } else if (rf.q1 == 2) {
                path = path + ".TwoPlayersMi";
            } else if (rf.q2 == 2) {
                path = path + ".TwoPlayersSc";
            } else if (rf.q3 == 2) {
                path = path + ".TwoPlayersScZ";
            } else if (rf.q4 == 2) {
                path = path + ".TwoPlayersMiSh";
            } else if (rf.q5 == 2) {
                path = path + ".TwoPlayersScSh";
            } else if (rf.q6 == 2) {
                path = path + ".TwoPlayersScShZ";
            }
            else if(rf.o1==2)
            {path=path+".ComPlayerMi";}
            else if(rf.o2==2)
            {path=path+".ComPlayerMiSh";
            }
            FileOutputStream filee = new FileOutputStream(path);
            out = new ObjectOutputStream(filee);
            out.writeObject(stof);
            out.close();
            filee.close();
        } catch (Exception es) {
            es.printStackTrace();
        }
    }

    public void savefilequick(StoreFile stof) {
        try {
            ObjectOutputStream out1;

//          temp1=temp1.createTempFile("TempFile", ".Temp");
            FileOutputStream filee = new FileOutputStream(temp1);
            out1 = new ObjectOutputStream(filee);
            out1.writeObject(stof);
            out1.close();
            filee.close();
        } catch (Exception es) {
            es.printStackTrace();
        }
    }

    public void interface1() {
        JFileChooser save = new JFileChooser();
        int filetosave = save.showOpenDialog(save);
        if (filetosave != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String path1 = save.getSelectedFile().toString();
        if (s1 == 1) {
            main.renameTo(new File(path1 + ".PlayerOneMiShow"));
        } else if (s2 == 1) {
            main.renameTo(new File(path1 + ".PlayerOneScShow"));
        } else if (s3 == 1) {
            main.renameTo(new File(path1 + ".PlayerOneShShow"));
        } else if (s4 == 1) {
            main.renameTo(new File(path1 + ".PlayerOneScShShow"));
        } else if (c1 == 1) {
            main.renameTo(new File(path1 + ".TwoPlayersMiShow"));
        } else if (c2 == 1) {
            main.renameTo(new File(path1 + ".TwoPlayersScShow"));
        } else if (c3 == 1) {
            main.renameTo(new File(path1 + ".TwoPlayersScZShow"));
        } else if (c4 == 1) {
            main.renameTo(new File(path1 + ".TwoPlayersMiShShow"));
        } else if (c5 == 1) {
            main.renameTo(new File(path1 + ".TwoPlayersScShShow"));
        } else if (c6 == 1) {
            main.renameTo(new File(path1 + ".TwoPlayersScZShShow"));
        }else if (k1 == 1) {
            main.renameTo(new File(path1 + ".ComPlayerMi"));
        }else if (k2 == 1) {
            main.renameTo(new File(path1 + ".ComPlayerMiSh"));
        }

//        
//        FileInputStream inna = null;
//        FileOutputStream outta = null;
// 
//        try {
//            inna = new FileInputStream("hani.txt");
//            outta = new FileOutputStream("1");
//            int c;
// 
//            while ((c = inna.read()) != -1) {
//                outta.write(c);
//            }
//        }
//        catch(IOException e) {
//            System.out.println("There is IOException!");
//        }
//        finally {
//            try
//            {
//                if (inna != null) {
//                inna.close();
//            }
//            if (outta != null) {
//                outta.close();
//            }
//            }
//            catch(Exception er){}
//            
//        }
    }

    public String interface3() {
        String path2 = null;
        JFileChooser save = new JFileChooser();
        int filetosave = save.showOpenDialog(save);
        if (filetosave != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        String path1 = save.getSelectedFile().toString();
        if (s2 == 1) {
            path2 = path1 + ".PlayerOneScShow";
            main.renameTo(new File(path2));
        } 
          else  if (s4 == 1) {
            path2=path1+ ".PlayerOneScShShow";
            main.renameTo(new File(path2));
        }  else if (c2 == 1) {
            path2=path1 + ".TwoPlayersScShow";
            main.renameTo(new File(path2));
        } else if (c3 == 1) {
            path2=path1 + ".TwoPlayersScZShow";
            main.renameTo(new File(path2));
        } else if (c5 == 1) {
            path2=path1 + ".TwoPlayersScShShow";
            main.renameTo(new File(path2));
        } else if (c6 == 1) {
            path2=path1 + ".TwoPlayersScZShShow";
            main.renameTo(new File(path2));
        }
        return path2;
    }

    public void interface2() {

        JFrame framem = new JFrame("Options");
        framem.setSize(325, 110);
        framem.setLocationRelativeTo(null);
        framem.setResizable(false);
        framem.setVisible(true);
        framem.setLayout(null);
        JLabel minesl = new JLabel("Do you want to save your game for showing it later?");
        JButton ok = new JButton("Yse");
        JButton no = new JButton("No");

        minesl.setBounds(10, 15, 300, 20);
        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
        Color defaultButtonBackgroundColor = Color.white;
        Color defaultButtonTextColor = Color.red;

//framem.setBackground(Color.red);
//minesm.setBackground(Color.white);
//ok.setBackground(Color.red);
        ok.setFont(defaultFont);
        ok.setBackground(defaultButtonBackgroundColor);
        ok.setForeground(defaultButtonTextColor);
        ok.setBounds(10, 50, 60, 25);
        no.setFont(defaultFont);
        no.setBackground(defaultButtonBackgroundColor);
        no.setForeground(defaultButtonTextColor);
        no.setBounds(240, 50, 60, 25);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {

                framem.setVisible(false);
                interface1();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {

                framem.setVisible(false);

            }
        });
        framem.add(ok);
        framem.add(no);
        framem.add(minesl);

    }

  

   

    public void save() {
        try {
            FileInputStream inn = new FileInputStream(assist);
            ObjectInputStream in = new ObjectInputStream(inn);
            StoreFile sv = (StoreFile) in.readObject();

            inn.close();
            in.close();
            out.writeObject(sv);

        } catch (Exception eo) {
            eo.printStackTrace();
        }
    }

    public void saveScoreBoard(ScoreBoard sb, Player player, Player player2) {
        if (ch == 'w') {
            sb.setId(array.size() + 1);
            array.add(sb);

            try {
                oos.writeObject(array);
                fos.close();
                oos.close();
            } catch (Exception exc) {
            }
        } else if (ch == 'r') {

            try {
                ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) ois.readObject();
                sb.setId(arrab.size() + 1);
                arrab.add(sb);
                ois.close();
                fis.close();
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(arrab);
                fos.close();
                oos.close();
            } catch (Exception exc) {
            }
        }
    }
}
