import java.util.*;

public class Area {

    private double length, height;

    public Area(double length, double height){
        this.setDim(length, height);
    }

    public Area(){
        this.setDim();
    }

    public void setDim() {

        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the length: ");
        length = s.nextDouble();

        System.out.println("Please enter the height: ");
        height = s.nextDouble();

    }

    public void setDim(double length, double height) {
        this.length = length;
        this.height = height;
    }

    public double getArea() {
        double area = length*height;
        return area;
    }

}
