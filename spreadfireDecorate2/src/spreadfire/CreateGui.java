
package spreadfire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateGui extends JFrame {
    JFrame frame ;
    Fire fire;
    
    public CreateGui(Fire tmpfire){
        fire = tmpfire;
        final CreateGui tmp = this;
        
        frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.setSize(800, 565); // size frame 
        frame.setLocation(50, 50); // location frame border
        frame.setLayout(new BorderLayout(0, 0));
        
        RectsJPanel rect = new RectsJPanel(fire);
        frame.getContentPane().add(rect);
        
        //-------------------eastpanel-----------------------------
        MyPanel paneleast = new MyPanel();
        paneleast.setBackground(Color.PINK);
        JPanel mix = new JPanel(new GridLayout(8, 2,15,15));
        mix.setBackground(Color.PINK);
        
        final JButton start = new JButton("Start");
        final JButton stop = new JButton("Stop");
        final JButton reset = new JButton("Reset");
        final JButton step = new JButton("Step");
        final JButton help = new JButton("Help");
        final JButton set = new JButton("Set");
        final JTextField setprobcatchtextfield = new JTextField("    ");
        final JLabel setProbcatch = new JLabel("SetProbCatch : ");
        final JTextField setgreentreetextfield = new JTextField("    ");
        final JLabel setgreentree = new JLabel("SetProbtree : ");
        final JTextField setredtreetextfield = new JTextField("    ");
        final JLabel setredtree = new JLabel("SetProbburn : ");
        
        
        setprobcatchtextfield.setBackground(Color.WHITE);
        setgreentreetextfield.setBackground(Color.WHITE);
        setredtreetextfield.setBackground(Color.WHITE);
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        fire.hasTwo(tmp);
                    }
                });
                t.start();
                stop.setEnabled(true);
                start.setEnabled(false);
                
            }
        });
              
        stop.setEnabled(false);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                fire.stop();
                reset.setEnabled(true);
                stop.setEnabled(false);
            }
        });
        
        reset.setEnabled(false);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fire.reset();
                
                reset.setEnabled(false);
                
                start.setEnabled(true);
            }
        });
        
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                double d = Double.parseDouble(setgreentreetextfield.getText());
                double b = Double.parseDouble(setredtreetextfield.getText());
                double p = Double.parseDouble(setprobcatchtextfield.getText());
                fire.createForest(d,b,p);
            }
        });
        
        step.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                fire.step(tmp);
            }
        });
        
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                JOptionPane.showMessageDialog(null,"Hello!!");  
            }
        });
        
        
        mix.add(setProbcatch);
        mix.add(setprobcatchtextfield);
        mix.add(setgreentree);
        mix.add(setgreentreetextfield);
        mix.add(setredtree);
        mix.add(setredtreetextfield);
        mix.add(set);
        mix.add(start);
        mix.add(stop);
        mix.add(reset);
        mix.add(step);
        mix.add(help);
        
        
        paneleast.add(mix);
        

        //-----------add all panel in frame------

        frame.getContentPane().add(paneleast, BorderLayout.EAST);
        
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
