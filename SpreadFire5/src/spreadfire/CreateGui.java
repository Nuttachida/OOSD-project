
package spreadfire;


import javax.swing.*;



public class CreateGui extends JPanel {
    
       
    public CreateGui(int[][] recieve){
       
        JFrame frame = new JFrame("Spread of Fire_CSC319 Project");
        //JButton start = new JButton("start");
        //frame.add(start);
        
        //RectsJPanel rectsJPanel = new RectsJPanel();
        //frame.add(rectsJPanel);
        frame.setSize(600, 600);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
