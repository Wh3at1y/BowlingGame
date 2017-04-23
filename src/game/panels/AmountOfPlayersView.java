package game.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.GameController;
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

	public AmountOfPlayersView(AllViewsPanel allViewsPanel)
	{
		this.allViewsPanel = allViewsPanel;
		
		baseLayout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		twoplayerButton = new JLabel("2 Players");		
		threeplayerButton = new JLabel("3 Players");
		fourplayerButton = new JLabel("4 Players");
		backLabel = new JLabel("Back");
		baseLayout.putConstraint(SpringLayout.WEST, backLabel, 35, SpringLayout.WEST, twoplayerButton);

		buildPanel();
		buildPlacements();
		buildListeners(this.twoplayerButton);
		buildListeners(this.threeplayerButton);
		buildListeners(this.fourplayerButton);
		buildListeners(this.backLabel);
		
	}
	
	private void buildPanel()
	{
		this.setVisible(false);
		this.setOpaque(false);
		
		setLayout(baseLayout);
		
		add(this.twoplayerButton);
		add(this.threeplayerButton);
		add(this.fourplayerButton);
		add(this.backLabel);
	}

	private void buildListeners(JLabel button)
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
		
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, twoplayerButton, 620, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, twoplayerButton, 892, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, threeplayerButton, 720, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, threeplayerButton, 0, SpringLayout.WEST, twoplayerButton);
		baseLayout.putConstraint(SpringLayout.NORTH, fourplayerButton, 820, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, fourplayerButton, 0, SpringLayout.WEST, twoplayerButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, fourplayerButton, -212, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 920, SpringLayout.NORTH, this);
	}
	
}
