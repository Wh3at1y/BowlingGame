/*
 * Game Frame is the class that builds the frame of the GUI
 */
package game.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
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
		
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("", new ImageIcon(GameFrame.class.getResource("/resources/MiniBowlLogo.png")), SwingConstants.CENTER));
		//window.setLocationRelativeTo(null);
		window.setSize(1920, 1080);
		window.setBackground(new Color(255,255,255,0));
		window.setVisible(true);
		try
		{
			Thread.sleep(3500);
			window.dispose();
			basePanel = new AllViewsPanel();
			buildFrame();
		} catch (InterruptedException error)
		{
			// TODO Auto-generated catch block
			error.printStackTrace();
			
		}
		
		
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