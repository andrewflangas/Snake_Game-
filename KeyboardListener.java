import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 39: // right arrow key
                // If the snake is not moving left, set the direction to right
                if(ThreadsController.directionSnake!=2)
                    ThreadsController.directionSnake=1;
                break; 
            case 38: // up arrow key
                // If the snake is not moving down, set the direction to up
                if(ThreadsController.directionSnake!=4)
                    ThreadsController.directionSnake=3;
                break; 
            case 37: // left arrow key
                // If the snake is not moving right, set the direction to left
                if(ThreadsController.directionSnake!=1)
                    ThreadsController.directionSnake=2; 
                break; 
            case 40: // down arrow key
                // If the snake is not moving up, set the direction to down
                if(ThreadsController.directionSnake!=3)
                    ThreadsController.directionSnake=4; 
                break; 
            default: break; // If a different key is pressed, do nothing
        }
    }
}