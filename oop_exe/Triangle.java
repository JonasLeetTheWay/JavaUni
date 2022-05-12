public class Triangle {

    public int a, b, c;
    private int perimeter;
    private double area;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.area = getArea();
        this.perimeter = getPerimeter();
    }

    public double getArea() {
        double s = (a + b + c) / 2.0;
        double area = Math.pow((s * (s - a) * (s - b) * (s - c)), 0.5);
        return area;
    }

    public int getPerimeter() {
        int perimeter = a + b + c;
        return perimeter;
    }

    public void setDim(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

}
