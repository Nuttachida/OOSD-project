
package spreadfire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;


public class CreateGui extends JFrame {
    JFrame frame ;
    Fire fire;
    int delay;
   
    final JLabel count = new JLabel("Count : ");
    final JSlider setsize = new JSlider(0, 50);
    final JSlider setdelay = new JSlider(0, 1000);
    final JButton start = new JButton("Start");
    final JButton stop = new JButton("Stop");
    final JButton reset = new JButton("Reset");
    final JButton step = new JButton("Step");
    final JButton help = new JButton("Help");
    final JButton set = new JButton("Set");
    final JComboBox combosize = new JComboBox();
    final JTextField setprobcatchtextfield = new JTextField("");
    final JLabel setProbcatch = new JLabel("SetProbCatch : ");
    final JTextField setgreentreetextfield = new JTextField("");
    final JLabel setgreentree = new JLabel("SetProbTree   : ");
    final JTextField setredtreetextfield = new JTextField("");
    final JLabel setredtree = new JLabel("SetProbBurn  : ");
    final JLabel sizeL = new JLabel("SetSize         : ");    
    final JLabel delayL = new JLabel(">> SetDelay <<"); 
    public CreateGui(Fire tmpfire){
        fire = tmpfire;
        final CreateGui tmp = this;
        
        frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.setSize(756, 601); // size frame 
        
        frame.setLocation(50, 50); // location frame border
        // frame.setLayout(new BorderLayout(0, 0));
        
        RectsJPanel rect = new RectsJPanel(fire);
        frame.getContentPane().add(rect);
        
        /**
         * Paneleast keep all button, slider, combobox, label, and textfield 
         * setBackground,Font,Color of text , size of font
         */
        MyPanel paneleast = new MyPanel();
        paneleast.setBackground(Color.PINK);
        paneleast.setPreferredSize(new Dimension(250, 0));
        
        set.setFont(new Font("Segoe Print",Font.BOLD,18));
        set.setForeground(Color.WHITE);
        set.setBackground(Color.BLACK);
        
        start.setFont(new Font("Segoe Print",Font.BOLD,18));
        start.setForeground(Color.WHITE);
        start.setBackground(Color.BLACK);
        
        stop.setFont(new Font("Segoe Print",Font.BOLD,18));
        stop.setForeground(Color.WHITE);
        stop.setBackground(Color.BLACK);
        
        step.setFont(new Font("Segoe Print",Font.BOLD,18));
        step.setForeground(Color.WHITE);
        step.setBackground(Color.BLACK);
        
        reset.setFont(new Font("Segoe Print",Font.BOLD,18));
        reset.setForeground(Color.WHITE);
        reset.setBackground(Color.BLACK);
        
        help.setFont(new Font("Segoe Print",Font.BOLD,18));
        help.setForeground(Color.WHITE);
        help.setBackground(Color.BLACK);
        
        setredtree.setFont(new Font("Segoe Print",Font.BOLD,20));
        setProbcatch.setFont(new Font("Segoe Print",Font.BOLD,20));
        setgreentree.setFont(new Font("Segoe Print",Font.BOLD,20));
        
        setprobcatchtextfield.setBackground(Color.WHITE);
        setgreentreetextfield.setBackground(Color.WHITE);
        setredtreetextfield.setBackground(Color.WHITE);
        
        setredtreetextfield.setColumns(6);
        setprobcatchtextfield.setColumns(6);
        setgreentreetextfield.setColumns(6);
        
        sizeL.setFont(new Font("Segoe Print",Font.BOLD,20));
        
        setsize.setBackground(Color.PINK);
        setsize.setMajorTickSpacing(10);
        setsize.setMinorTickSpacing(5);
        setsize.setPaintTicks(true);
        setsize.setPaintLabels(true);
        
        delayL.setFont(new Font("Segoe Print",Font.BOLD,24));
        
        
        setdelay.setMajorTickSpacing(200);
        setdelay.setMinorTickSpacing(100);
        setdelay.setPaintTicks(true);
        setdelay.setPaintLabels(true);
        setdelay.setBackground(Color.PINK);
        
        /**
         * add choice of size  
         */
        combosize.addItem(10+ "         ");
        combosize.addItem(20);
        combosize.addItem(25);
        combosize.addItem(50);
        combosize.addItem(100);
        combosize.addItem(500);
        combosize.setBackground(Color.WHITE);
        
        /**
         * Action of start button
         */
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        fire.hasTwo(tmp);
                        count.setText("Round Count: " + fire.getCount());
                    }
                });
                t.start();
                stop.setEnabled(true);
                start.setEnabled(false);
                
            }
        });
        
        /**
         * Action of stop button
         */
              
        stop.setEnabled(false);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                fire.stop();
                reset.setEnabled(true);
                stop.setEnabled(false);
            }
        });
        
        /**
         * Action of reset button
         */
        
        reset.setEnabled(false);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fire.reset();
                count.setText("Round Count: " + fire.getCount());
                reset.setEnabled(false);
                start.setEnabled(true);
            }
        });
        
        /**
         * Action of set button
         */
        
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                
                double d = Double.parseDouble(setgreentreetextfield.getText());
                double b = Double.parseDouble(setredtreetextfield.getText());
                double p = Double.parseDouble(setprobcatchtextfield.getText());
                fire.createForest(d,b,p);
                fire.setSize(WIDTH);
            }
        });
        
        /**
         * Action of step button
         */
        
        step.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
                fire.step(tmp);
                count.setText("Round Count: " + fire.getCount());
            }
        });
        
        /**
         * Action of combosize that is combobox
         */
        
        combosize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fire.setSize(Integer.parseInt(""+combosize.getSelectedItem()));
            }
        });
        
        /**
         * Action of setdelay that is JSlider 
         */
        
        setdelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
               delayL.setText("SetDelay : " + String.valueOf(setdelay.getValue()));
               delay = setdelay.getValue();
            }
        });
        
        /**
         * Action of help button
         */
        
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                JOptionPane.showMessageDialog(null, "Introduction for the word in program \n"
                                                  + "'ProbCatch' : Probability of tree that fire can spread to the N/S/E/W side of tree (Probability between 0-1) \n"
                                                  + "'ProbTree' : Probability of tree that grow on the field (Probability between 0-1) \n"
                                                  + "'ProbBurn' : Probability of fire that start on the first time spreading in the field(Probability between 0-1) \n\n"
                                                  + "                                                                5 Steps to use the program \n"
                                                  + "1. Set ProbCatch, Probtree, and ProbBurn \n"
                                                  + "2. Press 'Set' will show you how about the field in the first time. \n"
                                                  + "3. Press 'Start' and the simulator will show you about your field. \n"
                                                  + "4. After simulation stop, Press 'Stop' to stop the program. \n"
                                                  + "5. If you want to simulate again, Press 'Reset' to clear your field first. Otherwise, you can't simulate it again.");
            }
        });
        
        /**
         * Add all buttons, label, textfield, combobox, slider in to paneleast
         */
        
        paneleast.add(setProbcatch);
        paneleast.add(setprobcatchtextfield);
        paneleast.add(setgreentree);
        paneleast.add(setgreentreetextfield);
        paneleast.add(setredtree);
        paneleast.add(setredtreetextfield);
        paneleast.add(sizeL);
        paneleast.add(combosize);
        paneleast.add(delayL);
        paneleast.add(setdelay);
        paneleast.add(set);
        paneleast.add(start);
        paneleast.add(stop);
        paneleast.add(step);
        paneleast.add(reset);
        paneleast.add(help);
        
        /**
         * Panelsouth keep Imageicon and count
         */
        
        MyPanel panelsouth = new MyPanel();
        panelsouth.setBackground(Color.DARK_GRAY);
        count.setForeground(Color.PINK);
        count.setFont(new Font("Segoe Print",Font.BOLD,20));
        
        JButton tree1 = new JButton(new ImageIcon("tree1.png"));
        tree1.setBackground(Color.DARK_GRAY);

        panelsouth.add(tree1);
        panelsouth.add(count);
        

        /**
         * add all panel(paneleast,panelsouth) into frame 
         * and set borderlayout 
         * and fix size
         */

        frame.getContentPane().add(paneleast, BorderLayout.EAST);
        frame.getContentPane().add(panelsouth, BorderLayout.SOUTH);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        
    }
    
    /**
     * This is setGUI method do delay
     * @param rect 
     */
    
    public void setGUI(RectsJPanel rect){
        try{
            Thread.sleep(delay);
            
        }catch(Exception e){
         // 
        }
    }
}
