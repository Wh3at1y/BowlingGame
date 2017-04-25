/*
 * Game Frame is the class that builds the frame of the GUI
 */
package game.view;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class GameFrame extends JFrame
{
	private AllViewsPanel basePanel;

	public GameFrame()
	{
		try 
	    { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    } 
	    catch(Exception e){ 
	    }
		
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