public class MyComplexNumber {

    private double real;
    private double imag;

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

        return new MyComplexNumber(real + c.getReal(), imag + c.getImag());
    }

    // minus
    public MyComplexNumber subtract(MyComplexNumber c) {
        /** Order mathers
         * c1 - c2
         */
        return new MyComplexNumber(real - c.getReal(), imag - c.getImag());
    }

    // product
    public MyComplexNumber multiply(MyComplexNumber c) {
        /** Order mathers
         * c1 * c2
         */
        // (a + bi) * (c + di) = ac - bd + (ad + bc) * i
        // a, c = real
        // b, d = imag

        return new MyComplexNumber(real * c.getReal() - imag * c.getImag(), real * c.getImag() + imag * c.getReal());
    }

    // divide
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

        double denominator = Math.pow(c.getReal(), 2) + Math.pow(c.getImag(), 2);

        return new MyComplexNumber((real * c.getReal() + imag * c.getImag()) / denominator, (imag * c.getReal() - real * c.getImag()) / denominator);
    }

}
