import java.util.ArrayList;
import java.awt.Color; 

public class DataOfSquare{

    // ArrayList to store different colors for the squares
    ArrayList<Color> C = new ArrayList<Color>();
    
    // variable to hold the color index of the square
    int color; 
    
    // instance of SquarePanel class to represent the square visually
    SquarePanel square;
    
    // constructor to initialize the square color
    public DataOfSquare(int col){

        // add different colors to the ArrayList
        C.add(Color.purple);
        C.add(Color.BLUE);
        C.add(Color.white);
        
        // set the square color index
        color=col; 
        
        // create a new instance of SquarePanel with the color at the index
        square= new SquarePanel(C.get(color));
    }
    
    // method to change the color of the square
    public void lightMeUp(int c){
        // change the color of the SquarePanel instance to the color at the given index
        square.ChangeColor(C.get(c)); 
    }
}