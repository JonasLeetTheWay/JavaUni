public class g2g_prac {
    public static void main(String[] args) {
        int[] arr1 = {12, 4, 2, 5, 3};
        int[] arr2 = {32, 13, 43, 10, 8};
        System.out.println(checkIfPossibleMerge(arr1, arr2));
    }

    // check if two sorted arrays can be merged to form a sorted array with no adjacent pair from the same array
    /*
        Input: A[] = {3, 5, 8}, B[] = {2, 4, 6}
        Output: Yes

        Explanation: Merged array = {B[0], A[0], B[1], A[1], B[2], A[2]}
        Since the resultant array is sorted array, the required output is Yes.

        Input: A[] = {12, 4, 2, 5, 3}, B[] = {32, 13, 43, 10, 8}
        Output: No
     */
//    public static boolean checkIfPossibleMerge(int[] arr1, int[] arr2) {
//        if (arr1.length != arr2.length) return false;
//
//        boolean flag = true;
//        int prev = 1;
//        // 1: prev element of merged array is from arr1
//        // 2: prev element of merged array is from arr2
//        int i = 0;
//        int j = 0;
//
//        while (i < arr1.length && j < arr2.length){
//                if (arr1[i] < arr2[j] && prev != 1) {
//                    i++;
//                    prev = 1;
//                } else if (arr1[i] < arr2[j] && prev != 2) {
//                    j++;
//                    prev = 2;
//                } else if (arr1[i] == arr2[j]) {
//                    if (prev != 2){
//                        j++;
//                        prev = 2;
//                    } else {
//                    i++;
//                    prev = 1;
//                } flag = false;
//            }
//        }
//        return flag;
//    }
//}
    static boolean checkIfPossibleMerge(int[] A, int[] B) {

        int i = 0;
        int j = 0;

        int prev = -1;

        boolean flag = true;

        // Traverse both the arrays
        while (i < A.length && j < B.length) {

            if (A[i] < B[j] && prev != 0) {
                prev = 0;
                i++;
            }

            else if (B[j] < A[i] && prev != 1) {
                prev = 1;
                j++;
            }

            else if (A[i] == B[j]) {
                if (prev != 1) {
                    prev = 1;
                    j++;
                }
                else {
                    prev = 0;
                    i++;
                }
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
