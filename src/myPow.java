public class myPow {
    public static void main(String[] args) {
        double val;
        int n;
        val = 3; n = 5;
        powMethod(val,n);
    }

    static double powMethod(double val, int n){
        int i = 0;
        i++;
        if(n==0){
            System.out.println("p1");
            return 1;
        }
        else if(n==1){
            System.out.println("p2");
            System.out.println("p2's n: "+n);
            return n;
        }
        else if(n<0){
            System.out.println("p3");
            return 1 / powMethod(val,-n);
        }
        else{
            System.out.println("p4");
            //System.out.println("no. "+i);
            System.out.println("\t"+val+"--"+n);
            System.out.println("\t\t"+val * powMethod(val,n-1));
            return val * powMethod(val,n-1);
        }
    }
}
