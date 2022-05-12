public class HexStringConverter {
    // initialization for valid hexString numbers & characters
    static char[] dict = "0123456789abcdef".toCharArray();
    static String[] check = {"2ae43","8g023","249abc","2354aer23","234245"};

    public static void main(String[] args) {
        // print = Valid Chars: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f,
        System.out.print("Valid Chars: "); printCharArray(dict);
        System.out.println();
        // verify each hexStrings. if valid, show answer. if invalid, tell user it's invalid.
        for(String str : check){
            if(checkValidity(str)){
                System.out.println("The decimal value of the hex-String "+str+" is: "+
                        convertedAnswer(str));
            }else{
                System.out.println("The String "+str+" is no valid hex-String");
            }
        }
    }

    public static void printCharArray(char[] arr){
        for(char c : arr){
            System.out.print(c+", ");
        }
    }

    // returns true if it is valid
    public static boolean checkValidity(String str){
        for(int i=0; i< str.length(); i++){
            for(int j=0; j< dict.length; j++) {
                char c = str.charAt(i);
                if(c == dict[j]) {break;}
                if(j >= dict.length-1) {return false;}
            }
        }
        return true;
    }

    // after converting hex-string to decimal,
    // returns answer in STRING FORMAT, without decimal numbers
    public static String convertedAnswer(String str){
        double sum = 0;
        for(int i=0, j=str.length()-1; i<str.length() && j>=0; i++, j--){
            char c = str.charAt(i);
            sum += Character.getNumericValue((c)) * Math.pow(16,j);
        }
        return String.format("%.0f",sum);
    }
}
