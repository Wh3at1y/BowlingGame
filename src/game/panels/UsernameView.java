/*
 * UserName View class
 * This class provides the panel in which we collect players user names.
 */
package game.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import game.view.AllViewsPanel;

public class UsernameView extends JPanel
{
	//Declaration section for our variables in this class.
	private AllViewsPanel allViewsPanel;
	private SpringLayout baselayout;
	private JTextField username1;
	private JTextField username2;
	private JTextField username3;
	private JTextField username4;
	private JLabel player1;
	private JLabel player2;
	private JLabel player3;
	private JLabel player4;
	private JLabel backLabel;
	private JLabel startgameButton;
	private Font labelFont;
	private int amountofPlayers;
	
	//Constructor initializes new components going into the panel.
	public UsernameView(AllViewsPanel allViewsPanel)
	{	
		this.allViewsPanel = allViewsPanel;
		
		baselayout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		username1 = new JTextField();
		username1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		player1 = new JLabel("Player 1:");
		player1.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		
		username2 = new JTextField();
		username2.setFont(new Font("Sitka Text", Font.BOLD, 15));
		player2 = new JLabel("Player 2:");
		player2.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		
		username3 = new JTextField();
		username3.setFont(new Font("Sitka Text", Font.BOLD, 15));	
		player3 = new JLabel("Player 3:");
		player3.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		
		username4 = new JTextField();
		username4.setFont(new Font("Sitka Text", Font.BOLD, 15));
		player4 = new JLabel("Player 4:");
		player4.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		
		backLabel = new JLabel("Back");
		startgameButton = new JLabel("Start");
		
		buildPanel();
		buildPlacements();
		displayTextFields();
		buildListeners(this.backLabel);
		buildListeners(this.startgameButton);		
	}
	
