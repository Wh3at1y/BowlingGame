package game.menus;

import game.controller.GameController;

import java.awt.Font;

import javax.swing.*;

public class MainMenu extends JPanel
	{
		private SpringLayout baseLayout;
		private JLabel startLabel;
		private JLabel optionsLabel;
		private JLabel loadLabel;
		private JLabel exitLabel;
		private Font labelFont;

		public MainMenu(GameController baseController)
			{
				baseLayout = new SpringLayout();
				
				labelFont = new Font("Sitka Text", Font.BOLD, 30);

				startLabel = new JLabel("New Game");
				baseLayout.putConstraint(SpringLayout.NORTH, startLabel, 620, SpringLayout.NORTH, this);
				loadLabel = new JLabel("Load Profile");
				baseLayout.putConstraint(SpringLayout.NORTH, loadLabel, 250, SpringLayout.NORTH, this);
				optionsLabel = new JLabel("Options");
				baseLayout.putConstraint(SpringLayout.WEST, startLabel, -20, SpringLayout.WEST, optionsLabel);
				baseLayout.putConstraint(SpringLayout.NORTH, optionsLabel, 720, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, optionsLabel, 898, SpringLayout.WEST, this);
				exitLabel = new JLabel("Quit Game");
				baseLayout.putConstraint(SpringLayout.NORTH, exitLabel, 820, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, exitLabel, -17, SpringLayout.WEST, optionsLabel);
				optionsLabel.setName("options");

				baseController.buildButton(startLabel);
				baseController.buildButton(loadLabel);
				baseController.buildButton(optionsLabel);
				baseController.buildButton(exitLabel);

				buildPanel();
				buildWindow();
			}

		private void buildPanel()
			{
				optionsLabel.setFont(labelFont);
				startLabel.setFont(labelFont);
				exitLabel.setFont(labelFont);
				setOpaque(false);
				setLayout(baseLayout);
				add(startLabel);
				add(loadLabel);
				add(optionsLabel);
				add(exitLabel);
			}

		private void buildWindow()
			{
				baseLayout.putConstraint(SpringLayout.WEST, loadLabel, 150, SpringLayout.WEST, this);
			}

		public JLabel getStartLabel()
			{
				return startLabel;
			}

		public JLabel getOptionsLabel()
			{
				return optionsLabel;
			}

		public JLabel getLoadLabel()
			{
				return loadLabel;
			}

		public JLabel getExitLabel()
			{
				return exitLabel;
			}

	}