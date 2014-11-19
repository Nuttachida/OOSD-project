package spreadfire;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MyPanel extends JPanel{
public MyPanel() { 
 
 TitledBorder border = BorderFactory.createTitledBorder( new EtchedBorder()); 
 border.setBorder(border); 
 } 
}

