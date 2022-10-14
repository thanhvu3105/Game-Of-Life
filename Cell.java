import java.util.ArrayList;
import java.util.Random;



public class Cell implements Runnable {
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


    @Override
    public void run() {

        System.out.println("\n------------ INITIAL STATE ------------- \n");
        result.displayFinal(originalGrid);

        for(int k = 0; k < gens; k++){
            
            //each cell as a thread will run here
            try {
                runThread();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            //After a generation's run, override the origial grid with the most recent ones.
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    originalGrid[i][j] = updatedGrid[i][j];
                }
            }

    
            try{
                Thread.sleep(time);
            } catch(Exception e){

            }

        }

        System.out.println(" \n --------------- FINAL STATE ------------- \n");
        result.displayFinal(updatedGrid);


        
    }

    //This function will enables each cell in each generation as a thread.
    public void runThread() throws InterruptedException{
        
        //Iterate through each single cell and apply the rule to the cell
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                int tempRows = i;
                int tempCols = j;

                //create a runnable object to run thread.
                //in runnable, declare anonymous classes.
                //we will check neighbors of each cell, at the same time determines the next generations
                //these two function will run concurently
                Runnable runnable = () -> {
                    checkNeighbors.getLivingNeighbor(originalGrid, tempRows, tempCols);
                    gameRule.determine(originalGrid, tempRows, tempCols);
                };

                Thread t = new Thread(runnable);

                //start thread, triigers run(), multithread starts 
                t.start();
                //wait for thread to complete and die.
                t.join();
            }
        }
        
       
    }

  

}
