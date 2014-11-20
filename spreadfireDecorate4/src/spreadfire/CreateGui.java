
package spreadfire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CreateGui extends JFrame {
    JFrame frame ;
    Fire fire;
    int delay;
    
    public CreateGui(Fire tmpfire){
        fire = tmpfire;
        final CreateGui tmp = this;
        
        frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.setSize(770, 600); // size frame 
        frame.setLocation(50, 50); // location frame border
        
        
        RectsJPanel rect = new RectsJPanel(fire);
        frame.getContentPane().add(rect);
        
        //--------------------------------
        MyPanel panelnorth = new MyPanel();
        panelnorth.setBackground(Color.BLACK);
        //------------------------------
        
        MyPanel panelwest = new MyPanel();
        panelwest.setBackground(Color.BLACK);
        //-------------------eastpanel-----------------------------
        MyPanel paneleast = new MyPanel();
        paneleast.setBackground(Color.PINK);
        paneleast.setPreferredSize(new Dimension(250, 0));
        paneleast.setBorder(new LineBorder(Color.BLACK, 8));
        
        final JLabel count = new JLabel("Round Count : ");
        count.setFont(new Font("Segoe Print",Font.BOLD,22));
        count.setForeground(Color.PINK);
        
        final JButton start = new JButton("Start");
        start.setFont(new Font("Segoe Print",Font.BOLD,18));
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        
        final JButton stop = new JButton("Stop");
        stop.setFont(new Font("Segoe Print",Font.BOLD,18));
        stop.setBackground(Color.BLACK);
        stop.setForeground(Color.WHITE);
        
        final JButton set = new JButton("Set");
        set.setFont(new Font("Segoe Print",Font.BOLD,18));
        set.setBackground(Color.BLACK);
        set.setForeground(Color.WHITE);
        
        final JButton reset = new JButton("Reset");
        reset.setFont(new Font("Segoe Print",Font.BOLD,18));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        
        final JButton step = new JButton("Step");
        step.setFont(new Font("Segoe Print",Font.BOLD,18));
        step.setBackground(Color.BLACK);
        step.setForeground(Color.WHITE);
        
        final JButton help = new JButton("Help");
        help.setFont(new Font("Segoe Print",Font.BOLD,18));
        help.setBackground(Color.BLACK);
        help.setForeground(Color.WHITE);
        
        final JLabel setProbcatch = new JLabel("SetProbCatch : ");
        setProbcatch.setFont(new Font("Segoe Print",Font.BOLD,18));
        final JTextField setprobcatchtextfield = new JTextField("");
        setprobcatchtextfield.setFont(new Font("Segoe Print",Font.BOLD,18));
        setprobcatchtextfield.setColumns(4);
        
        final JLabel setprobtreeL =new JLabel("SetProbTree   : ");
        setprobtreeL.setFont(new Font("Segoe Print",Font.BOLD,18));
        final JTextField setprobtree = new JTextField();
        setprobtree.setFont(new Font("Segoe Print",Font.BOLD,18));
        setprobtree.setColumns(4);
        
        
        final JLabel setprobburnL =new JLabel("SetProbBurn  : ");
        setprobburnL.setFont(new Font("Segoe Print",Font.BOLD,18));
        final JTextField setprobburn = new JTextField();
        setprobburn.setFont(new Font("Segoe Print",Font.BOLD,18));
        setprobburn.setColumns(4);
        
        final JLabel setdelayL = new JLabel("SetDelay");
        setdelayL.setFont(new Font("Segoe Print",Font.BOLD,18));
        final JSlider setdelay = new JSlider(0, 1000);
        setdelay.setFont(new Font("Segoe Print",Font.BOLD,10));
        setdelay.setBackground(Color.PINK);
        setdelay.setMajorTickSpacing(200);
        setdelay.setMinorTickSpacing(100);
        setdelay.setPaintTicks(true);
        setdelay.setPaintLabels(true);
        
        //delay control
        setdelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
               setdelayL.setText(">> SetDelay: " + String.valueOf(setdelay.getValue())+" <<");
                delay = setdelay.getValue();
            }
        });
        
        //reset control
        reset.setEnabled(false);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fire.reset();
                count.setText("Round Count: " + fire.getCount());
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
                Thread t = new Thread(new Runnable(){
                    public void run(){
                        fire.hasTwo(tmp);
                        count.setText("Round Count : " + fire.getCount());
                    }
                });
                t.start();
                stop.setEnabled(true);
                start.setEnabled(false);
                
            }
        });
        
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {           
                JOptionPane.showMessageDialog(null, "Introduction for the word in program \n"
                                                  + "'ProbCatch' : Probability of tree that fire can spread to the N/S/E/W side of tree (Probability between 0-1) \n"
                                                  + "'ProbTree' : Probability of tree that grow on the field (Probability between 0-1) \n"
                                                  + "'ProbBurn' : Probability of fire that start on the first time spreading in the field(Probability between 0-1) \n\n"
                                                  + "                                                                5 Steps to use the program \n"
                                                  + "1. Set ProbCatch, Probtree,ProbBurn,and Delay \n"
                                                  + "2. Press 'Set' will show you how about the field in the first time. \n"
                                                  + "3. Press 'Start' and the simulator will show you about your field. \n"
                                                  + "4. After simulation stop, Press 'Stop' to stop the program. \n"
                                                  + "5. If you want to simulate again, Press 'Reset' to clear your field first. Otherwise, you can't simulate it again.");
            }
        });
        
         step.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                fire.step(tmp);
                count.setText("Round Count: " + fire.getCount());
            }
        });
         
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try{
                double d = Double.parseDouble(setprobtree.getText());
                double b = Double.parseDouble(setprobburn.getText());
                double p = Double.parseDouble(setprobcatchtextfield.getText());
                fire.newForest(d,b,p);
                }catch(NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "Please insert every inputs",
                        "Error 404 : Boxes need input", JOptionPane.ERROR_MESSAGE);
                    
                } 
            }
        });
         
        
        paneleast.add(setProbcatch);
        paneleast.add(setprobcatchtextfield);
        paneleast.add(setprobtreeL);
        paneleast.add(setprobtree);
        paneleast.add(setprobburnL);
        paneleast.add(setprobburn);
        paneleast.add(setdelayL);
        paneleast.add(setdelay);
        paneleast.add(set);
        paneleast.add(start);
        paneleast.add(stop);
        paneleast.add(reset);
        paneleast.add(step);
        paneleast.add(help);
        
        
        
       //--------------------southpanel----------------------------
        
        MyPanel panelsouth = new MyPanel();
        panelsouth.setBackground(Color.BLACK);
        panelsouth.add(count);
        
        
        //-----------add all panel in frame------
        
        frame.getContentPane().add(panelnorth,BorderLayout.NORTH);
        frame.getContentPane().add(panelwest, BorderLayout.WEST);
        frame.getContentPane().add(panelsouth,BorderLayout.SOUTH);
        frame.getContentPane().add(paneleast, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    public void setGUI(RectsJPanel rect){
        try{
            Thread.sleep(delay);
            
        }catch(Exception e){
         // 
        }
    }
    
}
