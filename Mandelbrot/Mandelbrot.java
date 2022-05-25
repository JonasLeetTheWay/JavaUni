public class Mandelbrot{
	public Mandelbrot(boolean test){
		if(!test){
			Window w = new Window(this);
		}
	}

	public static void main(String[] args){
		Mandelbrot m = new Mandelbrot(false);
	}
	
	public void calc(Window w){
		
		System.out.print("Berechne Zahlen...");
		int resX = w.getXResolution();
		int resY = w.getYResolution();
		double xMin = w.getXMin();
		double xMax = w.getXMax();
		double yMin = w.getYMin();
		double yMax = w.getYMax();
		int n_iter = w.getIterations();

		double stepsizeX = (xMax-xMin)/(resX-1);
		double stepsizeY = (yMax-yMin)/(resY-1);

		int n;
		
		for(int x=0; x<resX; x++){
			for(int y=0; y<resY; y++){
				MyComplexNumber c = new MyComplexNumber(x*stepsizeX+xMin, y*stepsizeY+yMin);
				MyComplexNumber z = new MyComplexNumber(0,0);
				n = 0;
				while(z.magnitude() <= 2 && ++n < n_iter){
					z = z.multiply(z).add(c);
				}
				w.setPixel(x,y,(int)(255.0*n/n_iter));
			}
		}


		System.out.println("Fertig!");
	}
}
