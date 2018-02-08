package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository bookRepository, BuddyInfoRepository buddyRepository) {
        return (args) -> {
            AddressBook book = new AddressBook();

            book.addBuddy(new BuddyInfo("Jack", "(613) 123-3030", "123 Main St."));
            book.addBuddy(new BuddyInfo("Chloe", "(613) 123-5500", "123 Main St."));
            book.addBuddy(new BuddyInfo("Justin", "(613) 123-9001", "123 Main St."));
            book.addBuddy(new BuddyInfo("Justin", "(613) 123-4455", "123 Main St."));
            book.addBuddy(new BuddyInfo("Michelle", "(613) 123-3000", "123 Main St."));

            bookRepository.save(book);

            // fetch all customers
            log.info("hello.BuddyInfo's found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : buddyRepository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo bud = buddyRepository.findOne(1L);
            log.info("hello.BuddyInfo found with findOne(1L):");
            log.info("--------------------------------");
            log.info(bud.toString());
            log.info("");

            // fetch customers by last name
            log.info("hello.BuddyInfo's found with findByName('Justin'):");
            log.info("--------------------------------------------");
            for (BuddyInfo buddy : buddyRepository.findByName("Justin")) {
                log.info(buddy.toString());
            }
            log.info("");
        };
    }

}