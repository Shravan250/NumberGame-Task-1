
package number.game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class Secondleveltwo extends JFrame implements ActionListener {
    
    JTextField answer;
    
    int random , low  = 0 , high = 50 ,  toohigh , toolow , slhigh , sllow;
    
    JButton submit , exit;
    
    Secondleveltwo(){
        
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0xD3D9E4), w, 0, new Color(0x2FA0BB));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, w, h);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel levelone = new JLabel("Level - 2");
        levelone.setBounds(160 , 40 , 300 , 50 );
        levelone.setFont(new Font("Raleway" , Font.BOLD , 40));
        add(levelone);
        
        JLabel scoretext = new JLabel("Score : 100");
        scoretext.setBounds(400 , 30 , 100 , 30 );
        scoretext.setFont(new Font("Raleway" , Font.BOLD , 10));
        add(scoretext);
        
        exit = new JButton("❌");
        exit.setBounds(400 , 60 , 50 , 20 );
        exit.addActionListener(this);
        exit.setForeground(Color.RED);
        add(exit);        
        
        JLabel text = new JLabel("Guess Number between 0 to 50");
        text.setBounds(80 , 110 , 400 , 30 );
        text.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(text);
        
        answer = new JTextField();
        answer.setBounds(80 , 160 , 320 , 30 );
        answer.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(answer);
        
        submit = new JButton("Submit");
        submit.setBounds(180 , 210 , 100 , 30 );
        submit.addActionListener(this);
        add(submit);
        
        Random rand = new Random();
        random = rand.nextInt(high - low) + low;
        
                 
        toohigh = Math.abs((random + high + 1)/2); 
        toolow = Math.abs((random + low - 1)/2); 
        slhigh = (int) Math.abs(random + ((high - low +1)*(0.1))); 
        sllow = (int) Math.abs(random - ((high - low +1)*(0.1)));
  
                                    System.out.println("random " + random);
                    
        setUndecorated(true);        
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,250);
        setSize(500 , 300);
        setVisible(true);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){

        
        if(ae.getSource() == submit){
            if(submit.getText() == "Next")
            {
                setVisible(false);
                new Thirdlevelone();
                
            }else{
                try {
                    int ans = Integer.parseInt(answer.getText());
                    
                    if (ans == random) {
                        JOptionPane.showMessageDialog(null, "Correct");
                        submit.setText("Next");
                    } else if (ans >= random - 2 && ans <= random + 2) {
                        JOptionPane.showMessageDialog(null, "Very Close");
                    } else if (ans < random - 2) {
                        handleLowGuess(ans);
                    } else if (ans > random + 2) {
                        handleHighGuess(ans);
                    }
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        }else{
            setVisible(false);
            new Gameover("100").setVisible(true);
        }
        
    }
    
    private void handleLowGuess(int ans) {
        if (ans >= sllow ) {
            JOptionPane.showMessageDialog(null, "Slightly Low");
        } else if ( ans < sllow && ans>= toolow){
            JOptionPane.showMessageDialog(null, "Low");
        } else if (ans < low) {
            JOptionPane.showMessageDialog(null, "Out of Bounds");
        } else {
            JOptionPane.showMessageDialog(null, "Too Low");
        }
    }

    private void handleHighGuess(int ans) {
        if (ans <= slhigh) {
            JOptionPane.showMessageDialog(null, "Slightly High");
        } else if(ans > slhigh && ans < toohigh) {
            JOptionPane.showMessageDialog(null, "High");
        } else if (ans > high) {
            JOptionPane.showMessageDialog(null, "Out of Bounds");
        } else{
            JOptionPane.showMessageDialog(null, "Too High");
        }
    }    
    
    public static void main (String[] args){
        new Secondleveltwo();
    }

    

    
}
