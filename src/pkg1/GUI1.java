package pkg1;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.omg.CORBA.INITIALIZE;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static pkg1.GUIGame.choice;

import pkg1.Initialize;
import pkg1.Player;
import pkg1.Score;
import pkg1.StartPage;

/**
 *
 * @author Mosab
 */
public class GUI1 extends JFrame {

    StartPage startPage;
    GUIGame GuiGame;
    Twoplayergui tw;
    JPanel startPagePanel, singlePlayerPagePanel, multiPlayerPagePanel, settingsPagePanel, GUIGame;
//Initialize en=new Initialize((int)Math.sqrt(Integer.parseInt(dim)),(int)Math.sqrt(Integer.parseInt(dim)));;
    Container container;
    Random randm = new Random();
    CardLayout card;
    int chosePlan = 0;
    int initTest = 0;
    int sh = 0;
    int counter = 10;
    static String time = "10", armor = "0", ok, name1 = "Player1", mines = "5", dim = "36", name2 = "player2", Bomb = "250", O = "10", auto = "1", lastO = "100", Wflag = "5", Lflag = "1";
    static int sh1 = 0;

    public GUI1(Initialize en, Score score, Player player, Player player2) {
        initView();
        initEvent(en, score, player, player2);
        setTitle("MinesWepper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GuiGame.temp1.deleteOnExit();

        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        en.setMinsNum((int) Integer.parseInt(mines));

        en.setX((int) Math.sqrt(Integer.parseInt(dim)));
        en.setY((int) Math.sqrt(Integer.parseInt(dim)));
        int d2 = en.getY();
        int d1 = en.getX();
        en.setArmorsNum((int) Integer.parseInt(armor));
    }

    public void initView() {
        container = getContentPane();
        card = new CardLayout();
        startPagePanel = new JPanel(null);
        startPagePanel.setBackground(Color.lightGray);
        GUIGame = new JPanel(null);

        startPage = new StartPage(startPagePanel);
    }

    public void initEvent(Initialize en, Score score, Player player, Player player2) {
        add(startPagePanel);
        add(GUIGame);
        //  StoreFile f=new StoreFile();
        container.setLayout(card);
        container.getLayout().addLayoutComponent("startPage", startPagePanel);
        container.getLayout().addLayoutComponent("GUIGame", GUIGame);
        startPage.startPage_setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame("Options");
                frame1.setSize(405, 600);
                frame1.setLayout(null);
                Font defaultFont = new Font("Arial", Font.ITALIC, 16);
                Color defaultButtonBackgroundColor = Color.white;

                frame1.setLocationRelativeTo(null);
                frame1.setResizable(false);

                frame1.setVisible(true);

                JLabel twoplayer = new JLabel(" Two PLAYERS ");
                JLabel oneplayer = new JLabel(" ONE PLAYER ");
                JLabel generaldata = new JLabel(" GENERAL DATA ");
                JLabel playwithscore1 = new JLabel(" PLAYING WITH SCORES");
                JLabel playwithshields = new JLabel(" PLAYING WITH SHIELDS");
                JButton btnTimer = new JButton("Timer");

                //  JTextField fieldmines=new JTextField();
                JButton btnMines = new JButton("Mines");
                JButton btnDim = new JButton("Dimintion");
                JButton btnName = new JButton("Player's name");
                JButton btnName1 = new JButton("First plater's name");
                JButton btnName2 = new JButton("Second player's name");
                JButton btnB = new JButton("Bomb");
                JButton btnO = new JButton("Open");
                JButton btnAuto = new JButton("Auto");
                JButton btnLastO = new JButton("Last_bomb");
                JButton btnWFlag = new JButton("Win_flag");
                JButton btnLFlag = new JButton("Loss_flag");
                JButton btnArmor = new JButton("Number of armors");
                JButton btnok = new JButton("OK");
                oneplayer.setBounds(10, 10, 200, 30);
                btnName.setBounds(220, 10, 170, 30);
                twoplayer.setBounds(10, 60, 200, 30);
                btnName1.setBounds(220, 60, 170, 30);
                btnName2.setBounds(220, 95, 170, 30);
                generaldata.setBounds(10, 145, 200, 30);
                btnDim.setBounds(220, 145, 170, 30);
                btnMines.setBounds(220, 180, 170, 30);
                playwithshields.setBounds(10, 230, 200, 30);
                btnArmor.setBounds(220, 230, 170, 30);
                btnTimer.setBounds(220, 265, 170, 30);
                playwithscore1.setBounds(10, 315, 200, 30);
                btnB.setBounds(220, 315, 170, 30);
                btnO.setBounds(220, 350, 170, 30);
                btnAuto.setBounds(220, 385, 170, 30);
                btnLastO.setBounds(220, 420, 170, 30);
                btnWFlag.setBounds(220, 455, 170, 30);
                btnLFlag.setBounds(220, 490, 170, 30);
                btnok.setBounds(10, 530, 380, 30);

                frame1.add(oneplayer);
                frame1.add(btnName);
                frame1.add(twoplayer);
                frame1.add(btnName1);
                frame1.add(btnName2);
                frame1.add(generaldata);
                frame1.add(btnDim);
                frame1.add(btnMines);
                frame1.add(playwithshields);
                frame1.add(btnArmor);
                frame1.add(btnTimer);
                frame1.add(playwithscore1);
                frame1.add(btnB);
                frame1.add(btnO);
                frame1.add(btnAuto);
                frame1.add(btnLastO);
                frame1.add(btnWFlag);
                frame1.add(btnLFlag);
                frame1.add(btnok);

                btnok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame1.setVisible(false);

                        add(startPagePanel);
                        add(GUIGame);

                        container.setLayout(card);
                        container.getLayout().addLayoutComponent("startPage", startPagePanel);
                        container.getLayout().addLayoutComponent("GUIGame", GUIGame);

                    }

                });
                btnTimer.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 145);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("How much time you wanna choice it?");
                        JLabel minesll = new JLabel("Minimum : 2 seconds.");
                        JLabel mineslll = new JLabel("Maximum : 3 minutes.");

                        JTextField minesm = new JTextField("");
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 10);
                        minesll.setBounds(10, 25, 300, 10);
                        mineslll.setBounds(10, 40, 300, 10);

                        minesm.setBounds(10, 54, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 80, 60, 25);
                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                boolean yes = true;
                                String M = minesm.getText();
                                if (M.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "fill up the gap please!");
                                    time = "10";
                                } else {
                                    for (int i = 0; i < M.length(); i++) {
                                        if (!Character.isDigit(M.charAt(i))) {
                                            JOptionPane.showMessageDialog(null, "The number can't be contained Characters!");
                                            time = "10";
                                            yes = false;
                                        }
                                    }
                                    if (yes == true) {
                                        if ((int) Integer.parseInt(M) <= 1 || (int) Integer.parseInt(M) > 180) {
                                            JOptionPane.showMessageDialog(null, "The number is so small or big");
                                            time = "10";
                                        } else {

                                            time = M;

                                            framem.setVisible(false);

                                        }
                                    }
                                }
                                counter = (int) Integer.parseInt(time);

                            }
                        });

                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);
                        framem.add(minesll);
                        framem.add(mineslll);
                    }

                });

                btnMines.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame framem = new JFrame("mines");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("How many mines you want to choice? Let's know");
                        JTextField minesm = new JTextField("");
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);
                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                boolean yes = true;
                                String M = minesm.getText();
                                if (M.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "fill up the gap please!");
                                    mines = "5";
                                } else {
                                    for (int i = 0; i < M.length(); i++) {
                                        if (!Character.isDigit(M.charAt(i))) {
                                            JOptionPane.showMessageDialog(null, "The number can't be contained Characters!");
                                            mines = "5";
                                            yes = false;
                                        }
                                    }
                                    if (yes == true) {
                                        if ((int) Integer.parseInt(M) <= 0 || (int) Integer.parseInt(M) >= (int) Integer.parseInt(dim)) {
                                            JOptionPane.showMessageDialog(null, "The number is so small or big");
                                            mines = "5";
                                        } else {
                                            if (Integer.valueOf(M) < Integer.valueOf(armor)) {
                                                JOptionPane.showMessageDialog(null, "The number is so small comparing with armors" + "\narmors :" + Integer.valueOf(armor));

                                            } else {
                                                mines = M;
                                                framem.setVisible(false);
                                                en.setMinsNum((int) Integer.parseInt(mines));

                                            }
                                        }
                                    }
                                }

                            }

                        });

                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });
                btnDim.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object[] values = {"25", "36", "49", "64", "81", "100", "121", "144"};

                        JFrame framem = new JFrame("Options");
                        framem.setSize(325, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("What's the dimintion you want to choice? Let's know");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 325, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

//framem.setBackground(Color.red);
//minesm.setBackground(Color.white);
//ok.setBackground(Color.red);
                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String d = (String) minesm.getSelectedItem();
                                if (Integer.valueOf(d) < Integer.valueOf(mines)) {
                                    JOptionPane.showMessageDialog(null, "The dimintion is too small comparing with mines" + "\nmines :" + Integer.valueOf(mines));
                                } else {
                                    dim = (String) minesm.getSelectedItem();
                                    framem.setVisible(false);
                                }
                                en.setX((int) Math.sqrt(Integer.parseInt(dim)));
                                en.setY((int) Math.sqrt(Integer.parseInt(dim)));
                            }

                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });
                btnName.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        name1 = JOptionPane.showInputDialog(null, "Enter your Name ", "", JOptionPane.PLAIN_MESSAGE);
                        player.setName(name1);
                    }
                });
                btnName1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        name1 = JOptionPane.showInputDialog(null, "Enter firs player's name ", "", JOptionPane.PLAIN_MESSAGE);
                        player.setName(name1);
                    }
                });
                btnName2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        name2 = JOptionPane.showInputDialog(null, "Enter second player's name ", "", JOptionPane.PLAIN_MESSAGE);
                        player2.setName(name2);
                    }
                });

                btnB.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Object[] values = {"1", "5", "10", "15", "20", "25", "50", "100", "150", "200", "250", "300", "350", "400", "450", "500", "550", "600", "650", "700", "750", "800", "850", "900", "950", "1000"};
                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("How many points you will loss them when you press a mine");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

