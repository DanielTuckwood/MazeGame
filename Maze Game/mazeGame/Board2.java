package mazeGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board2 extends JPanel implements ActionListener{
	//Room 1 variables
	private Timer timer1;
	private Map map;
	private Player player;
	private boolean finished = false;
	private int call = 0;
	private boolean gold_found_1 = false;
	private boolean gold_found_2 = false;
	private boolean gold_found_3 = false;
	
	public Board2() {
		//focuses on the window so the room becomes interactive
				requestFocus();
				//Initialise the map and player class
				map = new Map();
				player = new Player();
				timer1 = new Timer(40, this);
				timer1.start();
				addKeyListener(new Al());
	}
	
	public void actionPerformed(ActionEvent e) {
		//when the player's position = teleporter position, finished = true
		if (map.getMap(player.getSquareX(), player.getSquareY()).equals("t")) {
			finished = true;
		}
		//the screen refreshes if the player has not reached the end (t).
		setBackground(Color.black);
		requestFocus();
		revalidate();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		/* The if statement checks that finished =  not true. If it is not true it will do a loop for the
		 * height and width of the map to check which letter is in that field. e = finish, p = path, x = wall
		 * t = teleporter. In addition to that it checks if the user has found all 3 gold coins in the room.
		 * If the user has found all 3 gold coins the floor turns white and their wealth is displayed. If not
		 * the locations of the remaining gold coins are revealed.
		 */
		
		if(!finished) {
				for (int y = 0; y < 20; y++) {
						for(int x = 0; x < 20; x++) {
							if(map.getMap(x, y).equals("e")) {
								g.drawImage(map.getFinish(), x * 32, y * 32, null);
							}
							if (map.getMap(x, y).equals("f")) {
								g.drawImage(map.getPath(), x * 32, y * 32, null);
							}
							if (map.getMap(x, y).equals("x")) {
								g.drawImage(map.getWall(), x * 32, y * 32, null);
							}
							if (map.getMap(x, y).equals("p")) {
								g.drawImage(map.getTeleporter(), x * 32, y * 32, null);
							}
							if (gold_found_1) {
								g.drawImage(map.getPath(), 10 * 32, 13 * 32, null);
							}
							if (!gold_found_1) {
								g.drawImage(map.getGold(), 10 * 32, 13 * 32, null);
							}
							if (gold_found_2) {
								g.drawImage(map.getPath(), 8 * 32, 1 * 32, null);
							}
							if (!gold_found_2) {
								g.drawImage(map.getGold(), 8 * 32, 1 * 32, null);
							}
							if (gold_found_3) {
								g.drawImage(map.getPath(), 15 * 32, 18 * 32, null);
							}
							if (!gold_found_3) {
								g.drawImage(map.getGold(), 15 * 32, 18 * 32, null);
							}
						}
					}
				
				String value = Integer.toString(Maze.wealth);
				g.setColor(Color.white);
				g.drawString("Wealth: " + value, 15, 25);
				g.drawImage(player.getPlayer(), player.getSquareX() * 32, player.getSquareY() * 32, null);
				}
				if (finished == true & call != 1) {
					won();
					call +=1;
				}
		}
	private class Al extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyChoice = e.getKeyCode();
			
			/*Every key on the keyboard corresponds to a keycode. The 4 keys to navigate are the 4 arrows.
			 * When the user presses one of these keys it will move the user in the corresponding direction.
			 * If the user moves into a square that is a wall, the player will not move. If the player moves
			 * to a square that contains a gold coin then the player's wealth increase.
			 */
			
			
			if (keyChoice == KeyEvent.VK_UP) {
				if (!map.getMap(player.getSquareX(), player.getSquareY() - 1).equals("x")) {
				}
			}
			if (keyChoice == KeyEvent.VK_DOWN) {
				if (!map.getMap(player.getSquareX(), player.getSquareY() + 1).equals("x")) {
				}
			}
			if (keyChoice == KeyEvent.VK_LEFT) {
				if (!map.getMap(player.getSquareX() - 1, player.getSquareY()).equals("x")) {
				}
			}
			if (keyChoice == KeyEvent.VK_RIGHT) {
				if (!map.getMap(player.getSquareX() + 1, player.getSquareY()).equals("x")) {
				}
			}
			if (player.getSquareX() == 5 & player.getSquareY() == 2 & gold_found_1 != true) {
				gold_found_1 = true;
				Maze.wealth += 1;
			}
			if (player.getSquareX() == 4 & player.getSquareY() == 17 & gold_found_1 != true) {
				gold_found_1 = true;
				Maze.wealth += 1;
			}
			if (player.getSquareX() == 19 & player.getSquareY() == 2 & gold_found_1 != true) {
				gold_found_1 = true;
				Maze.wealth += 1;
			}
		}
		
		public void keyReleased(KeyEvent e ) {
			
		}
		public void keyTyped(KeyEvent e) {

		}
	}
	
	private void won() {
		//Board 2 call
		Maze.completion();
	}
}