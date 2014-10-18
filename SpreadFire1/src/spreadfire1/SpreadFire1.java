
package spreadfire1;
import java.util.*;

public class SpreadFire1 {

    static double prob=0.5;
    public static void main(String[] args) {
        // SIZE A*A 
        int[][] num = new int[20][20];
        // DO TREE = 1 
        for(int i =0;i<num.length;i++){
            for(int j=0 ; j<num.length;j++){
                num[i][j] = 1;
            }
        }
        
       // DO EMPTY = 5
       num[4][7]=5;
       // PRINT NATURAL
       print(num);
       // PRINT 1 ROUND
       prepare(num); 
       print(num);
       // PRINT 2 ROUND
       prepare(num);
       print(num);
       // PRINT 3 ROUND
       prepare(num);
       print(num);
       // PRINT 4 ROUND
       prepare(num);
       print(num);
       // PRINT 5 ROUND
       prepare(num);
       print(num);
       
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
       
        ArrayList<Integer> keepi = new ArrayList<>();
        ArrayList<Integer> keepj = new ArrayList<>();
       
        b[6][6]=0; // DO BURN POINT
       
        for(int i=1;i<b.length-1;i++){ //KEEP BURN POINT
            for(int j=1;j<b.length-1;j++){
                if(b[i][j]==0){
                keepi.add(i);
                keepj.add(j);
                }                
            }
        }
        burn(keepi,keepj,b); 
    }
    
    public static void burn(ArrayList i, ArrayList j,int[][] n){
        for(int y =0;y<i.size();y++){
            if(Float.parseFloat((""+Math.random()).substring(0,3))<prob){ //NORTH
                n[(int)i.get(y)-1][(int)j.get(y)]= n[(int)i.get(y)-1][(int)j.get(y)]==1 ? 0 : n[(int)i.get(y)-1][(int)j.get(y)];
            }
            if(Float.parseFloat((""+Math.random()).substring(0,3))<prob){ //SOUTH
                n[(int)i.get(y)+1][(int)j.get(y)]= n[(int)i.get(y)+1][(int)j.get(y)]==1 ? 0 : n[(int)i.get(y)+1][(int)j.get(y)];
            }
            if(Float.parseFloat((""+Math.random()).substring(0,3))<prob){ //WEST
                n[(int)i.get(y)][(int)j.get(y)-1]= n[(int)i.get(y)][(int)j.get(y)-1]==1 ? 0 : n[(int)i.get(y)][(int)j.get(y)-1];
            }
            if(Float.parseFloat((""+Math.random()).substring(0,3))<prob){ //EAST
                n[(int)i.get(y)][(int)j.get(y)+1]= n[(int)i.get(y)][(int)j.get(y)+1]==1 ? 0 : n[(int)i.get(y)][(int)j.get(y)+1];
            }
        }
    }
    }
    





