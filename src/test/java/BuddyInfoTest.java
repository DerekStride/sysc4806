import hello.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo bud;

    @Before
    public void setUp() throws Exception {
        bud = new BuddyInfo("Derek", "(613) 123-4567", "123 Main St.");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Derek", bud.getName());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals("(613) 123-4567", bud.getPhoneNumber());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("123 Main St.", bud.getAddress());
    }

    @Test
    public void toString1() throws Exception {
        assertEquals("ID: null\tName: Derek\tPhone#: (613) 123-4567\tAddress: 123 Main St.", bud.toString());
    }
}
