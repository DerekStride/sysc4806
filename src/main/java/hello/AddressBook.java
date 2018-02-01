package hello;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public AddressBook(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public List<BuddyInfo> getBuddies() {
        return new ArrayList<>(buddies);
    }

    public void addBuddy(BuddyInfo bud) {
        if (buddies.contains(bud))
            return;
        buddies.add(bud);
        bud.setAddressBook(this);
    }

    public void setBuddy(int i, BuddyInfo bud) {
        buddies.add(i, bud);
    }

    public void removeBuddy(int i) {
        buddies.remove(i);
    }

    public BuddyInfo getBuddy(int i) {
        return buddies.get(i);
    }

    public int size() {
        return buddies.size();
    }

    public String toString() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Id: ");
        stringBuffer.append(id);
        stringBuffer.append(" Buddies:\n");
        for (BuddyInfo bud : buddies) {
            stringBuffer.append("\t");
            stringBuffer.append(bud);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static void main(String args[]){
        AddressBook book = new AddressBook();
        book.addBuddy(new BuddyInfo("Derek", "(613) 123-4567"));
        book.addBuddy(new BuddyInfo("Max", "(613) 123-7654"));
        book.addBuddy(new BuddyInfo("Tom", "(613) 123-7896"));

        System.out.println(book);
    }
}
