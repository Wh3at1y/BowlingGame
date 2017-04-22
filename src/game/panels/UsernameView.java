package game.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import game.controller.GameController;
import game.view.AllViewsPanel;

public class UsernameView extends JPanel
{
	private AllViewsPanel allViewsPanel;
	private SpringLayout layout;
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
	
	public UsernameView(AllViewsPanel allViewsPanel)
	{
		this.setVisible(false);
		this.setOpaque(false);
		
		this.allViewsPanel = allViewsPanel;
		
		layout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		username1 = new JTextField();
		username1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		layout.putConstraint(SpringLayout.NORTH, username1, 620, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username1, 920, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username1, -855, SpringLayout.EAST, this);
		player1 = new JLabel("Player 1:");
		player1.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		layout.putConstraint(SpringLayout.NORTH, player1, 620, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, player1, 850, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, player1, -850, SpringLayout.EAST, this);
		username2 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username2, 45, SpringLayout.SOUTH, username1);
		username2.setFont(new Font("Sitka Text", Font.BOLD, 15));
		layout.putConstraint(SpringLayout.WEST, username2, 0, SpringLayout.WEST, username1);
		player2 = new JLabel("Player 2:");
		player2.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		layout.putConstraint(SpringLayout.NORTH, player2, 50, SpringLayout.SOUTH, player1);
		layout.putConstraint(SpringLayout.WEST, player2, 0, SpringLayout.WEST, player1);
		username3 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username3, 45, SpringLayout.SOUTH, username2);
		username3.setFont(new Font("Sitka Text", Font.BOLD, 15));
		layout.putConstraint(SpringLayout.WEST, username3, 0, SpringLayout.WEST, username1);
		player3 = new JLabel("Player 3:");
		player3.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		layout.putConstraint(SpringLayout.NORTH, player3, 50, SpringLayout.SOUTH, player2);
		layout.putConstraint(SpringLayout.WEST, player3, 0, SpringLayout.WEST, player2);
		username4 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username4, 45, SpringLayout.SOUTH, username3);
		username4.setFont(new Font("Sitka Text", Font.BOLD, 15));
		layout.putConstraint(SpringLayout.EAST, username4, 0, SpringLayout.EAST, username1);
		player4 = new JLabel("Player 4:");
		player4.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		layout.putConstraint(SpringLayout.NORTH, player4, 50, SpringLayout.SOUTH, player3);
		layout.putConstraint(SpringLayout.WEST, player4, 0, SpringLayout.WEST, player3);
		backLabel = new JLabel("Back");
		layout.putConstraint(SpringLayout.NORTH, backLabel, 920, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, backLabel, -140, SpringLayout.WEST, username4);
		startgameButton = new JLabel("Start");
		layout.putConstraint(SpringLayout.NORTH, startgameButton, 920, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, startgameButton, 140, SpringLayout.WEST, username4);
		
		buildPanel();
		buildPlacements();
		displayTextFields();
		buildListeners(this.backLabel);
		buildListeners(this.startgameButton);
		
	}
	
	private void buildListeners(JLabel button)
	{
		button.setFont(this.labelFont);	button.setForeground(Color.BLACK);
		
		button.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent arg0)
			{
					if(button == backLabel)
					{
						allViewsPanel.closeUserNameView();
						username1.setText("");
						username2.setText("");
						username3.setText("");
						username4.setText("");
					}
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e)
			{	button.setForeground(Color.WHITE);	}
			
			public void mouseExited(MouseEvent e)
			{	button.setForeground(Color.BLACK);	}
			
			public void mouseReleased(MouseEvent e){}
		}
				);
	}

	public void setAmountOfPlayers(int amountofPlayers)
	{
		this.amountofPlayers = amountofPlayers;
		displayTextFields();
		System.out.println(this.amountofPlayers);
	}

	private void buildPanel()
	{
		setLayout(this.layout);
		
		add(this.username1);
		add(this.username2);
		add(this.username3);
		add(this.username4);
		add(this.player1);
		add(this.player2);
		add(this.player3);
		add(this.player4);
		add(this.backLabel);
		add(this.startgameButton);
	}
	
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
	
	public void buildPlacements()
	{
		layout.putConstraint(SpringLayout.EAST, username2, 0, SpringLayout.EAST, username1);
		layout.putConstraint(SpringLayout.EAST, username3, 0, SpringLayout.EAST, username1);
		layout.putConstraint(SpringLayout.WEST, username4, 0, SpringLayout.WEST, username1);
	}
}
