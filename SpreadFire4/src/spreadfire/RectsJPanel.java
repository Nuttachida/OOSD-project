/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadfire;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
/**
 *
 * @author PC
 */
public class RectsJPanel extends JPanel{
    int row; //ต้องใส่ลูป
    int column;
       
       final private int yellow = 0;
       final private int green  = 1;
       final private int red    = 2;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        for(int i=0;i<600;i++){ //300 = ขนาด setsize
            for(int j=0;j<600;j++){
                if(i==0){
                g.setColor(Color.YELLOW);
                g.fillRect(i, j, 1,1);  
                }
                else if(j==1){
                g.setColor(Color.GREEN);
                g.fillRect(i, j, 1, 1);
                }else{
                g.setColor(Color.RED);
                g.fillRect(i, j, 1, 1);
                }
            }
        } 
    }
}