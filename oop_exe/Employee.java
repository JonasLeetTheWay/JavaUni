public class Employee {

    String name;
    String address;
    int year_joined;

    public Employee(String name, int year_joined, String address){
        this.name = name;
        this.address = address;
        this.year_joined = year_joined;
    }

    @Override
    public String toString(){
        return name + "\t\t\t" + year_joined + "\t\t\t" + address;
    }

    public static void printEmployees(Employee... args){
        for (Employee e : args){
            System.out.println(e);
        }
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getYear(){
        return year_joined;
    }

}
