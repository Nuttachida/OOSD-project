
package spreadfire;

import javax.swing.*;

public class CreateGui extends JPanel {
    JFrame frame ;
    public CreateGui(Fire fire){
       
      RectsJPanel rect = new RectsJPanel(fire);
        frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.add(rect);
        frame.setSize(600, 600);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void setGUI(RectsJPanel rect){
        try{
            Thread.sleep(100);
            
        }catch(Exception e){}
        frame.add(rect);
       // frame.setVisible(true);
        //frame.setVisible(false);
    }
    
}
