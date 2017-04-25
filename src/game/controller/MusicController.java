/**
*
*	This is the Class that has our sounds and music for the GUI
*	and also activates the music and sounds.
*
**/
package game.controller;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController
{
	private MediaPlayer mainMenuPlayer;
	private MediaPlayer buttonClickPlayer;
	private MediaPlayer buttonHoverPlayer;
	private boolean isButtonClicksOn;
	private boolean isMenuSongPlaying;

	public MusicController() // Activates all sounds for GUI
	{
		this.isButtonClicksOn = true;
		menuSong();
	}

	public void setButtonClicks(boolean buttonStatus) // Checks if the sounds are active
	{	isButtonClicksOn = buttonStatus;	}
		
	public void menuMusicStatus() // Checks if the music is paused or playing
	{
		if (this.isMenuSongPlaying == true)
		{
			mainMenuPlayer.play();
			isMenuSongPlaying = false;
		}
		else
		{
			mainMenuPlayer.pause();
			isMenuSongPlaying = true;
		}
	}

	public void buttonClickStatus() // Activates the sound for clicking the button
	{
		if(this.isButtonClicksOn == true)
			buttonClick();
		}
		
	public void buttonHovorStatus() // Activates the sound for hovering over text
	{
		if(this.isButtonClicksOn == true)
			buttonHover();
	}

	public void menuSong() // The music for the game
	{
		URL resource = getClass().getResource("/resources/song.wav");
		Media media = new Media(resource.toString());
		mainMenuPlayer = new MediaPlayer(media);
		mainMenuPlayer.setVolume(.45);
		mainMenuPlayer.play();
	}

	public void buttonClick() // The sound when a button is clicked
	{
		URL resource = getClass().getResource("/resources/buttonClick.wav");
		Media media = new Media(resource.toString());
		buttonClickPlayer = new MediaPlayer(media);
		buttonClickPlayer.setVolume(.25);
		buttonClickPlayer.play();
	}

	public void buttonHover() // The sound when mouse hovers over text
	{
		URL resource = getClass().getResource("/resources/click.wav");
		Media media = new Media(resource.toString());
		buttonHoverPlayer = new MediaPlayer(media);
		buttonHoverPlayer.setVolume(.25);
		buttonHoverPlayer.play();
	}
	
}