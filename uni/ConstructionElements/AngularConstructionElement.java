package ConstructionElements;

public class AngularConstructionElement {

    private double sideLength;

    public static void main(String[] args) {

    }
    public void setSideLength(double newSideLength) {
        sideLength = newSideLength;
    }
    public double getSideLength() {
        return sideLength;
    }
}

/**
 * First create the class AngularConstructionElement and its descending
 * classes. Since the MassCalculationprogramm exentsivly uses the polymorphism feature
 * of Java, you will need to override calculateVolume()- and getValuesFromConsoleInput()
 * methods so they are valid for the individual classes. The getValuesFromConsoleInput()
 *
 * instance method is supposed to get the minimal needed geometric information from user in-
 * put on the shell console and save it in the object. The setAttributes(...) methoden is not
 *
 * always overridden but sometime overloaded, since different construction part types have dif-
 * fering number of attributes that are needed to calculate their volume and thus, together with
 *
 * the density, to calculate their mass. The attributes of a class are partly individually defined
 * in the class and partly inherited from the super-classes.
 * • Cuboids need density, and length, height, and width.
 * • Wedge) also require density, and length, height, and width
 * • Pyramids need density) and sideLength and height
 * Note: As is standard in CAD and other technical drawings (at least in most parts of the world)
 * the measuring units for length is in mm while the unit for mass is in kg.
 */
