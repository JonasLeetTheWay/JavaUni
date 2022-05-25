/**
 * Addressbook which holds the entries
 *
 * @author Larissa
 */
public class AddressBook {
    private Friend[] myFriends;
    private int actualPosition;
    private int numberOfEntries;

    /**
     * constructor. Initialize the global variables above
     *
     * @param numberOfEntries number of entries the book can have
     */
    public AddressBook(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
        myFriends = new Friend[numberOfEntries];
    }

    /**
     * Adds a friend if the address book isn't full already.
     * 1. check if there are free entries
     * 2. create a new friend with the given parameters
     * 3. add it to myFriends
     * 4. update data and return
     *
     * @param name    name of the friend
     * @param age     age of the friend
     * @param address address of the friend
     * @return true if successful, false otherwise
     */
    public boolean addFriend(String name, int age, String address) {
        boolean result = false;
        if (actualPosition < numberOfEntries) {
            myFriends[actualPosition] = new Friend(name, age, address);
            actualPosition++;
            result = true;
        }
        return result;
    }

    /**
     * your friend got older? change his age here.
     * 1. look for the friend with the given name and address within the existing entries
     * (use the getAddress() and getName()-method of Friend. You can compare Strings with
     * the equals(String toCompare)-method.
     * 2. if you found the friend, set the age to the given newAge
     * (use the setAge(int newAge)-method of Friend)
     * 3. return
     *
     * @param name    name of the friend
     * @param address address of the friend
     * @return true if successful, false otherwise
     */
    public boolean changeAge(String name, String address, int newAge) {

        boolean result = false;
        for (int i = 0; i < actualPosition; i++) {

            Friend temp_friend = myFriends[i];
            String temp_name = temp_friend.getName();
            String temp_address = temp_friend.getAddress();

            if ( temp_name.equals(name) && temp_address.equals(address) ){
                temp_friend.setAge(newAge);
                myFriends[i] = temp_friend;
            }
        }
        return result;
    }


    /**
     * prints the field myFriends to the console
     */
    public void printAddressBook() {
        for (int i = 0; i < actualPosition; i++) {
            myFriends[i].printFriend();
        }
    }
}
