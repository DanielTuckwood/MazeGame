package mazeGame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	// x,y & player image coordinate variables
	private int SquareX;
	private int SquareY;
	private Image player;
	
	public Player() {
		//player image defined to a variable
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\playerImage.png");
		player = img.getImage();
		//player positioned at 1,1 to start
		SquareX = 1;
		SquareY = 1;
	}
	
	//gets the player image
		public Image getPlayer() {
			return player;
		}
		
	// get x,y coordinate of the player
		public int getSquareX() {
			return SquareX;
		}
		public int getSquareY() {
			return SquareY;
		}
		
	//player x,y coordinates = new x,y coordinates
		public void move(int dx, int dy) {
			SquareX += dx;
			SquareY += dy;
		}
}
