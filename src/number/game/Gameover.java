
package number.game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Gameover extends JFrame implements ActionListener {
    
    String score;
    
    JButton playagain;
    
    Gameover(String score){
    this.score = score;

    Font PetitCochon = FontManager.getFont("PetitCochon" , Font.BOLD , 60f);    
    
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/GameOverBackground.jpeg"));
    Image i2 = i1.getImage().getScaledInstance(500 , 300 , Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel bi = new JLabel(i3);
    bi.setBounds(0 , 0 , 500 , 300);
    add(bi);

    JLabel text = new JLabel("GAME OVER");
    text.setBounds(110 , 60 , 300 , 70 );
    text.setFont(PetitCochon);
    bi.add(text);    
        
    JLabel highscoretext = new JLabel("Score : ");
    highscoretext.setBounds(170 , 150 , 100 , 30 );
    highscoretext.setFont(new Font("Raleway" , Font.BOLD , 25));
    bi.add(highscoretext);
    
    JLabel highscore = new JLabel(score);
    highscore.setBounds(270 , 150 , 250 , 30 );
    highscore.setFont(new Font("Raleway" , Font.BOLD , 25));
    bi.add(highscore);
    
    playagain = new JButton("GameOver");
    playagain.setBounds(200 , 210 , 100 , 30);
    playagain.addActionListener(this);
    bi.add(playagain);
        
    setUndecorated(true);
    setLocation(450,250);
    setSize(500 , 300);
    setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == playagain){
            setVisible(false);
            new NumberGame(score).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Gameover("");
    }
    
}
