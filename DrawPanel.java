import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

/*
 ** 0 - Main Menu
 ** 1 - Play Game
 ** 2 - Game Over
*/

public class DrawPanel extends JPanel implements ActionListener {
    private Scene dispatch[];

    private Timer timer;

    private ActiveState gameState;

    public DrawPanel() {
        super();
        addKeyListener(new TAdapter());
        setFocusable(true);
        gameState = ActiveState.PLAY_GAME;
        dispatch = new Scene[] {
            new MainMenu(),
            new PlayGame(),
            new GameOver()
        };
    }

    public void playGame() {
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameState = dispatch[gameState.ordinal()].update();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        dispatch[gameState.ordinal()].draw(g);
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            dispatch[gameState.ordinal()].keyPressed(e.getKeyCode());
        }
    }
}





// public class DrawPanel extends JPanel implements ActionListener{

//     private Snake snake;
//     private int size = 20;
//     private Color snakeColor = Color.BLUE;

//     private Apple apple;
//     private Color appleColor = Color.RED;

//     private Timer timer;
    
//     public DrawPanel() {
//         super();
//         addKeyListener(new TAdapter());
//         setFocusable(true);

//         snake = new Snake();
//         apple = new Apple();

//     }

//     @Override
//     public void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         // g.setColor(Color.BLUE);
//         // g.drawRect(100, 100, 100, 200);
//         // x, y, width, height

//         drawSnake(g);
//         drawApple(g);
//     }

//     public void drawSnake(Graphics g) {

//         //System.out.println("??");

//         g.setColor(snakeColor);
//         Coordinate head = snake.getHead();
//         g.fillRect(head.getX() * size, head.getY() * size, size, size);

//         //draw snake body
//     }

//     public void drawApple(Graphics g) {

//         g.setColor(appleColor);

//         Coordinate appleCoord = apple.getCoord();

//         g.fillRect(appleCoord.getX() * size, appleCoord.getY() * size, size, size);
//     }

//     public void playGame() {
//         timer = new Timer(100, this);
//         timer.start();
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         snake.move();

//         if (snake.getHead().getX() > 19 ||
//             snake.getHead().getY() > 19 ||
//             snake.getHead().getX() < 0 ||
//             snake.getHead().getY() < 0) {
//                 System.out.println("game over");
//             }

//         //check if overlap
//         if (snake.getHead().getX() == apple.getX() &&
//             snake.getHead().getY() == apple.getY()) {
//             apple.randApple();
//         }


//         //extend snake body
//         repaint();
//     }

//     private class TAdapter extends KeyAdapter {
//         @Override
//         public void keyPressed(KeyEvent e) {
//             int key = e.getKeyCode();
            
//             if (key == KeyEvent.VK_LEFT) {
//                 snake.moveLeft();
//             }
//             if (key == KeyEvent.VK_RIGHT) {
//                 snake.moveRight();
//             }
//             if (key == KeyEvent.VK_UP) {
//                 snake.moveUp();
//             }
//             if (key == KeyEvent.VK_DOWN) {
//                 snake.moveDown();
//             }
//         }
//     }
// }

//django

//array of coordinates, adn darw an array of rectangles

//maps == dictionaries
//unions? able to use more than 1 class/pirimitive?