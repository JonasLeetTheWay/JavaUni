import java.util.*;
import java.util.stream.Collectors;

public class arrExe__1_to_20 {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 20, 20, 30, 30, 30, 20, 20, 10, 10, 10, 10, 10, 20, 30,40,50,50,050,50,50,1};
//        int[] arr = generateRandomArray(20);
        String[] str1 = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};
        String[] str2 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};

        // ArrayList<Integer> -> .toArray() -> Arrays.toString()
//        System.out.println(Arrays.toString(convertIntArray2ArrayList(arr).toArray()));
        // ArrayList<String> -> .toArray() -> Arrays.toString()
//        System.out.println(Arrays.toString(convertStringArray2ArrayList(str1).toArray()));

        System.out.println(Arrays.toString(removeDuplicateWithResizing(arr)));

//        System.out.println(sumVal(arr));
//        System.out.println(avgVal(arr));
//        printGrid(10, 10);
//        System.out.println(valExistenceByBinarySearch(arr, 10));
//        System.out.println(valIndexByBinarySearch(arr, 10));
//        System.out.println(Arrays.toString(valRemover(arr, 5)));
//        System.out.println(Arrays.toString(arrCopy(arr)));
//        System.out.println(Arrays.toString(reverseArr(arr)));
//        findDuplicateTimesByHashSet(arr);                                         // BUG
//        System.out.println(findCommonString(str1,str2));
//
//        System.out.println(Arrays.toString(removeDuplicateWithResizing(arr)));    // BUG
//        System.out.println(Arrays.toString(sortedLargestByHashSet2(arr)));          // BUG

//        System.out.println(Arrays.toString(arr));
//        sortedUniqueArray(arr, 1, "largest");

