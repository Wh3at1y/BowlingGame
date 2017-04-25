package game.view;

import java.awt.Image;
import game.controller.MusicController;
import game.panels.*;
import javax.swing.*;

public class AllViewsPanel extends JPanel
{
	private SpringLayout baseLayout;
	private MusicController soundPlayer;
	private MainMenuView mainMenuView;
	private NewGameView newGameView;
	private OptionsView optionsMenuView;
	private AmountOfPlayersView amountOfPlayersView;
	private UsernameView usernamePanel;
	private BowlingGameView bowlingGameView;
	private JLabel logoImage;
	private JLabel backgroundImage;
	private boolean isGameMenuShowing;
	private int frameWidth;
	private int frameHeight;

	public AllViewsPanel()
	{
		this.baseLayout = new SpringLayout();
		this.soundPlayer = new MusicController();
		this.mainMenuView = new MainMenuView(this);
		this.newGameView = new NewGameView(this);
		this.optionsMenuView = new OptionsView(this);
		this.amountOfPlayersView = new AmountOfPlayersView(this);
		this.usernamePanel = new UsernameView(this);
		this.bowlingGameView = new BowlingGameView(this);
		this.logoImage = new JLabel(new ImageIcon(AllViewsPanel.class.getResource("/resources/MiniBowlLogo.png")));
		this.backgroundImage = new JLabel();
		this.isGameMenuShowing = false;

		buildPanel();
		buildWindow();
	}

	public void setMusicToggle()
	{	soundPlayer.menuMusicStatus();	}

	public void setButtonToggle(boolean buttonStatus)
	{	soundPlayer.setButtonClicks(buttonStatus);	}

	public void playButtonHovor()
	{	soundPlayer.buttonHovorStatus();	}

	public void playButtonClick()
	{	soundPlayer.buttonClickStatus();		}

	private void buildPanel()
	{
		this.setVisible(true);
		this.setLayout(this.baseLayout);
		this.add(this.bowlingGameView);
		this.add(this.amountOfPlayersView);
		this.add(this.usernamePanel);
		this.add(this.mainMenuView);
		this.add(this.newGameView);
		this.add(this.optionsMenuView);
		this.add(this.logoImage);
		this.add(this.backgroundImage);
	}

	public void updateBackgroundImage(int x, int y)
	{
		this.frameWidth = x;
		this.frameHeight = y;
		if (this.isGameMenuShowing == false)
		{
			ImageIcon imageIcon = new ImageIcon(AllViewsPanel.class.getResource("/resources/BackgroundImage.jpg"));
			Image image = imageIcon.getImage(); // transform it
			Image newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg); // transform it back
			backgroundImage.setIcon(imageIcon);
		} else
		{
			ImageIcon imageIcon = new ImageIcon(AllViewsPanel.class.getResource("/resources/Background2Players.jpg"));
			Image image = imageIcon.getImage(); // transform it
			Image newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg); // transform it back
			backgroundImage.setIcon(imageIcon);
		}
	}

	public void openAmountOfPlayersView()
	{
		this.amountOfPlayersView.setVisible(true);
		this.mainMenuView.setVisible(false);
	}

	public void closeAmountofPlayersView()
	{
		this.mainMenuView.setVisible(true);
		this.amountOfPlayersView.setVisible(false);
	}

	public void openUserNameView()
	{
		this.usernamePanel.setVisible(true);
		this.amountOfPlayersView.setVisible(false);
	}

	public void closeUserNameView()
	{
		this.amountOfPlayersView.setVisible(true);
		this.usernamePanel.setVisible(false);
	}

	public void openBowlingGameView()
	{
		this.bowlingGameView.setVisible(true);
		this.usernamePanel.setVisible(false);
	}

	public void closeBowlingGameView()
	{
		this.usernamePanel.setVisible(true);
		this.bowlingGameView.setVisible(false);
	}

	public void openOptionsView()
	{
		this.optionsMenuView.setVisible(true);
		this.mainMenuView.setVisible(false);
	}

	public void closeOptionsView()
	{
		this.mainMenuView.setVisible(true);
		this.optionsMenuView.setVisible(false);
	}
	
	public void openMainMenuView()
	{
		this.mainMenuView.setVisible(true);
		this.bowlingGameView.setVisible(false);
	}
	
	public void openPlayersView()
	{
		this.amountOfPlayersView.setVisible(true);
		this.bowlingGameView.setVisible(false);
	}

	public void exitButtonOperation()
	{	System.exit(0);	}

	public JLabel getLogo()
	{	return this.logoImage;		}

	public void setBackgroundStatus(boolean status)
	{
		this.isGameMenuShowing = status;
		this.updateBackgroundImage(this.frameWidth, this.frameHeight);
	}

	public MainMenuView getNewGamePanel()
	{	return this.mainMenuView;	}

	public NewGameView getMainMenuPanel()
	{	return this.newGameView;		}

	public OptionsView getOptionsMenuPanel()
	{	return this.optionsMenuView;	}

	public UsernameView getUsernameView()
	{	return this.usernamePanel;		}
	
	public BowlingGameView getBowlingView()
	{	return this.bowlingGameView;	}

	private void buildWindow()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, bowlingGameView, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, bowlingGameView, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bowlingGameView, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, bowlingGameView, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, backgroundImage, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, backgroundImage, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, backgroundImage, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, backgroundImage, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, mainMenuView, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, mainMenuView, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, mainMenuView, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, mainMenuView, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, newGameView, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, newGameView, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, newGameView, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, newGameView, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, optionsMenuView, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, optionsMenuView, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, optionsMenuView, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, optionsMenuView, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, logoImage, 195, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, logoImage, 828, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, amountOfPlayersView, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, amountOfPlayersView, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, amountOfPlayersView, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, amountOfPlayersView, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, usernamePanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, usernamePanel, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, usernamePanel, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, usernamePanel, 0, SpringLayout.EAST, this);
	}

}