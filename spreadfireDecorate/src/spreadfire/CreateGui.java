
package spreadfire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateGui extends JFrame {
    JFrame frame ;
    Fire fire;
    Thread t;
    
    public CreateGui(Fire tmpfire){
        fire = tmpfire;
        final CreateGui tmp = this;
        
        frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.setSize(1000, 600); // size frame 
        frame.setLocation(50, 50); // location frame border
        frame.setLayout(new BorderLayout(0, 0));
        
        RectsJPanel rect = new RectsJPanel(fire);
        frame.getContentPane().add(rect);
        
        //--------------------westpanel----------------------
        MyPanel panelwest = new MyPanel();
        panelwest.setBackground(Color.RED);
        
        //-------------------eastpanel-----------------------------
        MyPanel paneleast = new MyPanel();
        paneleast.setBackground(Color.PINK);
        
        final JButton start = new JButton("Start");
        final JButton stop = new JButton("Stop");
        final JButton reset = new JButton("Reset");
        final JButton help = new JButton("Help");
        final JTextField setprobcatchtextfield = new JTextField("                 ");
        final JLabel setProbcatch = new JLabel("SetProbCatch : ");
        
        
        //reset control
        reset.setEnabled(false);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fire.reset();
                reset.setEnabled(false);
                
                start.setEnabled(true);
            }
        });
        
        //stop control
        stop.setEnabled(false);
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {           
                
                fire.stop();
                reset.setEnabled(true);
                stop.setEnabled(false);
            }
        });
        
        //start control
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p = setprobcatchtextfield.getText();
                fire.setProb(Double.parseDouble(p));
                
                t = new Thread(new Runnable(){
                    public void run(){
                        fire.hasTwo(tmp);
                    }
                });
                t.start();
                stop.setEnabled(true);
                start.setEnabled(false);
                
            }
        });
        
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {           
                JOptionPane.showMessageDialog(null,"Hello");  
            }
        });
        
        paneleast.add(setProbcatch);
        paneleast.add(setprobcatchtextfield);
        paneleast.add(start);
        paneleast.add(stop);
        paneleast.add(reset);
        paneleast.add(help);
        
        
        
       //--------------------southpanel----------------------------
        
        MyPanel panelsouth = new MyPanel();
        panelsouth.setBackground(Color.BLUE);
        
        
        //-----------add all panel in frame------
        frame.getContentPane().add(panelsouth,BorderLayout.SOUTH);
        frame.getContentPane().add(paneleast, BorderLayout.EAST);
        frame.getContentPane().add(panelwest, BorderLayout.WEST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void setGUI(RectsJPanel rect){
        try{
            Thread.sleep(500);
            
        }catch(Exception e){
         // 
        }
    }
    
}
