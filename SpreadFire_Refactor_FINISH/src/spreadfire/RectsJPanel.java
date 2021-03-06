package spreadfire;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class RectsJPanel extends JPanel {

    int[][] land;
    int cell;
    int size;

    public RectsJPanel(int[][] forest, int size) {
        setSize(500,500);
        land = forest;
        cell = 5;
        this.size = size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    // Method for repaint simulator.
    public void reSimulator(int[][] forest){
        cell = 100/size*5;
        land = forest;
        validate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        this.setBackground(Color.GRAY);
        
        int y = 0;
        int x = 0; 

        for (int i = 0; i < land.length; i++) {
            x = 0;
            for (int j = 0; j < land.length; j++) {
                if (land[i][j] == 0) {
                    g.setColor(Color.orange);
                } 
                if (land[i][j] == 1) {
                    g.setColor(Color.green);
                } 
                if (land[i][j] == 2) {
                    g.setColor(Color.RED);
                }
                g.fillRect(x * cell, y * cell, cell-1, cell-1);
                x++;
            }
            y++;
        }
        validate();
        repaint();
    }

}
