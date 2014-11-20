/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spreadfire;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Aom
 */
public class MyPanel extends JPanel{
public MyPanel() { 
 
 TitledBorder border = BorderFactory.createTitledBorder( new EtchedBorder()); 
 border.setBorder(border); 
 } 
}

