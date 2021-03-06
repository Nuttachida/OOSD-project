package spreadfire;

import java.util.ArrayList;

public class Fire {

    private static double[][] randomProb;
    private static ArrayList<Integer> forX;
    private static ArrayList<Integer> forY;
    private static double prob;
    private static boolean noTwo = false;
    private Forest forest;
    private static int count = 0;
    private int delay = 500;

    public Fire(Forest forest) {
        this.forest = forest;
        randomProb = new double[forest.getSize()][forest.getSize()];
        forX = new ArrayList<Integer>();
        forY = new ArrayList<Integer>();
        randomFirePerPoint();
    }
    
    public boolean isCorrectProp(){
        if(prob > 1 || prob < 0){
            return false;
        }
        else {
            return true;
        }
    }
    
    public int getCount(){
        return count;
    }
    
    public boolean getNoTwo(){
        return noTwo;
    }
    
    public void setDelay(int delay){
        this.delay = delay;
    }

    // Method for random every index.
    public void randomFirePerPoint() {
        for (int i = 0; i < randomProb.length; i++) {
            for (int j = 0; j < randomProb.length; j++) {
                randomProb[i][j] = Math.random();
            }
        }
    }
    
    // Method for burning automatic in GUI.
    public void probCatch(double prob){
        this.prob = prob;
        Burning(forX,forY);
        try{
            Thread.sleep(delay);
        }catch(Exception e){
            //
        }
        count++;
        if(forX.isEmpty() && forY.isEmpty()){
            noTwo = true;
        }
    }
    
    // Method for burning step by step in GUI.
    public void stepByStep(double prob) {
        this.prob = prob;
        //Prepare(forest.getForest());
        Burning(forX,forY);
        if(forX.isEmpty() && forY.isEmpty()){
            noTwo = true;
        }
        count++;
    }

    // Method for check N/S/E/W that has prob enough for spreading fire.
    public void Burning(ArrayList i, ArrayList j) {
        for (int y = 0; y < i.size(); y++) {
            if (randomProb[(int) i.get(y) - 1][(int) j.get(y)] < prob) { //NORTH
                if (forest.getForest()[(int) i.get(y) - 1][(int) j.get(y)] == 1) {
                    forest.getForest()[(int) i.get(y) - 1][(int) j.get(y)] = 2;
                }
            }

            if (randomProb[(int) i.get(y) + 1][(int) j.get(y)] < prob) { //SOUTH

                if (forest.getForest()[(int) i.get(y) + 1][(int) j.get(y)] == 1) {
                    forest.getForest()[(int) i.get(y) + 1][(int) j.get(y)] = 2;
                }
            }
            
            if (randomProb[(int) i.get(y)][(int) j.get(y) - 1] < prob) { //WEST
                if (forest.getForest()[(int) i.get(y)][(int) j.get(y) - 1] == 1) {
                    forest.getForest()[(int) i.get(y)][(int) j.get(y) - 1] = 2;
                }
            }
            
            if (randomProb[(int) i.get(y)][(int) j.get(y) + 1] < prob) { //EAST
                if (forest.getForest()[(int) i.get(y)][(int) j.get(y) + 1] == 1) {
                    forest.getForest()[(int) i.get(y)][(int) j.get(y) + 1] = 2;
                }
            }
            forest.getForest()[(int) i.get(y)][(int) j.get(y)] = 0;
        }
        Prepare(forest.getForest());
    }

    // Method to Prepare for Burning.
    public void Prepare(int[][] b) {
        forX.clear();
        forY.clear();
        for (int i = 1; i < b.length - 1; i++) {
            for (int j = 1; j < b.length - 1; j++) {
                if (b[i][j] == 2) {
                    forX.add(i);
                    forY.add(j);
                }
            }
        }
    }
    
    // Method for reset value in GUI.
    public void reDefault() {
        prob = 0;
        count = 0;
        noTwo = false;
        delay = 500;
    }
    
    // Method for stop GUI
    public void stop() {
        noTwo = true;
    }

}
