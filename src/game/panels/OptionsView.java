package game.panels;

import game.view.AllViewsPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionsView extends JPanel
	{
		private AllViewsPanel allViewsPanel;
		private SpringLayout baseLayout;
		private JLabel toggleMusicLabel;
		private JLabel toggleClicksLabel;
		private JLabel backLabel;
		private Font labelFont;
		private boolean toggleClicks;
		private boolean toggleMusic;

		public OptionsView(AllViewsPanel allViewsPanel)
			{
				this.allViewsPanel = allViewsPanel;
				
				baseLayout = new SpringLayout();
				
				labelFont = new Font("Sitka Text", Font.BOLD, 30);
				toggleMusicLabel = new JLabel("<html>Toggle Music:<br><div style='text-align: center;'>ON</div></html>");
				baseLayout.putConstraint(SpringLayout.NORTH, toggleMusicLabel, 600, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, toggleMusicLabel, 855, SpringLayout.WEST, this);
				toggleClicksLabel = new JLabel("<html><div style='text-align: center;'>Toggle Button Sounds:<br>ON</div></html>");
				baseLayout.putConstraint(SpringLayout.NORTH, toggleClicksLabel, 700, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, toggleClicksLabel, 790, SpringLayout.WEST, this);
				backLabel = new JLabel("Back");
				baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 820, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, backLabel, 135, SpringLayout.WEST, toggleClicksLabel);
				
				toggleClicks = true;
				toggleMusic = true;

				buildPanel();
				buildWindow();
				buildListeners(this.toggleMusicLabel);
				buildListeners(this.toggleClicksLabel);
				buildListeners(this.backLabel);
			}

		private void buildPanel()
			{
				setVisible(false);
				setOpaque(false);
				setLayout(baseLayout);
				add(toggleMusicLabel);
				add(toggleClicksLabel);
				add(backLabel);
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
						
						if(button == backLabel)
						{
							allViewsPanel.closeOptionsView();
						}
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
					public void mouseEntered(MouseEvent e)
					{	button.setForeground(Color.WHITE);
						allViewsPanel.playButtonHovor();	}
	
				public void mouseExited(MouseEvent e)
					{	button.setForeground(Color.BLACK);	}
					public void mouseReleased(MouseEvent e){}
				});
		}
		
		private void buildWindow()
			{
			}
		
		public JLabel getToggleMusicLabel()
			{
				return toggleMusicLabel;
			}

		public JLabel getToggleClicksLabel()
			{
				return toggleClicksLabel;
			}

		public JLabel getBackLabel()
			{
				return backLabel;
			}
	}
