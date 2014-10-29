
package spreadfire;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpreadFire {
    
    public static void main(String[] args) {
        
        Fire fire = new Fire();
        CreateGui show = new CreateGui(fire);
        fire.hasTwo(show);
    }
}
