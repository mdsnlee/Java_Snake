import java.awt.Graphics;


public class GameOver implements Scene {

    public GameOver() {
        System.out.println("Game over");
    }

    public ActiveState update() {
        return ActiveState.GAME_OVER;

    }

    public void draw(Graphics g) {

    }

    public void keyPressed(int key) {

    }
}