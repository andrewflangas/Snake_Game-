import javax.swing.JFrame; 

public class Main{

    public static void main(String[] args){

        // Create a new instance of the Window class
        Window f1 = new Window();

        // Set the title of the window to "Snake"
        f1.setTitle("Snake");

        // Set the size of the window to 300 pixels wide by 300 pixels tall
        f1.setSize(300,300);

        // Make the window visible
        f1.setVisible(true);

        // Set the default close operation to exit the application when the window is closed
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}