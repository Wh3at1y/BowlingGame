package game.panels;

import game.view.AllViewsPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MainMenuView extends JPanel
	{
		private AllViewsPanel allViewsPanel;
		private SpringLayout baseLayout;
		private JLabel startLabel;
		private JLabel optionsLabel;
		private JLabel exitLabel;
		private Font labelFont;

		public MainMenuView(AllViewsPanel allViewsPanel)
			{
				this.allViewsPanel = allViewsPanel;
				
				baseLayout = new SpringLayout();
		
				labelFont = new Font("Sitka Text", Font.BOLD, 30);
				
				startLabel = new JLabel("New Game");
				optionsLabel = new JLabel("Options");
				exitLabel = new JLabel("Quit Game");

				buildPanel();
				buildWindow();
				buildListeners(this.startLabel);
				buildListeners(this.optionsLabel);
				buildListeners(this.exitLabel);
			}

		private void buildPanel()
			{
				this.setOpaque(false);
				this.setLayout(baseLayout);
				this.add(startLabel);
				this.add(optionsLabel);
				this.add(exitLabel);
			}

		private void buildListeners(JLabel button)
		{
				button.setFont(this.labelFont);	button.setForeground(Color.BLACK);
				
				button.addMouseListener(new MouseListener()
				{
					public void mousePressed(MouseEvent arg0)
					{
						if(button == startLabel)
						{	allViewsPanel.openAmountOfPlayersView();		}
						if(button == optionsLabel)
						{	allViewsPanel.openOptionsView();		}
						if(button == exitLabel)
							System.exit(0);
					}
					public void mouseClicked(MouseEvent e){}
					public void mouseEntered(MouseEvent e)
					{	button.setForeground(Color.WHITE);	}
					
					public void mouseExited(MouseEvent e)
					{	button.setForeground(Color.BLACK);	}
					
					public void mouseReleased(MouseEvent e){}
					});
		}
		
		private void buildWindow()
			{
				baseLayout.putConstraint(SpringLayout.NORTH, startLabel, 620, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, startLabel, -20, SpringLayout.WEST, optionsLabel);
				baseLayout.putConstraint(SpringLayout.NORTH, optionsLabel, 720, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, optionsLabel, 898, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, exitLabel, 820, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, exitLabel, -17, SpringLayout.WEST, optionsLabel);
			}

		public JLabel getStartLabel()
		{	return startLabel;		}

		public JLabel getOptionsLabel()
		{	return optionsLabel;		}

		public JLabel getExitLabel()
		{	return exitLabel;	}
		
	}