	//Method to add components to the panel.
	private void buildPanel()
	{
		this.setLayout(this.baselayout);
		this.setVisible(false);
		this.setOpaque(false);
		this.add(this.username1);
		this.add(this.username2);
		this.add(this.username3);
		this.add(this.username4);
		this.add(this.player1);
		this.add(this.player2);
		this.add(this.player3);
		this.add(this.player4);
		this.add(this.backLabel);
		this.add(this.startgameButton);
	}
	//Sets action listeners on the buttons on this panel.
	private void buildListeners(JLabel button)
	{
		//Listens for the Enter key on username 2 (THANKS JO)
		username2.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent enterButton)
				{
					allViewsPanel.setBackgroundStatus(true);
					allViewsPanel.getLogo().setVisible(false);
					allViewsPanel.getBowlingView().updatePlayerUsernames();
					allViewsPanel.openBowlingGameView();	
				}
				});
		
	
				
		button.setFont(this.labelFont);	button.setForeground(Color.BLACK);
		
		button.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent arg0)
			{
				allViewsPanel.playButtonClick();	
				
				//This statement is for changing panels and clearing fields.
				if(button == backLabel)
				{
					allViewsPanel.closeUserNameView();
					username1.setText("");
					username2.setText("");
					username3.setText("");
					username4.setText("");
				}
				//This statement is for changing to a new panel and starting the actual game.
				if(button == startgameButton)
				{
					allViewsPanel.setBackgroundStatus(true);
					allViewsPanel.getLogo().setVisible(false);
					allViewsPanel.getBowlingView().updatePlayerUsernames();
					allViewsPanel.openBowlingGameView();	
				}
			}
			public void mouseClicked(MouseEvent e){}
			//This event changes the button color when hovered over it to white.
			public void mouseEntered(MouseEvent e)
			{	
				button.setForeground(Color.WHITE);
				allViewsPanel.playButtonHovor();	
			}
			//This event changes the button color to black again when the mouse exits the button area.
			public void mouseExited(MouseEvent e)
			{	button.setForeground(Color.BLACK);	}
			
			public void mouseReleased(MouseEvent e){}
		});
	}
	//Method calls the method below to set text fields based on how many players are selected to play.
	public void setAmountOfPlayers(int amountofPlayers)
	{
		this.amountofPlayers = amountofPlayers;
		displayTextFields();
	}
	//This method determines how many player text fields need to be displayed for the amount of players.
	private void displayTextFields()
	{
		if(amountofPlayers == 2)
		{
			username1.setVisible(true);
			username2.setVisible(true);
			username3.setVisible(false);
			username4.setVisible(false);
			player1.setVisible(true);
			player2.setVisible(true);
			player3.setVisible(false);
			player4.setVisible(false);
		}
		
		else if(amountofPlayers == 3)
		{
			username1.setVisible(true);
			username2.setVisible(true);
			username3.setVisible(true);
			username4.setVisible(false);
			player1.setVisible(true);
			player2.setVisible(true);
			player3.setVisible(true);
			player4.setVisible(false);
		}
		
		else if(amountofPlayers == 4)
		{
			username1.setVisible(true);
			username2.setVisible(true);
			username3.setVisible(true);
			username4.setVisible(true);
			player1.setVisible(true);
			player2.setVisible(true);
			player3.setVisible(true);
			player4.setVisible(true);
		}
	}
	//This is constraints for components in our Panel.
	public void buildPlacements()
	{
		baselayout.putConstraint(SpringLayout.NORTH, username1, 615, SpringLayout.NORTH, this);
		baselayout.putConstraint(SpringLayout.WEST, username1, 920, SpringLayout.WEST, this);
		baselayout.putConstraint(SpringLayout.EAST, username1, -855, SpringLayout.EAST, this);
		baselayout.putConstraint(SpringLayout.NORTH, player1, 620, SpringLayout.NORTH, this);
		baselayout.putConstraint(SpringLayout.WEST, player1, 850, SpringLayout.WEST, this);
		baselayout.putConstraint(SpringLayout.EAST, player1, -850, SpringLayout.EAST, this);
		baselayout.putConstraint(SpringLayout.NORTH, username2, 40, SpringLayout.SOUTH, username1);
		baselayout.putConstraint(SpringLayout.EAST, username2, 0, SpringLayout.EAST, username1);
		baselayout.putConstraint(SpringLayout.WEST, username2, 0, SpringLayout.WEST, username1);
		baselayout.putConstraint(SpringLayout.NORTH, player2, 50, SpringLayout.SOUTH, player1);
		baselayout.putConstraint(SpringLayout.WEST, player2, 0, SpringLayout.WEST, player1);
		baselayout.putConstraint(SpringLayout.EAST, username3, 0, SpringLayout.EAST, username1);
		baselayout.putConstraint(SpringLayout.NORTH, username3, 45, SpringLayout.SOUTH, username2);
		baselayout.putConstraint(SpringLayout.WEST, username3, 0, SpringLayout.WEST, username1);
		baselayout.putConstraint(SpringLayout.NORTH, player3, 50, SpringLayout.SOUTH, player2);
		baselayout.putConstraint(SpringLayout.WEST, player3, 0, SpringLayout.WEST, player2);
		baselayout.putConstraint(SpringLayout.WEST, username4, 0, SpringLayout.WEST, username1);
		baselayout.putConstraint(SpringLayout.NORTH, username4, 45, SpringLayout.SOUTH, username3);
		baselayout.putConstraint(SpringLayout.EAST, username4, 0, SpringLayout.EAST, username1);
		baselayout.putConstraint(SpringLayout.NORTH, player4, 50, SpringLayout.SOUTH, player3);
		baselayout.putConstraint(SpringLayout.WEST, player4, 0, SpringLayout.WEST, player3);
		baselayout.putConstraint(SpringLayout.NORTH, backLabel, 920, SpringLayout.NORTH, this);
		baselayout.putConstraint(SpringLayout.WEST, backLabel, -140, SpringLayout.WEST, username4);
		baselayout.putConstraint(SpringLayout.NORTH, startgameButton, 920, SpringLayout.NORTH, this);
		baselayout.putConstraint(SpringLayout.WEST, startgameButton, 140, SpringLayout.WEST, username4);
	}
	//These getters get the user names users enter for players 1-4.
	public JTextField getUsername1()
	{	return this.username1;	}
	
	public JTextField getUsername2()
	{	return this.username2;	}
	
	public JTextField getUsername3()
	{	return this.username3;	}
	
	public JTextField getUsername4()
	{	return this.username4;	}
	
}