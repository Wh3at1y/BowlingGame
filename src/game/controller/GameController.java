package game.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import game.menus.*;
import game.view.GameFrame;
import game.view.GamePanel;
import javafx.embed.swing.JFXPanel;

public class GameController
	{
		private GameFrame baseFrame;
		private ButtonController buttonController;
		private MusicController playSound;

		public GameController()
			{
				new JFXPanel(); // Starts JFXPanel for MP3 Audio
				baseFrame = new GameFrame(this);
				buttonController = new ButtonController(this);
				playSound = new MusicController(this);
				playSound.menuSong(); // Starts the MainMenu song
			}

		public void buildLabelOnly(JLabel button)
			{
				button.setFont(new Font("Sitka Text", Font.BOLD, 30));
				button.setEnabled(false);
				button.setForeground(Color.WHITE);
			}

		public void buildButton(JLabel button)
			{
				button.setFont(new Font("Sitka Text", Font.BOLD, 30));
				button.setEnabled(false);
				button.setForeground(Color.WHITE);
				mainButtonListeners(button); // passes the button into the listener
			}

		/**
		 * @param button
		 *            : The button the user clicks on Makes listeners for all the buttons that call for it
		 */
		public void mainButtonListeners(JLabel button)
			{
				button.addMouseListener(new MouseListener()
					{
						public void mouseClicked(MouseEvent clicked)
							{

							}

						public void mousePressed(MouseEvent e)
							{
								/**
								 * ------------- Main Menu Listeners
								 */
								if (playSound.getButtonClicks()) // Checks the toggle clicks status
									playSound.buttonClick(); // Plays the sound
								if (button == getMainMenuPanel().getOptionsLabel() || button == getOptionsPanel().getBackLabel() || button == getLoadPanel().getBackLabel() || button == getNewGamePanel().getBackLabel()) // Options and Back Button
									buttonController.optionsButtonOperation(); // Load the options operations
								if (button == getMainMenuPanel().getStartLabel()) // Start Button
									buttonController.newGameButtonOperation(); // Load start button operations
								if (button == getMainMenuPanel().getLoadLabel())
									{ // Load Button
										buttonController.loadButtonOperation();
									}// Load the load game operations
								if (button == getMainMenuPanel().getExitLabel()) // Exit Button
									buttonController.exitButtonOperation(); // Load the exit button operations

								/**
								 * ------------- New Game Listeners
								 */
								if (button == getNewGamePanel().getStartGameLabel());
								/**
								 * ------------- Load Menu Listeners
								 */
								if (button == getLoadPanel().getChooseProfileLabel())
								/**
								 * ------------- Options Menu Listeners
								 */
								if (button == getOptionsPanel().getToggleMusicLabel()) // Toggle Music Button
									playSound.menuMusicStatus(); // Toggles the sound
								if (button == getOptionsPanel().getToggleClicksLabel()) // Toggle Button click sounds
									playSound.buttonClickStatus(); // Toggles the sound
							}

						public void mouseReleased(MouseEvent e)
							{

							}

						public void mouseEntered(MouseEvent e)
							{
								if (playSound.getButtonClicks())
									playSound.buttonHover();
								button.setEnabled(true);
							}

						public void mouseExited(MouseEvent e)
							{
								button.setEnabled(false);
							}
					});
			}

		/*
		 * --------Getters
		 */
		public MainMenu getMainMenuPanel()
			{
				return baseFrame.getPanel().getMainMenuPanel();
			}
		public GameFrame getFRAME()
		{
			return this.baseFrame;
		}
		public NewGameMenu getNewGamePanel()
			{
				return baseFrame.getPanel().getNewGamePanel();
			}

		public OptionsMenu getOptionsPanel()
			{
				return baseFrame.getPanel().getOptionsMenuPanel();
			}

		public LoadMenu getLoadPanel()
			{
				return baseFrame.getPanel().getLoadMenu();
			}

		public MusicController getMusicController()
			{
				return playSound;
			}
	}
