
package spreadfire;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class RectsJPanel extends JPanel{
    int row; //ต้องใส่ลูป
    int column;
    Fire forest;
    int[][] land;
      
    public RectsJPanel(Fire forest){
        this.forest = forest;
    }
      // final private int yellow = 0;
      // final private int green  = 1;
      // final private int red    = 2;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        land = forest.getForest();
            
        int y = 1;
       // g.setColor(Color.yellow);
       // g.fillRoundRect(195, 40, 90, 55, 50, 50);
       for(int i=0;i < land.length;i++){ //300 = ขนาด setsize
           int x = 1;
            for(int j=0; j< land.length;j++){
                if(land[i][j] == 0){
                    g.setColor(Color.yellow);
                    g.fillRect(x*10, y*10, 10,10);
                    x++;
                }else if(land[i][j] == 1){
                    g.setColor(Color.green);
                    g.fillRect(x*10, y*10, 10, 10);
                    x++;
                }else if(land[i][j] == 2){
                    g.setColor(Color.RED);
                    g.fillRect(x*10 ,y*10, 10, 10);
                    x++;
               }
                
            }
            y++;
        } 
      //  g.drawRoundRect(row, column, 50, 50, 0, 0); // x,y,width,heigth,arcw,arch
       
        
    }
    
    public void delay(){
    
           try{
               Thread.sleep(100);
           }catch(Exception e){
           
           }
    }
}
