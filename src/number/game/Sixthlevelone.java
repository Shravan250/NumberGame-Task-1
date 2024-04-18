
package number.game;

import java.awt.*;
import javax.swing.*;

public class Sixthlevelone extends JFrame{
    
    Sixthlevelone(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/finallevelbg.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500 , 300 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bi = new JLabel(i3);
        bi.setBounds(0 , 0 , 500 , 300);
        add(bi);
        
        setLayout(null);
        
        JLabel levelone = new JLabel("Final Level");
        levelone.setBounds(130 , 60 , 300 , 50 );
        levelone.setFont(new Font("Raleway" , Font.BOLD , 50));
        bi.add(levelone);
        
        JLabel reward = new JLabel("Reward : 1500");
        reward.setBounds(170 , 130 , 250 , 30 );
        reward.setFont(new Font("Raleway" , Font.BOLD , 20));
        bi.add(reward);
        
        JLabel diff = new JLabel("Difficulty : Hell");
        diff.setBounds(150 , 170 , 250 , 30);
        diff.setFont(new Font("Raleway" , Font.BOLD , 20));
        bi.add(diff);
        
        new java.util.Timer().schedule(new java.util.TimerTask(){
           @Override
           public void run(){ 
              setVisible(false);
              new Sixthleveltwo().setVisible(true);
           }
        },3000);

        setUndecorated(true);        
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,250);
        setSize(500 , 300);
        setVisible(true);
    }
    
    public static void main (String[] args){
        new Sixthlevelone();
    }
}

