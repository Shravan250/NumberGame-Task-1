
package number.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HowToPlay extends JFrame {

    HowToPlay(){
        setLayout(null);
        
        JLabel text = new JLabel("How To Play?");
        text.setBounds(70 , 30 , 350 , 50 );
        text.setFont(new Font("Raleway" , Font.BOLD , 40));
        add(text);
        
        JLabel text1 = new JLabel("<html>1)Too Low = Indicates your guess is very Far from the number<br><br>2) Low = Indicates your guess is smaller than the number<br><br>3)Slightly Low = Indicates your guess is very close to the number<br><br>4)Very CLose = Indicates your guess is either 2 number smaller or higher from the number<br><br>5)Slightly high = Indicates your guess is very close to the number<br><br>6)High = Indicates your guess is higher than the number<br><br>7)Too High = Indicates your guess is very Far from the number<br><br></html>");
        text1.setBounds(30 , 80 , 350 , 500 );
        text1.setFont(new Font("Raleway" , Font.PLAIN, 15));
        add(text1);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(30 , 50);
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new HowToPlay();
    }
    
}
