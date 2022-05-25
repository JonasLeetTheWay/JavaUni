import java.io.FileWriter;
import java.io.IOException;

public class JavaToMaple {

    //global variables to save the trajectory data
    public static double t[] = new double[150]; //time
    public static double x[] = new double[150]; //x-coordinate
    public static double y[] = new double[150]; //y-coordinate

    //... space for other global variables

    /**
     * Method for printing the global t, x and y- coordinate pairs
     * to the console
     */
    public static void printToConsole() {
        for (int i = 0; i < t.length; i++) {
            System.out.printf("%s, %s, %s",t[i],x[i],y[i]);
            System.out.println();
        }

    }

    /**
     * Method for calculating the trajectory
     */
    public static void calc(double v0, double dt, double ang) {
        double rad = ang / 180 * Math.PI; // degree -> rad conversion
        double ti = 0;
        final double G = 9.81;

        double roundoff = 100;

        for (int i = 0; i < t.length; i++) {
            x[i] = Math.rint(v0 * ti * Math.cos(rad) * roundoff) / roundoff;
            y[i] = Math.rint((v0 * ti * Math.sin(rad) - 0.5 * G * ti * ti) * roundoff) / roundoff;
			t[i] = Math.rint(ti * roundoff) / roundoff;
			ti += dt; // update time at every step
        }
    }

    public static void main(String[] args) {

        // example for parsing the first input parameter
        // Warning: program will crash if no input parameter is given

        System.out.println("Please enter the arguments in the following order,\n" +
                "Every argument you enter must be separated by a white-space:\n" +
                "\nstarting velocity (m/s)" +
                "\ntime difference between 2 consecutive computations (s)" +
                "\nlaunch angle (degree)" +
                "\n" +
                "\nExample:" +
                "\n50 0.05 30");
        //...implement further parsing and evaluation of args
//        double v0 = Double.parseDouble(args[0]);
//        double dt = Double.parseDouble(args[1]);
//        double ang = Double.parseDouble(args[2]);

        //calling methods
        calc(50, 0.05, 30);
        printToConsole();

        //saving the elements to the maple worksheet
        //uncomment to save to the maple sheet
        //for Automator-turn-in this must be commented out
        // (writing files is not allowed in test environment)
//		saveMaple("throw");
    }

    /**
     * Method that creates a new Maple-work sheet. (.mw file)
     * This method is complete! The details are not mandatory to be understood.
     *
     * @param title - Name that the new Maple File will get
     */
    public static void saveMaple(String title) {

        String plot = "restart; with(plots):A:=<<";

        //try-catch block: not relevant for exam,
        //but the preferred way to handle possible exceptions in JAVA
        //in this case if the computer fails to write a file for some reason
        try {
            //a class of the package IO for writing to text files
            FileWriter w = new FileWriter(title + ".mw");

            int i = 0;
            for (i = 0; i < t.length - 1; i++) {
                plot = plot + x[i] + ",";
            }
            plot = plot + x[i] + ">|<";

            for (i = 0; i < t.length - 1; i++) {
                plot = plot + y[i] + ",";
            }

            plot = plot + y[i] + ">>:";
            plot = plot + "pointplot(A,color=blue,symbol=cross,labels=[distance,height]);";

            w.append(plot);
            w.flush();
            w.close();

            System.out.println("\nFile saved as " + title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
