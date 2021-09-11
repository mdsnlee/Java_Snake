import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.LinkedList;

public class PlayGame implements Scene {

    private Snake snake;
    private int size = 20;
    private Color snakeColor = Color.BLUE;

    private Apple apple;
    private Color appleColor = Color.RED;

    
    public PlayGame() {
        System.out.println("play game");

        snake = new Snake();
        apple = new Apple();
    }

    public ActiveState update() {
        snake.move();
        //check if overlap
        if (snake.getHead().getX() == apple.getX() &&
            snake.getHead().getY() == apple.getY()) {
            apple.randApple();
            snake.grow();
        }
        //extend snake body

        //if game over return 2


        if (snake.isColliding()) {
            return ActiveState.GAME_OVER;
        }

        return ActiveState.PLAY_GAME;
    }

    public void draw(Graphics g) {
        drawApple(g);
        drawSnake(g);
    }

    private void drawSnake(Graphics g) {
        g.setColor(snakeColor);
        Coordinate head = snake.getHead();
        g.fillRect(head.getX() * size, head.getY() * size, size, size);
        
        //draw snake body
        
        // //method 1 (for loop)
        //LinkedList<Coordinate> body = snake.getBody();
        // for (int i = 0; i < body.size(); i++) {
        //     g.fillRect(body.get(i).getX() * size, body.get(i).getY() * size, size, size);
        // }

        // //method 2 (python for loop/for each loop)
        // //      variable            list
        // for (Coordinate piece : snake.getBody()) {
        //     g.fillRect(piece.getX() * size, piece.getY() * size, size, size);
        // }

        // //method 3 (iterator)
        // //Iterator object
        // //only for linked lists? iterator part of linked list, use mainly for linked list
        // Iterator it = body.iterator();
        // while (it.hasNext()) {
        //     g.fillRect(it.getX() * size, it.getY() * size, size, size);
        //     it.next()
        // }

        //method 4 (for each (again))
        LinkedList<Coordinate> body = snake.getBody();
        //built in
        body.forEach(
            //java syntax
            (piece) -> g.fillRect(piece.getX() * size, piece.getY() * size, size, size)
        );

        //method 5 ()

    }

    private void drawApple(Graphics g) {
        g.setColor(appleColor);
        Coordinate appleCoord = apple.getCoord();
        g.fillRect(appleCoord.getX() * size, appleCoord.getY() * size, size, size);
    }

    public void keyPressed(int key) {
        
        if (key == KeyEvent.VK_LEFT) {
            snake.moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            snake.moveRight();
        }
        if (key == KeyEvent.VK_UP) {
            snake.moveUp();
        }
        if (key == KeyEvent.VK_DOWN) {
            snake.moveDown();
        }
    }

}

//switch statements

//enums?????
//list of coordinates, print it through using coordinates
//collect body rectangle's coordinates and print through it
//create a linked list the snake's body rectangles

//body
//head = x,y
//body goes to previous head coordinate
//ways of data structure - linked list (moving each one up), 

//try: adding buttons to main menu and game over? buttons + screens, making it pretty