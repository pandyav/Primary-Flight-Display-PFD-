import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class BankMeter extends JPanel {
	
	private int rad=0;
	private int X, Y, W, H;
	

		BankMeter(int X, int Y, int W, int H) {
			
			this.X=X;
			this.Y=Y;
			this.W=W;
			this.H=H;
			
			setPreferredSize(new Dimension(420, 210));

		}
		
		public void DrawCurrentAngle(Graphics2D g2, int sliderValue)
		{
			Font fn = new Font("Serif", Font.PLAIN, 15);
			
			g2.setColor(Color.gray);
			g2.fillRect(471, 450, 25, 40);
			g2.draw(new Line2D.Double(471, 490, 483, 499));
			g2.draw(new Line2D.Double(496, 490, 483, 499));
			g2.setColor(Color.white);
			fn = new Font("Serif", Font.BOLD, 17);

			g2.setFont(fn);
			g2.drawString(sliderValue + "", 471, 470);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D gx = (Graphics2D) g;
			Font fn;
			gx.setColor(Color.gray);

			gx.translate(getWidth() / 2, getHeight());
			gx.rotate(Math.toRadians(rad * 1.8), 0, 0);
			Shape s3 = new Ellipse2D.Double(X,Y,W,H);

			gx.fill(s3);

			fn = new Font("Serif", Font.BOLD, 20);

			gx.setFont(fn);
			gx.setColor(Color.white);
			int y = -90;
			for (int x = 0; x < 20; x++) {

				gx.fill3DRect(0, -215, 3, 16, true);
				gx.fill3DRect(35, -210, 3, 8, true);
				if (x < 10)
					gx.drawString(" " + 10 * x, -10, -185);
				else if (x > 10) {
					gx.drawString(y + "  ", -14, -185);
					y += 10;
				}

				gx.rotate(2 * Math.PI / 20);

			}

		}
		
		public void setRad(int rad)
		{
			this.rad=rad;
		}
	}