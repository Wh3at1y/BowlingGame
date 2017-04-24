package game.panels;

import java.awt.Font;
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
		private JLabel player1Username;
		private JLabel player2Username;
		private JLabel player3Username;
		private JLabel player4Username;
		private JLabel rollingUsername;

		public BowlingGameView(AllViewsPanel allViewsPanel)
			{
				this.allViewsPanel = allViewsPanel;
				
				layout = new SpringLayout();
				
				logoImage = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/MiniBowlLogo.png")));
				backgroundImage = new JLabel();
				
				player1Username = new JLabel("Player1");
				layout.putConstraint(SpringLayout.WEST, player1Username, 57, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.SOUTH, player1Username, -200, SpringLayout.SOUTH, this);
				player1Username.setFont(new Font("Sitka Text", Font.BOLD, 45));
				player2Username = new JLabel("Player2");
				layout.putConstraint(SpringLayout.WEST, player2Username, 0, SpringLayout.WEST, player1Username);
				layout.putConstraint(SpringLayout.SOUTH, player2Username, 150, SpringLayout.SOUTH, player1Username);
				player2Username.setFont(new Font("Sitka Text", Font.BOLD, 45));
				player3Username = new JLabel("Player3");
				layout.putConstraint(SpringLayout.WEST, player3Username, 0, SpringLayout.WEST, player1Username);
				layout.putConstraint(SpringLayout.SOUTH, player3Username, 300, SpringLayout.SOUTH, player1Username);
				player4Username = new JLabel("Player4");
				layout.putConstraint(SpringLayout.WEST, player4Username, 0, SpringLayout.WEST, player1Username);
				layout.putConstraint(SpringLayout.SOUTH, player4Username, 450, SpringLayout.SOUTH, player1Username);
				rollingUsername = new JLabel("Username");
				layout.putConstraint(SpringLayout.NORTH, rollingUsername, 75, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, rollingUsername, 57, SpringLayout.WEST, this);
				rollingUsername.setFont(new Font("Sitka Text", Font.BOLD, 45));
					
				buildPanel();
				buildWindow();
			}

		public  void updatePlayerUsernames()
		{
			player1Username.setText(this.allViewsPanel.getUsernameView().getUsername1());	
			player2Username.setText(this.allViewsPanel.getUsernameView().getUsername2());
			player3Username.setText(this.allViewsPanel.getUsernameView().getUsername3());
			player4Username.setText(this.allViewsPanel.getUsernameView().getUsername4());
			rollingUsername.setText(this.allViewsPanel.getUsernameView().getUsername1());
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
				this.add(this.rollingUsername);
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
