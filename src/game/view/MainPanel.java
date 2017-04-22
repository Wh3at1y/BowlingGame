package game.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.GameController;
import game.menus.AliasPanel;
import game.menus.UsernamePanel;

public class MainPanel extends JPanel
{
	private SpringLayout layout;
	
	private  GamePanel gamePanel;
	private AliasPanel aliasPanel;
	private UsernamePanel usernamePanel;
	
	public MainPanel(GameController baseController)
	{
		layout = new SpringLayout();
		gamePanel = new GamePanel(baseController);
		layout.putConstraint(SpringLayout.NORTH, gamePanel, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, gamePanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, gamePanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, gamePanel, 0, SpringLayout.EAST, this);
		aliasPanel = new AliasPanel(baseController);
		layout.putConstraint(SpringLayout.NORTH, aliasPanel, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, aliasPanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, aliasPanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, aliasPanel, 0, SpringLayout.EAST, this);
		usernamePanel = new UsernamePanel(baseController);
		layout.putConstraint(SpringLayout.NORTH, usernamePanel, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, usernamePanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, usernamePanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, usernamePanel, 0, SpringLayout.EAST, this);
		
		buildPanel();
		buildPlacements();
	}
	
	public void buildPanel()
	{
		setLayout(this.layout);
		add(this.aliasPanel);
		add(this.gamePanel);
		add(this.usernamePanel);
	}
	
	public void buildPlacements()
	{
		
	}
	
	public GamePanel getGamePanel()
	{
		return this.gamePanel;
	}
	
	public UsernamePanel getNamePanel()
	{
		return this.usernamePanel;
	}
	
}
