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

		public GameController()
			{
				new JFXPanel(); // Starts JFXPanel for MP3 Audio
				baseFrame = new GameFrame();
			}

	}
