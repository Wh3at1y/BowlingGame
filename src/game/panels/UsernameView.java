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
		username2 = new JTextField();
		username3 = new JTextField();
		username4 = new JTextField();
		backLabel = new JLabel("Back");
		
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
		layout.putConstraint(SpringLayout.NORTH, username1, 68, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, username1, 47, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username1, -257, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, username2, 44, SpringLayout.SOUTH, username1);
		layout.putConstraint(SpringLayout.WEST, username2, 47, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username2, 0, SpringLayout.EAST, username1);
		layout.putConstraint(SpringLayout.NORTH, username3, 72, SpringLayout.SOUTH, username2);
		layout.putConstraint(SpringLayout.WEST, username3, 47, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, username3, 0, SpringLayout.EAST, username1);
		layout.putConstraint(SpringLayout.NORTH, username4, 99, SpringLayout.SOUTH, username3);
		layout.putConstraint(SpringLayout.WEST, username4, 0, SpringLayout.WEST, username1);
		layout.putConstraint(SpringLayout.EAST, username4, -257, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, backLabel, 200, SpringLayout.NORTH, this);
	}
}
