﻿
package spreadfire;


import java.awt.*;
import javax.swing.*;


public class Graphic extends JFrame{

        JButton start = new JButton("start");
        JButton stop = new JButton("stop");
        JButton reset = new JButton("reset");
        
        public Graphic(){
            JPanel panel2 = new JPanel();
            //panel.setLayout(new GridLayout(2,2));
            panel2.add(start);
            panel2.add(stop);
            panel2.add(reset);
            this.add(panel2,BorderLayout.EAST);
           // spread.addActionListener(new spreadListener()); พอกดปุ่มแล้วรัน
            
        }

        public static void main(String[] args) throws Exception { 
        
            
            JFrame frame = new Graphic(); // big frame
            frame.setSize(600,600);
            frame.setLocation(100, 100);
            frame.setTitle("Spreading of Fire");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
           
            
        }   
        
        
        
    }

            
     




