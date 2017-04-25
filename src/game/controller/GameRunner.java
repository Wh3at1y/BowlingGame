/**
 * 
 * This Class contains the main method and launches the actual game.
 * 
 **/
package game.controller;

import game.view.GameFrame;
import javafx.embed.swing.JFXPanel;

public class GameRunner
{
	public static void main(String[]args)
	{
		new JFXPanel(); // Starts JFXPanel for MP3 Audio
		new GameFrame();	//Starts the Frame, holding all the stuff.
	}
	
}