package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookRepository bookRepo;
    @Autowired
    private BuddyInfoRepository buddyRepo;

    @RequestMapping(value = "/addressBook/{id}/addBuddy", method = RequestMethod.PATCH, produces = {
            "application/JSON"
    })
    public void addBuddy(@PathVariable Long id, @RequestParam("buddyId") Long buddyId) {
        AddressBook book = bookRepo.findOne(id);
        BuddyInfo bud = buddyRepo.findOne(buddyId);
        book.addBuddy(bud);
        bookRepo.save(book);
    }

//    @GetMapping("/addressBook")
//    public String buddyForm(Model model) {
//        model.addAttribute("addressBook", new AddressBook());
//        return "addressBook";
//    }
//
//    @GetMapping("/addressBook/{id}")
//    public String buddyForm(@PathVariable Long id, Model model) {
//        model.addAttribute("addressBook", bookRepo.findOne(id));
//        return "resultAddressBook";
//    }
//
//    @PostMapping("/addressBook")
//    public String buddySubmit(@ModelAttribute AddressBook addressBook) {
//        bookRepo.save(addressBook);
//        return "resultAddressBook";
//    }


}