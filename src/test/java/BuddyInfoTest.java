import hello.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo bud;

    @Before
    public void setUp() throws Exception {
        bud = new BuddyInfo("Derek", "(613) 123-4567");
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
    public void toString1() throws Exception {
        assertEquals("Name: Derek\tPhone#: (613) 123-4567", bud.toString());
    }
}
