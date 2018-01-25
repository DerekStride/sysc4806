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
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "(613) 123-3030"));
            repository.save(new BuddyInfo("Chloe", "(613) 123-5500"));
            repository.save(new BuddyInfo("Justin", "(613) 123-9001"));
            repository.save(new BuddyInfo("Justin", "(613) 123-4455"));
            repository.save(new BuddyInfo("Michelle", "(613) 123-3000"));

            // fetch all customers
            log.info("hello.BuddyInfo's found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo bud = repository.findOne(1L);
            log.info("hello.BuddyInfo found with findOne(1L):");
            log.info("--------------------------------");
            log.info(bud.toString());
            log.info("");

            // fetch customers by last name
            log.info("hello.BuddyInfo's found with findByName('Justin'):");
            log.info("--------------------------------------------");
            for (BuddyInfo buddy : repository.findByName("Justin")) {
                log.info(buddy.toString());
            }
            log.info("");
        };
    }

}