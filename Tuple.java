// Tuple class to represent a pair of coordinates
public class Tuple{
    
    // Fields to store the coordinates and their respective changes
    public int x;
    public int y; 
    public int xf;
    public int yf; 

    // Constructor for the Tuple class
    public Tuple(int x, int y){
        
        // Set the initial values of x and y
        this.x = x;
        this.y = y; 
    }
    
    // Method to change the values of x and y
    public void ChangeData(int x, int y){
        
        // Set the new values of x and y
        this.x = x;
        this.y = y; 
    }
    
    // Getter method for x
    public int getX(){
        
        // Return the value of x
        return x; 
    }
    
    // Getter method for y
    public int getY(){
        
        // Return the value of y
        return y; 
    }
    
    // Getter method for xf
    public int getXf(){
        
        // Return the value of xf
        return xf; 
    }
    
    // Getter method for yf
    public int getYf(){
        
        // Return the value of yf
        return yf; 
    }
}