/**
 * 
 *  This Class contains all the information for when a New Game is
 *  selected. It will take you to a new Panel where you can choose
 *  how many players are going to play the game.
 * 
 **/
package game.panels;

import game.view.AllViewsPanel;
import javax.swing.*;

public class NewGameView extends JPanel
{
	private SpringLayout baseLayout;
	private JLabel twoplayersLabel;
	private JLabel threeplayersLabel;
	private JLabel fourplayersLabel;
	private JLabel backLabel;

	public NewGameView(AllViewsPanel allViewsPanel) // Formatting of the New Game
	{
		baseLayout = new SpringLayout();
				
		twoplayersLabel = new JLabel("2 Players ");
		threeplayersLabel = new JLabel("3 Players ");
		fourplayersLabel = new JLabel("4 Players ");
		backLabel = new JLabel("Back");
				
		buildPanel();
		buildWindow();
	}

	private void buildPanel() // Adding each Button into the GUI
	{
		this.setVisible(false);
		this.setOpaque(false);
		this.setLayout(baseLayout);
		this.add(this.backLabel);
		this.add(this.twoplayersLabel);
		this.add(this.threeplayersLabel);
		this.add(this.fourplayersLabel);
	}

	private void buildWindow() // Layout of the New Game screen
	{
		baseLayout.putConstraint(SpringLayout.NORTH, twoplayersLabel, 620, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, twoplayersLabel, 885, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, threeplayersLabel, 720, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, threeplayersLabel, 0, SpringLayout.WEST, twoplayersLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, fourplayersLabel, 820, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, fourplayersLabel, 0, SpringLayout.WEST, threeplayersLabel);				
		baseLayout.putConstraint(SpringLayout.EAST, backLabel, -80, SpringLayout.WEST, fourplayersLabel);
	}

	public JLabel getBackLabel() // Getter for the Back Label
	{	return backLabel;	}

}