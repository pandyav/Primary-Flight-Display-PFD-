import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public class SpeedIndicator {
	
	private int X, Y, W, H;
	
	public SpeedIndicator(int X, int Y, int W, int H)
	{
		this.X=X;//x coordinate of the speed gauge
		this.Y=Y;//y coordinate of the speed gauge
		this.W=W;//width of the speed gauge
		this.H=H;//height of the speed gauge
	}
	
	public void DrawMeter(Graphics2D g2, int maxSpeed, int speedY, int sliderValue)
	{
		Shape s = new Rectangle2D.Double(X, Y,W,H);// altitude gauge
		
		g2.setColor(Color.lightGray);
		g2.fill(s);
		
		g2.setColor(Color.white);
		g2.draw(s);
		
		Font fn = new Font("Serif", Font.PLAIN, 15);

		g2.setFont(fn);
		
		SetMarkers(maxSpeed,speedY,g2);
		
		g2.setColor(Color.black);
		
		g2.fillRect(60, 230, 60, 30);
		g2.draw(new Line2D.Double(50, 245, 60, 230));
		g2.draw(new Line2D.Double(50, 245, 60, 259));
		
		g2.setColor(Color.white);
		fn = new Font("Serif", Font.BOLD, 25);

		g2.setFont(fn);
		
		g2.drawString(sliderValue + "", 65, 253);
		//speedY = sliderValue * 3 + 250;
	}
	
	public void SetMarkers(int maxSpeed, int speedY, Graphics2D g2)
	{
		for (int x = 0; x <= maxSpeed; x++) {

			if (x % 10 == 0 && x < maxSpeed-10) {
				if (speedY > 85 && speedY < 460)
					g2.draw(new Line2D.Double(30, speedY - 35, 50, speedY - 35));

			}

			if (x % 20 == 0) {

				if (speedY > 60 && speedY < 430) {
					g2.draw(new Line2D.Double(30, speedY - 5, 50, speedY - 5));

				}
				if (speedY > 60 && speedY < 425) {

					g2.drawString(x + "", 70, speedY);

				}

				speedY -= 60;
			}

		}
	}

}
