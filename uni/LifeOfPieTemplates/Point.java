package LifeOfPieTemplates;

public class Point {

    private double x, y;
    private double norm;

    public Point(double x, double y) {
        this.x = getX();
        this.y = getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double norm() {
        double x_square = Math.pow(x, 2);
        double y_square = Math.pow(y, 2);
        norm = Math.pow(x_square + y_square, 0.5);
        return norm;
    }

    public static Point generateRandom(int xy){
        return new Point( (xy * Math.random()), (xy * Math.random()));
    }
}
