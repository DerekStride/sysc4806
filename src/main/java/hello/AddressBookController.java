package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookRepository bookRepo;
    @Autowired
    private BuddyInfoRepository buddyRepo;

    @RequestMapping(value = "/addressBooks/{id}/addBuddy", method = RequestMethod.PATCH, produces = {
            "application/JSON"
    })
    public void addBuddy(@PathVariable Long id, @RequestParam("buddyId") Long buddyId) {
        AddressBook book = bookRepo.findOne(id);
        BuddyInfo bud = buddyRepo.findOne(buddyId);
        book.addBuddy(bud);
        bookRepo.save(book);
    }
}