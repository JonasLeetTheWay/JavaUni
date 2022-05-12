import java.util.*;

public class Pair {

    static boolean isEqualsIgnoreOrder(int[] a, int[] b) {
            /*
              method 1: sort a and sort b, compare one by one (time: O(NlogN + N) = O(NlogN)
              HEAPSORT QUICKSORT merge sort, quick sort, mix quick sort and insertion sort --> TimSort: java and python
               main consideration stable sort
               Person array
               Person -> name, age
               you want to sort Person[] base on age, like Person[]{e, b, c, d, a}
               , when b c d age equal, stable: ensure sorted Person[] in the order as is
//              method 2: double for loop, two pointers from the beginning to the end
              method 2: count map, HashMap<Integer, Integer>, key = values in array, value = occurrence in array: O(N)
             */
        // [ 2 4 5 8 7 5 4 3 ]

        HashMap<Integer, Integer> countMap = new HashMap<>();  // key is element, value is count
        // a
        for (int ele : a) {
            if (!countMap.containsKey(ele)) {
                countMap.put(ele, 0);
            }
            countMap.put(ele, countMap.get(ele) + 1);
        }
        // a
        for (int ele : b) {
            if (!countMap.containsKey(ele)) {
                countMap.put(ele, 0);
            }
            countMap.put(ele, countMap.get(ele) - 1);
        }
        for (int key : countMap.keySet()) {
            if (countMap.get(key) != 0) return false;
        }
        return true;
    }

//        if (false) {
//
//            HashMap<Integer, Integer> countMap2 = new HashMap<>();  // key is element, value is count
//            for (int ele : b) {
//                if (!countMap2.containsKey(ele)) {
//                    countMap2.put(ele, 0);
//                }
//                countMap2.put(ele, countMap2.get(ele) + 1);
//            }
//            for (int key : countMap.keySet()) {
//                if (!countMap2.containsKey(key)) return false;
//                if (!Objects.equals(countMap.get(key), countMap2.get(key))) return false;
//            }
//            return true;
//        }

    int x, y, z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public boolean equals(Object obj) {  // a b c, a c b, b a c, b c a, c a b, c b a
        Pair o = (Pair) obj;
        if (o != null) {
//            return o.x == this.x && o.y == this.x && o.z == this.x ||
//                    o.x == this.x && o.y == this.z && o.z == this.y ||
//                    o.x == this.y && o.y == this.x && o.z == this.z ||
//                    o.x == this.y && o.y == this.z && o.z == this.x ||
//                    o.x == this.z && o.y == this.x && o.z == this.y ||
//                    o.x == this.z && o.y == this.y && o.z == this.x;
            return isEqualsIgnoreOrder(new int[]{x, y, z}, new int[]{o.x, o.y, o.z});
        }
        return false;
    }

    @Override
    public int hashCode() {
        // if a equals b, a hash must equal b hash
        // if a hash equal b hash, a and b may differ
//        return Objects.hash(x, y, z);
        return 0;
    }

    @Override
    public String toString() {
        return "{" + this.x + "," + this.y + "," + this.z + "}";
    }

    public static Set<Pair> twoSumPairs (int[] arr, int targetSum) {
        Set<Pair> output = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int num : arr){

            int complement = targetSum - num;

            if (visited.contains(num)){
                output.add(new Pair(num, complement));

            } else {
                visited.add(complement);
            }
        }
        return output;
    }

    public static Set<Pair> threeSumPairs (int[] arr, int targetSum, String condition) {
        /* arr index -> val
         * create hashmap val->index
         * */
        Set<Pair> output = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> original = new HashSet<>();

        for (int i : arr) {
            original.add(i);
        }

        // move mouse to

        switch (condition) {  // a + b + c = d, a b -> +c to vis, a c -> +b to vis, b c -> add a b c to output
            case "try straight":
                for (int i = 0; i < arr.length; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        for (int k = j + 1; k < arr.length; k++) {
                            if (arr[i] + arr[j] + arr[k] == targetSum) {
                                output.add(new Pair(arr[i], arr[j], arr[k]));
                            }
                        }
                    }
                }
                break;

            case "": {
                for (int num1 : arr) {
                    for (int num2 : arr) {
                        int complement = targetSum - num1 - num2;

                        if (visited.contains(num1) & visited.contains(num2)) {

                            if (original.contains(num1) & original.contains(num2) & original.contains(complement)) {

                                if (!output.equals(new Pair(num1, num2, complement))) {
                                    output.add(new Pair(num1, num2, complement));
                                }
                            }

                        } else {
                            visited.add(complement);
                        }
                    }
                }
                break;

            }
            case "x<=y<=z": {
                for (int num1 : arr) {
                    for (int num2 : arr) {
                        int complement = targetSum - num1 - num2;
                        // x<=y<=z
                        if (visited.contains(num1) & visited.contains(num2)) {

                            if ((num1 < num2 & num2 < complement ||
                                    num1 > num2 & num2 > complement) &
                                    (original.contains(num1) & original.contains(num2) & original.contains(complement))) {

                                if (!output.equals(new Pair(num1, num2, complement))) {
                                    output.add(new Pair(num1, num2, complement));
                                }
                            }

                        } else {
                            visited.add(complement);
                        }

                    }
                }
                break;
            }
        }
        return output;
    }

    public static void main(String[] args) {

        System.out.println(isEqualsIgnoreOrder(new int[]{5, 1, -4}, new int[]{-4, 1, 5}));

        int[] arr = {1, -2, 0, 5, -1, -4};
        System.out.println(Arrays.toString(arr));
        System.out.println(Pair.threeSumPairs(arr, 2, ""));
        System.out.println(Pair.twoSumPairs(arr,2));

        Pair a = new Pair(2,3);
        System.out.println(a.x);

    }
}
