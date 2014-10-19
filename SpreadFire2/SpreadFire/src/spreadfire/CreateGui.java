
package spreadfire;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.*;



public class CreateGui extends JPanel {
    
       final private int yellow = 0;
       final private int green  = 1;
       final private int red    = 2;
       
    public CreateGui(int[][] recieve){
       
        JFrame frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.setSize(600, 600);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}