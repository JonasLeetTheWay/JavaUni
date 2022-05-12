import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class arrList__exe1_to_22 {

    public static void main(String[] args) {
        ArrayList<String> arr_list = objects2ArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");

        List<List<String>> a = extractPortionInStringList(arr_list, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"); // only can handle duplicates found 2 times, if 3 times, there will be bug
        System.out.println(a);

        ArrayList<String> list1 = objects2ArrayList("Red","Green","Black","White","Pink") ;
        ArrayList<String> list2 = (ArrayList<String>) list1.clone();
        replaceStringsAtIndex(list2,3,"");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(compareTwoStringLists(list1,list2));
        System.out.println(swapStringInStringList(list1, "Red","Black"));

        System.out.println(extendElementsinArrayList(list1,"White","Pink","Yellow","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White","White"));

    }



    public static List<String> swapStringInStringList (List<String> list, String before, String after){
        int[] indicesToSwap = searchStringsInArrayList_returnIndices(list, before, after);
        for (int i=0; i<indicesToSwap.length; i++){
            list.set( indicesToSwap[i] ,after);
            list.set( indicesToSwap[++i] ,before);
        }
        return list;
    }

    public static List<Boolean> compareTwoStringLists(List<String> list1, List<String> list2) {
        List<Boolean> res = new ArrayList<>();
        for (String e : list1)
            res.add(list2.contains(e));
        return res;
    }

    public static List<List<String>> extractPortionInStringList(List<String> list, String... stringAsIndices) {

        List<String> str_indices = new ArrayList<>();
        String[] str_indices_arr;

        List<List<String>> extractions_based_on_indices = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            str_indices.add(stringAsIndices[i]);
            str_indices.add(stringAsIndices[++i]);
            str_indices_arr = new String[str_indices.size()];

            for (int j = 0; j < str_indices_arr.length; j++) {
                str_indices_arr[j] = str_indices.get(j);
            }
            int[] begin_and_end_indices = searchStringsInArrayList_returnIndices(list, stringAsIndices);

            for (int k = 0; k < begin_and_end_indices.length; k++) {
                extractions_based_on_indices.add( list.subList(begin_and_end_indices[k], begin_and_end_indices[++k]) );
            }
            str_indices.clear();
        }
        return extractions_based_on_indices;
    }

    public static List<String> copy_list1_to_list2(List<String> list1, List<String> list2) {
        Collections.copy(list1, list2); // side effect: list2 has been completely rewritten
        return list2;
    }

    public static List<String> copy_list_to_newlist_String(ArrayList<String> list) {
        List<String> res = Collections.EMPTY_LIST;
        for (String str : list) {
            res.add(str);
        }
        return res;
    }

    public static List<Integer> copy_list_to_newlist_INTEGER(List<Integer> list) {
        List<Integer> res = Collections.EMPTY_LIST;
        for (Integer i : list) {
            res.add(i);
        }
        return res;
    }

    public static ArrayList<String> sortStrings(ArrayList<String> arr_list, int direction, int startingIndex) {
        /**
         * direction: +1 or -1
         */
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < startingIndex; i++) {
            res.add(arr_list.get(i));
        }

        ArrayList<String> sorted_list = (ArrayList<String>) arr_list.clone();
        Collections.sort(sorted_list);

        switch (direction) {
            case 1:
                for (int i = startingIndex; i < sorted_list.size(); i++) {
                    res.add(sorted_list.get(i));
                }
                break;
            case -1:
                for (int i = sorted_list.size() - 1; i >= startingIndex; i--) {
                    res.add(sorted_list.get(i));
                }
                break;
        }
        return res;
    }

    public static ArrayList<Integer> sortIntegers(ArrayList<Integer> arr_list, int direction, int startingIndex) {
        /**
         * direction: +1 or -1
         */
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < startingIndex; i++) {
            res.add(arr_list.get(i));
        }

        ArrayList<Integer> sorted_list = (ArrayList<Integer>) arr_list.clone();
        Collections.sort(sorted_list);

        switch (direction) {
            case 1:
                for (int i = startingIndex; i < sorted_list.size(); i++) {
                    res.add(sorted_list.get(i));
                }
                break;
            case -1:
                for (int i = sorted_list.size() - 1; i >= startingIndex; i--) {
                    res.add(sorted_list.get(i));
                }
                break;
        }
        return res;
    }

    public static String[] searchStringsInArrayList_returnStrings(ArrayList<String> arr_list, String... objects) {
        ArrayList<String> res = new ArrayList<>();
        for (String str : arr_list) {
            for (String objects_str : objects) {
                if (objects_str.equals(str)) {
                    res.add(str);
                }
            }
        }
        String[] res_array = new String[res.size()];
        for (int i = 0; i < res_array.length; i++) {
            res_array[i] = res.get(i);
        }
        return res_array;
    }

    public static int[] searchStringsInArrayList_returnIndices(List<String> arr_list, String... objects) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        ArrayList<Integer> res_final = new ArrayList<>();

        for (int i = 0; i < arr_list.size(); i++) {
            for (int j = 0; j < objects.length; j++) {
                if (arr_list.get(i) == objects[j]) {
                    if (!res.contains(i)) {
                        res.add(i);
                    } else {
                        res2.add(i);
                    }
                }
            }
        }
        res_final.addAll(res);
        res_final.addAll(res2);
        int[] res_array = new int[res_final.size()];
        for (int i = 0; i < res_array.length; i++) {
            res_array[i] = res_final.get(i);
        }
        return res_array;
    }

    public static ArrayList<String> replaceStringsAtIndex(ArrayList<String> arr_list, int position, String... objects) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < arr_list.size(); i++) {
            if (i == position) {
                arr_list.remove(position);
                for (String obj : objects) {
                    res.add(obj);
                }
            }
            res.add(arr_list.get(i));
        }
        return res;
    }

    public static List<String> insertStringsAtIndex(List<String> arr_list, int position, String... objects) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr_list.size(); i++) {
            if (i == position) {
                for (String obj : objects) {
                    res.add(obj);
                }
            }
            res.add(arr_list.get(i));
        }
        return res;
    }

    public static ArrayList<String> objects2ArrayList(String... objects) {
        ArrayList<String> arr_list = new ArrayList<>();
        for (String obj : objects) {
            arr_list.add(obj);
        }
        return arr_list;
    }

    public static ArrayList<Integer> objects2ArrayList(Integer... objects) {
        ArrayList<Integer> arr_list = new ArrayList<>();
        for (Integer obj : objects) {
            arr_list.add(obj);
        }
        return arr_list;
    }

    public static ArrayList<ArrayList<Integer>> objects2ArrayList(ArrayList<Integer>... objects) {
        ArrayList<ArrayList<Integer>> arr_list = new ArrayList<>();
        for (ArrayList<Integer> obj : objects) {
            arr_list.add(obj);
        }
        return arr_list;
    }

    public static ArrayList<String> extendElementsinArrayList(ArrayList<String> list, String... objects){
        list.trimToSize();
        list.ensureCapacity(list.size()+objects.length);
        for (int i=0; i<objects.length;i++){
            list.add(objects[i]);
        }
        return list;
    }


//    public static void doSomethingInIteration (Object obj){
//
//    }

}
