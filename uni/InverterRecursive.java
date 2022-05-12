import Prog1Tools.IOTools;

public class InverterRecursive {

    static int count = 0;
    static boolean flag = true;

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        str.append("===============================\n");
        str.append("Inverter\n");
        str.append("===============================\n\n");
        str.append("Please input characters");
        System.out.println(str.toString());

        inverterRecursive(flag);

        System.out.printf("The recursive method has been called %d times.", count);
    }

    public static boolean inverterRecursive(boolean flag) {
        if (flag) {
            System.out.printf("%d.Character: ", count + 1);
            char c = IOTools.readChar();
            count++;
            if (c == 'x' || c == 'X') {
                flag = false;
            }
            inverterRecursive(flag);
        }
        return flag;
    }
}
