import java.util.ArrayList; 

public class ThreadsController extends Thread{
    ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>(); // List of Squares on the game grid
    Tuple headSnakePos; // Current position of the head of the snake
    int sizeSnake=3; // Initial size of the snake
    long speed = 50; // Time delay between each movement of the snake
    public static int directionSnake; // Direction of the snake, represented as an integer value (1-4)

    ArrayList<Tuple> positions = new ArrayList<Tuple>(); // List of positions occupied by the snake's body
    Tuple foodPosition; // Position of the food on the game grid

    // Constructor
    ThreadsController(Tuple positionDepart){
        Squares=Window.Grid; // Set the game grid to the one defined in the Window class

        headSnakePos = new Tuple(positionDepart.x, positionDepart.y); // Set the starting position of the snake's head
        directionSnake = 1; // Set the initial direction of the snake to right

        Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
        positions.add(headPos); // Add the head of the snake to the list of positions

        foodPosition = new Tuple(Window.height-1, Window.width-1); // Set the starting position of the food
        spawnFood(foodPosition); // Spawn the food on the game grid
    }

    // Run method that will be called when the thread starts
    public void run(){
        while(true){
            moveInterne(directionSnake); // Move the snake in the current direction
            checkCollision(); // Check for collisions with walls or the snake's body
            moveExterne(); // Move the snake on the game grid
            deleteTail(); // Remove the last square of the snake's body if it has exceeded the maximum size
            pauser(); // Wait for a specified time before moving again
        }
    }

    // Helper method that pauses the thread for the specified amount of time
    private void pauser(){
        try{
            sleep(speed);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    // Helper method that checks for collisions with walls or the snake's body
    private void checkCollision(){
        Tuple posCritique = positions.get(positions.size()-1);
        for(int i=0;i<=positions.size()-2;i++){
            boolean biteItself = posCritique.getX()==positions.get(i).getX() && posCritique.getY()==positions.get(i).getY();
            if(biteItself){ // If the snake has collided with its own body, stop the game
                stopTheGame();
            }
        }

        boolean eatingFood = posCritique.getX()==foodPosition.y && posCritique.getY()==foodPosition.x;
        if(eatingFood){ // If the snake has eaten the food, increase its size and spawn a new food
            System.out.println("Mmmgoooord!");
            sizeSnake = sizeSnake+1;
            foodPosition = getValAleaNotInSnake();

            spawnFood(foodPosition);
        }
    }

    // Helper method that stops the game if the snake has collided with its own body
    private void stopTheGame(){
        System.out.println("COLISION! \n");
        while(true){ // Pause the thread indefinitely
            pauser();
        }
    }

        // Helper method that spawns the food on the game grid
    private void spawnFood(Tuple foodPositionIn){
        Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
    }

    // Helper method that generates a random Tuple (x,y) that is not in the snake
    private Tuple getValAleaNotInSnake(){
        Tuple p;
        int ranX= 0 + (int)(Math.random()*19);
        int ranY= 0 + (int)(Math.random()*19);
        p=new Tuple(ranX,ranY);
        // Check if the random Tuple is in the snake, if it is, generate a new one
        for(int i=0;i<=positions.size()-1;i++){
            if(p.getY()==positions.get(i).getX()&& p.getX()==positions.get(i).getY()){
                ranX= 0 + (int)(Math.random()*19);
                ranY= 0 + (int)(Math.random()*19);
                p = new Tuple(ranX,ranY);
                i = 0;
            }
        }
        return p;
    }

    // Helper method that moves the snake in the given direction
    private void moveInterne(int dir){
        switch (dir){
            case 4:
                    // Move the snake right
                    headSnakePos.ChangeData(headSnakePos.x,(headSnakePos.y+1)%20);
                    positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
                    break;
            case 3:
                    // Move the snake left
                    if(headSnakePos.y-1<0){
                        headSnakePos.ChangeData(headSnakePos.x,19);
                    }
                    else{
                        headSnakePos.ChangeData(headSnakePos.x,Math.abs(headSnakePos.y-1)%20);
                    }
                    positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
                    break;
            case 2:
                    // Move the snake up
                    if(headSnakePos.x-1<0){
                        headSnakePos.ChangeData(19,headSnakePos.y);
                    }
                    else{
                        headSnakePos.ChangeData(Math.abs(headSnakePos.x-1)%20,headSnakePos.y);
                    }
                    positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
                    break;
            case 1:
                    // Move the snake down
                    headSnakePos.ChangeData(Math.abs(headSnakePos.x+1)%20, headSnakePos.y);
                    positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
                    break;
        }
    }

    // Helper method that clears the snake from the previous positions on the game grid
    private void moveExterne(){
        for(Tuple t: positions){
            int y = t.getX();
            int x = t.getY();
            Squares.get(x).get(y).lightMeUp(0);
        }
    }

    // Helper method that deletes the tail of the snake from the game grid
    private void deleteTail(){
        int cmpt = sizeSnake;
        for(int i=positions.size()-1;i>=0;i--){
            if(cmpt==0){
                Tuple t = positions.get(i);
                Squares.get(t.y).get(t.x).lightMeUp(2);
            }
            else{
                cmpt--;
            }
        }
        cmpt = sizeSnake;
        // Remove the tail of the snake from the list of positions
        for(int i=positions.size()-1;i>=0;i--){
            if(cmpt==0){
                positions.remove(i);
            }
            else{
                cmpt--;
            }
        }
    }
}