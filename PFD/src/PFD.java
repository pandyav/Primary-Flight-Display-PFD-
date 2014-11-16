/*
 * Primary Flight Display (PFD) Simulator
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
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

	private int speedY = 250, altY = 250;// y coordinate of speed and altitude meter
	private int attY = -630;//y coordinate of attitude indicator
	private int rad=0;// Bank angle in degrees
	private int maxHeight=100000;//max altitude
	private int maxSpeed=1000;//max speed
	private int minBankAngle=-90;//min bank angle
	private int maxBankAngle=90;//max bank angle
	private int minPitchAngle=-90;//min pitch angle
	private int maxPitchAngle=90;//max pitch angle

	private Graphics2D g2;
	private AltitudeIndicator altIndi = new AltitudeIndicator(850, 50, 120, 375);
	private SpeedIndicator speedIndi = new SpeedIndicator(30, 50, 120, 375);
	private BankMeter jPanel2 = new BankMeter(-210, -214, 420, 420);

	public PFD() {
		initComponents();

		addMouseMotionListener(this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g2 = (Graphics2D) g;
		speedIndi.DrawMeter(g2, maxSpeed,speedY,jSlider1.getValue());
		altIndi.DrawMeter(g2, maxHeight,altY,jSlider3.getValue());
		jPanel2.DrawCurrentAngle(g2,jSlider4.getValue());		


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
		jSlider1.setMaximum(maxSpeed);
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

		jSlider2.setMaximum(maxPitchAngle+198);
		jSlider2.setMinimum(minPitchAngle-203);
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
		jSlider3.setMaximum(maxHeight);
		jSlider3.setMinorTickSpacing(100);
		jSlider3.setValue(0);
		jSlider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				jSlider3StateChanged(evt);
			}
		});

		// jSlider4.setMajorTickSpacing(200);
		jSlider4.setMaximum(maxBankAngle);
		jSlider4.setMinimum(minBankAngle);
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

		jLabel7.setIcon(new ImageIcon("src/wing8.png")); // NOI18N
		jLabel7.setLabelFor(jLabel7);
		jLabel7.setNextFocusableComponent(jLabel6);
		jPanel1.add(jLabel7);
		jLabel7.setBounds(80, 130, 200, 62);

		jLabel6.setIcon(new ImageIcon("src/pfd4.jpg")); // NOI18N
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
		jPanel2.setRad(rad);
		jPanel1.repaint();
		jPanel2.repaint();
		
		repaint();
	}

	// attitude slider change
	private void jSlider2StateChanged(ChangeEvent evt) {

		jLabel6.setBounds(jLabel6.getBounds().x,
				attY + jSlider2.getValue()*2, 1600, 1600);

	}

	// Variables declarations
	private JFrame jFrame1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JPanel jPanel1;
	
	private JSlider jSlider1;
	private JSlider jSlider2;
	private JSlider jSlider3;
	private JSlider jSlider4;

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

	

	
	
}
