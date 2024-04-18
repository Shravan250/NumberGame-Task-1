
package number.game;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class NumberGame extends JFrame implements ActionListener ,  MouseListener{

    
    JButton play , exit;
    
    String score;
  

    
    NumberGame(String score){
        this.score = score;
        setTitle("Number Game");

        Font OvertheRainbow = FontManager.getFont("OvertheRainbow" , Font.BOLD , 40f);
        Font Mansalva = FontManager.getFont("Mansalva" , Font.BOLD , 25f );
        
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0xF7FAFF), w, 0, new Color(0x9DEDFF));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, w, h);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        exit = new JButton("❌");
        exit.setBounds(420 , 30 , 50 , 20 );
        exit.addActionListener(this);
        exit.setForeground(Color.RED);
        add(exit);
     
        
        JLabel heading = new JLabel("NUMBER GAME");
        heading.setBounds(100 , 60 , 350 , 50 );
        heading.setFont(OvertheRainbow);
        add(heading);

        
        JLabel highscoretext = new JLabel("High Score");
        highscoretext.setBounds(170 , 130 , 250 , 30 );
        highscoretext.setFont(Mansalva);
        add(highscoretext);
        
        JLabel highscore = new JLabel(score);
        highscore.setBounds(215 , 160 , 250 , 30 );
        highscore.setFont(new Font("Raleway" , Font.BOLD , 15));
        add(highscore);
        
        play = new JButton("Play");
        play.setBounds(185 , 200 , 100 , 30);
        play.addActionListener(this);
        play.setForeground(Color.BLACK);  
        add(play);

        JLabel howtoplay = new JLabel("<html><u>How To Play?</u></html>");
        howtoplay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        howtoplay.setBounds(30 , 250 , 100 , 30);
        howtoplay.addMouseListener(this);
        add(howtoplay);
        
        setUndecorated(true);
        setLocation(450,250);
        setSize(500 , 300);
        setVisible(true);

    }
    

    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == play){
            setVisible(false);
            new Firstlevelone().setVisible(true);
        }else if(ae.getSource() == exit){
            System.exit(0);            
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {        
        new HowToPlay().setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    
    public static void main(String[] args) {
       new NumberGame("  0");
    }


}
