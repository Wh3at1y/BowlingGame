package game.view;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private AllViewsPanel basePanel;

	public GameFrame()
	{
		basePanel = new AllViewsPanel();
		buildFrame();
	}

	private void buildFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(basePanel);
		this.setVisible(true);
		this.basePanel.updateBackgroundImage(this.getWidth(), this.getHeight());
	}
		
}