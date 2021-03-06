package spreadfire;

public class Forest {
    
    private static int[][] forestSize;
    private static int size;
    private static double probBurn;
    private static double probTree;
    private static int tree;
    
    public Forest(int size) {
        this.size = size;
        forestSize = new int[size][size];
        probBurn = 0.0;
        probTree = 1.0;
        createForest();
    }
    
    public Forest(int size, double density, double burn) {
        this.size = size;
        forestSize = new int[size][size];
        probBurn = burn;
        probTree = density;
        createForest();
    }
    
    public boolean isCorrectBurn(){
        if(probBurn > 1 || probBurn < 0){
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean isCorrectTree(){
        if(probTree > 1 || probTree < 0){
            return false;
        }
        else {
            return true;
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public int[][] getForest() {
        return forestSize;
    }
    
    // create forest. even probTree and probBurn here.
    public void createForest(){
        for(int i=0; i < forestSize.length;i++){
            for(int j=0; j < forestSize.length;j++){
                if(probTree > Math.random()){
                    if(probBurn > Math.random()) {
                        forestSize[i][j] = 2;
                    }
                    else {
                        forestSize[i][j] = 1;
                    }
                }
                else {
                    forestSize[i][j] = 0;
                }
                
                if(i == 0 || j == 0 || i == forestSize.length-1 || j == forestSize.length-1) {
                    forestSize[i][j] = 0;
                }
            }
        }
    }
    
    // reset probBurn, probTree, and forest to defalut value.
    public void reDefault() {
        probBurn = 0.0;
        probTree = 1.0;
        createForest();
    }
    
}
