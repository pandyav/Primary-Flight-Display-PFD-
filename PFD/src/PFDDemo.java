

import java.awt.*;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
//Tester class for PFD

@SuppressWarnings("serial")
public class PFDDemo extends JApplet {
	

	public static void main(String s[])  {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("PFD");
		JApplet applet = new PFDDemo();
		applet.init();	
		frame.getContentPane().add(applet);
		
		frame.pack();		
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void init() {
		JPanel panel = new PFD();
		panel.setBackground(Color.black);	
		
		getContentPane().add(panel);
                
		

	}
}