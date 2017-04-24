package game.panels;

import game.controller.GameController;
import game.view.AllViewsPanel;

import javax.swing.*;

public class NewGameView extends JPanel
	{
		private SpringLayout baseLayout;
		private JLabel twoplayersLabel;
		private JLabel threeplayersLabel;
		private JLabel fourplayersLabel;
		private JLabel startGameLabel;
		private JLabel backLabel;

		public NewGameView(AllViewsPanel allViewsPanel)
			{
				baseLayout = new SpringLayout();
				
				twoplayersLabel = new JLabel("2 Players ");
				threeplayersLabel = new JLabel("3 Players ");
				fourplayersLabel = new JLabel("4 Players ");
				backLabel = new JLabel("Back");
				
				buildPanel();
				buildWindow();
			}

		private void buildPanel()
			{
				setVisible(false);
				setOpaque(false);
				setLayout(baseLayout);
				add(startGameLabel);
				add(backLabel);
				add(twoplayersLabel);
				add(threeplayersLabel);
				add(fourplayersLabel);
			}

		private void buildWindow()
			{
				baseLayout.putConstraint(SpringLayout.NORTH, twoplayersLabel, 620, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, twoplayersLabel, 885, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, threeplayersLabel, 720, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, threeplayersLabel, 0, SpringLayout.WEST, twoplayersLabel);
				baseLayout.putConstraint(SpringLayout.NORTH, fourplayersLabel, 820, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, fourplayersLabel, 0, SpringLayout.WEST, threeplayersLabel);
				baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 0, SpringLayout.NORTH, startGameLabel);
				baseLayout.putConstraint(SpringLayout.EAST, backLabel, -80, SpringLayout.WEST, fourplayersLabel);

				
			}

		public JLabel getStartGameLabel()
			{
				return startGameLabel;
			}

		public JLabel getBackLabel()
			{
				return backLabel;
			}
	}
