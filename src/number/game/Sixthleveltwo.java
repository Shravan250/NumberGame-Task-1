
package number.game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class Sixthleveltwo extends JFrame implements ActionListener {
    
    JTextField answer;
    
    int random , low  = 0 , high = 1000 , attempt = 1;
    
    JLabel chance;
    
    JButton submit , exit;
    
    Sixthleveltwo(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/finallevelbg.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500 , 300 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bi = new JLabel(i3);
        bi.setBounds(0 , 0 , 500 , 300);
        add(bi);
        
        setLayout(null);
        
        chance = new JLabel("Attempt Left : " + attempt );
        chance.setBounds(10 , 20 , 300 , 30 );
        chance.setFont(new Font("Raleway" , Font.BOLD , 14));
        bi.add(chance);
        
        
        JLabel levelone = new JLabel("Final Level");
        levelone.setBounds(140 , 40 , 300 , 50 );
        levelone.setFont(new Font("Raleway" , Font.BOLD , 40));
        bi.add(levelone);
        
        JLabel scoretext = new JLabel("Score : 1500");
        scoretext.setBounds(400 , 30 , 100 , 30 );
        scoretext.setFont(new Font("Raleway" , Font.BOLD , 10));
        bi.add(scoretext);
        
        exit = new JButton("❌");
        exit.setBounds(400 , 60 , 50 , 20 );
        exit.addActionListener(this);
        exit.setForeground(Color.RED);
        bi.add(exit);
        
        JLabel text = new JLabel("Guess Number between 0 to 1000");
        text.setBounds(80 , 110 , 400 , 30 );
        text.setFont(new Font("Raleway" , Font.BOLD , 20));
        bi.add(text);
        
        answer = new JTextField();
        answer.setBounds(80 , 160 , 320 , 30 );
        answer.setFont(new Font("Raleway" , Font.BOLD , 20));
        bi.add(answer);
        
        submit = new JButton("Submit");
        submit.setBounds(180 , 210 , 100 , 30 );
        submit.addActionListener(this);
        bi.add(submit);
        
        Random rand = new Random();
        random = rand.nextInt(high - low) + low;
        
                
  
        System.out.println("random " + random);
                    
                    
        setUndecorated(true);        
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,250);
        setSize(500 , 300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        
        if(ae.getSource() == submit){
           if(submit.getText() == "Next"){
               setVisible(false);
               new NumberGame("3000").setVisible(true);
           
           }
           else{ 
                try {
                    int ans = Integer.parseInt(answer.getText());

                    if (ans == random) {
                        JOptionPane.showMessageDialog(null, "Correct");
                        submit.setText("Next");
                    }else if(ans > 1000 || ans < 0) {
                        JOptionPane.showMessageDialog(null, "Out of Bounds");
                    }else{
                        chance.setText("Attempts Left: " + attempt--);
                        //GameOver
                       setVisible(false);
                       new Gameover("1500").setVisible(true);                    
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }                   
           }
        }else if(ae.getSource() == exit){
            setVisible(false);
            new Gameover("1500").setVisible(true);              
        }
        
    }

    
    public static void main (String[] args){
        new Sixthleveltwo();
    }

    

    
}

