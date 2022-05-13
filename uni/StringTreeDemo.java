/**
 * Possible Solution for the tree exercise 
 *
 * @version 2013-01-19
 * @author matthes.elstermann@kit.edu
 *
 */
public class StringTreeDemo
{
    public static void main (String[] args)
    {
       StringTree tree = null;
       
	   String[] wordsToBeSorted = {"G", "A", "K", "C", "B", "E", "D", "I", "H", "F" }; //must be of lenght at least 9
	   
        tree = new StringTree("E");
        System.out.println(tree);
        
		for(int i = 0; i < wordsToBeSorted.length; i++){
			tree.insert(wordsToBeSorted[i]);
			System.out.println(tree);
		}

		
    }
}
