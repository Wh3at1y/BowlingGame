package game.panels;

import java.awt.Image;
import game.controller.GameController;
import game.panels.*;

import javax.swing.*;

public class BowlingGameView extends JPanel
	{
		private GameController baseController;
		private SpringLayout layout;
		private JLabel logoImage;
		private JLabel backgroundImage;
		private JLabel twoPlayerBoard;
		private JLabel threePlayerBoard;
		private JLabel fourPlayerBoard;
		private JLabel player1Username;
		private JLabel player2Username;
		private JLabel player3Username;
		private JLabel player4Username;

		public BowlingGameView(GameController baseController)
			{
				this.baseController= baseController;
				
				layout = new SpringLayout();
				
				logoImage = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/MiniBowlLogo.png")));
				backgroundImage = new JLabel();
				
				twoPlayerBoard = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/ScoreSheet2.jpg")));
				threePlayerBoard = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/ScoreSheet3.jpg")));
				fourPlayerBoard = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/ScoreSheet4.jpg")));
				
				player1Username = new JLabel();
				player2Username = new JLabel();
				player3Username = new JLabel();
				player4Username = new JLabel();
				
				buildPanel();
				buildWindow();
			}

		private void buildPanel()
			{
				this.setLayout(this.layout);
				this.setVisible(false);
				this.setOpaque(false);
			}

		private void buildWindow()
			{
				layout.putConstraint(SpringLayout.NORTH, logoImage, 195, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, logoImage, 828, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, backgroundImage, 0, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, backgroundImage, 0, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.SOUTH, backgroundImage, 0, SpringLayout.SOUTH, this);
				layout.putConstraint(SpringLayout.EAST, backgroundImage, 0, SpringLayout.EAST, this);
			}

		public void setPlayer1Username(JLabel player1Username)
		{
			this.player1Username = player1Username;
		}

		public void setPlayer2Username(JLabel player2Username)
		{
			this.player2Username = player2Username;
		}

		public void setPlayer3Username(JLabel player3Username)
		{
			this.player3Username = player3Username;
		}

		public void setPlayer4Username(JLabel player4Username)
		{
			this.player4Username = player4Username;
		}
		
	}
