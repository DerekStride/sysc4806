package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {

    private static final String DEFAULT_NAME = "";
    private static final String DEFAULT_NUMBER = "";
    private static final String DEFAULT_ADDRESS = "";

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;
    private String address;

    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo() {
        this(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_ADDRESS);
    }

    public BuddyInfo(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public AddressBook getAddressBook() { return addressBook; }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        if (!addressBook.getBuddies().contains(this))
            addressBook.addBuddy(this);
    }

    public String toString() {
        return "ID: "+ id + "\tName: " + name + "\tPhone#: " + phoneNumber +
                "\tAddress: " + address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
