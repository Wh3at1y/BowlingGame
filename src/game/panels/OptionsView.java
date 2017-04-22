package game.panels;

import game.controller.GameController;
import game.view.AllViewsPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class OptionsView extends JPanel
	{
		private AllViewsPanel allViewsPanel;
		
		private SpringLayout baseLayout;
		
		private JLabel toggleMusicLabel;
		private JLabel toggleClicksLabel;
		private JLabel backLabel;
		
		private Font labelFont;

		public OptionsView(AllViewsPanel allViewsPanel)
			{
				this.allViewsPanel = allViewsPanel;
				baseLayout = new SpringLayout();
				
				labelFont = new Font("Sitka Text", Font.BOLD, 30);
				
				toggleMusicLabel = new JLabel("Toggle Music : On");
				toggleClicksLabel = new JLabel("Toggle Button Sounds : On");
				backLabel = new JLabel("Back");

				buildPanel();
				buildWindow();
				buildListeners(backLabel);
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
						if(button == backLabel)
						{
							allViewsPanel.closeOptionsView();
						}
					}
					public void mouseClicked(MouseEvent e){}
					public void mouseEntered(MouseEvent e)
					{
						//if (playSound.getButtonClicks())
							//playSound.buttonHover();
						button.setForeground(Color.WHITE);
					}
	
				public void mouseExited(MouseEvent e)
					{
						button.setForeground(Color.BLACK);
					}
					public void mouseReleased(MouseEvent e){}
				});
		}
		
		private void buildWindow()
			{
				baseLayout.putConstraint(SpringLayout.WEST, backLabel, 150, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, toggleClicksLabel, 50, SpringLayout.NORTH, toggleMusicLabel);
				baseLayout.putConstraint(SpringLayout.WEST, toggleClicksLabel, 150, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, toggleMusicLabel, 200, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, toggleMusicLabel, 150, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 50, SpringLayout.NORTH, toggleClicksLabel);
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
