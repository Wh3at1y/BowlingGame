/**
 * 
 *  This is where the actual game takes place. Once you have selected
 *  the amount of players to play, it takes you to this panel where you
 *  can play the game, return to the Main Menu, Play again, or Exit the Game.
 * 
 **/

package game.panels;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Random;
import game.view.AllViewsPanel;
import javax.swing.*;
import java.awt.Dimension;

public class BowlingGameView extends JPanel
{
	private AllViewsPanel allViewsPanel;
	private SpringLayout baseLayout;
	private JLabel logoImage;
	private JLabel backgroundImage;
	private JLabel player1Username;
	private JLabel player2Username;
	private JLabel player3Username;
	private JLabel player4Username;
	private JLabel playerUp;
	private JLabel rollingUsername;
	private JLabel p1BigBox1;
	private JLabel p1SmallBox1;
	private JLabel p1SmallBox2;
	private JLabel p1BigBox2;
	private JLabel p1SmallBox3;
	private JLabel p1SmallBox4;
	private JLabel p1BigBox3;
	private JLabel p1SmallBox5;
	private JLabel p1SmallBox6;
	private JLabel p2BigBox1;
	private JLabel p2SmallBox1;
	private JLabel p2SmallBox2;
	private JLabel p2BigBox2;
	private JLabel p2SmallBox3;
	private JLabel p2SmallBox4;
	private JLabel p2BigBox3;
	private JLabel p2SmallBox5;
	private JLabel p2SmallBox6;
	private JLabel rollStatusLabel;
	private JLabel rollStatusGif;
	private JButton rollButton;
	private JButton rollAgainButton;
	private JButton nextPlayerButton;
	private JButton playAgainButton;
	private JButton quitGameButton;
	private JButton returnToMenuButton;
	private int selectedPins;
	private int secondSelectedPins;
	private int scorePosition;

	//Constructor initializes new components going into the panel.
	public BowlingGameView(AllViewsPanel allViewsPanel)
	{
		this.allViewsPanel = allViewsPanel;

		baseLayout = new SpringLayout();

		logoImage = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/MiniBowlLogo.png")));
		backgroundImage = new JLabel();

		player1Username = new JLabel("Player1");
		player1Username.setFont(new Font("Sitka Text", Font.BOLD, 45));

		player2Username = new JLabel("Player2");
		player2Username.setFont(new Font("Sitka Text", Font.BOLD, 45));

		player3Username = new JLabel("Player3");
		player4Username = new JLabel("Player4");

		playerUp = new JLabel("Player Up:");
		playerUp.setFont(new Font("Sitka Text", Font.ITALIC, 30));

		rollingUsername = new JLabel("Username");
		rollingUsername.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1BigBox1 = new JLabel();
		p1BigBox1.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1SmallBox1 = new JLabel();
		p1SmallBox1.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1SmallBox2 = new JLabel();
		p1SmallBox2.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1BigBox2 = new JLabel();
		p1BigBox2.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1SmallBox3 = new JLabel();
		p1SmallBox3.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1SmallBox4 = new JLabel();
		p1SmallBox4.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1BigBox3 = new JLabel();
		p1BigBox3.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1SmallBox5 = new JLabel();
		p1SmallBox5.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p1SmallBox6 = new JLabel();
		p1SmallBox6.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2BigBox1 = new JLabel();
		p2BigBox1.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2SmallBox1 = new JLabel();
		p2SmallBox1.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2SmallBox2 = new JLabel();
		p2SmallBox2.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2BigBox2 = new JLabel();
		p2BigBox2.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2SmallBox3 = new JLabel();
		p2SmallBox3.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2SmallBox4 = new JLabel();
		p2SmallBox4.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2BigBox3 = new JLabel();
		p2BigBox3.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2SmallBox5 = new JLabel();
		p2SmallBox5.setFont(new Font("Sitka Text", Font.BOLD, 45));

		p2SmallBox6 = new JLabel();
		p2SmallBox6.setFont(new Font("Sitka Text", Font.BOLD, 45));

		rollStatusLabel = new JLabel("", SwingConstants.CENTER);
		rollStatusLabel.setFont(new Font("Sitka Text", Font.BOLD, 80));

		rollButton = new JButton("Roll Ball");
		rollButton.setPreferredSize(new Dimension(120, 50));
		rollButton.setFont(new Font("Sitka Text", Font.BOLD, 12));
		
		nextPlayerButton = new JButton("Next Player");
		nextPlayerButton.setPreferredSize(new Dimension(160, 50));
		nextPlayerButton.setFont(new Font("Sitka Text", Font.BOLD, 12));
		
		rollAgainButton = new JButton("Roll Again");
		rollAgainButton.setPreferredSize(new Dimension(100, 50));
		rollAgainButton.setFont(new Font("Sitka Text", Font.BOLD, 12));
		
		playAgainButton = new JButton("Play Again?");
		playAgainButton.setPreferredSize(new Dimension(120, 50));
		playAgainButton.setFont(new Font("Sitka Text", Font.BOLD, 12));
		
		quitGameButton = new JButton("Exit Game");
		quitGameButton.setPreferredSize(new Dimension(100, 50));
		quitGameButton.setFont(new Font("Sitka Text", Font.BOLD, 12));
		
		returnToMenuButton = new JButton("Return to Main Menu");
		returnToMenuButton.setPreferredSize(new Dimension(160, 50));
		returnToMenuButton.setFont(new Font("Sitka Text", Font.BOLD, 12));

		this.rollAgainButton.setVisible(false);
		this.nextPlayerButton.setEnabled(false);
		this.playAgainButton.setVisible(true);
		this.quitGameButton.setVisible(true);
		this.returnToMenuButton.setVisible(true);
		this.rollStatusGif = new JLabel();
		this.rollStatusGif.setVisible(false);
		this.scorePosition = 1;
		
		this.buildPanel();
		this.buildWindow();
		this.buildListeners();
	}

