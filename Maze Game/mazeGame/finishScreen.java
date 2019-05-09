package mazeGame;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class finishScreen extends Component implements ActionListener {
	private JButton button1;
	//finshScreen method
	public finishScreen() {
		//setLayout(null);
		requestFocus();
		revalidate();
		repaint();
		//button to exit the Maze Game
		button1 = new JButton("Quit");
		button1.setBounds(60, 80, 160, 60);
		button1.add(button1);
		button1.addActionListener((ActionListener) this);
	}
	
	public void paint(Graphics g) {
		//Shows player their total wealth throughout both rooms
		super.paint(g);
		g.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		setBackground(Color.white);
		String wealthValue = Integer.toString(Maze.wealth);
		g.drawString("Congratulations! You finished the maze", 40, 60);
		g.drawString("With a total wealth of: " + wealthValue, 30, 60);
	}
	
	public void actionPerformed(ActionEvent e) {
		//the game will close when the user clicks quit
		if(e.getSource() == button1)
			System.exit(0);
	}
}
