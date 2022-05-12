public class Student {

    private String name;
    private int roll_no;

    public Student(String name, int roll_no){
        this.name = name;
        this.roll_no = roll_no;
    }

    public int setRollNum(int roll_no){
        this.roll_no = roll_no;
        return roll_no;
    }

    public String setName(String name){
        this.name = name;
        return name;
    }

    public int getRollNum(){
        return roll_no;
    }

    public String getName(){
        return name;
    }

}
