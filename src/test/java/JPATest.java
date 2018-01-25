import hello.AddressBook;
import hello.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.persistence.*;

public class JPATest {
    BuddyInfo bud1, bud2;
    AddressBook book;

    @Before
    public void setUp() throws Exception {
        bud1 = new BuddyInfo("Derek", "(613) 123-4567");
        bud2 = new BuddyInfo("Frank", "(613) 123-4568");
        book = new AddressBook();
        book.addBuddy(bud1);
        book.addBuddy(bud2);
    }

    @Test
    public void testPersistBuddy() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("address-book");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(book);

        tx.commit();

        Query q = em.createQuery("SELECT books FROM AddressBook books");

        AddressBook actualBook = (AddressBook) q.getSingleResult();

        System.out.println("Results:");
        System.out.println(book);

        em.close();
        emf.close();

        assertEquals(book, actualBook);
    }
}