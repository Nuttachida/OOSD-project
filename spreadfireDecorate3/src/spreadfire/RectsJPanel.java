package spreadfire;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RectsJPanel extends JPanel{
    
    Fire forest;
    int[][] land;
    int cell; 
      
    public RectsJPanel(Fire forest){
        this.forest = forest;
        cell=500/forest.getForest().length;
    }
     
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        this.setBackground(Color.BLACK); 
        
        land = forest.getForest();
            
        int y = 0;
       
        cell = 500/forest.getForest().length;
       for(int i=0;i < land.length;i++){ 
           int x = 0;
            for(int j=0; j< land.length;j++){
                if(land[i][j] == 0){
                    g.setColor(Color.yellow);
                    g.fillRect(x*cell, y*cell, cell,cell);
                    x++;
                }else if(land[i][j] == 1){
                    g.setColor(Color.green);
                    g.fillRect(x*cell, y*cell, cell, cell);
                    x++;
                }else if(land[i][j] == 2){
                    g.setColor(Color.RED);
                    g.fillRect(x*cell ,y*cell, cell, cell);
                    x++;
               }
            }
            y++;
        } 
       validate();
       repaint();
    }
}
