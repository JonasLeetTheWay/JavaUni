import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Locale;


@SuppressWarnings("serial")
class Window extends Frame {
	private Label lResX;
	private Label lResY;
	private Label lNIter;
	private Label lXMin;
	private Label lXMax;
	private Label lYMin;
	private Label lYMax;
	private Label lR;
	private Label lG;
	private Label lB;
	private Label lDiv;
	private Label lConv;
	private Label lColors;
	private TextField tResX;
	private TextField tResY;
	private TextField tNIter;
	private TextField tXMin;
	private TextField tXMax;
	private TextField tYMin;
	private TextField tYMax;
	private TextField tRD;
	private TextField tRC;
	private TextField tGD;
	private TextField tGC;
	private TextField tBD;
	private TextField tBC;
	private Plot plot;
	private BufferedImage img;
	private Mandelbrot m;
	private int dr;
	private int dg;
	private int db;
	private int r0;
	private int g0;
	private int b0;
	private int resX;
	private int resY;
	private int kOSx = 0;
	private int kOSy = 0;

	public Window(Mandelbrot m) {
		if(m != null){
			//To make sure '.' is used as decimal point
			Locale.setDefault(Locale.US);
			//Stop user from resizing, since all componets have a fixed width
			this.setResizable(false);
	
			//Reference to parent Mandelbrot class - needed for Listener callback
			this.m = m;
	
			//Button for default values
			Button standard = new Button("Default Values");
			standard.setBounds(10, 410, 210, 30); // setting button position  
			add(standard); //adding button into frame  
	
			//Button to calculate the set
			Button calc = new Button("Calculate");
			calc.setBounds(10, 450, 210, 30);
			add(calc);
	
			//Canvas to display the rendered image
			plot = new Plot();
			plot.setBounds(230, 40, 700, 700);
			plot.setBackground(Color.LIGHT_GRAY);
			add(plot);
	
			//All Labels that describe the value fields
			lResX   = new Label("Resolution (x)");
			lResY   = new Label("Resolution (y)");
			lXMin   = new Label("X_min");
			lXMax   = new Label("X_max");
			lYMin   = new Label("Y_min");
			lYMax   = new Label("Y_max");
			lNIter  = new Label("Iterations");
			lR	    = new Label("Red");
			lG	    = new Label("Green");
			lB	    = new Label("Blue");
			lDiv    = new Label("Div.");
			lConv   = new Label("Conv.");
			lColors = new Label("Colors:");
	
			//All text boxes for value entry
			tResX  = new TextField("700");
			tResY  = new TextField("700");
			tXMin  = new TextField("-2.5");
			tXMax  = new TextField("1.5");
			tYMin  = new TextField("-2");
			tYMax  = new TextField("2");
			tNIter = new TextField("100");
			tRD    = new TextField("0");
			tRC    = new TextField("0");
			tGD    = new TextField("0");
			tGC    = new TextField("255");
			tBD    = new TextField("0");
			tBC    = new TextField("0");
	
			//Position and size of all Labels
			lResX.setBounds(10, 40, 100, 20);
			lResY.setBounds(10, 70, 100, 20);
			lXMin.setBounds(10, 100, 100, 20);
			lXMax.setBounds(10, 130, 100, 20);
			lYMin.setBounds(10, 160, 100, 20);
			lYMax.setBounds(10, 190, 100, 20);
			lNIter.setBounds(10, 220, 100, 20);
			lColors.setBounds(10, 280, 70, 20);
			lR.setBounds(10, 310, 40, 20);
			lG.setBounds(10, 340, 40, 20);
			lB.setBounds(10, 370, 40, 20);
			lDiv.setBounds(80, 280, 40, 20);
			lConv.setBounds(150, 280, 40, 20);
	
			//Position and size of all TextFields
			tResX.setBounds(120, 40, 100, 20);
			tResY.setBounds(120, 70, 100, 20);
			tXMin.setBounds(120, 100, 100, 20);
			tXMax.setBounds(120, 130, 100, 20);
			tYMin.setBounds(120, 160, 100, 20);
			tYMax.setBounds(120, 190, 100, 20);
			tNIter.setBounds(120, 220, 100, 20);
			tRD.setBounds(80, 310, 40, 20);
			tRC.setBounds(150, 310, 40, 20);
			tGD.setBounds(80, 340, 40, 20);
			tGC.setBounds(150, 340, 40, 20);
			tBD.setBounds(80, 370, 40, 20);
			tBC.setBounds(150, 370, 40, 20);
	
			//Add all Components to the Frame
			add(lResX);
			add(lResY);
			add(lXMin);
			add(lXMax);
			add(lYMin);
			add(lYMax);
			add(lNIter);
			add(lColors);
			add(lR);
			add(lG);
			add(lB);
			add(lConv);
			add(lDiv);
			add(tResX);
			add(tResY);
			add(tXMin);
			add(tXMax);
			add(tYMin);
			add(tYMax);
			add(tNIter);
			add(tRD);
			add(tRC);
			add(tGD);
			add(tGC);
			add(tBD);
			add(tBC);
	
			//Add Listeners to the Buttons (Including Close Button)
			standard.addActionListener(new Reset(this));
			calc.addActionListener(new Calculate(this));
			addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						System.exit(0);
					}
				});
	
			//Configure Window
			setSize(950, 760);
			setTitle("AXX - Mandelbrot Viewer");
			setLayout(null);
			setVisible(true);
		}
	}

	void calc() {
		//Try to read all values from the color-boxes and calculates color gradients; 
		//display error message on error or call the Mandelbrot.calc() method on success
		try {
			r0   = Integer.parseInt(tRD.getText());
			dr   = Integer.parseInt(tRC.getText()) - r0;
			g0   = Integer.parseInt(tGD.getText());
			dg   = Integer.parseInt(tGC.getText()) - g0;
			b0   = Integer.parseInt(tBD.getText());
			db   = Integer.parseInt(tBC.getText()) - b0;
			resX = Integer.parseInt(tResX.getText());
			resY = Integer.parseInt(tResY.getText());
			img  = new BufferedImage(resX, resY, BufferedImage.TYPE_INT_ARGB);
		} catch (Exception e) {
			System.out.println("Please enter integer values only int the color fields");

			return;
		}

		m.calc(this);
		refresh();
	}

	//Paints the BufferedImage saved in img to the Canvas
	private void refresh() {
		plot.setImg(img);
		plot.repaint();
	}

	//Sets pixel (x,y) to a color calculated from intensity and the values in the color boxes
	public void setPixel(int x, int y, int intensity) {
		int rgb = getColor(intensity);
		img.setRGB(x, resY - y - 1, rgb); //Y-coordinate ist switched, in order to increase from the bottom of the image
	}

	//Getter method for value in Textbox Resolution (x); returns -1 on error
	public int getXResolution() {
		try {
			return Integer.parseInt(tResX.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return -1;
		}
	}

	//Getter method for value in Textbox Resolution (y); returns -1 on error
	public int getYResolution() {
		try {
			return Integer.parseInt(tResY.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return -1;
		}
	}

	//Getter method for value in Textbox X_Min; returns NaN on error
	public double getXMin() {
		try {
			return Double.parseDouble(tXMin.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return Double.NaN;
		}
	}

	//Getter method for value in Textbox X_Max; returns NaN on error
	public double getXMax() {
		try {
			return Double.parseDouble(tXMax.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return Double.NaN;
		}
	}

	//Getter method for value in Textbox Y_Min; returns NaN on error
	public double getYMin() {
		try {
			return Double.parseDouble(tYMin.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return Double.NaN;
		}
	}

	//Getter method for value in Textbox Y_Max; returns NaN on error
	public double getYMax() {
		try {
			return Double.parseDouble(tYMax.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return Double.NaN;
		}
	}

	//Getter method for value in Textbox Iterations; returns -1 on error
	public int getIterations() {
		try {
			return Integer.parseInt(tNIter.getText());
		} catch (Exception e) {
			System.out.println("Please enter valid numbers only!");

			return -1;
		}
	}

	//Setter methods for Textbox Resolution (x)
	void setResX(String s) {
		tResX.setText(s);
	}

	//Setter methods for Textbox Resolution (y)
	void setResY(String s) {
		tResY.setText(s);
	}

	//Setter methods for Textbox X_Min
	void setXMin(String s) {
		tXMin.setText(s);
	}

	//Setter methods for Textbox X_Max
	void setXMax(String s) {
		tXMax.setText(s);
	}

	//Setter methods for Textbox Y_Min
	void setYMin(String s) {
		tYMin.setText(s);
	}

	//Setter methods for Textbox Y_Max
	void setYMax(String s) {
		tYMax.setText(s);
	}

	//Setter methods for Textbox Iterations
	void setIter(String s) {
		tNIter.setText(s);
	}

	//Calculates color from color gradients and intensity
	private int getColor(int intensity) {
		int r = (int) ((dr * (intensity / 255.0)) + r0);
		int g = (int) ((dg * (intensity / 255.0)) + g0);
		int b = (int) ((db * (intensity / 255.0)) + b0);

		return (0xFF << 24) | (r << 16) | (g << 8) | b;
	}
	//Draws COS in center
	public void drawKOS() {
		drawKOS((int)(this.resX/2),(int)(this.resY/2));
	}
	//Draws COS at specific point
	public void drawKOS(int xStart, int yStart) {
		//safe KOS (0/0)
		this.kOSx = xStart;
		this.kOSy = yStart;
		// make it black:
		int tr0 = r0, tg0 = g0, tb0 = b0;
		
		r0 = 0;
		g0 = 0;
		b0 = 0;
		
		//y-axis:
		for (int i = 0; i < this.resX; i++) {
			this.setPixel(yStart, i, 0);
		}
		//x-axis
		for (int i = 0; i < this.resY; i++) {
			this.setPixel(i, xStart, 0);
		}
		// restore
		r0 = tr0;
		b0 = tb0;
		g0 = tg0;
	}
	//Draws Complex Number with specific color
	public void drawComplexInKOS(MyComplexNumber toDraw, Color pointColor) {
		int tr0 = r0, tg0 = g0, tb0 = b0;
		int tdr = dr, tdg = dg, tdb = db;
		dr = 0;
		dg = 0;
		db = 0;
		b0 = pointColor.getBlue();
		r0 = pointColor.getRed();
		g0 = pointColor.getGreen();
		drawPointInKOS((int)(toDraw.getReal()*10), (int) (toDraw.getImag()*10));
		// restore
		r0 = tr0;
		b0 = tb0;
		g0 = tg0;
		dr = tdr;
		dg = tdg;
		db = tdb;
	}
	//Draws Complex Number with specific standard color
	public void drawComplexInKOS(MyComplexNumber toDraw) {
		drawPointInKOS((int)(toDraw.getReal()*10), (int) (toDraw.getImag()*10));
	}
	//Draws Point 
	public void drawPointInKOS(int posX, int posY) {
		drawPointInKOS(posX, posY, 20);
	}
	
	//Draws Point with specific Ball size
	public void drawPointInKOS(int posX, int posY, int size) {
		int hsize = (int) (size/2);
		posX = this.kOSx + posX;
		posY = this.kOSy + posY;
		for (int j = posY - hsize; j < posY + hsize; j++) {
			for (int i = posX - hsize; i < posX + hsize; i++) {
				if ( Math.sqrt(  Math.pow((j - posY ) ,2 ) + Math.pow((i - posX ) ,2 )) < hsize ) {
					this.setPixel(i, j, 255);
				}
			}
		}
	}
	//Draws Unitcircle with cn on it
	public void drawUnitCircleOfComplex(MyComplexNumber cn) {
		drawCircleOfComplex(cn);
	}
	//Draws Unitcircle with cn on it
	public void drawCircleOfComplex(MyComplexNumber cn) {
		drawCircleOfComplex(cn.magnitude());
	}
	//Draws Circle with specific radius
	public void drawCircleOfComplex(double radius) {
		drawCircle(this.kOSx, this.kOSy, radius * 10);
	}
	
	//Draws Circle with specific radius at specific position
	public void drawCircle(int posX, int posY, double radius) {
		
		// make it black:
		int tr0 = r0, tg0 = g0, tb0 = b0;
		r0 = 0;
		g0 = 0;
		b0 = 0;
		
		int witdh = 1; // staerke des Kreises
		for (int j = posY - (int) radius - witdh; j < posY + radius + witdh; j++) {
			for (int i = posX - (int) radius - witdh; i < posX + radius + witdh; i++) {
				double euklid = Math.sqrt(  Math.pow((j - posY ) ,2 ) + Math.pow((i - posX ) ,2 ));
				//outer && inner
				if ( euklid < (radius + witdh) && euklid > (radius - witdh)) {
					this.setPixel(i, j, 0);
				}
			}
		}
		// restore
		r0 = tr0;
		b0 = tb0;
		g0 = tg0;
	}
	//returns an array with Complex Numbers representing PI
	public MyComplexNumber[] figurePI() {
		MyComplexNumber startH = new MyComplexNumber(-5,5);
		MyComplexNumber startV1 = new MyComplexNumber(2.5,-5);
		MyComplexNumber startV2 = new MyComplexNumber(-2.5,-5);
		double every = 0.66;
		int numberPoints = 45;
		MyComplexNumber[] pi = new MyComplexNumber[numberPoints];
		//Horizontal
		for (int i = 0; i < pi.length/3; i++) {
			if(i==0) {
				pi[i] = startH.add(new MyComplexNumber(i*every, 0).add(new MyComplexNumber(0, -0.5)));
			}
			else {
				pi[i] = startH.add(new MyComplexNumber(i*every, 0));
			}
		}
		//Vertikal 1
		for (int i = 0; i < pi.length/3; i++) {
			
				pi[i+(int)(numberPoints/3)] = startV1.add(new MyComplexNumber(0, i*every));
			
		}
		//Vertikal 2
		for (int i = 0; i < pi.length/3; i++) {
			if (i==0) {
				pi[i+(int)(numberPoints*2/3)] = startV2.add(new MyComplexNumber(0, i*every)).add(new MyComplexNumber(-0.5,0.2)) ;
			}
			else {
				pi[i+(int)(numberPoints*2/3)] = startV2.add(new MyComplexNumber(0, i*every));
			}
		}
		
		return pi;
		
	}
	
}


class Reset implements ActionListener {
	Window w;

	Reset(Window w) {
		this.w = w;
	}

	public void actionPerformed(ActionEvent e) {
		w.setResX("700");
		w.setResY("700");
		w.setXMin("-2.5");
		w.setXMax("1.5");
		w.setYMin("-2");
		w.setYMax("2");
		w.setIter("100");
	}
}


class Calculate implements ActionListener {
	Window w;

	Calculate(Window w) {
		this.w = w;
	}

	public void actionPerformed(ActionEvent e) {
		w.calc();
	}
}


@SuppressWarnings("serial")
class Plot extends Canvas {
	private BufferedImage img;

	Plot() {
		img = null;
	}

	public void paint(Graphics g) {
		if (img != null) {
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
}
