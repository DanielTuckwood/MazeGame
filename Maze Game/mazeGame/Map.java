package mazeGame;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	private Scanner map;
	private String Map[] = new String[25];
	private Image path, finish, wall, teleporter, gold;
	
	public Map() {
		//gets all images for the different objects on screen
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\path.png");
		path = img.getImage();
		img = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\wall.png");
		wall = img.getImage();
		img = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\finish.png");
		finish = img.getImage();
		img = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\teleporter.png");
		teleporter = img.getImage();
		img = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\gold.png");
		gold = img.getImage();
		
		//Open, read and close the map text file
		openFile();
		readFile();
		closeFile();
	}
	
	//returns all the images
	public Image getPath() {
		return path;
	}
	
	public Image getWall() {
		return wall;
	}
	
	public Image getFinish () {
		return finish;
	}
	
	public Image getGold () {
		return gold;
	}
	
	public Image getTeleporter () {
		return teleporter;
	}
	
	public String getMap(int x, int y) {
		//gets and returns the character in the text field that the user is on.
		String index = Map[y].substring(x, x + 1);
		return index;
	}
	
	//Map text file is opened and read, exceptions are caught if there is a spontaneous error. 
	public void openFile() {
		try {
			map = new Scanner(new File("C:\\Users\\Admin\\eclipse-workspace\\Maze Game\\Map.txt"));
			while (map.hasNext()) {
				String i = map.next();
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println("Error loading map, Details: " + e);
			System.exit(0);
		}
	}
	
	//loops throughout the map text file and assigns the current text character to the variable.
	public void readFile() {
		while (map.hasNext()) {
			for (int i = 0; i < 20; i++) {
				Map[i] = map.next();
			}
		}
	}
	
	//map file closes
	public void closeFile() {
		map.close();	
	}
}
