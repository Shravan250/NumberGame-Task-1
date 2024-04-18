
package number.game;

import java.awt.*;
import javax.swing.*;

public class Fourthlevelone extends JFrame{
    
    Fourthlevelone(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0x91AED5), w, 0, new Color(0x3364C3));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, w, h);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel levelone = new JLabel("Level - 4");
        levelone.setBounds(150 , 60 , 300 , 50 );
        levelone.setFont(new Font("Raleway" , Font.BOLD , 50));
        add(levelone);
        
        JLabel reward = new JLabel("Reward : 400 ");
        reward.setBounds(170 , 130 , 250 , 30 );
        reward.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(reward);
        
        JLabel diff = new JLabel("Difficulty : Hard");
        diff.setBounds(150 , 170 , 250 , 30);
        diff.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(diff);
        
        new java.util.Timer().schedule(new java.util.TimerTask(){
           @Override
           public void run(){ 
              setVisible(false);
              new Fourthleveltwo().setVisible(true);
           }
        },3000);

        setUndecorated(true);        
        getContentPane().setBackground(Color.WHITE);
        setLocation(450,250);
        setSize(500 , 300);
        setVisible(true);
    }
    
    public static void main (String[] args){
        new Fourthlevelone();
    }
}
