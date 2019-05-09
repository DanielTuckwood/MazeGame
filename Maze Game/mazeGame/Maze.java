package mazeGame;

import javax.swing.JFrame;

import mazeGame.Board1;

public class Maze {
	//one frame per room
	public static JFrame room_1 = new JFrame();
	public static JFrame room_2 = new JFrame();
	public static JFrame finish = new JFrame();
	//wealth tracker
	public static int wealth = 0;
	
	public static void main(String[] args) {
		//Setting up the first room and calling the board method
		board();
	}

	public static void board() {
		//first room brought to the screen (board method)
		room_1.setTitle("Room 1");
		room_1.setSize(750, 750);
		room_1.setVisible(true);
		room_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		room_1.setLocationRelativeTo(null);
		room_1.add(new Board1());
	}
	
	public static void board2() {
		//first room removed and second room brought to the screen (board2 method)
		room_1.dispose();
		room_2.setTitle("Room 1");
		room_2.setSize(750, 750);
		room_2.setVisible(true);
		room_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		room_2.setLocationRelativeTo(null);
		room_2.add(new Board2());
	}
	
	public static void completion() {
		//second room removed and finish screen brought to the screen (completion method)
		room_2.dispose();
		finish.setTitle("You win!");
		finish.setSize(350, 350);
		finish.setVisible(true);
		finish.add(new finishScreen());
		finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finish.setLocationRelativeTo(null);
	}
}
