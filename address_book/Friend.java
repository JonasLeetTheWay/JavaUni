/**
 * models a Friend with name, age and address
 *
 * @author Larissa
 */
public class Friend {
    private String name;
    private int age;
    private String address;

    /**
     * constructor. Initialize the global variables above
     *
     * @param name    name of the friend
     * @param age     age of the friend
     * @param address address of the friend
     */
    public Friend(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * prints a friend to the console
     */
    public void printFriend() {
        System.out.println("Freund: " + name + " Alter: " + age + " Adresse: " + address);
    }

    /**
     * getter for the Name
     *
     * @return name of the friend
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the Age
     *
     * @return age of the friend
     */
    public int getAge() {
        return age;
    }

    /**
     * getter for the address
     *
     * @return address of the friend
     */
    public String getAddress() {
        return address;
    }

    /**
     * setter for the age
     *
     * @param newAge new age to set
     */
    public void setAge(int newAge) {
        this.age = newAge;
    }

}
