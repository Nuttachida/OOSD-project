package spreadfire;

import java.util.ArrayList;

public class Fire {
    
    private static int two = 1;
    private boolean stop;
    private static final ArrayList<Integer> keepi = new ArrayList<>();
    private static final ArrayList<Integer> keepj = new ArrayList<>();
    private double prob;
    private double initBurn = 0.1;
    private double density = 0.5;
    private static double[][] randomProb;
    private int size = 50;
    private static int[][] forest;
    private static int count = 0;
    
    public Fire(){
        createForest(1.0,0.0,0.0);
        createRandom();
        stop = false;
    }
    
     public void setSize(int size){
        this.size = size;
    }
    
    public void createForest(double den, double probBurn, double prob){
        createRandom();
        forest = new int[size][size];
        this.prob = prob;
        for(int i=0; i < forest.length;i++){
            for(int j=0; j < forest.length;j++){
                if(i==0 || i == forest.length-1 || j==0 || j == forest.length-1){
                    forest[i][j] = 0;
                }else if(Math.random() < den){
                    if(Math.random() < probBurn){
                        forest[i][j] = 2;
                    }else {
                        forest[i][j] = 1;
                    }
                } 
                else {
                    forest[i][j] = 0;
                }
                
            }
        }
    }
    
    public void createRandom(){
        randomProb = new double[size][size];
        for(int i=0 ;i<randomProb.length;i++){
           for(int j=0;j<randomProb.length;j++){
               randomProb[i][j] = Math.random();
           }
       }
    }
    
    public void hasTwo(CreateGui panel){
        RectsJPanel rect = new RectsJPanel(this);
        print(forest);
        prepare(forest);
        panel.setGUI(rect);
        while(two > 0 && (!stop)){
           rect = new RectsJPanel(this);
           prepare(forest);
           print(forest);
           count++;
           panel.setGUI(rect);
        }
    }
    
    public void print(int [][] c){
        
        for (int[] c1 : c) {
            for (int j = 0; j<c.length; j++) {
                
                System.out.print(c1[j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }
    
    public void prepare(int[][] b){
     keepi.clear();
     keepj.clear();
       
        for(int i=1;i<b.length-1;i++){ 
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
            }
            
            if(randomProb[(int)i.get(y)+1][(int)j.get(y)] < prob){ //SOUTH
                
                if(b[(int)i.get(y)+1][(int)j.get(y)]==1){
                    b[(int)i.get(y)+1][(int)j.get(y)]=2;
                    two++;
                }
            }
            if(randomProb[(int)i.get(y)][(int)j.get(y)-1] < prob){ //WEST
                if(b[(int)i.get(y)][(int)j.get(y)-1]==1 ) {
                    b[(int)i.get(y)][(int)j.get(y)-1]=2; 
                    two++;
                }
            }
            if(randomProb[(int)i.get(y)][(int)j.get(y)+1 ]< prob){ //EAST
                if(b[(int)i.get(y)][(int)j.get(y)+1]==1){
                    b[(int)i.get(y)][(int)j.get(y)+1]=2;
                    two++;
                }
            }
            b[(int)i.get(y)][(int)j.get(y)] = 0;
        }
    }
    
    // this method for start burn point
//    public void startBurn(int[][] b){
//       int burnX = (int)(Math.random()*48+1);
//       int burnY = (int)(Math.random()*48+1);
//       b[burnX][burnY] = 2;
//    }
    
    public void probTree(int[][] b){
       double probStart;
       for(int i =1;i<forest.length-1;i++){
            for(int j=1 ; j<forest.length-1;j++){
                probStart = Math.random()*1;
               if(density < probStart) {
                   b[i][j] = 0;
               }
               else {
                   b[i][j] = 1;
               }
            }
        }
    }
    
    public void probBurn(int[][] b){
        double probStart;
        for(int i =1;i<forest.length-1;i++){
            for(int j=1 ; j<forest.length-1;j++){
                probStart = Math.random()*1;
                if(initBurn > probStart ) {
                   b[i][j] = 2;
                }
                else {
                   b[i][j] = 1;
                }
            }
        }
    }
    
    public void step(CreateGui panel){
        RectsJPanel rect = new RectsJPanel(this);
        prepare(forest);
        print(forest);
        count++;
        panel.setGUI(rect);
    }
    
    public int[][] getForest(){
        return forest;
    }
    
    public int getCount(){
        return count;
    }
    
    
    public void stop(){
        stop = true;
    } 
     
    public void reset(){
        
        stop = false;
        two = 1;
        createRandom();
        createForest(1.0,0.0,0.0);
        
        count = 0;
    }
}
