/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spreadfire;

import java.util.ArrayList;

public class Fire {
    static int two = 1;
    
    static ArrayList<Integer> keepi = new ArrayList<>();
    static ArrayList<Integer> keepj = new ArrayList<>();
       
    static double prob = 0.5; //กำหนด prob
    static double[][] randomProb =new double[50][50]; //0-1
    static int[][] size = new int[50][50]; //size keep 0,1,2
    
    public Fire(){
        createForest();
        createRandom();
        hasTwo();
        
    }
    
    public void createForest(){
        for(int i =0;i<size.length;i++){
            for(int j=0 ; j<size.length;j++){
               if(j==0 || i==0 || j==size.length-1 || i==size.length-1){//border
                    size[i][j]= 0;
                }else{size[i][j] =1;}
            }
        }
    }
    
    public void createRandom(){
        for(int i=0 ;i<randomProb.length;i++){
           for(int j=0;j<randomProb.length;j++){
               randomProb[i][j] = Math.random();
           }
       }
    }
    
    public void hasTwo(){
        while(two > 0){
           RectsJPanel rect = new RectsJPanel(this);
           //SpreadFire.frame.add(rect);
           prepare(size);
           print(size);
       }
      
    }
    
    public int[][] getForest(){
        return size;
    }
    
    public void print(int [][] c){
        for (int[] c1 : c) {
            for (int j = 0; j<c.length; j++) {
                System.out.print(c1[j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }
    
    public void prepare(int[][] b){
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
    
    public void burn(ArrayList i, ArrayList j,int[][] b){
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
    }
}
