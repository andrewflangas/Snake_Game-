import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

// Window class that extends JFrame
class Window extends JFrame{

    // serialVersionUID is a unique identifier for serialization 
    // and deserialization of an object
    private static final long serialVersionUID = -2542001418764869760L;

    // Two-dimensional ArrayList of DataOfSquare objects 
    public static ArrayList<ArrayList<DataOfSquare>> Grid;

    // Width and height of the game grid
    public static int width = 20;
    public static int height = 20;

    // Constructor for the Window class
    public Window(){

        // Initialize the two-dimensional ArrayList of DataOfSquare objects
        Grid = new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        // Loop through each row of the grid
        for(int i=0; i<width;i++){

            // Create a new ArrayList to represent the row
            data = new ArrayList<DataOfSquare>();

            // Loop through each column of the grid
            for(int j=0;j<height;j++){

                // Create a new DataOfSquare object with a value of 2
                DataOfSquare c = new DataOfSquare(2);

                // Add the DataOfSquare object to the ArrayList representing the row
                data.add(c);
            }

            // Add the ArrayList representing the row to the two-dimensional ArrayList
            Grid.add(data); 
        }

        // Set the layout of the JFrame to a GridLayout with 20 rows and 20 columns
        getContentPane().setLayout(new GridLayout(20,20,0,0));

        // Loop through each row of the grid
        for(int i=0;i<width;i++){

            // Loop through each column of the grid
            for(int j=0;j<height;j++){

                // Add the square component of the DataOfSquare object to the JFrame
                getContentPane().add(Grid.get(i).get(j).square);
            }
        }

        // Create a new Tuple object to represent the starting position of the snake
        Tuple position = new Tuple(10,10);

        // Create a new ThreadsController object with the starting position
        ThreadsController c = new ThreadsController(position);

        // Start the ThreadsController thread
        c.start();

        // Add a KeyListener to the JFrame to handle keyboard events
        this.addKeyListener((KeyListener) new KeyboardListener());
    }
}