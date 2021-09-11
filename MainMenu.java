import java.awt.Graphics;


public class MainMenu implements Scene {
    
    public MainMenu() {
        System.out.println("Main menu");
    }

    public ActiveState update() {
        return ActiveState.MAIN_MENU;

    }

    public void draw(Graphics g) {

    }

    public void keyPressed(int key) {

    }
}

//body
//head = x,y
//body goes to previous head coordinate
//ways of data structure - linked list (moving each one up), 