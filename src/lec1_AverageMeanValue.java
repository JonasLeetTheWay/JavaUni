public class lec1_AverageMeanValue {
    public static void main(String[] args) {

        System.out.println( meanValueComputation1() );
        System.out.println( meanValueComputation2() );

    }
    public static double meanValueComputation1(){
        double a = 5;
        double i = 2;
        return a/i;
    }
    public static double meanValueComputation2() {
        double sum = 0;
        double j = 0;
        double meanValue = 0;
        double val;
        do {
            val = Math.round (100*Math.random() );
            if (val == 0 & j != 0) {
                meanValue = sum / j;
            }
            sum += val;
            j += 1;
        } while (val != 0);
        return meanValue;
    }
}
