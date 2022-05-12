import java.util.*;

public class arrExe__21_to_35 {

    //    static int[] arr = {5,10,11,4,7,8,6,9};
    static int[] arr = {2,7,11,15,-2,3,3,3,3,6,7,11,1,8};
    static int[] arr1 = {2, 4, 8, 8, 9, 8, 8, 8, 8, 8, 8, 10, 10};
    static int[] arr2 = {2, 3, 4, 8, 10, 1, 9, 9, 9, 10};
    static int[] arr3 = {4, 8, 14, 40, 2, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10};

    public static void main(String[] args) {
//        Set set = new HashSet();
//        ArrayList check = new ArrayList();
//        set.add(1);
//        set.add(2);
//        check.add(3);
//        System.out.println(set.contains(check.get(0)));;
//        System.out.println(Arrays.toString(findMissingNum(arr2, arr1).toArray()));
//        System.out.println(Arrays.toString(findCommonNum(arr2, arr1).toArray()));
//        System.out.println(Arrays.toString(findCommonElementsFrom3Arrays(arr2, arr3, arr1).toArray()));
        //System.out.println(Arrays.toString(moveZerosToTheEnd(arr)));
//        System.out.println(Arrays.toString(arr));
//        findNumberofEvenandOddIntegers(arr);
//        System.out.println(findDifferenceBetweenLargestSmallest(arr));
//        System.out.println(averageValueExceptLargestSmallest(arr));
//        System.out.println(totalSumOfSpecifiedNum(arr, 10));
//        printMatrix(indexOf2SpecfiedNums(arr, 65, 1));
//        System.out.println(check2SpecfifiedNums(arr, 65, 77));
//        System.out.println(longestSequenceLength(arr));
//        System.out.println(longestSequenceSet(arr));
//        System.out.println(Pair3.findPairs(arr, 9));
        printPairs(arr,9);


    }

