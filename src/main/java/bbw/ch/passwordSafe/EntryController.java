package bbw.ch.passwordSafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
public class EntryController {
    @Autowired
    private EntryList entryList;

    private String pSalt = "AES-GSM Password-Bases encryption!";

    @GetMapping("/list-entries")
    public String listEntries(Model model) {
        for (Entry entry : entryList.getAllEntries()) {
            try {
                String decryptedPW = Encryptor.decrypt(entry.getPassword(), pSalt);
                entry.setPassword(decryptedPW);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("listOfEntries", entryList.getAllEntries());
        model.addAttribute("newEntry", new Entry());
        return "entrylist";
    }

    @PostMapping("/add-entry")
    public String addEntry(@ModelAttribute Entry newEntry, Model model) {
        try {
            String encryptedPW = Encryptor.encrypt(newEntry.getPassword().getBytes(UTF_8), pSalt);
            newEntry.setPassword(encryptedPW);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @PostMapping("/logout")
    public String logout() {
        for (Entry entry : entryList.getAllEntries()) {
            try {
                String encryptedPW = Encryptor.encrypt(entry.getPassword().getBytes(UTF_8), pSalt);
                entry.setPassword(encryptedPW);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/login?logout";
    }
}