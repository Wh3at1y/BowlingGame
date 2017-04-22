package game.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.GameController;

public class AliasPanel extends JPanel
{
	GameController baseController;
	private SpringLayout layout;
	private JLabel twoplayerButton;
	private JLabel threeplayerButton;
	private JLabel fourplayerButton;
	private JLabel startgameButton;
	private UsernamePanel usernamePanel;

	public AliasPanel(GameController baseController)
	{
		this.baseController = baseController;
		this.setVisible(false);
		this.setOpaque(false);
		layout = new SpringLayout();
		
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
		
		buildPanel();
		buildListeners(twoplayerButton, 2);
		buildListeners(threeplayerButton, 3);
		buildListeners(fourplayerButton, 4);
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

	private void buildListeners(JLabel button, int amountofPlayers)
	{
		button.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent arg0)
			{
				baseController.getFRAME().getMainPANEL().getNamePanel().getAmountOfPlayers(amountofPlayers);
				
			}

			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
		});
		
	}
		
	private void buildPlacements()
	{
		
	}
	
}
