
import javax.swing.*;
import javax.swing.SwingUtilities;

public class SnakeGame extends JFrame {
	
	private DrawPanel mainPanel;

	public SnakeGame() {
		//setup
		setTitle("Snake");
        setSize(400, 429);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

		initializeGame();
		mainPanel.playGame();
	}

	private void initializeGame() {
        mainPanel = new DrawPanel();
        add(mainPanel);
    }

	public static void main(String[] args) {
	    //Sync Threads
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            //new SnakeGame();
				SnakeGame game = new SnakeGame();
	        }
	    });
	}
}