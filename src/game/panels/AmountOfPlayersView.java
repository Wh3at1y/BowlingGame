/**
 * 
 *  This Class contains all the information needed when a the 
 *  amount of players are selected from the New Game screen. Based
 *  on what is chosen here will affect how many Usernames can be 
 *  entered into the game to a maximum of 4 players.
 * 
 **/
package game.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import game.view.AllViewsPanel;

public class AmountOfPlayersView extends JPanel
{
	private AllViewsPanel allViewsPanel;	
	private SpringLayout baseLayout;
	private JLabel twoplayerButton;
	private JLabel threeplayerButton;
	private JLabel fourplayerButton;
	private JLabel backLabel;	
	private Font labelFont;

	public AmountOfPlayersView(AllViewsPanel allViewsPanel) // The Format of the New Game menu
	{
		this.allViewsPanel = allViewsPanel;
		
		baseLayout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		twoplayerButton = new JLabel("2 Players");		
		threeplayerButton = new JLabel("3 Players");
		fourplayerButton = new JLabel("4 Players");
		backLabel = new JLabel("Back");

		buildPanel();
		buildPlacements();
		buildListeners(this.twoplayerButton);
		buildListeners(this.threeplayerButton);
		buildListeners(this.fourplayerButton);
		buildListeners(this.backLabel);	
	}
	
	private void buildPanel() // Adding each Button into the GUI
	{
		this.setVisible(false);
		this.setOpaque(false);
		this.setLayout(baseLayout);
		this.add(this.twoplayerButton);
		this.add(this.threeplayerButton);
		this.add(this.fourplayerButton);
		this.add(this.backLabel);
	}

	private void buildListeners(JLabel button) // The actions that are performed when the amount of players are chosen
	{
		button.setFont(this.labelFont);
		button.setForeground(Color.BLACK);
		button.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent arg0)
			{
				allViewsPanel.playButtonClick();	
				
				if(button == twoplayerButton)
				{	
					allViewsPanel.getUsernameView().setAmountOfPlayers(2);
					allViewsPanel.openUserNameView();
				}
				if(button == threeplayerButton)
				{
					allViewsPanel.getUsernameView().setAmountOfPlayers(3);
					allViewsPanel.openUserNameView();
				}
				if(button == fourplayerButton)
				{
					allViewsPanel.getUsernameView().setAmountOfPlayers(4);
					allViewsPanel.openUserNameView();
				}
				if(button == backLabel)
				{	allViewsPanel.closeAmountofPlayersView();	}
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e)
			{	button.setForeground(Color.WHITE);
				allViewsPanel.playButtonHovor();	}

		public void mouseExited(MouseEvent e)
			{	button.setForeground(Color.BLACK);	}
			public void mouseReleased(MouseEvent e){}
		});
	}
		
	private void buildPlacements() // All of the placements of the text fields for the New Game menu
	{
		baseLayout.putConstraint(SpringLayout.NORTH, twoplayerButton, 620, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, twoplayerButton, 892, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, threeplayerButton, 720, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, threeplayerButton, 0, SpringLayout.WEST, twoplayerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, fourplayerButton, 820, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, fourplayerButton, 0, SpringLayout.WEST, twoplayerButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, fourplayerButton, -212, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 920, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, backLabel, 35, SpringLayout.WEST, twoplayerButton);
	}
	
}