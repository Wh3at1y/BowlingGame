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
	
	private SpringLayout layout;
	private JLabel twoplayerButton;
	private JLabel threeplayerButton;
	private JLabel fourplayerButton;
	private JLabel startgameButton;
	private JLabel backLabel;
	
	private Font labelFont;

	public AmountOfPlayersView(AllViewsPanel allViewsPanel)
	{
		this.allViewsPanel = allViewsPanel;
		layout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		twoplayerButton = new JLabel("2 Players");
		layout.putConstraint(SpringLayout.NORTH, twoplayerButton, 620, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, twoplayerButton, 892, SpringLayout.WEST, this);
		threeplayerButton = new JLabel("3 Players");
		layout.putConstraint(SpringLayout.NORTH, threeplayerButton, 720, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, threeplayerButton, 0, SpringLayout.WEST, twoplayerButton);
		
		fourplayerButton = new JLabel("4 Players");
		layout.putConstraint(SpringLayout.NORTH, fourplayerButton, 820, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fourplayerButton, 0, SpringLayout.WEST, twoplayerButton);
		layout.putConstraint(SpringLayout.SOUTH, fourplayerButton, -212, SpringLayout.SOUTH, this);
		startgameButton = new JLabel("Start");
		layout.putConstraint(SpringLayout.NORTH, startgameButton, 920, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, startgameButton, 202, SpringLayout.WEST, twoplayerButton);
		backLabel = new JLabel("Back");
		layout.putConstraint(SpringLayout.NORTH, backLabel, 920, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, backLabel, -140, SpringLayout.WEST, twoplayerButton);
		
		buildPanel();
		buildPlacements();
		buildListeners(twoplayerButton);
		buildListeners(threeplayerButton);
		buildListeners(fourplayerButton);
		buildListeners(this.backLabel);
		buildListeners(this.startgameButton);
	}
	
	private void buildPanel()
	{
		this.setVisible(false);
		this.setOpaque(false);
		
		setLayout(layout);
		
		add(this.twoplayerButton);
		add(this.threeplayerButton);
		add(this.fourplayerButton);
		add(this.startgameButton);
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
				if(button == backLabel)
				{
					allViewsPanel.closeAmountofPlayersView();
				}
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e)
			{
				//if (playSound.getButtonClicks())
					//playSound.buttonHover();
				button.setForeground(Color.WHITE);
			}

		public void mouseExited(MouseEvent e)
			{
				button.setForeground(Color.BLACK);
			}
			public void mouseReleased(MouseEvent e){}
		});
	}
		
	private void buildPlacements()
	{
	}
	
}
