package game.menus;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import game.controller.GameController;

public class UsernamePanel extends JPanel
{
	private SpringLayout layout;
	private JTextField username1;
	private JTextField username2;
	private JTextField username3;
	private JTextField username4;
	private int amountofPlayers;
	
	public UsernamePanel(GameController baseController)
	{
		//this.setVisible(false);
		this.setOpaque(false);
		
		layout = new SpringLayout();
		
		username1 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username1, 68, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username1, 47, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username1, -257, SpringLayout.EAST, this);
		username2 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username2, 44, SpringLayout.SOUTH, username1);
		layout.putConstraint(SpringLayout.WEST, username2, 47, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username2, 0, SpringLayout.EAST, username1);
		username3 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username3, 72, SpringLayout.SOUTH, username2);
		layout.putConstraint(SpringLayout.WEST, username3, 47, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username3, 0, SpringLayout.EAST, username1);
		username4 = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, username4, 99, SpringLayout.SOUTH, username3);
		layout.putConstraint(SpringLayout.WEST, username4, 0, SpringLayout.WEST, username1);
		layout.putConstraint(SpringLayout.EAST, username4, -257, SpringLayout.EAST, this);
		
		displayTextFields();
		buildPanel();
		
	}
	
	public void getAmountOfPlayers(int amountofPlayers)
	{
		this.amountofPlayers = amountofPlayers;
		System.out.println(this.amountofPlayers);
	}

	private void buildPanel()
	{
		setLayout(this.layout);
		
		add(this.username1);
		add(this.username2);
		add(this.username3);
		add(this.username4);
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

}