//framem.setBackground(Color.red);
//minesm.setBackground(Color.white);
//ok.setBackground(Color.red);
                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Bomb = (String) minesm.getSelectedItem();
                                framem.setVisible(false);

                            }
                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });

                btnO.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

//                   
                        Object[] values = {"0", "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};

                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("Enter How many points you will get when you press empty place");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

//framem.setBackground(Color.red);
//minesm.setBackground(Color.white);
//ok.setBackground(Color.red);
                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                O = (String) minesm.getSelectedItem();
                                framem.setVisible(false);

                            }
                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });

                btnAuto.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Object[] values = {"0", "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50"};
                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("Enter How many points you will get when it opens automatically");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                auto = (String) minesm.getSelectedItem();
                                framem.setVisible(false);

                            }
                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });

                btnLastO.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Object[] values = {"0", "5", "10", "15", "20", "25", "50", "75", "100", "125", "150", "175", "200", "225", "250", "275", "300"};
                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("Enter How many points you will get them from closed mines");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);
                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                lastO = (String) minesm.getSelectedItem();
                                framem.setVisible(false);

                            }
                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });

                btnWFlag.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Object[] values = {"0", "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};
                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("Enter Enter How many points you will get them from flags on closed mines ");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Wflag = (String) minesm.getSelectedItem();
                                framem.setVisible(false);

                            }
                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });

                btnLFlag.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Object[] values = {"0", "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};

                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("Enter Enter How many points you will loss them from flags on closed mines");
                        JComboBox minesm = new JComboBox(values);
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Lflag = (String) minesm.getSelectedItem();
                                framem.setVisible(false);

                            }
                        });
                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }
                });
                btnArmor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame framem = new JFrame("Options");
                        framem.setSize(300, 125);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("How many armors you want to choice? Let's know");
                        JTextField minesm = new JTextField("");
                        JButton ok = new JButton("Ok");
                        minesl.setBounds(10, 10, 300, 20);
                        minesm.setBounds(10, 32, 275, 20);
                        Font defaultFont = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
                        Color defaultButtonBackgroundColor = Color.white;
                        Color defaultButtonTextColor = Color.red;

