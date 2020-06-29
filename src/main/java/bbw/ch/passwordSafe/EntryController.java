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
        String message = isSafe(newEntry.getPassword());
        if (message.equals("safe") && entryIsValid(newEntry)) {
            try {
                String encryptedPW = Encryptor.encrypt(newEntry.getPassword().getBytes(UTF_8), pSalt);
                newEntry.setPassword(encryptedPW);
            } catch (Exception e) {
                e.printStackTrace();
            }
            entryList.addEntry(newEntry);
        }
        model.addAttribute("listOfEntries", entryList.getAllEntries());
        return "redirect:/list-entries";
    }

    @GetMapping("/delete-lastEntry")
    public String deleteLastEntry(Model model) {
        if ((entryList.getAllEntries()) != null && (entryList.getAllEntries().size() > 1)) {
            entryList.getAllEntries().remove(entryList.getAllEntries().size() - 1);
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

    private String isSafe(String password) {
        //Check length
        if (password.length() < 8) {
            return "Password too short";
        }
        //Check if password contains one digit
        if (!password.matches("(?=.*[0-9]).*")) {
            return "Password needs at least one digit";
        }
        //Check if password contains one lower case letter
        if (!password.matches("(?=.*[a-z]).*")) {
            return "Password needs at least one lower case letter";
        }
        //Check if password contains one upper case letter
        if (!password.matches("(?=.*[A-Z]).*")) {
            return "Password needs at least one upper case letter";
        }
        //Check if password contains one special character
        if (!password.matches("(?=.*[~?!@#$%^&*()_]).*")) {
            return "Password needs at least one special character (~?!@#$%^&*()_)";
        }
        return "safe";
    }

    private boolean entryIsValid(Entry entry) {
        if (entry.getUrl().trim().equals("")) {
            return false;
        }
        if (entry.getPassword().trim().equals("")) {
            return false;
        }
        if (entry.getComment().trim().equals("")) {
            return false;
        }
        if (entry.getEmail().trim().equals("")) {
            return false;
        }
        if (entry.getLoginName().trim().equals("")) {
            return false;
        }
        return true;
    }
}