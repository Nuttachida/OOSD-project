package spreadfire;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RectsJPanel extends JPanel{
    
    Fire forest;
    int[][] land;
      
    public RectsJPanel(Fire forest){
        this.forest = forest;
    }
     
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        this.setBackground(Color.BLACK); 
        
        land = forest.getForest();
            
        int y = 1;
       
       for(int i=0;i < land.length;i++){ 
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
       validate();
       repaint();
       
       
    }
    
}
