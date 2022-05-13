package Mandelbrot;

import org.junit.*;
import static org.junit.Assert.*;

public class MyComplexNumberTest{
	private static double  real1, real2, imag1, imag2;
	
	@Before
	public void setUpTestCase(){
		real1 = 100*(Math.random()-0.5);
		real2 = 100*(Math.random()-0.5);
		imag1 = 100*(Math.random()-0.5);
		imag2 = 100*(Math.random()-0.5);
	}

	@Test
	public void MyComplexNumberCreationTest(){
		
		boolean creationSuccesfull = false;
		MyComplexNumber c1;
		try{
			c1 = new MyComplexNumber(real1, imag1);
			creationSuccesfull = true;
			assertTrue("could not getReal() Value correctly. Set increation: " + 
				real1 + "returned Value: " + c1.getReal(), (c1.getReal()==real1));
			assertTrue("could not getImag() Value correctly. Set increation: " + 
				imag1 + "returned Value: " + c1.getImag(), (c1.getImag()==imag1));
			
		}catch(Exception E){}

		assertTrue("Could not instantiate a complex number with two doulbe values",creationSuccesfull);
		
		
	}
	
	@Test
	public void MyComplexNumberAdditionTest(){
		MyComplexNumber c1 = new MyComplexNumber(real1, imag1);
		MyComplexNumber c2 = new MyComplexNumber(real2, imag2);

		double result_real = real1+real2;
		double result_imag = imag1+imag2;

		assertTrue("Addition test failed", (Math.abs(result_real-c1.add(c2).getReal()) <= 0.001 && Math.abs(result_imag-c1.add(c2).getImag()) <= 0.001));
	}
	@Test
	public void MyComplexNumberSubtractionTest(){
		MyComplexNumber c1 = new MyComplexNumber(real1, imag1);
		MyComplexNumber c2 = new MyComplexNumber(real2, imag2);

		double result_real = real1-real2;
		double result_imag = imag1-imag2;

		assertTrue("Subtraction test failed", (Math.abs(result_real-c1.subtract(c2).getReal()) <= 0.001 && Math.abs(result_imag-c1.subtract(c2).getImag()) <= 0.001));
	}
	@Test
	public void MyComplexNumberMultplicationTest(){
		MyComplexNumber c1 = new MyComplexNumber(real1, imag1);
		MyComplexNumber c2 = new MyComplexNumber(real2, imag2);

		double result_real = real1*real2 - imag1*imag2;
		double result_imag = real1*imag2 + imag1*real2;

		assertTrue("Multiplication test failed", (Math.abs(result_real-c1.multiply(c2).getReal()) <= 0.001 && Math.abs(result_imag-c1.multiply(c2).getImag()) <= 0.001));
	}
	@Test
	public void MyComplexNumberDivisionTest(){
		MyComplexNumber c1 = new MyComplexNumber(real1, imag1);
		MyComplexNumber c2 = new MyComplexNumber(real2, imag2);

		double result_real = (real1*real2+imag1*imag2)/(real2*real2+imag2*imag2);
		double result_imag = (imag1*real2-real1*imag2)/(real2*real2+imag2*imag2);

		assertTrue("Division test failed", (Math.abs(result_real-c1.divide(c2).getReal()) <= 0.001 && Math.abs(result_imag-c1.divide(c2).getImag()) <= 0.001));
	}
	@Test
	public void MyComplexNumberMagnitudeTest(){
		MyComplexNumber c = new MyComplexNumber(real1, imag1);

		double result = Math.sqrt(real1*real1+imag1*imag1);

		assertTrue("Magnitude test failed", (Math.abs(c.magnitude()-result) <= 0.01));
	}
}