import hello.AddressBook;
import hello.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddressBookTest {
    BuddyInfo bud;
    AddressBook book;

    @Before
    public void setUp() throws Exception {
        bud = new BuddyInfo("Derek", "(613) 123-4567");
        book = new AddressBook(new ArrayList<BuddyInfo>());
    }

    @Test
    public void addBuddy() throws Exception {
        assertEquals(0, book.size());
        book.addBuddy(bud);
        assertEquals(1, book.size());
    }

    @Test
    public void toString1() throws Exception {
        book.addBuddy(bud);
        assertEquals("Id: null Buddies:\n\tID: null\tName: Derek\tPhone#: (613) 123-4567\n", book.toString());
    }
}