//        int[][] a = generateRandomMatrix(2,2);
//        int[][] b = generateRandomMatrix(2,2);
//        int[][] c = addMatrix(a,b);
//        printMatrix(a);
//        printMatrix(b);
//        printMatrix(c);
//        printMatrix( putArrayIntoMatrix(arr) );

    }

    public static int sumVal(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    public static double avgVal(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return (double) (sum / arr.length);
    }

    public static void printGrid(int horLen, int vertLen) {
        System.out.println();
        for (int i = 0; i < horLen; i++) {
            for (int j = 0; j < vertLen; j++) {
                System.out.print("- ");
            }
            System.out.println();
        }
    }

    public static void printGrid2(int horLen, int vertLen) {
        System.out.println();
        StringBuilder str_blr = new StringBuilder();
        for (int i = 0; i < horLen; i++) {
            for (int j = 0; j < vertLen; j++) {
                str_blr.append("- ");
            }
            System.out.println(str_blr.toString());
            str_blr.setLength(0);
        }
    }

    public static boolean valExistenceByBinarySearch(int[] arr, int target) {
        if (arr.length == 0) return false;

        int low = 0;
        int high = arr.length - 1;
        int idx = (low + high) / 2; // default idx is median

        while (low <= high) {
            if (arr[idx] == target) {
                return true;
            } else if (arr[low] < target) {
                low = idx + 1;
                idx = (low + high) / 2;
            } else if (arr[low] > target) {
                high = idx - 1;
                idx = (low + high) / 2;
            }
        }
        return false;
    }

    public static int valIndexByBinarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1; // -1 = not found

        int low = 0;
        int high = arr.length - 1;
        int idx = (low + high) / 2;

        while (low <= high) {
            if (arr[idx] == target) {
                return idx;
            } else if (arr[idx] < target) {
                low = idx + 1;
                idx = (low + high) / 2;
            } else if (arr[idx] > target) {
                high = idx - 1;
                idx = (low + high) / 2;
            }
        }
        return -1;
    }

    public static int[] valRemover(int[] arrI, int idx) {
        if (arrI.length == 0) return arrI;

        int[] arr = arrI.clone();

        for (int i = idx; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return arr;
    }

    public static int[] arrCopy(int[] arrI) {
        int[] arr = new int[arrI.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrI[i];
        }
        return arr;
    }

    public static int[] reverseArr(int[] arrI) {
        int[] arr = arrI.clone();

        for (int i = 0; i <= arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static void findDuplicateTimesByHashSet(int[] arr) {
        int timesCount = 0;
        int duplicateNum = 0;
        HashSet<Integer> hash = new HashSet<Integer>();
        int duplicateNumSize = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (!hash.contains(arr[j]) & arr[i] == arr[j]) {
                    timesCount += 1;
                    duplicateNum = arr[j];
                    System.out.println("Duplicate number is " + duplicateNum + ". Appears count: " + timesCount);
                } else if (hash.contains(arr[j]) & j + 1 < duplicateNumSize) {
                    if (arr[j] != arr[j + 1]) {
                        timesCount += 1;
                        System.out.println("Duplicate number is " + duplicateNum + ". Appears count: " + timesCount);
                    }
                }
                hash.add(arr[j]);
                duplicateNumSize = hash.size(); // track hash size that already has DuplicateNum
            }
        }
        if (timesCount == 0) System.out.println("Duplicate number is not found.");
    }

    public static HashSet<String> findCommonString(String[] arr1, String[] arr2) {
//        StringBuilder str_blr = new StringBuilder(); // not separated by commas
        HashSet<String> set = new HashSet<String>(); // separated by commas
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    set.add(arr1[i]);
//                    str_blr.append(arr1[i]);
                }
            }
        }
        return set;
    }

    public static int[] removeDuplicate(int[] arr) {
        HashSet<Object> hash = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (hash.contains(arr[i])) {
                arr[i] = 0;
            }
            hash.add(arr[i]);
        }
        return arr;
    }

    public static int[] removeDuplicateWithResizing(int[] arr) {
        // assuming all elements are unique
        int no_unique_elements = arr.length;
        for (int i = 0; i < no_unique_elements; i++) {
            for (int j = i + 1; j < no_unique_elements; j++) {
                if (arr[i] == arr[j]) {
                    // replace duplicate element with last unique element
                    arr[j] = arr[no_unique_elements - 1];
                    no_unique_elements--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(arr, no_unique_elements);
    }

    public static Object[] sortedLargestByHashSet(int[] arr) {
        int temp = 0;
        Set<Integer> sortedLargest = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (!sortedLargest.contains(arr[j]) & temp < arr[j]) {
                    temp = arr[j];
                }
                sortedLargest.add(temp);
            }
        }
        Integer[] sortedLargestArray = sortedLargest.toArray(new Integer[sortedLargest.size()]);
//        return new int[][]{sortedLargestArray};
        System.out.println("Sorted-Largest Arrays is:\n" + Arrays.toString(sortedLargestArray));
        System.out.print("Pick largest by indexing (0=largest,1=2nd largest) : ");
        Scanner scn = new Scanner(System.in);
        int idxLargest = scn.nextInt();


        System.out.println("You have selected no_" + idxLargest + " largest.");
        return new Integer[]{sortedLargestArray[idxLargest]};
    }

    public static Object[] sortedLargestByHashSet2(int[] arr) {
        int temp = 0;
        HashSet<Integer> sortedLargest = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (!sortedLargest.contains(arr[j]) & temp < arr[j]) {
                    temp = arr[j];
                }
                sortedLargest.add(temp);
            }
        }
        return sortedLargest.toArray();
    }

    public static void sortedUniqueArray(int[] arrI, int idxI, String key) {
        // arr: input array
        // idx: rank of largest or smallest
        // switch key: largest or smallest
        Set set = new HashSet();
        int idx = 0;

        for (int i : arrI) {
            // add unique elements to set
            set.add(i);
        }
        // initialize empty array with number of unique elements
        int[] arr = new int[set.size()];
        // update idx based on "key", to find largest or smallest
        if (key.equals("largest")) {
            idx = arr.length - idxI;
        } else if (key.equals("smallest")) {
            idx = idxI - 1;
        }

        Iterator itr = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            arr[i] = (int) itr.next();
        }

        System.out.println("The unsorted unique array:\n" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("The sorted unique array:\n" + Arrays.toString(arr));
        System.out.println("The no" + idxI + " " + key + " element in sorted unique array:\n" + arr[idx]);
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (1 + 1000 * Math.random());
        }
        return arr;
    }
    public static int[][] generateRandomMatrix(int m, int n){
        // m: row number
        // n: col number
        // initialize empty matrix
        int[][] mat = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] = (int) (1 + 10*Math.random());
            }
        }
        return mat;
    }
    public static void printMatrix(int[][] mat){
        for (int i=0; i<mat.length; i++){
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println();
    }
    public static int[][] addMatrix(int[][] a, int[][] b){
        // a, b must be of same size
        int[][][] mats = {a,b};
        int[][] sum = new int[a.length][a[0].length];
        for (int j = 0; j < a.length; j++) {
            for (int k=0; k < a[j].length; k++){
                sum[j][k] = mats[0][j][k]+mats[1][j][k];
            }
        }
        return sum;
    }
    public static int[][] putArrayIntoMatrix(int[] arr){
        return new int[][]{arr};
    }

    public static ArrayList<Integer> convertIntArray2ArrayList (int[] arr){
        return Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
    public static ArrayList<String> convertStringArray2ArrayList (String[] arr){
        return new ArrayList<String>(Arrays.asList(arr));
    }



}
