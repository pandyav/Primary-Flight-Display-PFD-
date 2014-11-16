import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public class AltitudeIndicator {
	
	private int X, Y, W, H;
	
	public AltitudeIndicator(int X, int Y, int W, int H)
	{
		this.X=X;//x coordinate of the altitude gauge
		this.Y=Y;//y coordinate of the altitude gauge
		this.W=W;//width of the altitude gauge
		this.H=H;//height of the altitude gauge
	}
	
	public void DrawMeter(Graphics2D g2, int maxHeight, int altY, int sliderValue)
	{
		Shape s2 = new Rectangle2D.Double(X, Y,W,H);// altitude gauge
		
		g2.setColor(Color.lightGray);
		g2.fill(s2);
		
		g2.setColor(Color.white);
		g2.draw(s2);
		
		Font fn = new Font("Serif", Font.PLAIN, 15);

		g2.setFont(fn);
		
		SetMarkers(maxHeight,altY,g2);
		
		g2.setColor(Color.black);
		
		g2.fillRect(850, 230, 90, 30);
		g2.draw(new Line2D.Double(950, 245, 940, 230));
		g2.draw(new Line2D.Double(950, 245, 940, 259));
		
		g2.setColor(Color.white);
		fn = new Font("Serif", Font.BOLD, 25);

		g2.setFont(fn);
		
		g2.drawString(sliderValue + "", 855, 253);
		altY = sliderValue * 3 / 10 + 250;
	}
	
	private void SetMarkers(int maxHeight, int altY, Graphics2D g2)
	{
		for (int x = 0; x <= maxHeight; x++) {

			if (x % 100 == 0 && x < maxHeight-100) {
				if (altY > 85 && altY < 460)
					g2.draw(new Line2D.Double(950, altY - 35, 970, altY - 35));

			}

			if (x % 200 == 0) {

				if (altY > 60 && altY < 430) {
					g2.draw(new Line2D.Double(950, altY - 5, 970, altY - 5));

				}
				if (altY > 60 && altY < 425) {

					g2.drawString(x + "", 900, altY);

				}

				altY -= 60;
			}

		}
	}

}
