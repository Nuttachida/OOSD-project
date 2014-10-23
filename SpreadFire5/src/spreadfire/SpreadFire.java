
package spreadfire;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpreadFire {
//    static int two = 1;
//    
//    static ArrayList<Integer> keepi = new ArrayList<>();
//    static ArrayList<Integer> keepj = new ArrayList<>();
//       
//    static double prob = 1; //กำหนด prob
//    static double[][] randomProb =new double[20][20]; //0-1
//    static int[][] size = new int[20][20]; //size keep 0,1,2
    
    public static void main(String[] args) {
        
        Fire fire = new Fire();
        JPanel show = new CreateGui(fire.getForest());
        RectsJPanel rect = new RectsJPanel(fire);
        JFrame frame = new JFrame("Spread of Fire_CSC319 Project");
        frame.add(rect);
        frame.setSize(600, 600);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        
        
        // DO TREE = 1 
//        for(int i =0;i<size.length;i++){
//            for(int j=0 ; j<size.length;j++){
//               if(j==0 || i==0 || j==size.length-1 || i==size.length-1){//border
//                    size[i][j]= 0;
//                }else{size[i][j] =1;}
//            }
//        }
       
       //randomProb;
//       for(int i=0 ;i<randomProb.length;i++){
//           for(int j=0;j<randomProb.length;j++){
//               randomProb[i][j] = Math.random();
//           }
//       }
       //print
//       while(two > 0){
//           
//           prepare(size);
//           print(size);
//       }
     
     
    
       
     
           
    }
    
    /*public int[][] getForest(){
        return size;
    }
    
    public static void print(int [][] c){
        for (int[] c1 : c) {
            for (int j = 0; j<c.length; j++) {
                System.out.print(c1[j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }
    
    public static void prepare(int[][] b){
     keepi.clear();
     keepj.clear();
       
        b[13][12]=2; // DO BURN POINT
       
        for(int i=1;i<b.length-1;i++){ //KEEP BURN POINT
            for(int j=1;j<b.length-1;j++){
                if(b[i][j]==2){
                keepi.add(i);
                keepj.add(j);
                }                
            }
        }
        burn(keepi,keepj,b); 
    }
    
    public static void burn(ArrayList i, ArrayList j,int[][] b){
        two=0;
        for(int y =0;y<i.size();y++){
            if(randomProb[(int)i.get(y)-1][(int)j.get(y)] < prob){ //NORTH
               if( b[(int)i.get(y)-1][(int)j.get(y)]==1){
                   b[(int)i.get(y)-1][(int)j.get(y)]=2;
                   two++;
               }
               //b[(int)i.get(y)-1][(int)j.get(y)]= b[(int)i.get(y)-1][(int)j.get(y)]==1 ? 2 : b[(int)i.get(y)-1][(int)j.get(y)];
            }
            
            if(randomProb[(int)i.get(y)+1][(int)j.get(y)] < prob){ //SOUTH
                
                if(b[(int)i.get(y)+1][(int)j.get(y)]==1){
                    b[(int)i.get(y)+1][(int)j.get(y)]=2;
                    two++;
                }
               // b[(int)i.get(y)+1][(int)j.get(y)]= b[(int)i.get(y)+1][(int)j.get(y)]==1 ? 2 : b[(int)i.get(y)+1][(int)j.get(y)];
            }
            if(randomProb[(int)i.get(y)][(int)j.get(y)-1] < prob){ //WEST
                if(b[(int)i.get(y)][(int)j.get(y)-1]==1 ) {
                    b[(int)i.get(y)][(int)j.get(y)-1]=2; 
                    two++;
                }
                // b[(int)i.get(y)][(int)j.get(y)-1]= b[(int)i.get(y)][(int)j.get(y)-1]==1 ? 2 : b[(int)i.get(y)][(int)j.get(y)-1];
            }
            if(randomProb[(int)i.get(y)][(int)j.get(y)+1 ]< prob){ //EAST
                if(b[(int)i.get(y)][(int)j.get(y)+1]==1){
                    b[(int)i.get(y)][(int)j.get(y)+1]=2;
                    two++;
                }
                //b[(int)i.get(y)][(int)j.get(y)+1]= b[(int)i.get(y)][(int)j.get(y)+1]==1 ? 2 : b[(int)i.get(y)][(int)j.get(y)+1];
            }
            b[(int)i.get(y)][(int)j.get(y)] = 0;
        }
    }*/
}
