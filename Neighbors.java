
// Neighbors class detemines whether the cell survie or dead on the next generation

public class Neighbors {
	
    public int getLivingNeighbor(char [][] g, int i, int j){
        // check all the surroundings of live cell
        int output = 0;

        //upperleft 
        if ((i - 1 >= 0) && (j - 1 >= 0)) {
			if (g[i-1][j - 1] == 'X') {
				output++; 
			}
		}
		// Check upper center 
		if ((i - 1 >= 0) && (j >= 0)) {
			if (g[i-1][j] == 'X') {
				output++; 
			}
		}
		// Check upper right 
		if ((i - 1 >= 0) && (j + 1 < 20)) {
			if (g[i-1][j+1] == 'X') {
				output++; 
			}
		}
		
		// Check center left 
		if ((i >= 0) && (j - 1 >= 0)) {
			if (g[i][j - 1] == 'X') {
				output++; 
			}
		}
		
		// Check center right 
		if ((i >= 0) && (j + 1 < 20)) {
			if (g[i][j+1] == 'X') {
				output++; 
			}
		}
		
		// Check lower left
		if ((i + 1 < 20) && (j - 1 >= 0)) {
			if (g[i+1][j - 1] == 'X') {
				output++; 
			}
		}
		// Check lower center 
		if ((i + 1 < 20) && (j >= 0)) {
			if (g[i+1][j] == 'X') {
				output++; 
			}
		}
		// Check lower right 
		if ((i + 1 < 20) && (j + 1 < 20)) {
			if (g[i+1][j+1] == 'X') {
				output++; 
			}
		}

        
    return output;
}

}
