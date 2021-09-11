import java.awt.Graphics;

interface Scene {
    public ActiveState update();
    public void draw(Graphics g);
    public void keyPressed(int key);
}