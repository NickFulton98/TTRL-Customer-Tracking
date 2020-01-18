package frontend;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * This is the main class object for the GUI. This is essentially the first step after loading 
 * the driver.
 * @author Nick Fulton
 */
public class App 
{
	JFrame mainFrame;
	
	/**
	 * This is the main constructor.
	 */
	public App()
	{
		
	}
	
	/**
	 * This method is used to launch everything and start the app.
	 */
	public void start()
	{
		buildFrame();
	}
	
	/**
	 * This method is used to build the GUI.
	 */
	private void buildFrame()
	{
		// Start the frame creation.
		mainFrame = new JFrame("TTRL Customer Tracking");
		mainFrame.setLayout(new GridBagLayout());
		
		// Since we are using GridBag we kinda need this.
		GridBagConstraints c = new GridBagConstraints();
		
		// This is where the logo is.
		JLabel logo = new JLabel(new ImageIcon("src/media/logo.png"));
		
		// This is where we are going to import the sales tax.
		JButton xmlImport = new JButton("Import Sales Data");
		
		// Throw that logo in there.
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		mainFrame.add(logo, c);
		
		// Throw the sales tax import button in there.
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		mainFrame.add(xmlImport, c);
		
		xmlImport.addActionListener(e -> importXMLData());
		
		// Finish off frame creation.
		mainFrame.setSize(new Dimension(500, 500));
		mainFrame.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	private void importXMLData()
	{
		Analyzer a = new Analyzer("src/frontend/SaleData.xml");
	}
}
