package game.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.GameController;

public class AliasPanel extends JPanel
{
	private SpringLayout layout;
	private JButton twoplayerButton;
	private JButton threeplayerButton;
	private JButton fourplayerButton;
	private JButton startgameButton;

	public AliasPanel(GameController baseController)
	{
		this.setVisible(false);
		layout = new SpringLayout();
		
		twoplayerButton = new JButton("2 Players");
		layout.putConstraint(SpringLayout.NORTH, twoplayerButton, 24, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, twoplayerButton, 10, SpringLayout.WEST, this);
		threeplayerButton = new JButton("3 Players");
		layout.putConstraint(SpringLayout.NORTH, threeplayerButton, 0, SpringLayout.NORTH, twoplayerButton);
		layout.putConstraint(SpringLayout.WEST, threeplayerButton, 6, SpringLayout.EAST, twoplayerButton);
		fourplayerButton = new JButton("4 Players");
		layout.putConstraint(SpringLayout.NORTH, fourplayerButton, 0, SpringLayout.NORTH, twoplayerButton);
		layout.putConstraint(SpringLayout.WEST, fourplayerButton, -183, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, fourplayerButton, 64, SpringLayout.NORTH, twoplayerButton);
		layout.putConstraint(SpringLayout.EAST, fourplayerButton, -10, SpringLayout.EAST, this);
		startgameButton = new JButton("Start");
		layout.putConstraint(SpringLayout.NORTH, startgameButton, 138, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, startgameButton, 513, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, startgameButton, 202, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, startgameButton, 686, SpringLayout.WEST, this);
		
		buildPanel();
		buildListeners();
		buildPlacements();	
	}
	
	private void buildPanel()
	{
		//this.setOpaque(true);
		setLayout(this.layout);
		
		add(this.twoplayerButton);
		add(this.threeplayerButton);
		add(this.fourplayerButton);
		add(this.startgameButton);
	}

	private void buildListeners()
	{
		this.twoplayerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				
			}
		});
		
		this.threeplayerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				
			}
		});
		
		this.fourplayerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				
			}
		});
		
		this.startgameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent clicked)
			{
				
			}
		});
	}
		
	
	private void buildPlacements()
	{
		
	}
	
}