	// Shows the Gifs if you get a Strike or a Spare
	private void changeGifSize(String loc)
	{
		ImageIcon imageIcon = new ImageIcon(AllViewsPanel.class.getResource(loc));
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(500, 400, java.awt.Image.SCALE_FAST);
		imageIcon = new ImageIcon(newimg); // transform it back
		rollStatusGif.setIcon(imageIcon);
		rollStatusGif.setVisible(true);
	}

	// Pulls the Usernames entered to the score board
	public void updatePlayerUsernames()
	{
		player1Username.setText(this.allViewsPanel.getUsernameView().getUsername1().getText());
		player2Username.setText(this.allViewsPanel.getUsernameView().getUsername2().getText());
		player3Username.setText(this.allViewsPanel.getUsernameView().getUsername3().getText());
		player4Username.setText(this.allViewsPanel.getUsernameView().getUsername4().getText());
		rollingUsername.setText(this.allViewsPanel.getUsernameView().getUsername1().getText());
	}

	//Method to add components to the panel.
	private void buildPanel()
	{
		this.setLayout(this.baseLayout);
		this.setVisible(false);
		this.setOpaque(false);
		this.add(this.rollButton);
		this.add(this.nextPlayerButton);
		this.add(this.rollAgainButton);
		this.add(this.playAgainButton);
		this.add(this.quitGameButton);
		this.add(this.returnToMenuButton);
		this.add(this.player1Username);
		this.add(this.player2Username);
		this.add(this.player3Username);
		this.add(this.player4Username);
		this.add(this.playerUp);
		this.add(this.rollingUsername);
		this.add(this.p1BigBox1);
		this.add(this.p1SmallBox1);
		this.add(this.p1SmallBox2);
		this.add(this.p1BigBox2);
		this.add(this.p1SmallBox3);
		this.add(this.p1SmallBox4);
		this.add(this.p1BigBox3);
		this.add(this.p1SmallBox5);
		this.add(this.p1SmallBox6);
		this.add(this.p2BigBox1);
		this.add(this.p2SmallBox1);
		this.add(this.p2SmallBox2);
		this.add(this.p2BigBox2);
		this.add(this.p2SmallBox3);
		this.add(this.p2SmallBox4);
		this.add(this.p2BigBox3);
		this.add(this.p2SmallBox5);
		this.add(this.p2SmallBox6);
		this.add(this.rollStatusLabel);
		this.add(this.rollStatusGif);
	}

