import java.util.*;

public class Pair3 {
    final int x, y;

    public Pair3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair3) {
            Pair3 other = (Pair3) o;
            return other.x == this.x && other.y == this.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return new StringBuilder("{").append(this.x).append(",").append(this.y).append("}").toString();
    }

    public static Set<Pair3> findPairs(int inputs[], int targetSum) {
        Set<Pair3> results = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int number : inputs) {
            int complement = targetSum - number;

            if (visited.contains(number)) {
                results.add(new Pair3(number, complement));
            } else {

                visited.add(complement);
            }
        }
        return results;
    }

//    public static int[] findTwoSum(int[] list, int sum) {
//        if (list == null || list.length < 2) return null;
//        //map values to indexes
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i < list.length; i++) {
//            indexMap.put(list[i], i);
//        }
//
//        for (int i = 0; i < list.length; i++) {
//            int needed = sum - list[i];
//            if (indexMap.get(needed) != null) {
//                return new int[]{i, indexMap.get(needed)};
//            }
//        }
//
//        //none found
//        return null;
//    }

    public static void main(String[] args) {

        int[] arr = {1,3,5,7,9,8,4};
        int[] arr2 = {2,7,11,15,-2,3,3,3,3,6,7,11,1,8};

//        Iterator itr = findPairs(arr,9).iterator();
//        while (itr.hasNext()){
//            Pair i = (Pair) itr.next();
//            System.out.println(i);
//            System.out.println(         findPairs(arr2,9).contains(i)        );
//        }

    }
}

