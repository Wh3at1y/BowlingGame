package game.panels;

import java.awt.Image;
import game.panels.*;
import game.view.AllViewsPanel;
import javax.swing.*;

public class BowlingGameView extends JPanel
	{
		private AllViewsPanel allViewsPanel;
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

		public BowlingGameView(AllViewsPanel allViewsPanel)
			{
				this.allViewsPanel = allViewsPanel;
				
				layout = new SpringLayout();
				
				logoImage = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/MiniBowlLogo.png")));
				backgroundImage = new JLabel();
				
				player1Username = new JLabel("Player1");	
				layout.putConstraint(SpringLayout.NORTH, player1Username, 298, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, player1Username, 165, SpringLayout.WEST, this);
				player2Username = new JLabel("Player2");
				layout.putConstraint(SpringLayout.NORTH, player2Username, 310, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.EAST, player2Username, -324, SpringLayout.EAST, this);
				player3Username = new JLabel("Player3");
				layout.putConstraint(SpringLayout.WEST, player3Username, 77, SpringLayout.WEST, this);
				player4Username = new JLabel("Player4");
				layout.putConstraint(SpringLayout.WEST, player4Username, 321, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.SOUTH, player4Username, -256, SpringLayout.SOUTH, this);
					
				buildPanel();
				buildWindow();
			}

		public  void updatePlayerUsernames()
		{
			player1Username.setText(this.allViewsPanel.getUsernameView().getUsername1());	
			player2Username.setText(this.allViewsPanel.getUsernameView().getUsername2());
			player3Username.setText(this.allViewsPanel.getUsernameView().getUsername3());
			player4Username.setText(this.allViewsPanel.getUsernameView().getUsername4());
		}
		
		private void buildPanel()
			{
				this.setLayout(this.layout);
				this.setVisible(false);
				this.setOpaque(false);
				
				this.add(this.player1Username);
				this.add(this.player2Username);
				this.add(this.player3Username);
				this.add(this.player4Username);
			}

		private void buildWindow()
			{
				layout.putConstraint(SpringLayout.NORTH, logoImage, 195, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, logoImage, 828, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, backgroundImage, 0, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, backgroundImage, 0, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.SOUTH, backgroundImage, 0, SpringLayout.SOUTH, this);
				layout.putConstraint(SpringLayout.EAST, backgroundImage, 0, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.SOUTH, player3Username, -45, SpringLayout.SOUTH, this);
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
