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

	public MusicController()
	{
		this.isButtonClicksOn = true;
		menuSong();
	}

	public void setButtonClicks(boolean buttonStatus)
	{	isButtonClicksOn = buttonStatus;	}
		
	public void menuMusicStatus()
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

	public void buttonClickStatus()
	{
		if(this.isButtonClicksOn == true)
			buttonClick();
		}
		
	public void buttonHovorStatus()
	{
		if(this.isButtonClicksOn == true)
			buttonHover();
	}

	public void menuSong()
	{
		URL resource = getClass().getResource("/resources/song.wav");
		Media media = new Media(resource.toString());
		mainMenuPlayer = new MediaPlayer(media);
		mainMenuPlayer.setVolume(.45);
		mainMenuPlayer.play();
	}

	public void buttonClick()
	{
		URL resource = getClass().getResource("/resources/buttonClick.wav");
		Media media = new Media(resource.toString());
		buttonClickPlayer = new MediaPlayer(media);
		buttonClickPlayer.setVolume(.25);
		buttonClickPlayer.play();
	}

	public void buttonHover()
	{
		URL resource = getClass().getResource("/resources/click.wav");
		Media media = new Media(resource.toString());
		buttonHoverPlayer = new MediaPlayer(media);
		buttonHoverPlayer.setVolume(.25);
		buttonHoverPlayer.play();
	}
	
}