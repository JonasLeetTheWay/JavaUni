package AdressbuchTemplatesAndTests;

/**
 * class has the main-Method in it
 * @author Larissa
 *
 */
public class AddressBookProgramm{
    /**
     * here you can instantiate the addressbook and fill it with entries.
     * Use the methods of AddressBook to do this.
     * 
     * @param args not required
     */
    public static void main(String[] args) {

        // Examples that should work if everything work correctly

        Friend myFriend = new Friend("Lara", 32, "Bellinger Weg 15");
        System.out.println("My Friend: " + myFriend.getName() + " " +
        				   "is " + myFriend.getAge() + " years old and " +
        				   "lives at: " + myFriend.getAddress()
        				   );
        AddressBook myBook = new AddressBook(4);
        myBook.addFriend("Lara", 32, "Bellinger Weg 15");
        myBook.printAddressBook();

        myBook.changeAge("Lara", "Bellinger Weg 15", 33);
        myBook.printAddressBook();

    }

}