//framem.setBackground(Color.red);
//minesm.setBackground(Color.white);
//ok.setBackground(Color.red);
                        ok.setFont(defaultFont);
                        ok.setBackground(defaultButtonBackgroundColor);
                        ok.setForeground(defaultButtonTextColor);
                        ok.setBounds(10, 60, 60, 25);
                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                boolean yes = true;
                                String M = minesm.getText();
                                if (M.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "fill up the gap please!");
                                    armor = "0";
                                } else {
                                    for (int i = 0; i < M.length(); i++) {
                                        if (!Character.isDigit(M.charAt(i))) {
                                            JOptionPane.showMessageDialog(null, "The number can't be contained Characters!");
                                            armor = "0";
                                            yes = false;
                                        }
                                    }
                                    if (yes == true) {
                                        if ((int) Integer.parseInt(M) < 0 || (int) Integer.parseInt(M) >= (int) Integer.parseInt(mines)) {
                                            JOptionPane.showMessageDialog(null, "The number is so small or big");
                                            armor = "0";
                                        } else {
                                            armor = M;
                                            player.armorCount = (int) Integer.parseInt(armor);
                                            player2.setArmorCount((int) Integer.parseInt(armor));

                                            framem.setVisible(false);
                                        }
                                    }
                                }
                                en.setArmorsNum(Integer.parseInt(armor));

                            }
                        });

                        framem.add(minesm);
                        framem.add(ok);
                        framem.add(minesl);

                    }

                });

                frame1.getContentPane().setBackground(Color.BLACK);
                btnMines.setBackground(defaultButtonBackgroundColor);
                btnDim.setBackground(defaultButtonBackgroundColor);
                btnName.setBackground(defaultButtonBackgroundColor);
                btnAuto.setBackground(defaultButtonBackgroundColor);
                btnO.setBackground(defaultButtonBackgroundColor);
                btnB.setBackground(defaultButtonBackgroundColor);
                btnLFlag.setBackground(defaultButtonBackgroundColor);
                btnWFlag.setBackground(defaultButtonBackgroundColor);
                btnLastO.setBackground(defaultButtonBackgroundColor);
                btnArmor.setBackground(defaultButtonBackgroundColor);
                btnTimer.setBackground(defaultButtonBackgroundColor);
                btnName2.setBackground(defaultButtonBackgroundColor);
                btnName1.setBackground(defaultButtonBackgroundColor);
                btnok.setBackground(Color.red);
                playwithshields.setBackground(Color.red);

                /* btnMines.setFont(defaultFont);
           btnDim.setFont(defaultFont);
           btnB.setFont(defaultFont);
           btnLFlag.setFont(defaultFont);
           btnAuto.setFont(defaultFont);
           btnName.setFont(defaultFont);
           btnName1.setFont(defaultFont);
           btnName2.setFont(defaultFont);
           btnO.setFont(defaultFont);
           btnok.setFont(defaultFont);
           btnWFlag.setFont(defaultFont);
           btnArmor.setFont(defaultFont);
           btnDim.setFont(defaultFont);
                 */
                twoplayer.setForeground(Color.red);
                playwithshields.setForeground(Color.red);
                oneplayer.setForeground(Color.red);
                generaldata.setForeground(Color.red);
                playwithscore1.setForeground(Color.red);
                oneplayer.setFont(defaultFont);
                twoplayer.setFont(defaultFont);
                generaldata.setFont(defaultFont);
                playwithscore1.setFont(defaultFont);
                playwithshields.setFont(defaultFont);

            }

        });

        startPage.getStartPage_about().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aboutGame
                        = "<html>"
                        + "<big>MinesWepper</big><br><br>"
                        + "<p>Prepared by  <b>Mosab Mhana,Mohammad Abdulaziz,Mutasem Hamed</b><br><br>"
                        + "If you have any comments, ideas.. just let's know<br><br>"
                        + "<u>Note</u><br>"
                        + "<p><i>© Copyright 2018 DamascusFITE.com - All Rights Reserved</i></p>"
                        + "<html>";

            }
        });
        startPage.getStartPag_quick().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                GuiGame.temp1.deleteOnExit();
                Readfile rf = new Readfile();
                try {
                    StoreFile file = rf.temploadfile();
                    if (file != null) {
                        GuiGame.x = 2;
                        GuiGame.timerload = true;
                        GuiGame.timerload2 = true;
                        GuiGame.clickload = true;
                        card.show(container, "GUIGame");

                        if (GuiGame.qu == 1) {
                            GuiGame = new GUIGame(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (GuiGame.qu == 2) {
                            GuiGame = new P1underzero(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (GuiGame.qu == 3) {
                            GuiGame = new ShieldGuigame(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (GuiGame.qu == 4) {
                            GuiGame = new p1underShield(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (GuiGame.qu == 5) {
                            GuiGame.Turn = file.getE().turn1;
                            GuiGame = new Twoplayergui(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (GuiGame.qu == 6) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new Underzero(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (GuiGame.qu == 7) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new Towplayerguiscore(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (GuiGame.qu == 8) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new ShieldTwoplayergui(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());
                        } else if (GuiGame.qu == 9) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new ShieldUnderzero(file.getE(), file.getScore(), GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (GuiGame.qu == 10) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new ShieldTowplayerguiscore(file.getE(), file.getScore(), GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (GuiGame.qu == 11) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new Computergui(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (GuiGame.qu == 12) {
                            GuiGame.Turn = file.getE().turn1;
                            GuiGame = new Shieldcomputerplayer(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        }
                        GuiGame.display(file.getE(), file.getPlayer());
                        GuiGame.mainmenu.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                    }

                } catch (Exception eo) {

                }

            }
        });

        startPage.getStartPag_score().addActionListener(new ActionListener() {
            String pth = null;
            int a = 0;
            StoreFile r;
            StoreFile rr;
            FileInputStream fiss = null;
            ObjectInputStream inn = null;
            String path1 = null;
            FileInputStream fos = null;
            ObjectInputStream oin = null;
            FileInputStream fis1ll;
            ObjectInputStream innn;
            int pop = 0;

            @Override

            public void actionPerformed(ActionEvent e) {
                JTextField show = new JTextField("");
                JButton ok = new JButton("OK");
                JLabel enter = new JLabel("Enter The ID of Game ");
                enter.setBounds(225, 500, 200, 20);
                show.setBounds(350, 500, 150, 20);
                ok.setBounds(500, 500, 60, 20);

                JMenuBar menu = new JMenuBar();
                JMenu sort = new JMenu("Sort by");
                menu.add(sort);
                JMenuItem name = new JMenuItem("Name");
                JMenuItem scoore = new JMenuItem("Score");
                JMenuItem date = new JMenuItem("Date");
                JMenuItem id = new JMenuItem("ID");
                sort.add(name);
                sort.add(scoore);
                sort.add(date);
                sort.add(id);

                menu.setBounds(5, 5, 60, 20);
                JFrame framet = new JFrame("JTable demo");                 // أي قمنا بإنشاء نافذة مع وضع عنوان لها JFrame هنا أنشأنا كائن من الكلاس
                framet.setSize(900, 600);                                  // هنا قمنا بتحديد حجم النافذة. عرضها 500 و طولها 250
                framet.add(enter);
                framet.setLocationRelativeTo(null);
                framet.setLayout(null);
                framet.setResizable(false);
                framet.setVisible(true);// في النافذة بنفسنا Table لذلك سنقوم بتحديد مكان الـ Layout Manager أي لم نستخدم أي null هنا وضعنا
                ok.setBackground(Color.PINK);
                JLabel ll1 = new JLabel("ID");
                JLabel ll2 = new JLabel("Name");
                JLabel ll3 = new JLabel("Score");
                JLabel ll4 = new JLabel("begining Date");
                JLabel ll5 = new JLabel("Ending Date");
                JLabel ll6 = new JLabel("Situation");
                JLabel ll7 = new JLabel("Show");
                framet.add(ll1);
                framet.add(ll2);
                framet.add(ll3);
                framet.add(ll4);
                framet.add(ll5);
                framet.add(ll6);
                framet.add(ll7);
                framet.add(menu);
//                ll1.setBackground(Color.YELLOW);
                ll1.setBounds(10, 30, 60, 10);
                ll2.setBounds(90, 30, 80, 10);
                ll3.setBounds(180, 30, 60, 10);
                ll4.setBounds(310, 30, 150, 10);
                ll5.setBounds(510, 30, 150, 10);
                ll6.setBounds(680, 30, 60, 10);
                ll7.setBounds(760, 30, 60, 10);
                framet.add(show);
                framet.add(ok);
                a = 0;
                JLabel l[][] = new JLabel[10][7];

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 7; j++) {
                        l[i][j] = new JLabel("");
                        framet.add(l[i][j]);
                    }
                }
                l[0][0].setBounds(10, 60, 60, 30);
                l[0][1].setBounds(80, 60, 80, 30);
                l[0][2].setBounds(180, 60, 60, 30);
                l[0][3].setBounds(270, 60, 200, 30);
                l[0][4].setBounds(470, 60, 200, 30);
                l[0][5].setBounds(700, 60, 60, 30);
                l[0][6].setBounds(760, 60, 80, 30);

                l[1][0].setBounds(10, 100, 60, 30);
                l[1][1].setBounds(80, 100, 80, 30);
                l[1][2].setBounds(180, 100, 60, 30);
                l[1][3].setBounds(270, 100, 200, 30);
                l[1][4].setBounds(470, 100, 200, 30);
                l[1][5].setBounds(700, 100, 60, 30);
                l[1][6].setBounds(760, 100, 80, 30);

                l[2][0].setBounds(10, 140, 60, 30);
                l[2][1].setBounds(80, 140, 80, 30);
                l[2][2].setBounds(180, 140, 60, 30);
                l[2][3].setBounds(270, 140, 200, 30);
                l[2][4].setBounds(470, 140, 200, 30);
                l[2][5].setBounds(700, 140, 60, 30);
                l[2][6].setBounds(760, 140, 80, 30);

                l[3][0].setBounds(10, 180, 60, 30);
                l[3][1].setBounds(80, 180, 80, 30);
                l[3][2].setBounds(180, 180, 60, 30);
                l[3][3].setBounds(270, 180, 200, 30);
                l[3][4].setBounds(470, 180, 200, 30);
                l[3][5].setBounds(700, 180, 60, 30);
                l[3][6].setBounds(760, 180, 80, 30);

                l[4][0].setBounds(10, 220, 60, 30);
                l[4][1].setBounds(80, 220, 80, 30);
                l[4][2].setBounds(180, 220, 60, 30);
                l[4][3].setBounds(270, 220, 200, 30);
                l[4][4].setBounds(470, 220, 200, 30);
                l[4][5].setBounds(700, 220, 60, 30);
                l[4][6].setBounds(760, 220, 80, 30);

                l[5][0].setBounds(10, 260, 60, 30);
                l[5][1].setBounds(80, 260, 80, 30);
                l[5][2].setBounds(180, 260, 60, 30);
                l[5][3].setBounds(270, 260, 200, 30);
                l[5][4].setBounds(470, 260, 200, 30);
                l[5][5].setBounds(700, 260, 60, 30);
                l[5][6].setBounds(760, 260, 80, 30);

                l[6][0].setBounds(10, 300, 60, 30);
                l[6][1].setBounds(80, 300, 80, 30);
                l[6][2].setBounds(180, 300, 60, 30);
                l[6][3].setBounds(270, 300, 200, 30);
                l[6][4].setBounds(470, 300, 200, 30);
                l[6][5].setBounds(700, 300, 60, 30);
                l[6][6].setBounds(760, 300, 80, 30);

                l[7][0].setBounds(10, 340, 60, 30);
                l[7][1].setBounds(80, 340, 80, 30);
                l[7][2].setBounds(180, 340, 60, 30);
                l[7][3].setBounds(270, 340, 200, 30);
                l[7][4].setBounds(470, 340, 200, 30);
                l[7][5].setBounds(700, 340, 60, 30);
                l[7][6].setBounds(760, 340, 80, 30);

                l[8][0].setBounds(10, 380, 60, 30);
                l[8][1].setBounds(80, 380, 80, 30);
                l[8][2].setBounds(180, 380, 60, 30);
                l[8][3].setBounds(270, 380, 200, 30);
                l[8][4].setBounds(470, 380, 200, 30);
                l[8][5].setBounds(700, 380, 60, 30);
                l[8][6].setBounds(760, 380, 80, 30);

                l[9][0].setBounds(10, 410, 60, 30);
                l[9][1].setBounds(80, 410, 80, 30);
                l[9][2].setBounds(180, 410, 60, 30);
                l[9][3].setBounds(270, 410, 200, 30);
                l[9][4].setBounds(470, 410, 200, 30);
                l[9][5].setBounds(700, 410, 60, 30);
                l[9][6].setBounds(760, 410, 80, 30);

                try {
                    FileInputStream fis = new FileInputStream("hani.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) ois.readObject();
                    Iterator itr = arrab.iterator();

                    //pth.add(arrab.get(a-1).getId(),arrab.get(a-1).getPath());
                    for (Iterator<ScoreBoard> iterator = arrab.iterator(); iterator.hasNext();) {
                        l[a][0].setText("" + arrab.get(a).getId());
                        l[a][1].setText("" + arrab.get(a).getName1());
                        l[a][2].setText("" + arrab.get(a).getScore1());
                        l[a][3].setText("" + arrab.get(a).getDate());
                        l[a][4].setText("" + arrab.get(a).getDate2());

                        if (!arrab.get(a).isState()) {
                            l[a][5].setText("Loss");
                        } else if (arrab.get(a).isState()) {
                            l[a][5].setText("Win");
                        }
                        if (arrab.get(a).getPath() != null) {
                            l[a][6].setText("Acceptable");
                        }

                        if (iterator.hasNext()) {
                            ois.close();
                            fis.close();

                        }
                        a++;

                    }

                } catch (IndexOutOfBoundsException es) {

                } catch (IOException dffd) {

                } catch (ClassNotFoundException dfsf) {

                }

                id.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int a = 0;
                        try {
                            FileInputStream fis = new FileInputStream("hani.txt");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) ois.readObject();
                            Iterator itr = arrab.iterator();
                            for (Iterator<ScoreBoard> iterator = arrab.iterator(); iterator.hasNext();) {
                                l[a][0].setText("" + arrab.get(a).getId());
                                l[a][1].setText("" + arrab.get(a).getName1());
                                l[a][2].setText("" + arrab.get(a).getScore1());
                                l[a][3].setText("" + arrab.get(a).getDate());
                                l[a][4].setText("" + arrab.get(a).getDate2());
                                if (!arrab.get(a).isState()) {
                                    l[a][5].setText("Loss");
                                } else if (arrab.get(a).isState()) {
                                    l[a][5].setText("Win");
                                }
                                if (arrab.get(a).getPath() != null) {
                                    l[a][6].setText("Acceptable");
                                } else {
                                    l[a][6].setText("");
                                }
                                if (iterator.hasNext()) {
                                    ois.close();
                                    fis.close();

                                }
                                a++;

                            }

                        } catch (IndexOutOfBoundsException es) {

                        } catch (IOException dffd) {

                        } catch (ClassNotFoundException dfsf) {

                        }

                    }
                });
                scoore.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int a = 0;

                        try {
                            FileInputStream fis = new FileInputStream("hani.txt");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) ois.readObject();
                            Iterator itr = arrab.iterator();
                            for (Iterator<ScoreBoard> iterator = arrab.iterator(); iterator.hasNext();) {
                                l[a][0].setText("" + arrab.get(a).getId());
                                l[a][1].setText("" + arrab.get(a).getName1());
                                l[a][2].setText("" + arrab.get(a).getScore1());
                                l[a][3].setText("" + arrab.get(a).getDate());
                                l[a][4].setText("" + arrab.get(a).getDate2());
                                if (!arrab.get(a).isState()) {
                                    l[a][5].setText("Loss");
                                } else if (arrab.get(a).isState()) {
                                    l[a][5].setText("Win");
                                }
                                if (iterator.hasNext()) {
                                    ois.close();
                                    fis.close();
                                    try {
                                        fis = new FileInputStream("hani.txt");
                                        ois = new ObjectInputStream(fis);
                                        arrab = (ArrayList<ScoreBoard>) ois.readObject();
                                        arrab = compar2(arrab);
                                        a = 0;
                                        for (iterator = arrab.iterator(); iterator.hasNext();) {
                                            l[a][0].setText("" + arrab.get(a).getId());
                                            l[a][1].setText("" + arrab.get(a).getName1());
                                            l[a][2].setText("" + arrab.get(a).getScore1());
                                            l[a][3].setText("" + arrab.get(a).getDate());
                                            l[a][4].setText("" + arrab.get(a).getDate2());
                                            if (!arrab.get(a).isState()) {
                                                l[a][5].setText("Loss");
                                            } else if (arrab.get(a).isState()) {
                                                l[a][5].setText("Win");
                                            }
                                            if (arrab.get(a).getPath() != null) {
                                                l[a][6].setText("Acceptable");
                                            } else {
                                                l[a][6].setText("");
                                            }
                                            if (iterator.hasNext()) {
                                                ois.close();
                                                fis.close();
                                            }

                                            a++;

                                        }

                                    } catch (Exception ei) {
                                    }
                                }
                                a++;

                            }

                        } catch (IndexOutOfBoundsException es) {

                        } catch (IOException dffd) {

                        } catch (ClassNotFoundException dfsf) {

                        }

                    }
                });
                date.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            FileInputStream fis = new FileInputStream("hani.txt");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) ois.readObject();
                            Iterator itr = arrab.iterator();
                            int a = 0;
                            for (Iterator<ScoreBoard> iterator = arrab.iterator(); iterator.hasNext();) {
                                l[a][0].setText("" + arrab.get(a).getId());
                                l[a][1].setText("" + arrab.get(a).getName1());
                                l[a][2].setText("" + arrab.get(a).getScore1());
                                l[a][3].setText("" + arrab.get(a).getDate());
                                l[a][4].setText("" + arrab.get(a).getDate2());

                                if (!arrab.get(a).isState()) {
                                    l[a][5].setText("Loss");
                                } else if (arrab.get(a).isState()) {
                                    l[a][5].setText("Win");
                                }
//                                
                                if (iterator.hasNext()) {
                                    ois.close();
                                    fis.close();
                                    try {
                                        fis = new FileInputStream("hani.txt");
                                        ois = new ObjectInputStream(fis);
                                        arrab = (ArrayList<ScoreBoard>) ois.readObject();
                                        itr = arrab.iterator();
                                        int y = 0;
                                        for (int i = a; i >= 0; i--) {
                                            l[y][0].setText("" + arrab.get(i).getId());
                                            l[y][1].setText("" + arrab.get(i).getName1());
                                            l[y][2].setText("" + arrab.get(i).getScore1());
                                            l[y][3].setText("" + arrab.get(i).getDate());
                                            l[y][4].setText("" + arrab.get(i).getDate2());
                                            if (!arrab.get(i).isState()) {
                                                l[y][5].setText("Loss");
                                            } else if (arrab.get(i).isState()) {
                                                l[y][5].setText("Win");
                                            }
                                            if (arrab.get(i).getPath() != null) {
                                                l[y][6].setText("Acceptable");
                                            } else {
                                                l[y][6].setText("");
                                            }
                                            if (iterator.hasNext()) {
                                                ois.close();
                                                fis.close();
                                            }
                                            y++;
                                        }

                                    } catch (Exception ei) {
                                    }

                                }
                                a++;

                            }

                        } catch (IndexOutOfBoundsException es) {

                        } catch (IOException dffd) {

                        } catch (ClassNotFoundException dfsf) {

                        }

                    }
                });
                name.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int a = 0;

                        try {
                            FileInputStream fis = new FileInputStream("hani.txt");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) ois.readObject();
                            Iterator itr = arrab.iterator();
                            for (Iterator<ScoreBoard> iterator = arrab.iterator(); iterator.hasNext();) {
                                l[a][0].setText("" + arrab.get(a).getId());
                                l[a][1].setText("" + arrab.get(a).getName1());
                                l[a][2].setText("" + arrab.get(a).getScore1());
                                l[a][3].setText("" + arrab.get(a).getDate());
                                l[a][4].setText("" + arrab.get(a).getDate2());
                                if (!arrab.get(a).isState()) {
                                    l[a][5].setText("Loss");
                                } else if (arrab.get(a).isState()) {
                                    l[a][5].setText("Win");
                                }
                                if (iterator.hasNext()) {
                                    ois.close();
                                    fis.close();
                                    try {
                                        fis = new FileInputStream("hani.txt");
                                        ois = new ObjectInputStream(fis);
                                        arrab = (ArrayList<ScoreBoard>) ois.readObject();
                                        arrab = compar(arrab);
                                        a = 0;
                                        for (iterator = arrab.iterator(); iterator.hasNext();) {
                                            l[a][0].setText("" + arrab.get(a).getId());
                                            l[a][1].setText("" + arrab.get(a).getName1());
                                            l[a][2].setText("" + arrab.get(a).getScore1());
                                            l[a][3].setText("" + arrab.get(a).getDate());
                                            l[a][4].setText("" + arrab.get(a).getDate2());
                                            if (!arrab.get(a).isState()) {
                                                l[a][5].setText("Loss");
                                            } else if (arrab.get(a).isState()) {
                                                l[a][5].setText("Win");
                                            }
                                            if (arrab.get(a).getPath() != null) {
                                                l[a][6].setText("Acceptable");
                                            } else {
                                                l[a][6].setText("");
                                            }

//                                            
                                            if (iterator.hasNext()) {
                                                ois.close();
                                                fis.close();
                                            }

                                            a++;

                                        }

                                    } catch (Exception ei) {
                                    }
                                }
                                a++;

                            }

                        } catch (IndexOutOfBoundsException es) {

                        } catch (IOException dffd) {

                        } catch (ClassNotFoundException dfsf) {

                        }

                    }
                });

                ok.addActionListener(new ActionListener() {
                    int k = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            fos = new FileInputStream("hani.txt");
                            oin = new ObjectInputStream(fos);
                            ArrayList<ScoreBoard> arrab = (ArrayList<ScoreBoard>) oin.readObject();
                            Iterator itr = arrab.iterator();
                            for (Iterator<ScoreBoard> iterator = arrab.iterator(); iterator.hasNext();) {
                                pth = arrab.get(k).getPath();
                                if (Integer.parseInt(show.getText().toString()) == arrab.get(k).getId() && arrab.get(k).getPath() != null) {
//                                pth= arrab.get(k-1).getPath();             

//                             try{oin.close();
//                             fos.close();
//                             }catch(Exception er){}
                                    try {

                                        fis1ll = new FileInputStream(new File(pth));
                                        innn = new ObjectInputStream(fis1ll);
                                        rr = (StoreFile) innn.readObject();

                                    } catch (Exception es) {
                                    }

                                    framet.setVisible(false);
                                    card.show(container, "GUIGame");
                                    if (pth.endsWith("PlayerOneScShow")) {
                                        GuiGame.choice = 2;
                                        GuiGame = new P1underzero(rr.getE(), rr.getScore(), GUIGame, rr.getPlayer(), player2);
                                    } else if (pth.endsWith("PlayerOneScShShow")) {
                                        GuiGame.choice = 4;
                                        GuiGame = new p1underShield(rr.getE(), rr.getScore(), GUIGame, rr.getPlayer(), player2);
                                    } else if (pth.endsWith("TwoPlayersScShow")) {
                                        GuiGame.choice = 7;
                                        GuiGame = new Underzero(rr.getE(), rr.getScore(), GUIGame, rr.getPlayer(), rr.getPlayer2());
                                    } else if (pth.endsWith("TwoPlayersScZShow")) {
                                        GuiGame.choice = 8;
                                        GuiGame = new Towplayerguiscore(rr.getE(), rr.getScore(), GUIGame, rr.getPlayer(), rr.getPlayer2());
                                    } else if (pth.endsWith("TwoPlayersScShShow")) {
                                        GuiGame.choice = 9;
                                        GuiGame = new ShieldUnderzero(rr.getE(), rr.getScore(), GUIGame, rr.getPlayer(), rr.getPlayer2());
                                    } else if (pth.endsWith("TwoPlayersScZShShow")) {
                                        GuiGame.choice = 10;
                                        GuiGame = new ShieldTowplayerguiscore(rr.getE(), rr.getScore(), GUIGame, rr.getPlayer(), rr.getPlayer2());
                                    }

                                    GuiGame.endprint(rr.getE());
                                    GuiGame.display(rr.getE(), rr.getPlayer());

                                    GuiGame.next.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            try {
                                                pop++;
                                                rr = (StoreFile) innn.readObject();
                                                GuiGame.display(rr.getE(), rr.getPlayer());
                                                if (GuiGame.choice == 2 || GuiGame.choice == 4) {
                                                    JOptionPane.showMessageDialog(null, "Your score is  : " + r.getPlayer().score);
                                                } else if (GuiGame.choice == 7 || GuiGame.choice == 8 || GuiGame.choice == 9 || GuiGame.choice == 10) {
                                                    if (pop == 1) {
                                                        JOptionPane.showMessageDialog(null, r.getPlayer().getName() + "'s score is : " + r.getPlayer().score);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, r.getPlayer().getName() + "'s score is : " + r.getPlayer().score + "\n" + r.getPlayer2().getName() + "'s score is : " + r.getPlayer2().score);
                                                    }
                                                }
                                            } catch (Exception es) {
                                                try {
                                                    innn.close();
                                                    fis1ll.close();
                                                } catch (Exception e3) {
                                                }
                                                JOptionPane.showMessageDialog(null, "The Game has been Done!");
                                            }

                                        }
                                    });

                                    break;
                                } else {
                                    k++;
                                }

                                if (iterator.hasNext()) {
                                    oin.close();
                                    fos.close();

                                }

