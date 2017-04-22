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
	private JPanel player1;
	private JPanel player2;
	private JPanel player3;
	private JPanel player4;
	private JLabel backLabel;
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
		layout.putConstraint(SpringLayout.NORTH, username1, 620, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username1, 850, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username1, -850, SpringLayout.EAST, this);
		player1 = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, player1, 620, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, player1, 850, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, player1, -850, SpringLayout.EAST, this);
		username2 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username2, 50, SpringLayout.SOUTH, username1);
		layout.putConstraint(SpringLayout.WEST, username2, 0, SpringLayout.WEST, username1);
		player2 = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, player2, 50, SpringLayout.SOUTH, username1);
		layout.putConstraint(SpringLayout.WEST, player2, 0, SpringLayout.WEST, username1);
		username3 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username3, 50, SpringLayout.SOUTH, username2);
		layout.putConstraint(SpringLayout.WEST, username3, 0, SpringLayout.WEST, username1);
		player3 = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, player3, 50, SpringLayout.SOUTH, username2);
		layout.putConstraint(SpringLayout.WEST, player3, 0, SpringLayout.WEST, username1);
		username4 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username4, 50, SpringLayout.SOUTH, username3);
		layout.putConstraint(SpringLayout.EAST, username4, 0, SpringLayout.EAST, username1);
		player4 = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, player4, 50, SpringLayout.SOUTH, username3);
		layout.putConstraint(SpringLayout.EAST, player4, 0, SpringLayout.EAST, username1);
		backLabel = new JLabel("Back");
		layout.putConstraint(SpringLayout.NORTH, backLabel, 920, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, backLabel, 75, SpringLayout.WEST, username4);
		
		buildPanel();
		buildPlacements();
		displayTextFields();
		buildListeners(this.backLabel);
		
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
		add(this.backLabel);
		add(this.player1);
		add(this.player2);
		add(this.player3);
		add(this.player4);
	}
	
	private void displayTextFields()
	{
		if(amountofPlayers == 2)
		{
			System.out.println("IM DEB");
			username1.setVisible(true);
			username2.setVisible(true);
			username3.setVisible(false);
			username4.setVisible(false);
		}
		
		else if(amountofPlayers == 3)
		{
			username1.setVisible(true);
			username2.setVisible(true);
			username3.setVisible(true);
			username4.setVisible(false);
		}
		
		else if(amountofPlayers == 4)
		{
			System.out.println("IM DEB UGGdsf");
			username1.setVisible(true);
			username2.setVisible(true);
			username3.setVisible(true);
			username4.setVisible(true);
		}
	}
	
	public void buildPlacements()
	{
		layout.putConstraint(SpringLayout.EAST, username2, 0, SpringLayout.EAST, username1);
		layout.putConstraint(SpringLayout.EAST, username3, 0, SpringLayout.EAST, username1);
		layout.putConstraint(SpringLayout.WEST, username4, 0, SpringLayout.WEST, username1);
	}
}
