package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {

    private static final String DEFAULT_NAME = "";
    private static final String DEFAULT_NUMBER = "";

    @Id
    @GeneratedValue
    private Long id;

    private final String name;
    private final String phoneNumber;

    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo() {
        this(DEFAULT_NAME, DEFAULT_NUMBER);
    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressBook getAddressBook() { return addressBook; }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        if (!addressBook.getBuddies().contains(this))
            addressBook.addBuddy(this);
    }

    public String toString() {
        return "ID: "+ id + "\tName: " + name + "\tPhone#: " + phoneNumber;

    }
}
