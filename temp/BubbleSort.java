public class BubbleSort {

    public static int[] randomSequence;

    public static void main(String[] args) {
        int[] sortedSequence;
        int x = 5; // length of array
        randomSequence = generateNewRandomArray(x);

        System.out.println("\nRandomly generated sequence");
        printArrayToConsole(randomSequence);

        sortedSequence = sortArray(randomSequence);

        System.out.println("\nOriginal sequence"); printArrayToConsole(randomSequence);
        System.out.println("\nSorted sequence"); printArrayToConsole(sortedSequence);
        System.out.println("\nOriginal sequence is still UNCHANGED "); printArrayToConsole(randomSequence);
        // showing no side-effect: original array has remained UNCHANGED
    }

    // returns a new int-array of length x, filled with random INTEGER NUMBERS in range between 1 and 1000
    public static int[] generateNewRandomArray(int x){
        int[] arr = new int[x];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int) (1 + 1000*Math.random());
        }
        return arr;
    }

    // print out any int-array
    public static void printArrayToConsole(int[] x){
        System.out.print("> ");
        for(int element : x) {
            System.out.print(element+" ");
        }
    }

    // bubble sorting algorithm
    public static int[] sortArray(int[] a){

        // c is clone of integer array "a"
        int[] c = a.clone();

        boolean flagChg = true;
        int temp = 0;
        for(int n = c.length-1; n>=1 && flagChg; n--){
            for(int i=0; i<n; i++){
                if(c[i]>c[i+1]){
                    temp = c[i];
                    c[i] = c[i+1];
                    c[i+1] = temp;
                    flagChg = true;
                }
            }
        }
        return c;
    }
}

