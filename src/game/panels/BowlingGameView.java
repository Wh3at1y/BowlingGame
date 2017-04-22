package game.panels;

import java.awt.Image;
import game.controller.GameController;
import game.panels.*;

import javax.swing.*;

public class BowlingGameView extends JPanel
	{
		private SpringLayout baseLayout;
		private JLabel logoImage;
		private JLabel backgroundImage;
		private JLabel twoPlayerBoard;
		private JLabel threePlayerBoard;
		private JLabel fourPlayerBoard;

		public BowlingGameView(GameController baseController)
			{
				baseLayout = new SpringLayout();
				logoImage = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/MiniBowlLogo.png")));
				baseLayout.putConstraint(SpringLayout.NORTH, logoImage, 195, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, logoImage, 828, SpringLayout.WEST, this);
				backgroundImage = new JLabel();
				twoPlayerBoard = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/ScoreSheet2.jpg")));
				threePlayerBoard = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/ScoreSheet3.jpg")));
				fourPlayerBoard = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/ScoreSheet4.jpg")));
				buildPanel();
				buildWindow();
			}

		private void buildPanel()
			{
			int amountofPlayers = 2;
				setLayout(baseLayout);
				add(logoImage);
				add(backgroundImage);
				if(amountofPlayers == 2)
				{
					add(twoPlayerBoard);
				}
				else if(amountofPlayers == 3)
				{
					add(threePlayerBoard);
				}
				else if(amountofPlayers == 4)
				{
					add(fourPlayerBoard);
				}
			}

		public void updateBackgroundImage(int x, int y)
			{
				ImageIcon imageIcon = new ImageIcon(BowlingGameView.class.getResource("/resources/GameBackground1.jpg")); // load the image to a imageIcon
				Image image = imageIcon.getImage(); // transform it
				Image newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				imageIcon = new ImageIcon(newimg); // transform it back
				backgroundImage.setIcon(imageIcon);
			}

		private void buildWindow()
			{
				baseLayout.putConstraint(SpringLayout.NORTH, backgroundImage, 0, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, backgroundImage, 0, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, backgroundImage, 0, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, backgroundImage, 0, SpringLayout.EAST, this);
			}

	}
