import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


//Grid class basically read the text file and store it in grid 2d array
public class Grid {
    int rows = 20;
    int cols = 20;
    
    public char [][]gridArray = new char[rows][cols];

    int generations = 0;

    //dynamic array list that contains static char array,
    ArrayList<char[]> grid2d = new ArrayList<>();
    
    public Grid(){
        try{
            Scanner sc = new Scanner(new BufferedReader(new FileReader("grid.txt")));
            while(sc.hasNextLine()){
                //get the generations input from file, the number at the end of the file
                if(sc.hasNextInt()){
                    generations = sc.nextInt();
                }
                else{
                    //add each line of char as array to arrayList rows.
                    grid2d.add(sc.nextLine().toCharArray());
                }        
            }
            //Store all the elements in 2D array
            gridArray = grid2d.toArray(new char[grid2d.size()][]);
            
            sc.close();

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
       
    }
    
}
