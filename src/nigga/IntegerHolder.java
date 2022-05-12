package nigga;


public class IntegerHolder {

    static int commonValue = 1;  // class-level
    int instanceValue = 100; // class's instance-level

    void changeCommon() {
        commonValue += 1;
        instanceValue += 10;
    }

    public static void main(String[] args) {
        IntegerHolder hold_a = new IntegerHolder();
        hold_a.instanceValue = 4400;
        IntegerHolder hold_b = new IntegerHolder();
        hold_b.instanceValue = 3300;

        hold_a.changeCommon();
        hold_b.changeCommon();

        System.out.println(commonValue);
        System.out.printf("a val = %s\n", hold_a.instanceValue);
        System.out.printf("b val = %s\n", hold_b.instanceValue);
    }

//    public static int[] randomSequence = {1,2};
//
//
//    public static void accessOther() {
//    }
}