    static void printPairs(int arr[], int sum) {

        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Traverse through all elements
        for (int i : arr) {

            // Search if a pair can be formed with
            // arr[i].
            int rem = sum - i;
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);

                for (int j = 0; j < count; j++)
                    System.out.print("(" + rem +
                            ", " + i +
                            ")" + "\n");
            }
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
            }
        }
    }

    public static int longestSequenceLength(int[] arr) {
        // set: saves unique elements
        // set: able to check existence of elements
        Set set = new HashSet();
        int longest_sequence_length = 0;
        for (int i : arr) set.add(i);
        for (int i : arr) {
            // reinitialize length for looping every integer
            int length = 1;
            // start searching from integer position, along +x direction
            for (int j = i + 1; set.contains(j); j++) {
                // remove if consecutive numbers exists
                // to minimize the already done work, speeden up code
                set.remove(j);
                length++;
            }
            // start searching from integer position, along -x direction
            for (int j = i - 1; set.contains(j); j--) {
                set.remove(j);
                length++;
            }
            // track current longest sequence length
            longest_sequence_length = Math.max(length, longest_sequence_length);
        }
        return longest_sequence_length;
    }

    public static Set longestSequenceSet(int[] arr) {
        // set: saves unique elements
        // set: able to check existence of elements
        Set set = new HashSet();
        Set output_set = new HashSet<>();
        int longest_sequence_length = longestSequenceLength(arr);
        int count = 1;
        for (int i : arr) set.add(i);
        for (int i : arr) {
            // start searching from integer position, along +x direction
            for (int j = i + 1; set.contains(j); j++) {
                // remove if consecutive numbers exists
                // to minimize the already done work, speeden up code
                set.remove(j);
                output_set.add(j);
            }
            // start searching from integer position, along -x direction
            for (int j = i - 1; set.contains(j); j--) {
                set.remove(j);
                output_set.add(j);
            }
        }
        return new TreeSet(output_set);
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println();
    }

    public static boolean check2SpecfifiedNums(int[] arr, int num1, int num2) {
        for (int i : arr) {
            if (i == num1) {
                for (int j : arr) {
                    if (j == num2) return true;
                }
            }
        }
        return false;
    }

    public static int[][] indexOf2SpecfiedNums(int[] arr, int num1, int num2) {
        int num1_count = 0;
        int num2_count = 0;

        for (int i : arr) {
            if (i == num1) {
                num1_count++;
            } else if (i == num2) {
                num2_count++;
            }
        }

        int[] num1_idx = new int[num1_count];
        int[] num2_idx = new int[num2_count];
        num1_count = 0;
        num2_count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num1) {
                num1_count++;
                num1_idx[num1_count - 1] = i;
            } else if (arr[i] == num2) {
                num2_count++;
                num2_idx[num2_count - 1] = i;
            }
        }
        int[][] idx_matrix = {num1_idx, num2_idx};
        return idx_matrix;
    }


    public static int totalSumOfSpecifiedNum(int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static double averageValueExceptLargestSmallest(int[] arr) {
        int[] largest_smallest = findLargestSmallest(arr);
        int largest = largest_smallest[0];
        int smallest = largest_smallest[1];
        double sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != smallest & arr[i] != largest) {
                count++;
                sum += arr[i];
            }
        }
        return sum / count;
    }

    public static int[] findLargestSmallest(int[] arr) {
        int temp = 0;
        int largest = 0;
        int smallest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
            }
            largest = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
            }
            smallest = temp;
        }
        return new int[]{largest, smallest};
    }

    public static int findDifferenceBetweenLargestSmallest(int[] arr) {
        int temp = 0;
        int largest = 0;
        int smallest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
            }
            largest = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
            }
            smallest = temp;
        }
        return largest - smallest;
    }

    public static int[] twoSumFinder(int[] arr, int target) {
        Set set = new HashSet();
        // remove duplicates
        int[] clean_arr = arr.clone();
        clean_arr = removeDuplicateWithResizing(clean_arr);
        System.out.println(Arrays.toString(clean_arr));
        // initialize empty arr, waiting answer to be inputed
        int[] output_arr = new int[clean_arr.length * 10]; // why +1 to avoid error

        int insert_idx = 0;
        for (int val1 : clean_arr) {
            for (int val2 : clean_arr) {
                if (val1 + val2 == target) {
                    insert_idx += 2;
                    set.add(val1);
                    set.add(val2);
                    Iterator itr = set.iterator();
                    int[] ans_arr = new int[set.size()];
                    for (int k = 0; k < set.size(); k++) {
                        ans_arr[k] = (int) itr.next();
//                        System.out.println( (int) (itr.next()));
//                        System.out.println(Arrays.toString(ans_arr));
//                        System.out.println(Arrays.toString(output_arr));

                    }
                    System.arraycopy(ans_arr, 0, output_arr, insert_idx - 2, set.size());
                    set.clear();
                }
            }
        }
        output_arr = removeDuplicateWithResizing(output_arr);
        return output_arr;
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

    public static ArrayList findMissingNum(int[] a, int[] b) {
        // size requirement: a >= b
        ArrayList check = new ArrayList(); // larger
        ArrayList refer = new ArrayList(); // smaller
        ArrayList missing = new ArrayList();
        int num_to_check = 0;
        // larger
        for (int i : a) {
            check.add(i);
        }
        // remove duplicates
        check = removeDuplicatesInArrayList(check);
        // smaller
        for (int i : b) {
            refer.add(i);
        }
        // remove duplicates
        refer = removeDuplicatesInArrayList(refer);


        for (int i = 0; i < check.size(); i++) {
            num_to_check = (int) check.get(i);
            if (!refer.contains(num_to_check)) {
                missing.add(num_to_check);
            }
        }
        return missing;
    }

    public static ArrayList findCommonNum(int[] a, int[] b) {
        // size requirement: a >= b
        ArrayList check = new ArrayList(); // larger
        ArrayList refer = new ArrayList(); // smaller
        ArrayList common = new ArrayList();
        int num_to_check = 0;
        // larger
        for (int i : a) {
            check.add(i);
        }
        // remove duplicates
        check = removeDuplicatesInArrayList(check);
        // smaller
        for (int i : b) {
            refer.add(i);
        }
        // remove duplicates
        refer = removeDuplicatesInArrayList(refer);


        for (int i = 0; i < check.size(); i++) {
            num_to_check = (int) check.get(i);
            if (refer.contains(num_to_check)) {
                common.add(num_to_check);
            }
        }
        return common;
    }

    public static <T> ArrayList<T> removeDuplicatesInArrayList(ArrayList<T> list) {
        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();
        // Traverse through the first list
        for (T element : list) {
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static ArrayList findCommonElementsFrom3Arrays(int[] arr1, int[] arr2, int[] arr3) {
        ArrayList a = convertIntArray2ArrayList(arr1);
        ArrayList b = convertIntArray2ArrayList(arr2);
        ArrayList c = convertIntArray2ArrayList(arr3);
        int a_size = a.size();
        int b_size = b.size();
        int c_size = c.size();

        ArrayList common = new ArrayList();

        if (a_size > b_size) {
            if (a_size > c_size) {
                ArrayList largest = findCommonNum(arr1, arr3);
                ArrayList larger = findCommonNum(arr2, arr3);
                for (int i = 0; i < largest.size(); i++) {
                    if (larger.contains(largest.get(i))) {
                        common.add(largest.get(i));
                    }
                }
            } else {
                ArrayList largest = findCommonNum(arr3, arr1);
                ArrayList larger = findCommonNum(arr1, arr2);
                for (int i = 0; i < largest.size(); i++) {
                    if (larger.contains(largest.get(i))) {
                        common.add(largest.get(i));
                    }
                }
            }
        } else if (b_size > c_size) {
            ArrayList largest = findCommonNum(arr1, arr3);
            ArrayList larger = findCommonNum(arr2, arr3);
            for (int i = 0; i < largest.size(); i++) {
                if (larger.contains(largest.get(i))) {
                    common.add(largest.get(i));
                }
            }
        } else {
            ArrayList largest = findCommonNum(arr1, arr3);
            ArrayList larger = findCommonNum(arr2, arr3);
            for (int i = 0; i < largest.size(); i++) {
                if (larger.contains(largest.get(i))) {
                    common.add(largest.get(i));
                }
            }
        }
//        common = removeDuplicatesInArrayList(common);
        Collections.sort(common);
        return common;
    }

    public static ArrayList convertIntArray2ArrayList(int[] arr) {
        ArrayList arr_list = new ArrayList<>();
        for (int i : arr) {
            arr_list.add(i);
        }
        return arr_list;
    }

    public static int[] moveZerosToTheEnd(int[] arrI) {
        int[] arr = arrI.clone();

        int temp = 0;
        int i = 0; // i-pointer only updated when switching happens

        for (int j = 0; j < arr.length; ) {
            if (arr[j] == 0) {
                j++; // j-pointer only updated when the indexing result is 0
            } else {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        return arr;
    }

    public static void findNumberofEvenandOddIntegers(int[] arr) {
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println(evenCount);
        System.out.println(oddCount);
    }

}
