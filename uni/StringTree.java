public class StringTree {

    private StringTree leftChild;
    private StringTree rightChild;
    private String savedValue;

    public StringTree(String str) {
        this.savedValue = str;
//        if (leftChild != null && rightChild != null){
//            leftChild.toString();this.toString();rightChild.toString();
//        }
//        else if (leftChild != null){
//            leftChild.toString();this.toString();
//        }
//        else if (rightChild != null){
//            this.toString();rightChild.toString();
//        }
//        else this.toString();
    }

    public void insert(String str) {

        if (savedValue.compareTo(str) < 0) {

            if (leftChild == null) {
                leftChild = new StringTree(str);
                leftChild.toString();this.toString();

            } else {
                leftChild.insert(str);
                leftChild.toString();this.toString();
            }

        } else {

            if (rightChild == null) {
                rightChild = new StringTree(str);
                this.toString();rightChild.toString();

            } else {
                rightChild.insert(str);
                this.toString();rightChild.toString();
            }
        }
    }


    //    public String toStringPreOrder(){
//        return ;
//    }
//    public String toStringPostOrder(){
//        return ;
//    }

    public String toString() {
//        if (leftChild != null && rightChild != null){
//            return leftChild.savedValue + savedValue + rightChild.savedValue;
//        }
//        else if (leftChild != null){
//            return leftChild.savedValue + savedValue;
//        }
//        else if (rightChild != null){
//            return savedValue + rightChild.savedValue;
//        }
        return savedValue;
    }
}

/**
 * Think about how it should work and then implement the method insert(String s) so that
 * it correctly places the Strings. The value of savedValue will only be settable upon creation
 * of the object via constructor. Meaning for the insert method that it will not save the date
 * in this instance but rather create a new leaf (new StringTree) or delegate the saving to
 * an already existing child instance depending on whether the object to be saved is smaller
 * or bigger than the saved one. Advice: To determine whether a string come before or after
 * another you can use the compareTo(String s) method of the String class.
 * Example:
 * String a = "Ha";
 * String b = "Hi";
 * int result = a.compareTo(b);
 * System.out.println(result); // output: -8
 * • Since a is „smaller“ than b, a.compareTo(b) will return a value smaller than 0.
 * • If a and b were equal, calling a.compareTo(b) would return the value 0.
 * • If a were bigger than b, calling a.compareTo(b) would return a value bigger than 0.
 * <p>
 * <p>
 * c) Implement the method toString in the class StringTree, so that it will print out the textual
 * representation of the tree “in order“ (first the left child, than the actual value and then the right
 * child) Optional: Implement the methods toStringPreOrder() and toStringPostOrder() so
 * that they will print out the according traversal order of the tree.
 * <p>
 * d) Use the program StringTreeDemo from the ILIAS-System to test your class.
 * The print out should look like this:
 * E
 * E G
 * A E G
 * A E G K
 * A C E G K
 * A B C E G K
 * A B C E E G K
 * A B C D E E G K
 * A B C D E E G I K
 * A B C D E E G H I K
 * A B C D E E F G H I K
 */