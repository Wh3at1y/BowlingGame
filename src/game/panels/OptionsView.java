package game.panels;

import game.view.AllViewsPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionsView extends JPanel
{
	//Declaration section for our variables in this class.
	private AllViewsPanel allViewsPanel;
	private SpringLayout baseLayout;
	private JLabel toggleMusicLabel;
	private JLabel toggleClicksLabel;
	private JLabel backLabel;
	private Font labelFont;
	private boolean toggleClicks;
	private boolean toggleMusic;
	
	//Constructor initializes new components going into the panel.
	public OptionsView(AllViewsPanel allViewsPanel)
	{
		this.allViewsPanel = allViewsPanel;
				
		baseLayout = new SpringLayout();
				
		labelFont = new Font("Sitka Text", Font.BOLD, 30);
		
		toggleMusicLabel = new JLabel("<html>Toggle Music:<br><div style='text-align: center;'>ON</div></html>");	
		toggleClicksLabel = new JLabel("<html><div style='text-align: center;'>Toggle Button Sounds:<br>ON</div></html>");
		backLabel = new JLabel("Back");
				
		toggleClicks = true;
		toggleMusic = true;

		buildPanel();
		buildWindow();
		buildListeners(this.toggleMusicLabel);
		buildListeners(this.toggleClicksLabel);
		buildListeners(this.backLabel);
	}
	
	//Method to add components to the panel.
	private void buildPanel()
	{
		this.setVisible(false);
		this.setOpaque(false);
		this.setLayout(baseLayout);
		this.add(this.toggleMusicLabel);
		this.add(this.toggleClicksLabel);
		this.add(this.backLabel);
	}

	private void buildListeners(JLabel button)
	{
		button.setFont(this.labelFont);
		button.setForeground(Color.BLACK);
		button.addMouseListener(new MouseListener()
		{
			public void mousePressed(MouseEvent arg0)
			{
				allViewsPanel.playButtonClick();	
				//If you hit the back button it changes the panel to the previous panel.		
				if(button == backLabel)
				{
					allViewsPanel.closeOptionsView();
				}
				//Statement to check whether toggle music to show on or off and pauses/plays when on/off.
				if(button == toggleMusicLabel)
				{
					allViewsPanel.setMusicToggle();
					if(toggleMusic == true)
					{
						toggleMusicLabel.setText("<html>Toggle Music:<br><div style='text-align: center;'>OFF</div></html>");
						toggleMusic = false;
					}
					else
					{
						toggleMusicLabel.setText("<html>Toggle Music:<br><div style='text-align: center;'>ON</div></html>");
						toggleMusic = true;
					}
							
				}	
				//Statement to check whether toggle clicks should be on or off.
				if(button == toggleClicksLabel)
				{	
					if(toggleClicks == true)
					{
						toggleClicks = false;
						allViewsPanel.setButtonToggle(toggleClicks);
						toggleClicksLabel.setText("<html><div style='text-align: center;'>Toggle Button Sounds:<br>OFF</div></html>");		
					}
					else if(toggleClicks == false)
					{
						toggleClicks = true;
						allViewsPanel.setButtonToggle(toggleClicks);
						toggleClicksLabel.setText("<html><div style='text-align: center;'>Toggle Button Sounds:<br>ON</div></html>");
					}
				}
			}
			public void mouseClicked(MouseEvent e){}
			//This event changes the button color when hovered over it to white.
			public void mouseEntered(MouseEvent e)
			{	
				button.setForeground(Color.WHITE);
				allViewsPanel.playButtonHovor();	
			}
			//This event changes the button color to black again when the mouse exits the button area.
			public void mouseExited(MouseEvent e)
				{	button.setForeground(Color.BLACK);	}
			public void mouseReleased(MouseEvent e){}
		});
	}
	
	//This is constraints for components in our Panel.
	private void buildWindow()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, toggleMusicLabel, 600, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, toggleMusicLabel, 855, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, toggleClicksLabel, 700, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, toggleClicksLabel, 790, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 820, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, backLabel, 135, SpringLayout.WEST, toggleClicksLabel);
	}
		
	public JLabel getToggleMusicLabel()
	{	return toggleMusicLabel;	}

	public JLabel getToggleClicksLabel()
	{	return toggleClicksLabel;	}

	public JLabel getBackLabel()
	{	return backLabel;	}
	
}