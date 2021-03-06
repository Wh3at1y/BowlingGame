/**
 * 
 * 	This Class is the Main Menu of the Game. It contains New Game, Options,
 *  and Exit Game. This Class is the first thing you see when you start the Game.
 * 
 **/
package game.panels;

import game.view.AllViewsPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MainMenuView extends JPanel
{
	private AllViewsPanel allViewsPanel;
	private SpringLayout baseLayout;
	private JLabel startLabel;
	private JLabel optionsLabel;
	private JLabel exitLabel;
	private Font labelFont;

	public MainMenuView(AllViewsPanel allViewsPanel) // The Formatting of the Main Menu
	{
		this.allViewsPanel = allViewsPanel;
				
		baseLayout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
				
		startLabel = new JLabel("New Game");
		optionsLabel = new JLabel("Options");
		exitLabel = new JLabel("Quit Game");

		buildPanel();
		buildPlacements();
		buildListeners(this.startLabel);
		buildListeners(this.optionsLabel);
		buildListeners(this.exitLabel);
	}

	private void buildPanel() // Adding each Button into the GUI
	{
		this.setOpaque(false);
		this.setLayout(baseLayout);
		this.add(this.startLabel);
		this.add(this.optionsLabel);
		this.add(this.exitLabel);
	}

	private void buildListeners(JLabel button) // The actions that are performed when a selection is made on the main Menu
	{
		button.setFont(this.labelFont);	button.setForeground(Color.BLACK);
				
		button.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent arg0)
			{
				allViewsPanel.playButtonClick();	
						
				if(button == startLabel)
				{	allViewsPanel.openAmountOfPlayersView();		}
				if(button == optionsLabel)
				{	allViewsPanel.openOptionsView();		}
				if(button == exitLabel)
					System.exit(0);
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e)
			{	
				button.setForeground(Color.WHITE);
				allViewsPanel.playButtonHovor();	
			}
					
			public void mouseExited(MouseEvent e)
			{	button.setForeground(Color.BLACK);	}
					
			public void mouseReleased(MouseEvent e){}
		});
	}
		
	private void buildPlacements() // The layout of the Main Menu
	{
		baseLayout.putConstraint(SpringLayout.NORTH, startLabel, 620, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, startLabel, -20, SpringLayout.WEST, optionsLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, optionsLabel, 720, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, optionsLabel, 898, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, exitLabel, 820, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, exitLabel, -17, SpringLayout.WEST, optionsLabel);
	}

	public JLabel getStartLabel() // Getter for the New Game Button
	{	return startLabel;		}

	public JLabel getOptionsLabel() // Getter for the Options Button
	{	return optionsLabel;		}

	public JLabel getExitLabel() // Getter for the Exit Button
	{	return exitLabel;	}
		
}