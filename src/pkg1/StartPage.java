package pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPage extends PlayGame {

    JButton startPage_singlePlayer;
    JButton startPage_multiPlayer;
    JButton startPage_computerPlayer;
    JButton startPage_load;
    JButton startPage_about;
    JButton startPage_exit;
    JButton startPage_setting;
    JButton startPag_Show;
    JButton startPag_score;
    JButton startPag_quick;
    Font defaultFont = new Font("Arial", Font.ITALIC, 16);
    Color defaultButtonBackgroundColor = Color.darkGray;
    Color defaultButtonTextColor = Color.white;

    StartPage(JPanel startPage) {

        initView(startPage);

        initEvent(startPage);

        setThem(defaultFont, defaultButtonTextColor, defaultButtonBackgroundColor);

    }

    public void initView(JPanel startPage) {

        startPage_singlePlayer = new JButton("Single Player");
        startPage_multiPlayer = new JButton("Multi Player");
        startPage_computerPlayer = new JButton("Computer Player");
        startPage_load = new JButton("Load Game");
        startPage_about = new JButton("About");
        startPage_exit = new JButton("Exit");
        startPage_setting = new JButton("Setting");
        startPag_Show = new JButton("Show");
        startPag_score = new JButton("Score board");
          startPag_quick = new JButton("Quick load");
    }

    public void initEvent(JPanel startPage) {
        startPage.add(startPage_singlePlayer);
        startPage.add(startPage_multiPlayer);
        startPage.add(startPage_computerPlayer);
        startPage.add(startPage_setting);
        startPage.add(startPage_about);
        startPage.add(startPage_exit);
        startPage.add(startPage_load);
        startPage.add(startPag_Show);
        startPage.add(startPag_score);
 startPage.add(startPag_quick);
        // تحديد الحجم والموقع
        startPage_singlePlayer.setBounds(275, 85, 240, 40);
        startPage_multiPlayer.setBounds(275, 140, 240, 40);
        startPage_computerPlayer.setBounds(275, 195, 240, 40);
        startPage_load.setBounds(275, 250, 240, 40);
        startPag_Show.setBounds(275, 350, 240, 40);
        startPag_score.setBounds(275, 400, 240, 40);
        startPage_setting.setBounds(275, 450, 240, 40);
        startPage_about.setBounds(275, 500, 240, 40);
        startPage_exit.setBounds(275, 550, 240, 40);
startPag_quick.setBounds(275, 300, 240, 40);
    }

    public JButton getStartPag_quick() {
        return startPag_quick;
    }

    public JButton getStartPage_singlePlayer() {
        return startPage_singlePlayer;
    }

    public JButton getStartPag_Show() {
        return startPag_Show;
    }

    public JButton getStartPage_multiPlayer() {
        return startPage_multiPlayer;
    }

    public JButton getStartPage_load() {
        return startPage_load;
    }

    public JButton getStartPag_score() {
        return startPag_score;
    }

    public JButton getStartPage_computerPlayer() {
        return startPage_computerPlayer;
    }

    public JButton getStartPage_about() {
        return startPage_about;
    }

    public JButton getStartPage_exit() {
        return startPage_exit;
    }

    public JButton getStartPage_setting() {
        return startPage_setting;
    }

    public void setThem(Font font, Color textColor, Color backgroundColor) {

        startPage_singlePlayer.setFont(font);
        startPage_multiPlayer.setFont(font);
        startPage_computerPlayer.setFont(font);
        startPage_load.setFont(font);
startPag_quick.setFont(font);
        startPag_score.setFont(font);
        startPag_Show.setFont(font);
        startPage_about.setFont(font);
        startPage_exit.setFont(font);
        startPage_setting.setFont(font);
        startPage_singlePlayer.setForeground(textColor);
        startPage_multiPlayer.setForeground(textColor);
        startPage_computerPlayer.setForeground(textColor);
        startPage_load.setForeground(textColor);
        startPag_score.setForeground(textColor);
        startPag_Show.setForeground(textColor);
startPag_quick.setForeground(textColor);
        startPage_about.setForeground(textColor);
        startPage_exit.setForeground(textColor);
        startPage_setting.setForeground(textColor);

        startPage_singlePlayer.setBackground(backgroundColor);
        startPage_multiPlayer.setBackground(backgroundColor);
        startPage_computerPlayer.setBackground(backgroundColor);
        startPage_load.setBackground(backgroundColor);
        startPag_Show.setBackground(backgroundColor);
startPag_quick.setBackground(backgroundColor);
        startPage_about.setBackground(backgroundColor);
        startPage_exit.setBackground(backgroundColor);
        startPage_setting.setBackground(backgroundColor);
        startPag_score.setBackground(backgroundColor);

    }

}
