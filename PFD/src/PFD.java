/*
 * Primary Flight Display (PFD) Simulator
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Vaibhav
 */
@SuppressWarnings("serial")
public class PFD extends JPanel implements MouseMotionListener {

	/**
	 * Creates new form test
	 * 
	 * 
	 */

	int speedY = 250, altY = 250;// y coordinate of speed and altitude meter
	int attX = -70, attY = -630, slider2Val;
	int rad = 0;// Bank angle in degrees

	Graphics2D g2;

	public PFD() {
		initComponents();

		addMouseMotionListener(this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Shape s = new Rectangle2D.Double(30, 50, 120, 375);// speed gauge
		Shape s2 = new Rectangle2D.Double(850, 50, 120, 375);// altitude gauge
		g2 = (Graphics2D) g;

		g2.setColor(Color.lightGray);
		g2.fill(s);
		g2.setColor(Color.lightGray);
		g2.fill(s2);

		g2.setColor(Color.white);
		g2.draw(s);
		g2.setColor(Color.white);
		g2.draw(s2);

		g2.setColor(Color.white);
		Font fn = new Font("Serif", Font.PLAIN, 15);

		g2.setFont(fn);

		for (int x = 0; x <= 1000; x++) {

			if (x % 10 == 0 && x < 990) {
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

		for (int x = 0; x <= 100000; x++) {

			if (x % 100 == 0 && x < 99900) {
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
		g2.setColor(Color.black);
		g2.fillRect(60, 230, 60, 30);
		g2.draw(new Line2D.Double(50, 245, 60, 230));
		g2.draw(new Line2D.Double(50, 245, 60, 259));

		g2.fillRect(850, 230, 90, 30);
		g2.draw(new Line2D.Double(950, 245, 940, 230));
		g2.draw(new Line2D.Double(950, 245, 940, 259));
		g2.setColor(Color.white);
		fn = new Font("Serif", Font.BOLD, 25);

		g2.setFont(fn);
		g2.drawString(jSlider1.getValue() + "", 65, 253);
		g2.drawString(jSlider3.getValue() + "", 855, 253);
		speedY = jSlider1.getValue() * 3 + 250;
		altY = jSlider3.getValue() * 3 / 10 + 250;

		g2.setColor(Color.gray);
		g2.fillRect(471, 450, 25, 40);
		g2.draw(new Line2D.Double(471, 490, 483, 499));
		g2.draw(new Line2D.Double(496, 490, 483, 499));
		g2.setColor(Color.white);
		fn = new Font("Serif", Font.BOLD, 17);

		g2.setFont(fn);
		g2.drawString(jSlider4.getValue() + "", 471, 470);

	}

	// add components to the appropriate panel
	@SuppressWarnings("deprecation")
	private void initComponents() {

		jFrame1 = new JFrame();
		jSlider1 = new JSlider();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jSlider2 = new JSlider();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jSlider3 = new JSlider();
		jSlider4 = new JSlider();
		jLabel5 = new JLabel();
		jPanel1 = new JPanel();
		jPanel2 = new BankMeter();
		jLabel7 = new JLabel();
		jLabel6 = new RotateLabel();

		GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		setBackground(new Color(204, 204, 204));
		setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		setPreferredSize(new Dimension(1000, 700));

		jSlider1.setMajorTickSpacing(20);
		jSlider1.setMaximum(1000);
		jSlider1.setMinorTickSpacing(10);
		jSlider1.setValue(0);
		jSlider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				jSlider1StateChanged(evt);
			}
		});

		jLabel1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("SPEED");

		jLabel2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		jLabel2.setText("D/U");

		jSlider2.setMaximum(288);
		jSlider2.setMinimum(-293);
		jSlider2.setValue(0);
		jSlider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				jSlider2StateChanged(evt);
			}
		});

		jLabel3.setBackground(new Color(0, 0, 0));
		jLabel3.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		jLabel3.setText("ALTTITUDE");

		jLabel4.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		jLabel4.setText("L/R");

