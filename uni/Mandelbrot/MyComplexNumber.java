package Mandelbrot;

public class MyComplexNumber {

    private double real;
    private double imag;

    private static double real_temp;
    private static double imag_temp;

    public MyComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double magnitude() {
        double magnitude = Math.pow(Math.pow(real, 2) + Math.pow(imag, 2), 0.5);
        return magnitude;
    }

    public double getImag() {
        return imag;
    }

    public double getReal() {
        return real;
    }

    public MyComplexNumber add(MyComplexNumber c) {
        real_temp = real + c.real;
        imag_temp = imag + c.imag;
        return new MyComplexNumber(real_temp, imag_temp);
    }

    // minus
    public MyComplexNumber subtract(MyComplexNumber c) {
        /** Order mathers
         * c1 - c2
         */
        real_temp = real - c.real;
        imag_temp = imag - c.imag;
        return new MyComplexNumber(real_temp, imag_temp);
    }

    // product
    public MyComplexNumber multiply(MyComplexNumber c) {
        /** Order mathers
         * c1 * c2
         */
        // (a + bi) * (c + di) = ac - bd + (ad + bc) * i
        // a, c = real
        // b, d = imag

        real_temp = real * c.real - imag * c.imag;
        imag_temp = real * c.imag + imag * c.real;

        return new MyComplexNumber(real_temp, imag_temp);
    }

    // divide
    // product
    public MyComplexNumber divide(MyComplexNumber c) {
        /** Order mathers
         * c1 / c2
         */
        /*
            (a + bi) / (c + di)
          = (ac + bd)/(c2 + d2) + (bc - ad)/(c2 + d2) * i
         */
        // a, c = real
        // b, d = imag

        double denominator = Math.pow(c.real, 2) + Math.pow(c.imag, 2);

        real_temp = (real * c.real + imag * c.imag) / denominator;
        imag_temp = (imag * c.real - real * c.imag) / denominator;

        return new MyComplexNumber(real_temp, imag_temp);
    }

    // print
    @Override
    public String toString() {
        return new StringBuilder("(").append(real).append(",").append(imag).append(")").toString();
    }
}