//                        }
                            }

                        } catch (IOException dffd) {

                        } catch (ClassNotFoundException dfsf) {
                        } catch (Exception es) {
                            framet.setVisible(false);
//                          framet.setVisible(true);

                        }

                    }
                });

            }

        });
        startPage.getStartPag_Show().addActionListener(new ActionListener() {
            FileInputStream fis = null;
            ObjectInputStream in = null;
            StoreFile r;
            int x = 1;
            int pop = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser save = new JFileChooser();
                int filetosave = save.showOpenDialog(save);
                if (filetosave != JFileChooser.APPROVE_OPTION) {
                    return;
                }
                String path1 = save.getSelectedFile().toString();
//
                try {

                    fis = new FileInputStream(path1);
                    in = new ObjectInputStream(fis);

//            }
                    r = (StoreFile) in.readObject();
                } catch (Exception es) {
                }

                card.show(container, "GUIGame");
                if (path1.endsWith("PlayerOneMiShow")) {
                    GuiGame.choice = 1;
                    GuiGame = new GUIGame(r.getE(), score, GUIGame, r.getPlayer(), player2);

                } else if (path1.endsWith("PlayerOneScShow")) {
                    GuiGame.choice = 2;
                    GuiGame = new P1underzero(r.getE(), r.getScore(), GUIGame, r.getPlayer(), player2);
                } else if (path1.endsWith("PlayerOneShShow")) {
                    GuiGame.choice = 3;
                    GuiGame = new ShieldGuigame(r.getE(), score, GUIGame, r.getPlayer(), player2);
                } else if (path1.endsWith("PlayerOneScShShow")) {
                    GuiGame.choice = 4;
                    GuiGame = new p1underShield(r.getE(), r.getScore(), GUIGame, r.getPlayer(), player2);
                } else if (path1.endsWith("TwoPlayersMiShow")) {
                    GuiGame.choice = 5;
                    GuiGame = new Twoplayergui(r.getE(), score, GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("TwoPlayersScShow")) {
                    GuiGame.choice = 7;
                    GuiGame = new Underzero(r.getE(), r.getScore(), GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("TwoPlayersScZShow")) {
                    GuiGame.choice = 8;
                    GuiGame = new Towplayerguiscore(r.getE(), r.getScore(), GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("TwoPlayersMiShShow")) {
                    GuiGame.choice = 6;
                    GuiGame = new ShieldTwoplayergui(r.getE(), score, GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("TwoPlayersScShShow")) {
                    GuiGame.choice = 9;
                    GuiGame = new ShieldUnderzero(r.getE(), r.getScore(), GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("TwoPlayersScZShShow")) {
                    GuiGame.choice = 10;
                    GuiGame = new ShieldTowplayerguiscore(r.getE(), r.getScore(), GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("ComPlayerMi")) {
                    GuiGame.choice = 11;
                    GuiGame = new Computergui(r.getE(), r.getScore(), GUIGame, r.getPlayer(), r.getPlayer2());
                } else if (path1.endsWith("ComPlayerMiSh")) {
                    GuiGame.choice = 12;
                    GuiGame = new Shieldcomputerplayer(r.getE(), r.getScore(), GUIGame, r.getPlayer(), r.getPlayer2());
                }
                GuiGame.endprint(r.getE());
                GuiGame.display(r.getE(), r.getPlayer());
                GuiGame.next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            pop++;
                            r = (StoreFile) in.readObject();
                            GuiGame.display(r.getE(), r.getPlayer());
                            if (GuiGame.choice == 2 || GuiGame.choice == 4) {
                                JOptionPane.showMessageDialog(null, "Your score is  : " + r.getPlayer().score);
                            } else if (GuiGame.choice == 7 || GuiGame.choice == 8 || GuiGame.choice == 9 || GuiGame.choice == 10) {
                                if (pop == 1) {
                                    JOptionPane.showMessageDialog(null, r.getPlayer().getName() + "'s score is : " + r.getPlayer().score);
                                } else {
                                    JOptionPane.showMessageDialog(null, r.getPlayer().getName() + "'s score is : " + r.getPlayer().score + "\n" + r.getPlayer2().getName() + "'s score is : " + r.getPlayer2().score);
                                }
                            }

                        } catch (Exception es) {
                            try {
                                in.close();
                                fis.close();
                            } catch (Exception e3) {
                            }
                            JOptionPane.showMessageDialog(null, "The Game has been Done!");
                        }

                    }
                });
                GuiGame.mainmenu.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame framem = new JFrame("Options");
                        framem.setSize(250, 100);
                        framem.setLocationRelativeTo(null);
                        framem.setResizable(false);
                        framem.setVisible(true);
                        framem.setLayout(null);
                        JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                        no.setBounds(180, 40, 60, 25);

                        ok.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                framem.setVisible(false);
                                GUIGame.removeAll();
                                GuiGame.restar(en, score, player, player2);
                                card.show(container, "startPage");

                            }
                        });
                        no.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                framem.setVisible(false);

                            }
                        });
                        framem.add(ok);
                        framem.add(no);
                        framem.add(minesl);

                    }
                });

            }
        });
        startPage.getStartPage_exit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startPage.startPage_load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Readfile rf = new Readfile();
                try {

                    StoreFile file = rf.loadfile();
                    if (file != null) {
                        GuiGame.x = 2;
                        GuiGame.timerload = true;
                        GuiGame.timerload2 = true;
                        GuiGame.clickload = true;
                        card.show(container, "GUIGame");
                        if (rf.p1 == 1) {
                            GuiGame = new GUIGame(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (rf.p2 == 1) {
                            GuiGame = new P1underzero(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (rf.p3 == 1) {
                            GuiGame = new ShieldGuigame(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (rf.p4 == 1) {
                            GuiGame = new p1underShield(file.getE(), score, GUIGame, file.getPlayer(), player2);
                        } else if (rf.q1 == 1) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new Twoplayergui(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (rf.q2 == 1) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new Underzero(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (rf.q3 == 1) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new Towplayerguiscore(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (rf.q4 == 1) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new ShieldTwoplayergui(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());
                        } else if (rf.q5 == 1) {
                            GuiGame.Turn = file.getE().turn1;

                            GuiGame = new ShieldUnderzero(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (rf.q6 == 1) {
                            GuiGame.Turn = file.getE().turn1;
                            GuiGame = new ShieldTowplayerguiscore(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (rf.o1 == 1) {
                            GuiGame.Turn = file.getE().turn1;
                            GuiGame = new Computergui(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        } else if (rf.o2 == 1) {
                            GuiGame.Turn = file.getE().turn1;
                            GuiGame = new Shieldcomputerplayer(file.getE(), score, GUIGame, file.getPlayer(), file.getPlayer2());

                        }

                        GuiGame.display(file.getE(), file.getPlayer());
                        GuiGame.mainmenu.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });
//hhh
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        startPage.startPage_singlePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Options");
                frame1.setSize(400, 250);
                frame1.setLayout(null);

                frame1.setLocationRelativeTo(null);
                frame1.setResizable(false);

                frame1.setVisible(true);
                frame1.setLayout(new GridLayout(4, 1));

                JButton btnPlayMines = new JButton("Lossing at first mine");
                JButton btnPlayScore = new JButton("Lossing when beacoming under zero");
                JButton btnPlayMinessh = new JButton("Lossing at first mine in addition with shields");
                JButton btnPlayScoresh = new JButton("Lossing when beacoming under zero in addition with shields");
                frame1.getContentPane().setBackground(Color.darkGray);

                btnPlayMines.setBounds(85, 30, 240, 30);
                btnPlayScore.setBounds(85, 90, 240, 30);
                frame1.add(btnPlayMines);
                frame1.add(btnPlayScore);
                frame1.add(btnPlayMinessh);
                frame1.add(btnPlayScoresh);
                btnPlayMines.setBackground(Color.white);
                btnPlayScore.setBackground(Color.white);
                btnPlayMinessh.setBackground(Color.white);
                btnPlayScoresh.setBackground(Color.white);

                btnPlayMines.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.setVisible(false);

                        GuiGame = new GUIGame(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.p1 = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 1;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
//             GuiGame.newoption.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                en.setMinsNum(0);
//                                JButton bottuns[][]=new JButton[en.getX()][en.getY()];
//                                  for (int i = 0; i < en.getX(); i++) {
//            for (int j = 0; j < en.getY(); j++) {
//                
//                bottuns[i][j].setText(null);
//                bottuns[i][j].setIcon(null);
//                
//                bottuns[i][j].setBackground(null);
//                bottuns[i][j].setEnabled(true);
//                bottuns[i][j].setBackground(Color.darkGray);
//
//            }
//        }
//                                Initialize e1=new Initialize(6, 6, 5, 0);
//                                GuiGame.x=0;
//card.show(container, "GUIGame");
//                                          GuiGame = new GUIGame(e1,score, GUIGame, player);
//System.out.print("mbmb");
//// GuiGame.display(e, );
//                            }
//                        });

                    }

                });
                btnPlayScore.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.setVisible(false);

                        GuiGame = new P1underzero(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GuiGame.x = 0;
                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.p2 = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });

                    }
                });
                btnPlayScoresh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        while (sh1 == Integer.valueOf(mines)) {
                            if (Integer.valueOf(dim) == Integer.valueOf(mines) + 1) {
                                sh1 = 0;
                                return;
                            }
                            sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        }
                        frame1.setVisible(false);

                        GuiGame = new p1underShield(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");

                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GuiGame.x = 0;
                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

//                                GuiGame.getGamePage_back().addActionListener(new ActionListener() {
//                                    @Override
//                                    public void actionPerformed(ActionEvent e) {
//                                        GUIGame.removeAll();
//                                        GuiGame.restar(en, score, player);
//                                       card.show(container, "startPage");
//
//                                    }
//                                });
                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.p4 = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 4;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                    }
                });
                btnPlayMinessh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        while (sh1 == Integer.valueOf(mines)) {
                            if (Integer.valueOf(dim) == Integer.valueOf(mines) + 1) {
                                sh1 = 0;
                                return;
                            }
                            sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        }
                        en.setArmorsNum(sh1);
                        int sh = en.getArmorsNum();
                        new Initialize(36, 36, 5, sh);

                        frame1.setVisible(false);
                        GuiGame = new ShieldGuigame(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.p3 = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 3;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                    }
                });

            }
        });
        startPage.startPage_multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Options");
                frame2.setSize(400, 300);
                frame2.setResizable(false);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
                frame2.setLayout(new GridLayout(6, 1));

                JButton btnPlayMines2 = new JButton("Lossing at first mine");
                JButton btnPlayScore = new JButton("Lossing when beacoming under zero");
                JButton btnPlayScoreunderzero = new JButton("Playing with scores under zero");
                JButton btnPlayMinessh = new JButton("Lossing at first mine in addition with shields");
                JButton btnPlayScoresh = new JButton("Lossing when beacoming under zero in addition with shields");
                JButton btnPlayScoreunderzerosh = new JButton("Playing with score under zero in addition with shields");

                frame2.getContentPane().setBackground(Color.darkGray);

                btnPlayMines2.setBounds(85, 30, 240, 30);
                btnPlayScore.setBounds(85, 90, 240, 30);
                frame2.add(btnPlayMines2);
                frame2.add(btnPlayScore);
                frame2.add(btnPlayScoreunderzero);

                frame2.add(btnPlayMinessh);
                frame2.add(btnPlayScoresh);
                frame2.add(btnPlayScoreunderzerosh);

                btnPlayMines2.setBackground(Color.white);
                btnPlayScore.setBackground(Color.white);
                btnPlayMinessh.setBackground(Color.white);
                btnPlayScoresh.setBackground(Color.white);

                btnPlayScoreunderzero.setBackground(Color.white);
                btnPlayScoreunderzerosh.setBackground(Color.white);

                btnPlayMines2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        GuiGame = new Twoplayergui(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {

                            @Override

                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {

                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);
                                rf.q1 = 2;
                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 5;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });

                    }
                });
                btnPlayScore.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        GuiGame = new Underzero(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.q2 = 2;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 6;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                    }
                });
                btnPlayScoresh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        while (sh1 == Integer.valueOf(mines)) {
                            if (Integer.valueOf(dim) == Integer.valueOf(mines) + 1) {
                                sh1 = 0;
                                return;
                            }
                            sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        }
                        en.setArmorsNum(sh1);
                        int sh = en.getArmorsNum();
                        new Initialize(36, 36, 5, sh);
                        GuiGame = new ShieldUnderzero(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.q5 = 2;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 9;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });

                    }
                });
                btnPlayMinessh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        while (sh1 == Integer.valueOf(mines)) {
                            if (Integer.valueOf(dim) == Integer.valueOf(mines) + 1) {
                                sh1 = 0;
                                return;
                            }
                            sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        }
                        en.setArmorsNum(sh1);
                        int sh = en.getArmorsNum();
                        new Initialize(36, 36, 5, sh);

                        GuiGame = new ShieldTwoplayergui(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.q4 = 2;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 8;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                    }
                });
                btnPlayScoreunderzero.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        GuiGame = new Towplayerguiscore(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.q3 = 2;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 7;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                    }
                });
                btnPlayScoreunderzerosh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                        sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        while (sh1 == Integer.valueOf(mines)) {
                            if (Integer.valueOf(dim) == Integer.valueOf(mines) + 1) {
                                sh1 = 0;
                                return;
                            }
                            sh1 = randm.nextInt(Integer.valueOf(mines) - Integer.valueOf(GUI1.armor));
                        }
                        en.setArmorsNum(sh1);

                        int sh = en.getArmorsNum();
                        new Initialize(36, 36, 5, sh);
                        GuiGame = new ShieldTowplayerguiscore(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });

                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.q6 = 2;
                                StoreFile fille = new StoreFile(en, player, player2);

                                en.turn1 = GuiGame.Turn;
                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 10;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                    }
                });

            }
        });
        startPage.startPage_computerPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Options");
                frame1.setSize(400, 150);
                frame1.setLayout(null);

                frame1.setLocationRelativeTo(null);
                frame1.setResizable(false);

                frame1.setVisible(true);
                frame1.setLayout(new GridLayout(2, 1));

                JButton btnPlayMines = new JButton("Lossing at first mine");
                JButton btnPlayMinessh = new JButton("Lossing at first mine in addition with shields");
                frame1.getContentPane().setBackground(Color.darkGray);

                frame1.add(btnPlayMines);
                frame1.add(btnPlayMinessh);
                btnPlayMines.setBackground(Color.white);
                btnPlayMinessh.setBackground(Color.white);

                btnPlayMines.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame1.setVisible(false);
                        GuiGame = new Computergui(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");

                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back to main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });
                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.o1 = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });

                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 11;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });

                    }
                });
                btnPlayMinessh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame1.setVisible(false);
                        GuiGame = new Shieldcomputerplayer(en, score, GUIGame, player, player2);
                        card.show(container, "GUIGame");
                        GuiGame.mainmenu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame framem = new JFrame("Options");
                                framem.setSize(250, 100);
                                framem.setLocationRelativeTo(null);
                                framem.setResizable(false);
                                framem.setVisible(true);
                                framem.setLayout(null);
                                JLabel minesl = new JLabel("Are you sure to come back main menue?");
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
                                no.setBounds(180, 40, 60, 25);

                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);
                                        GUIGame.removeAll();
                                        GuiGame.restar(en, score, player, player2);
                                        card.show(container, "startPage");

                                    }
                                });
                                no.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        framem.setVisible(false);

                                    }
                                });
                                framem.add(ok);
                                framem.add(no);
                                framem.add(minesl);

                            }
                        });
                        GuiGame.save.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                rf.o2 = 2;
                                StoreFile fille = new StoreFile(en, player);

                                try {
                                    GuiGame.savefile(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });
                        GuiGame.quick.addActionListener(new ActionListener() {
                            Readfile rf;

                            @Override
                            public void actionPerformed(ActionEvent e1) {
                                GuiGame.qu = 12;
                                en.turn1 = GuiGame.Turn;
                                StoreFile fille = new StoreFile(en, player, player2);

                                try {
                                    GuiGame.savefilequick(fille);
                                } catch (Exception es) {
                                    es.printStackTrace();
                                }
                            }

                        });

                    }
                });

            }
        });

    }

    public static ArrayList<ScoreBoard> compar(ArrayList<ScoreBoard> m) {
        ScoreBoard temp = null;
        for (int i = 0; i < m.size() - 1; i++) {
            if (m.get(i).getName1().compareToIgnoreCase((String) m.get(i + 1).getName1()) > 0) {
                temp = m.get(i);
                m.set(i, m.get(i + 1));
                m.set(i + 1, temp);
                compar(m);
            }

        }
        return m;
    }

    public static ArrayList<ScoreBoard> compar2(ArrayList<ScoreBoard> m) {
        ScoreBoard temp = null;
        for (int i = 0; i < m.size() - 1; i++) {
            if (m.get(i).getScore1().compareTo((Integer) m.get(i + 1).getScore1()) < 0) {
                temp = m.get(i);
                m.set(i, m.get(i + 1));
                m.set(i + 1, temp);
                compar2(m);
            }

        }
        return m;
    }

}