		jSlider3.setMajorTickSpacing(200);
		jSlider3.setMaximum(100000);
		jSlider3.setMinorTickSpacing(100);
		jSlider3.setValue(0);
		jSlider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				jSlider3StateChanged(evt);
			}
		});

		// jSlider4.setMajorTickSpacing(200);
		jSlider4.setMaximum(90);
		jSlider4.setMinimum(-90);
		// jSlider4.setMinorTickSpacing(100);
		jSlider4.setValue(0);
		jSlider4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				jSlider4StateChanged(evt);
			}
		});

		jPanel1.setBackground(new Color(255, 255, 255));
		jPanel1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		jPanel1.setPreferredSize(new Dimension(350, 350));
		jPanel1.setLayout(null);

		jLabel7.setIcon(new ImageIcon("wing8.png")); // NOI18N
		jLabel7.setLabelFor(jLabel7);
		jLabel7.setNextFocusableComponent(jLabel6);
		jPanel1.add(jLabel7);
		jLabel7.setBounds(80, 130, 200, 62);

		jLabel6.setIcon(new ImageIcon("pfd4.jpg")); // NOI18N
		jLabel6.setPreferredSize(new Dimension(1600, 1600));
		jPanel1.add(jLabel6);
		jLabel6.setBounds(-620, -630, 1600, 1600);
		jPanel2.setBackground(null);
		jPanel2.setPreferredSize(new Dimension(430, 215));
		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		// jPanel2.setBounds(200, -200, 430, 430);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 419, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 215, Short.MAX_VALUE));

		GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(62, 62,
																		62)
																.addComponent(
																		jLabel5))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jPanel1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						367,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		jLabel2)
																																.addGap(25,
																																		25,
																																		25)
																																.addComponent(
																																		jSlider2,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		jLabel1)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		jSlider1,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jPanel2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										419,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel4))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jSlider4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jSlider3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(16, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel5)
								.addGap(25, 25, 25)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										330,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(113, 113, 113)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jSlider1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel1,
																						javax.swing.GroupLayout.Alignment.TRAILING))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jSlider2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanel2,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel3)
																												.addComponent(
																														jSlider3,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(6,
																																		6,
																																		6)
																																.addComponent(
																																		jSlider4,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		javax.swing.GroupLayout.PREFERRED_SIZE))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																.addComponent(
																																		jLabel4)))
																								.addGap(22,
																										22,
																										22)))))));

		jPanel1.getAccessibleContext().setAccessibleName("");
		jPanel1.getAccessibleContext().setAccessibleDescription("");
	}// </editor-fold>

	// speed slider change
	private void jSlider1StateChanged(ChangeEvent evt) {

		speedY = jSlider1.getValue() * 3 + 250;

		repaint();

	}

	// altitude slider change
	private void jSlider3StateChanged(ChangeEvent evt) {
		altY = jSlider3.getValue() * 3 / 10 + 250;
		repaint();
	}

	// Bank angle slider change
	private void jSlider4StateChanged(ChangeEvent evt) {

		rad = -jSlider4.getValue();
		jPanel1.repaint();
		jPanel2.repaint();
		repaint();
	}

	// attitude slider change
	private void jSlider2StateChanged(ChangeEvent evt) {

		jLabel6.setBounds(jLabel6.getBounds().x,
				attY + jSlider2.getValue() * 2, 1600, 1600);

	}

	// Variables declarations
	private javax.swing.JFrame jFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JSlider jSlider1;
	private javax.swing.JSlider jSlider2;
	private javax.swing.JSlider jSlider3;
	private javax.swing.JSlider jSlider4;

	// End of variables declaration

	@Override
	public void mouseDragged(MouseEvent e) {
		// throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		jLabel5.setText("PFD");

	}

	// inner class for the attitude. Rotates the horizon appropriately
	private class RotateLabel extends JLabel {

		public RotateLabel() {

		}

		@Override
		public void paintComponent(Graphics g) {
			Graphics2D gx = (Graphics2D) g;
			gx.rotate(Math.toRadians(rad), getWidth() / 2, getHeight() / 2);

			super.paintComponent(g);
		}
	}

	// inner class for creating/measuring the bank angle. updates the bank angle
	// appropriately
	private class BankMeter extends JPanel {

		BankMeter() {

			setPreferredSize(new Dimension(420, 210));

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D gx = (Graphics2D) g;
			Font fn;
			gx.setColor(Color.gray);

			gx.translate(getWidth() / 2, getHeight());
			gx.rotate(Math.toRadians(rad * 1.8), 0, 0);
			Shape s3 = new Ellipse2D.Double(-210, -214, 420, 420);

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
	}
}
