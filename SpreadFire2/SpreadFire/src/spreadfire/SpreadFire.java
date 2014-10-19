
package spreadfire;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpreadFire {
    
    
    static ArrayList<Integer> keepi = new ArrayList<>();
    static ArrayList<Integer> keepj = new ArrayList<>();
       
    static double prob = 0.5; //กำหนด prob
    static double[][] randomProb =new double[20][20]; //0-1
    static int[][] size = new int[20][20]; //size keep 0,1,2
    
    public static void main(String[] args) {
        
        // DO TREE = 1 
        for(int i =0;i<size.length;i++){
            for(int j=0 ; j<size.length;j++){
               if(j==0 || i==0 || j==size.length-1 || i==size.length-1){//border
                    size[i][j]= 0;
                }else{size[i][j] =1;}
            }
        }
       
       //randomProb;
       for(int i=0 ;i<randomProb.length;i++){
           for(int j=0;j<randomProb.length;j++){
               randomProb[i][j] = Math.random();
           }
       }
       // while(!keepi.isEmpty()){
     for(int i=0 ; i < 10 ; i++){
          // keepi.add(13);
          // keepj.add(12);
           print(size);
           prepare(size);
           
       }
     
     
     JPanel show = new CreateGui(size);
     
           
//       }
//       // PRINT NATURAL
//       print(num);
//       // PRINT 1 ROUND
//       prepare(num); 
//       print(num);
//       // PRINT 2 ROUND
//       prepare(num);
//       print(num);
//       // PRINT 3 ROUND
//       prepare(num);
//       print(num);
//       // PRINT 4 ROUND
//       prepare(num);
//       print(num);
//       // PRINT 5 ROUND
//       prepare(num);
//       print(num);
//       
//        //print(random);
       
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
        for(int y =0;y<i.size();y++){
            if(randomProb[(int)i.get(y)-1][(int)j.get(y)] < prob){ //NORTH
               b[(int)i.get(y)-1][(int)j.get(y)]= b[(int)i.get(y)-1][(int)j.get(y)]==1 ? 2 : b[(int)i.get(y)-1][(int)j.get(y)];
            }
            if(randomProb[(int)i.get(y)+1][(int)j.get(y)] < prob){ //SOUTH
                b[(int)i.get(y)+1][(int)j.get(y)]= b[(int)i.get(y)+1][(int)j.get(y)]==1 ? 2 : b[(int)i.get(y)+1][(int)j.get(y)];
            }
            if(randomProb[(int)i.get(y)][(int)j.get(y)-1] < prob){ //WEST
                b[(int)i.get(y)][(int)j.get(y)-1]= b[(int)i.get(y)][(int)j.get(y)-1]==1 ? 2 : b[(int)i.get(y)][(int)j.get(y)-1];
            }
            if(randomProb[(int)i.get(y)][(int)j.get(y)+1 ]< prob){ //EAST
                b[(int)i.get(y)][(int)j.get(y)+1]= b[(int)i.get(y)][(int)j.get(y)+1]==1 ? 2 : b[(int)i.get(y)][(int)j.get(y)+1];
            }
            b[(int)i.get(y)][(int)j.get(y)] = 0;
            
        }
    }
   
}
