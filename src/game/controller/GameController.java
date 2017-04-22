package game.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

import game.panels.*;
import game.view.GameFrame;
import game.view.AllViewsPanel;
import javafx.embed.swing.JFXPanel;

public class GameController
	{
		private GameFrame baseFrame;
		private ButtonController buttonController;
		private MusicController playSound;

		public GameController()
			{
				new JFXPanel(); // Starts JFXPanel for MP3 Audio
				baseFrame = new GameFrame();
				buttonController = new ButtonController();
				playSound = new MusicController();
				playSound.menuSong(); // Starts the MainMenu song
			}

		

		public void buildButton(JLabel button)
			{
				button.setFont(new Font("Sitka Text", Font.BOLD, 30));
				button.setEnabled(false);
				button.setForeground(Color.WHITE);
			}
				
		
		/*
		 * --------Getters
		 */


		public MusicController getMusicController()
			{
				return playSound;
			}
	}
