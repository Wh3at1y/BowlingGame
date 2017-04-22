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
				baseLayout.putConstraint(SpringLayout.NORTH, twoplayersLabel, 620, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, twoplayersLabel, 885, SpringLayout.WEST, this);
				threeplayersLabel = new JLabel("3 Players ");
				baseLayout.putConstraint(SpringLayout.NORTH, threeplayersLabel, 720, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, threeplayersLabel, 0, SpringLayout.WEST, twoplayersLabel);
				fourplayersLabel = new JLabel("4 Players ");
				baseLayout.putConstraint(SpringLayout.NORTH, fourplayersLabel, 820, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, fourplayersLabel, 0, SpringLayout.WEST, threeplayersLabel);
				startGameLabel = new JLabel("Start Game");
				baseLayout.putConstraint(SpringLayout.NORTH, startGameLabel, 60, SpringLayout.SOUTH, fourplayersLabel);
				baseLayout.putConstraint(SpringLayout.WEST, startGameLabel, 150, SpringLayout.WEST, fourplayersLabel);
				backLabel = new JLabel("Back");
				baseLayout.putConstraint(SpringLayout.NORTH, backLabel, 0, SpringLayout.NORTH, startGameLabel);
				baseLayout.putConstraint(SpringLayout.EAST, backLabel, -80, SpringLayout.WEST, fourplayersLabel);

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
