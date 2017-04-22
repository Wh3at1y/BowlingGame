package game.view;

import game.controller.GameController;
import javax.swing.JFrame;

public class GameFrame extends JFrame
	{
		private MainPanel basePanel;

		public GameFrame(GameController baseController)
			{
				basePanel = new MainPanel(baseController);
				buildFrame();
			}

		private void buildFrame()
			{
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setUndecorated(true);
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				this.setContentPane(basePanel);
				this.setVisible(true);
				this.basePanel.getGamePanel().updateBackgroundImage(this.getWidth(), this.getHeight());
			}

		public GamePanel getPanel()
			{
				return basePanel.getGamePanel();
			}
		public MainPanel getMainPANEL()
		{
			return this.basePanel;
		}

	}
