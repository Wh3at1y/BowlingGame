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
		this.setVisible(false);
		this.allViewsPanel = allViewsPanel;
		layout = new SpringLayout();
		
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		twoplayerButton = new JLabel("2 Players");
		layout.putConstraint(SpringLayout.NORTH, twoplayerButton, 24, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, twoplayerButton, 10, SpringLayout.WEST, this);
		threeplayerButton = new JLabel("3 Players");
		layout.putConstraint(SpringLayout.NORTH, threeplayerButton, 0, SpringLayout.NORTH, twoplayerButton);
		layout.putConstraint(SpringLayout.WEST, threeplayerButton, 6, SpringLayout.EAST, twoplayerButton);
		fourplayerButton = new JLabel("4 Players");
		layout.putConstraint(SpringLayout.NORTH, fourplayerButton, 0, SpringLayout.NORTH, twoplayerButton);
		layout.putConstraint(SpringLayout.WEST, fourplayerButton, -183, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, fourplayerButton, 64, SpringLayout.NORTH, twoplayerButton);
		layout.putConstraint(SpringLayout.EAST, fourplayerButton, -10, SpringLayout.EAST, this);
		startgameButton = new JLabel("Start");
		layout.putConstraint(SpringLayout.NORTH, startgameButton, 138, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, startgameButton, 513, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, startgameButton, 202, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, startgameButton, 686, SpringLayout.WEST, this);
		backLabel = new JLabel("Back");
		
		buildPanel();
		buildListeners(twoplayerButton);
		buildListeners(threeplayerButton);
		buildListeners(fourplayerButton);
		//buildPlacements();	
	}
	
	private void buildPanel()
	{
		setLayout(this.layout);
		
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
					allViewsPanel.closeOptionsView();
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
