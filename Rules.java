
//Rules class apply the rule of the game
public class Rules {

    // Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    // Any live cell with two or three live neighbors lives on to the next generation.
    // Any live cell with more than three live neighbors dies, as if by overpopulation.
    // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    
    Neighbors localGrid = new Neighbors();

    int cell;
    char temp;
    int aliveNeighbors = 0;
                         //orignal grid     
    public void determine(char[][] oGrid, int rows, int cols){
        cell = localGrid.getLivingNeighbor(oGrid, rows, cols);

        //cell lonely and dies
        if(oGrid[rows][cols] == 'X' && cell == 1){
            Cell.updatedGrid[rows][cols] = 'O';
        }
        
        //cell dies due to over population
        else if(oGrid[rows][cols] == 'X' && cell > 3){
            Cell.updatedGrid[rows][cols] = 'O';
        }
        
        //live cell with two or three live neighbors lives on to the next generation.
        else if(oGrid[rows][cols] == 'X' && (cell == 2 || cell == 3)){
            Cell.updatedGrid[rows][cols] = 'X';
        }

        //new cell is born
        else if(oGrid[rows][cols] == 'O' && cell == 3){
            Cell.updatedGrid[rows][cols] = 'X';
        }

        //remain the same
        else{
            Cell.updatedGrid[rows][cols] = oGrid[rows][cols];
        }

        
    }
    
}
