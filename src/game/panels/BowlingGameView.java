package game.panels;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Random;
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
    //private JLabel XStrikeScore;
    //private JLabel spareGif;
    //private JLabel strikeGif;
    
    private JButton rollButton;
    private JButton rollAgainButton;
    private JButton nextPlayerButton;
    private JButton playAgainButton;
    private JButton quitGameButton;
    private JButton returnToMenuButton;

    private int selectedPins;
    private int secondSelectedPins;  
    private int scorePosition;

    public BowlingGameView(AllViewsPanel allViewsPanel)
      {
        this.allViewsPanel = allViewsPanel;
        
        layout = new SpringLayout();
        
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
           
        rollButton = new JButton("Roll Ball"); 
        nextPlayerButton = new JButton("Next Player"); 
        rollAgainButton = new JButton("Roll Again"); 
        playAgainButton = new JButton("Play Again?");
        layout.putConstraint(SpringLayout.WEST, playAgainButton, 0, SpringLayout.WEST, rollButton);
        quitGameButton = new JButton("Exit Game");
        layout.putConstraint(SpringLayout.NORTH, playAgainButton, 0, SpringLayout.NORTH, quitGameButton);
        layout.putConstraint(SpringLayout.NORTH, quitGameButton, 38, SpringLayout.SOUTH, rollAgainButton);
        layout.putConstraint(SpringLayout.WEST, quitGameButton, 0, SpringLayout.WEST, rollAgainButton);
        returnToMenuButton = new JButton("Return to Main Menu");
        layout.putConstraint(SpringLayout.NORTH, returnToMenuButton, 38, SpringLayout.SOUTH, nextPlayerButton);
        layout.putConstraint(SpringLayout.WEST, returnToMenuButton, 0, SpringLayout.WEST, nextPlayerButton);
       
                  
        this.rollButton.disable();
        this.nextPlayerButton.setVisible(false);
        this.rollAgainButton.setVisible(false);
        this.playAgainButton.setVisible(true);
        this.quitGameButton.setVisible(true);
        this.returnToMenuButton.setVisible(true);
            
        //XStrikeScore = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/XRedStrike.png")));
        //spareGif = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/SpareGif.png")));
        // strikeGif = new JLabel(new ImageIcon(BowlingGameView.class.getResource("/resources/StrikeGif.png")));
        //this.XStrikeScore.setVisible(false);
        //this.spareGif.setVisible(false);
        //this.strikeGif.setVisible(false);
              
        this.scorePosition = 1;
            
        this.buildPanel();
        this.buildWindow();
        this.buildListenersP1F1();
      }

    public void updatePlayerUsernames()
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
      }

    private void buildListenersP1F1()
        {
          rollButton.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent click)
            {
              Random rand = new Random();
              selectedPins = Math.abs(rand.nextInt()) % 11;
              
              System.out.println(selectedPins);
              System.out.println("position " + scorePosition);
              
              //----STRIKE----
              if(selectedPins == 10)
              {
                //strikeGif.setVisible(true);
                nextPlayerButton.setVisible(true);
                rollButton.setVisible(false);
                rollAgainButton.setVisible(false);
                //THIS WILL BE A STRIKE ON THE BOARD. X   p1SmallBox1
                            
                //p1BigBox1
                if(scorePosition == 1)
                {
                  p1BigBox1.setText("");
                  p1SmallBox1.setText("X");
                  p1SmallBox2.setText("");
                }
                //p1BigBox2
                else if(scorePosition == 2)
                {
                  p2BigBox1.setText("");
                  p2SmallBox1.setText("X");
                  p2SmallBox2.setText("");
                }
                //p1BigBox3
                else if(scorePosition == 3)
                {
                  p1BigBox2.setText("");
                  p1SmallBox3.setText("X");
                  p1SmallBox4.setText("");
                }
                //p2BigBox1
                else if(scorePosition == 4)
                {
                  p2BigBox2.setText("");
                  p2SmallBox3.setText("X");
                  p2SmallBox4.setText("");
                }
                //p2BigBox2
                else if(scorePosition == 5)
                {
                  p1BigBox3.setText("");
                  p1SmallBox5.setText("X");
                  p1SmallBox6.setText("");
                }
                //p2BigBox3
                else if(scorePosition == 6)
                {
                  p2BigBox3.setText("");
                  p2SmallBox5.setText("X");
                  p2SmallBox6.setText("");
                }
              }
              
              else
              {
                //ADD WHAT THEY ROLLED TO THE BOARD IN p1SmallBox1. VARIABLE = (selectedPins)
                if(scorePosition == 1)
                  p1SmallBox1.setText(Integer.toString(selectedPins));
                else if(scorePosition == 2)
                  p2SmallBox1.setText(Integer.toString(selectedPins));
                else if(scorePosition == 3)
                  p1SmallBox3.setText(Integer.toString(selectedPins));
                else if(scorePosition == 4)
                  p2SmallBox3.setText(Integer.toString(selectedPins));
                else if(scorePosition == 5)
                  p1SmallBox5.setText(Integer.toString(selectedPins));
                else if(scorePosition == 6)
                  p2SmallBox5.setText(Integer.toString(selectedPins));
                         
                rollButton.setVisible(false);
                rollAgainButton.setVisible(true);
                rollAgainButton.enable();
              }
              
            }
          });
        
         this.rollAgainButton.addActionListener(new ActionListener()
         {
          public void actionPerformed(ActionEvent click)
          {
            Random rand = new Random();
            //Generates a number thats left. (if first bowl is 6, will generate between 0-4)
            int secondSelectedPins;

            if(selectedPins == 0)
              secondSelectedPins = rand.nextInt(10) + 1;
            else
              secondSelectedPins = rand.nextInt(11 - selectedPins);
            System.out.println(selectedPins);
                
            //----SPARE-----
            if(secondSelectedPins + selectedPins == 10)
            {
              //PUT ON SCOREBOARD "/" IN SECOND BOX
              if(scorePosition == 1)
              {
                p1SmallBox2.setText("/");
                p1BigBox1.setText(Integer.toString(10));
              }
              else if(scorePosition == 2)
              {
                p2SmallBox2.setText("/");
                p2BigBox1.setText(Integer.toString(10));
              }
              else if(scorePosition == 3)
              {
                p1SmallBox4.setText("/");
                p1BigBox2.setText(Integer.toString(10));
              }
              else if(scorePosition == 4)
              {
                p2SmallBox4.setText("/");
                p2BigBox2.setText(Integer.toString(10));
              }
              else if(scorePosition == 5)
              {
                p1SmallBox6.setText("/");
                p1BigBox3.setText(Integer.toString(10));
              }
              else if(scorePosition == 6)
              {
                p2SmallBox6.setText("/");
                p2BigBox3.setText(Integer.toString(10));
              }
              //spareGif.setVisible(true);
              
              rollAgainButton.disable();
              rollAgainButton.setVisible(false);
              nextPlayerButton.setVisible(true);
            }
            else  //----NOT SPARE----
            {
              if(scorePosition == 1)
              {
                p1SmallBox2.setText(Integer.toString(secondSelectedPins));
                p1BigBox1.setText(Integer.toString(selectedPins + secondSelectedPins));
              }
              if(scorePosition == 2)
              {
                p2SmallBox2.setText(Integer.toString(secondSelectedPins));
                p2BigBox1.setText(Integer.toString(selectedPins + secondSelectedPins));
              }
              if(scorePosition == 3)
              {
                p1SmallBox4.setText(Integer.toString(secondSelectedPins));
                p1BigBox2.setText(Integer.toString(selectedPins + secondSelectedPins));
              }
              if(scorePosition == 4)
              {
                p2SmallBox4.setText(Integer.toString(secondSelectedPins));
                p2BigBox2.setText(Integer.toString(selectedPins + secondSelectedPins));
              }
              if(scorePosition == 5)
              {
                p1SmallBox6.setText(Integer.toString(secondSelectedPins));
                p1BigBox3.setText(Integer.toString(selectedPins + secondSelectedPins));
              }
              if(scorePosition == 6)
              {
                p2SmallBox6.setText(Integer.toString(secondSelectedPins));
                p2BigBox3.setText(Integer.toString(selectedPins + secondSelectedPins));
              }
              
              rollAgainButton.disable();
              rollAgainButton.setVisible(false);
              nextPlayerButton.setVisible(true);
            }
          }
         });
         
         nextPlayerButton.addActionListener(new ActionListener()
         {
            private Object allViewsPanel;

			public void actionPerformed(ActionEvent click)
            {
              scorePosition++;
              //strikeGif.setVisible(false);
              nextPlayerButton.setVisible(false);
              rollButton.setVisible(true);   
            }
         });
         
         returnToMenuButton.addActionListener(new ActionListener()
         {
            private Object allViewsPanel;

			public void actionPerformed(ActionEvent click)
            {

            }
         });
         
         quitGameButton.addActionListener(new ActionListener()
         {
            private Object allViewsPanel;

			public void actionPerformed(ActionEvent click)
            {
				System.exit(0);
            }
         });
        }
     
    private void buildWindow()
      {
        layout.putConstraint(SpringLayout.NORTH, logoImage, 195, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, logoImage, 828, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, backgroundImage, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, backgroundImage, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, backgroundImage, 0, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.EAST, backgroundImage, 0, SpringLayout.EAST, this); 
        layout.putConstraint(SpringLayout.WEST, player1Username, 57, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, player1Username, -200, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, player2Username, 0, SpringLayout.WEST, player1Username);
        layout.putConstraint(SpringLayout.SOUTH, player2Username, 150, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, player3Username, 0, SpringLayout.WEST, player1Username);
        layout.putConstraint(SpringLayout.SOUTH, player3Username, 300, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, player4Username, 0, SpringLayout.WEST, player1Username);
        layout.putConstraint(SpringLayout.SOUTH, player4Username, 450, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.NORTH, playerUp, 50, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, playerUp, 57, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, rollingUsername, 100, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, rollingUsername, 57, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST, p1BigBox1, 675, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1BigBox1, 0, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1SmallBox1, 910, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1SmallBox1, -40, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1SmallBox2, 910, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1SmallBox2, 40, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1BigBox2, 1125, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1BigBox2, 0, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1SmallBox3, 1375, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1SmallBox3, -40, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1SmallBox4, 1375, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1SmallBox4, 40, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1BigBox3, 1575, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1BigBox3, 0, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1SmallBox5, 1810, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1SmallBox5, -40, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p1SmallBox6, 1810, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p1SmallBox6, 40, SpringLayout.SOUTH, player1Username);
        layout.putConstraint(SpringLayout.WEST, p2BigBox1, 675, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2BigBox1, 0, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2SmallBox1, 910, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2SmallBox1, -40, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2SmallBox2, 910, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2SmallBox2, 40, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2BigBox2, 1125, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2BigBox2, 0, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2SmallBox3, 1375, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2SmallBox3, -40, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2SmallBox4, 1375, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2SmallBox4, 40, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2BigBox3, 1575, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2BigBox3, 0, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2SmallBox5, 1810, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2SmallBox5, -40, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.WEST, p2SmallBox6, 1810, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, p2SmallBox6, 40, SpringLayout.SOUTH, player2Username);
        layout.putConstraint(SpringLayout.NORTH, rollButton, 22, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, rollButton, -444, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, nextPlayerButton, 0, SpringLayout.NORTH, rollButton);
        layout.putConstraint(SpringLayout.WEST, nextPlayerButton, 156, SpringLayout.EAST, rollButton);
        layout.putConstraint(SpringLayout.NORTH, rollAgainButton, 0, SpringLayout.NORTH, rollButton);
        layout.putConstraint(SpringLayout.WEST, rollAgainButton, 38, SpringLayout.EAST, rollButton);
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