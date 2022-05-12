import Prog1Tools.IOTools;

public class VarReadAndExchange {
	
	public static void main(String[] args){
		int x = IOTools.readInt("Input x: ");  // Read user input
		int y = IOTools.readInt("Input y: ");  // Read user input

		System.out.println("x: " + x + " - y: " + y);
		// swapping variables' value
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x: " + x + " - y: " + y);
		printLarger(x,y);
	}

	public static void printLarger(int x, int y) {
		if (x > y){
			System.out.println("The larger value is: " + x);
		} else if (y > x){
			System.out.println("The larger value is: " + y);
		} else{
			System.out.println("The larger value is none, since both numbers are equal");
		}
	}
}
