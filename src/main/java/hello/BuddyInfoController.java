package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository buddyRepo;
    @Autowired
    private AddressBookRepository bookRepo;

    @GetMapping("/buddyInfo")
    public String buddyForm(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "buddyInfo";
    }

    @PostMapping("/buddyInfo")
    public String buddySubmit(@ModelAttribute BuddyInfo buddyInfo) {
        buddyRepo.save(buddyInfo);
        return "result";
    }

    @GetMapping("/addressBook/{id}")
    public String bookForm(@PathVariable Long id, Model model) {
        model.addAttribute("addressBook", bookRepo.findOne(id));
        return "resultAddressBook";
    }

    @GetMapping("/addressBook")
    public String bookForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        return "resultAddressBook";
    }
}