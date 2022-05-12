public class Complex {

    public double real;
    public double imag;

    private static double real_temp;
    private static double imag_temp;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // add
    public Complex add(Complex c) {
        real_temp = real + c.real;
        imag_temp = imag + c.imag;
        return new Complex(real_temp, imag_temp);
    }

    // minus
    public Complex minus(Complex c) {
        /** Order mathers
         * c1 - c2
         */
        real_temp = real - c.real;
        imag_temp = imag - c.imag;
        return new Complex(real_temp, imag_temp);
    }

    // product
    public Complex times(Complex c) {
        /** Order mathers
         * c1 * c2
         */
        // (a + bi) * (c + di) = ac - bd + (ad + bc) * i
        // a, c = real
        // b, d = imag

        real_temp = real * c.real - imag * c.imag;
        imag_temp = real * c.imag + imag * c.real;

        return new Complex(real_temp, imag_temp);
    }

    // divide
    // product
    public Complex divide(Complex c) {
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

        return new Complex(real_temp, imag_temp);
    }

    // print
    @Override
    public String toString() {
        return new StringBuilder("(").append(real).append(",").append(imag).append(")").toString();
    }

    public double getImag() {
        return imag;
    }

    public double getReal() {
        return real;
    }

    public static Complex add(Complex c1, Complex c2) {

        real_temp = c1.real + c2.real;
        imag_temp = c1.imag + c2.imag;
        return new Complex(real_temp, imag_temp);
    }

    // minus
    public static Complex minus(Complex c1, Complex c2) {
        /** Order mathers
         * c1 - c2
         */
        real_temp = c1.real - c2.real;
        imag_temp = c1.imag - c2.imag;
        return new Complex(real_temp, imag_temp);
    }

    // product
    public static Complex times(Complex c1, Complex c2) {
        /** Order mathers
         * c1 * c2
         */
        // (a + bi) * (c + di) = ac - bd + (ad + bc) * i
        // a, c = real
        // b, d = imag

        real_temp = c1.real * c2.real - c1.imag * c2.imag;
        imag_temp = c1.real * c2.imag + c1.imag * c2.real;

        return new Complex(real_temp, imag_temp);
    }

    // divide
    public static Complex divide(Complex c1, Complex c2) {
        /** Order mathers
         * c1 / c2
         */
        /*
            (a + bi) / (c + di)
          = (ac + bd)/(c2 + d2) + (bc - ad)/(c2 + d2) * i
         */
        // a, c = real
        // b, d = imag

        double denominator = Math.pow(c2.real, 2) + Math.pow(c2.imag, 2);

        real_temp = (c1.real * c2.real + c1.imag * c2.imag) / denominator;
        imag_temp = (c1.imag * c2.real - c1.real * c2.imag) / denominator;

        return new Complex(real_temp, imag_temp);
    }


}
