public class main extends Matrix{

    public static void main(String[] args)
    {
        /*
        Triangle tri = new Triangle(3,4,5);
        System.out.println(tri.getArea());
        System.out.println(tri.getPerimeter());

        Area rect1 = new Area(4,5);
        Area rect2 = new Area(5,8);
        System.out.println(rect1.getArea());
        System.out.println(rect2.getArea());

        Average avg = new Average(10,20);
        System.out.println(avg.getAverage());

        Complex c1 = new Complex(2,3);
        Complex c2 = new Complex(4,5);
        Complex c3 = Complex.divide(c1,c2);
        System.out.println(c3);

        Employee e1 = new Employee("Robert", 1994, "64C");
        Employee e2 = new Employee("Sam", 2000, "64C");
        Employee e3 = new Employee("John", 1999, "64C");

        System.out.println("Name \t Year of Joining \t Address");
        Employee.printEmployees(e1,e2,e3);
        */

//        Matrix mat1 = new Matrix(3,2);
//        mat1.fill(1);
//        Matrix mat2 = new Matrix(2,3);
//        mat2.fill(1);
//        mat2.set(0,0,2);


//        double[][] list = {{3,4},{7,2},{5,9}};
//        double[][] list2 = {{3,1,5},{6,9,7}};

        double[][] list = {{3, 4}, {7, 2}, {5, 9}};
        double[][] list2 = {{3, 1, 5}, {6, 9, 7}};

        Matrix mat1 = new Matrix(list);
        Matrix mat2 = new Matrix(list2);

        printMatrices( mat1, mat2, new Matrix(new double[][]{{1},{1}}), times(mat1,mat2,1) );

        

    }



}
