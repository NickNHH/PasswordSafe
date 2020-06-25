package bbw.ch.passwordSafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EntryController {
    @Autowired
    private EntryList entryList;

    @GetMapping("/list-entries")
    public String listEntries(Model model) {
        model.addAttribute("listOfEntries", entryList.getAllEntries());
        model.addAttribute("newEntry", new Entry());
        return "entrylist";
    }

    @PostMapping("/add-entry")
    public String addEntry(@ModelAttribute Entry newEntry, Model model) {
        entryList.addEntry(newEntry);
        model.addAttribute("listOfEntries", entryList.getAllEntries());
        return "redirect:/list-entries";
    }

    @GetMapping("/delete-lastEntry")
    public String deleteLastEntry(Model model) {
        if ((entryList.getAllEntries()) != null && (entryList.getAllEntries().size() > 0)) {
            entryList.getAllEntries().remove(entryList.getAllEntries().size()-1);
        }
        model.addAttribute("listOfEntries", entryList.getAllEntries());
        return "redirect:/list-entries";
    }
}