	private void buildListeners()
	{
		// Rolls the ball the first time of a turn
		rollButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Random rand = new Random();
				selectedPins = Math.abs(rand.nextInt()) % 11;

				// ----STRIKE----
				if (selectedPins == 10)
				{
					changeGifSize("/resources/STRIKE.gif");
					nextPlayerButton.setEnabled(true);
					rollButton.setEnabled(false);
					rollStatusLabel.setText("<html><div style='text-align: center;'>STRIKE</div></html>");

					// p1BigBox1
					if (scorePosition == 1)
					{
						p1BigBox1.setText("10");
						p1BigBox1.setVisible(false);
						p1SmallBox1.setText("X");
						p1SmallBox2.setText("");
					}
					// p1BigBox2
					else if (scorePosition == 2)
					{
						p2BigBox1.setText("10");
						p2BigBox1.setVisible(false);
						p2SmallBox1.setText("X");
						p2SmallBox2.setText("");
					}
					// p1BigBox3
					else if (scorePosition == 3)
					{
						p1BigBox2.setText("10");
						p1BigBox2.setVisible(false);
						p1SmallBox3.setText("X");
						p1SmallBox4.setText("");
					}
					// p2BigBox1
					else if (scorePosition == 4)
					{
						p2BigBox2.setText("10");
						p2BigBox2.setVisible(false);
						p2SmallBox3.setText("X");
						p2SmallBox4.setText("");
					}
					// p2BigBox2
					else if (scorePosition == 5)
					{
						p1BigBox3.setText("10");
						p1BigBox3.setVisible(false);
						p1SmallBox5.setText("X");
						p1SmallBox6.setText("");
					}
					// p2BigBox3
					else if (scorePosition == 6)
					{
						p2BigBox3.setText("10");
						p2BigBox3.setVisible(false);
						p2SmallBox5.setText("X");
						p2SmallBox6.setText("");
						nextPlayerButton.setEnabled(false);
						calculateWinner();
					}
				}

				else
				{
					if (scorePosition == 1)
						p1SmallBox1.setText(Integer.toString(selectedPins));
					else if (scorePosition == 2)
						p2SmallBox1.setText(Integer.toString(selectedPins));
					else if (scorePosition == 3)
						p1SmallBox3.setText(Integer.toString(selectedPins));
					else if (scorePosition == 4)
						p2SmallBox3.setText(Integer.toString(selectedPins));
					else if (scorePosition == 5)
						p1SmallBox5.setText(Integer.toString(selectedPins));
					else if (scorePosition == 6)
						p2SmallBox5.setText(Integer.toString(selectedPins));

					rollStatusLabel.setText("HIT " + selectedPins);
					rollButton.setEnabled(false);
					rollButton.setVisible(false);
					rollAgainButton.setVisible(true);
					rollAgainButton.setEnabled(true);
				}
			}
		});

		// Allows you to roll if you didn't get a strike
		this.rollAgainButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Random rand = new Random();
				// Generates a number thats left. (if first bowl is 6, will
				// generate between 0-4)
				int secondSelectedPins;

				if (selectedPins == 0)
					secondSelectedPins = rand.nextInt(10) + 1;
				else
					secondSelectedPins = rand.nextInt(11 - selectedPins);

				// ----SPARE-----
				if (secondSelectedPins + selectedPins == 10)
				{
					changeGifSize("/resources/SPARE.gif");

					if (scorePosition == 1)
					{
						p1SmallBox2.setText("/");
						p1BigBox1.setText(Integer.toString(10));
						p1BigBox1.setVisible(false);
					} else if (scorePosition == 2)
					{
						p2SmallBox2.setText("/");
						p2BigBox1.setText(Integer.toString(10));
						p2BigBox1.setVisible(false);
					} else if (scorePosition == 3)
					{
						p1SmallBox4.setText("/");
						p1BigBox2.setText(Integer.toString(10));
						p1BigBox2.setVisible(false);
					} else if (scorePosition == 4)
					{
						p2SmallBox4.setText("/");
						p2BigBox2.setText(Integer.toString(10));
						p2BigBox2.setVisible(false);
					} else if (scorePosition == 5)
					{
						p1SmallBox6.setText("/");
						p1BigBox3.setText(Integer.toString(10));
						p1BigBox3.setVisible(false);
					} else if (scorePosition == 6)
					{
						p2SmallBox6.setText("/");
						p2BigBox3.setText(Integer.toString(10));
						p2BigBox3.setVisible(false);
					}

					rollStatusLabel.setText("SPARE");
					rollAgainButton.setEnabled(false);
					nextPlayerButton.setEnabled(true);

					if (scorePosition == 6)
					{
						nextPlayerButton.setEnabled(false);
						calculateWinner();
					}

				} else // ----NOT SPARE----
				{
					if (scorePosition == 1)
					{
						p1SmallBox2.setText(Integer.toString(secondSelectedPins));
						p1BigBox1.setText(Integer.toString(selectedPins + secondSelectedPins));
						p1BigBox1.setVisible(true);
					}
					if (scorePosition == 2)
					{
						p2SmallBox2.setText(Integer.toString(secondSelectedPins));
						p2BigBox1.setText(Integer.toString(selectedPins + secondSelectedPins));
						p2BigBox1.setVisible(true);
					}
					if (scorePosition == 3)
					{
						p1SmallBox4.setText(Integer.toString(secondSelectedPins));
						p1BigBox2.setText(Integer.toString(selectedPins + secondSelectedPins));
						p1BigBox2.setVisible(true);
					}
					if (scorePosition == 4)
					{
						p2SmallBox4.setText(Integer.toString(secondSelectedPins));
						p2BigBox2.setText(Integer.toString(selectedPins + secondSelectedPins));
						p2BigBox2.setVisible(true);
					}
					if (scorePosition == 5)
					{
						p1SmallBox6.setText(Integer.toString(secondSelectedPins));
						p1BigBox3.setText(Integer.toString(selectedPins + secondSelectedPins));
						p1BigBox3.setVisible(true);
					}
					if (scorePosition == 6)
					{
						p2SmallBox6.setText(Integer.toString(secondSelectedPins));
						p2BigBox3.setText(Integer.toString(selectedPins + secondSelectedPins));
						p2BigBox3.setVisible(true);
					}
					rollStatusLabel.setText("Next Player!");
					rollAgainButton.setEnabled(false);
					nextPlayerButton.setEnabled(true);

					if (scorePosition == 6)
					{
						nextPlayerButton.setEnabled(false);
						calculateWinner();
					}
				}
			}
		});

		// Moves from player to player after their turn.
		nextPlayerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				scorePosition++;
				rollStatusGif.setVisible(false);
				nextPlayerButton.setEnabled(false);
				rollAgainButton.setVisible(false);
				rollButton.setEnabled(true);
				rollButton.setVisible(true);

				if (scorePosition == 2)
					rollingUsername.setText(allViewsPanel.getUsernameView().getUsername2().getText());
				else if (scorePosition == 3)
					rollingUsername.setText(allViewsPanel.getUsernameView().getUsername1().getText());
				else if (scorePosition == 4)
					rollingUsername.setText(allViewsPanel.getUsernameView().getUsername2().getText());
				else if (scorePosition == 5)
					rollingUsername.setText(allViewsPanel.getUsernameView().getUsername1().getText());
				else if (scorePosition == 6)
					rollingUsername.setText(allViewsPanel.getUsernameView().getUsername2().getText());

				rollStatusLabel.setText("");

			}
		});

		// Returns you to the Main Menu
		returnToMenuButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				allViewsPanel.openMainMenuView();
				allViewsPanel.setBackgroundStatus(false);
				allViewsPanel.getLogo().setVisible(true);
				allViewsPanel.getUsernameView().getUsername1().setText("");
				allViewsPanel.getUsernameView().getUsername2().setText("");
				allViewsPanel.getUsernameView().getUsername3().setText("");
				allViewsPanel.getUsernameView().getUsername4().setText("");
				clearScoreBoard();
			}
		});

		// Returns you to the Amount of Players Screen
		playAgainButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				allViewsPanel.closeBowlingGameView();
				allViewsPanel.closeUserNameView();
				allViewsPanel.setBackgroundStatus(false);
				allViewsPanel.getLogo().setVisible(true);
				allViewsPanel.openAmountOfPlayersView();
				allViewsPanel.getUsernameView().getUsername1().setText("");
				allViewsPanel.getUsernameView().getUsername2().setText("");
				allViewsPanel.getUsernameView().getUsername3().setText("");
				allViewsPanel.getUsernameView().getUsername4().setText("");
				clearScoreBoard();
			}
		});

		// Lets you quit the game
		quitGameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{	System.exit(0);	}
		});

	}

	// The math to Calculate who wins
	private void calculateWinner()
	{
		int player1Score = 0;
		int player2Score = 0;

		player1Score = Integer.parseInt(this.p1BigBox1.getText()) + Integer.parseInt(this.p1BigBox2.getText())
				+ Integer.parseInt(this.p1BigBox3.getText());

		player2Score = Integer.parseInt(this.p2BigBox1.getText()) + Integer.parseInt(this.p2BigBox2.getText())
				+ Integer.parseInt(this.p2BigBox3.getText());

		if (player1Score > player2Score)
			rollStatusLabel.setText(allViewsPanel.getUsernameView().getUsername1().getText() + " WINS!");
		else if (player1Score < player2Score)
			rollStatusLabel.setText(allViewsPanel.getUsernameView().getUsername2().getText() + " WINS!");
		else
			rollStatusLabel.setText("TIE?");
	}

	// Clears the Score board for the next game
	private void clearScoreBoard()
	{
		scorePosition = 1;
		this.p1BigBox1.setText("");
		this.p1SmallBox1.setText("");
		this.p1SmallBox2.setText("");
		this.p1BigBox2.setText("");
		this.p1SmallBox3.setText("");
		this.p1SmallBox4.setText("");
		this.p1BigBox3.setText("");
		this.p1SmallBox5.setText("");
		this.p1SmallBox6.setText("");
		this.p2BigBox1.setText("");
		this.p2SmallBox1.setText("");
		this.p2SmallBox2.setText("");
		this.p2BigBox2.setText("");
		this.p2SmallBox3.setText("");
		this.p2SmallBox4.setText("");
		this.p2BigBox3.setText("");
		this.p2SmallBox5.setText("");
		this.p2SmallBox6.setText("");
		this.rollStatusLabel.setText("");
		this.rollStatusGif.setVisible(false);
		this.rollButton.setEnabled(true);
		this.rollButton.setVisible(true);
		this.rollAgainButton.setVisible(false);
		this.nextPlayerButton.setEnabled(false);
	}

	//This is constraints for components in our Panel.
	private void buildWindow()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, logoImage, 195, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, logoImage, 828, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, backgroundImage, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, backgroundImage, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, backgroundImage, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, backgroundImage, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, player1Username, 57, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, player1Username, -200, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, player2Username, 0, SpringLayout.WEST, player1Username);
		baseLayout.putConstraint(SpringLayout.SOUTH, player2Username, 150, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, player3Username, 0, SpringLayout.WEST, player1Username);
		baseLayout.putConstraint(SpringLayout.SOUTH, player3Username, 300, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, player4Username, 0, SpringLayout.WEST, player1Username);
		baseLayout.putConstraint(SpringLayout.SOUTH, player4Username, 450, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.NORTH, playerUp, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, playerUp, 57, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rollingUsername, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rollingUsername, 57, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, p1BigBox1, 675, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1BigBox1, 0, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1SmallBox1, 910, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1SmallBox1, -40, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1SmallBox2, 910, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1SmallBox2, 40, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1BigBox2, 1125, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1BigBox2, 0, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1SmallBox3, 1375, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1SmallBox3, -40, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1SmallBox4, 1375, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1SmallBox4, 40, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1BigBox3, 1575, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1BigBox3, 0, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1SmallBox5, 1810, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1SmallBox5, -40, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p1SmallBox6, 1810, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p1SmallBox6, 40, SpringLayout.SOUTH, player1Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2BigBox1, 675, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2BigBox1, 0, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2SmallBox1, 910, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2SmallBox1, -40, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2SmallBox2, 910, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2SmallBox2, 40, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2BigBox2, 1125, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2BigBox2, 0, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2SmallBox3, 1375, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2SmallBox3, -40, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2SmallBox4, 1375, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2SmallBox4, 40, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2BigBox3, 1575, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2BigBox3, 0, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2SmallBox5, 1810, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2SmallBox5, -40, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, p2SmallBox6, 1810, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, p2SmallBox6, 40, SpringLayout.SOUTH, player2Username);
		baseLayout.putConstraint(SpringLayout.WEST, rollStatusLabel, 697, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rollStatusLabel, -150, SpringLayout.NORTH, p1SmallBox1);
		baseLayout.putConstraint(SpringLayout.EAST, rollStatusLabel, -621, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rollButton, -20, SpringLayout.NORTH, playerUp);
		baseLayout.putConstraint(SpringLayout.WEST, rollButton, 400, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rollButton, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, rollButton, 600, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nextPlayerButton, -20, SpringLayout.NORTH, playerUp);
		baseLayout.putConstraint(SpringLayout.WEST, nextPlayerButton, -550, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, nextPlayerButton, 0, SpringLayout.SOUTH, rollButton);
		baseLayout.putConstraint(SpringLayout.EAST, nextPlayerButton, -350, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rollAgainButton, -21, SpringLayout.NORTH, playerUp);
		baseLayout.putConstraint(SpringLayout.WEST, rollAgainButton, 400, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rollAgainButton, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, rollAgainButton, 600, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, playAgainButton, -180, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, playAgainButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, playAgainButton, -10, SpringLayout.NORTH, quitGameButton);
		baseLayout.putConstraint(SpringLayout.WEST, quitGameButton, -180, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, quitGameButton, -325, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, quitGameButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, returnToMenuButton, 0, SpringLayout.WEST, playAgainButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, returnToMenuButton, -10, SpringLayout.NORTH, playAgainButton);
		baseLayout.putConstraint(SpringLayout.EAST, returnToMenuButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rollStatusGif, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rollStatusGif, 740, SpringLayout.WEST, this);
	}

	// Sets the name of Player 1
	public void setPlayer1Username(JLabel player1Username)
	{	this.player1Username = player1Username;	}

	// Sets the name of Player 2
	public void setPlayer2Username(JLabel player2Username)
	{	this.player2Username = player2Username;	}

	// Sets the name of Player 3
	public void setPlayer3Username(JLabel player3Username)
	{	this.player3Username = player3Username;	}

	// Sets the name of Player 4
	public void setPlayer4Username(JLabel player4Username)
	{	this.player4Username = player4Username;	}

}