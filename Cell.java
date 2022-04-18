import java.util.ArrayList;
import java.util.Random;

public class Cell  {
    //for thread
    int time;
    Random r = new Random();    

    Grid g;
    Rules gameRule;
    Display result;
    Neighbors checkNeighbors;
    
    int rows = 20;
    int cols = 20;
    int gens;

    public char [][] originalGrid = new char[20][20];
    public static char [][] updatedGrid = new char[20][20];

    //Constructor
    public Cell(){
        checkNeighbors = new Neighbors();
        g = new Grid();
        gameRule = new Rules();
        result = new Display();
        gens = g.generations;
        time = r.nextInt(999);
        
        //orginalGrid and updatedGrid are initialized from the g instance of Grid class.
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                originalGrid[i][j] = g.gridArray[i][j];
                updatedGrid[i][j] = g.gridArray[i][j];
            }
        }
        
    };

    public void run() {

        System.out.println("\n------------ INITIAL STATE ------------- \n");
        result.displayFinal(originalGrid);


        // ------------------------------- PROCESSING STATE ---------------------------- //
        for(int k = 0; k < gens; k++){
            
            // run the game
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols;j++){
                    checkNeighbors.getLivingNeighbor(originalGrid, i, j);
                    gameRule.determine(originalGrid, i, j);
                }
            }

            //After a generation's run, override the origial grid with the most recent ones.
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    originalGrid[i][j] = updatedGrid[i][j];
                }
            }
        }

        System.out.println(" \n --------------- FINAL STATE ------------- \n");
        result.displayFinal(updatedGrid);
        
    }

   
  

}
