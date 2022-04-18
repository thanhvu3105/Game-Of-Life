// this class just update a state of the grid

public class Display {

    public void displayFinal(char[][] grid){
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println("\n");
        }
    }
}
