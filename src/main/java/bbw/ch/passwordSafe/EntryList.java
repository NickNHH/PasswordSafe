package bbw.ch.passwordSafe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EntryList {
    public List<Entry> entryList = new ArrayList<>(Arrays.asList(
            new Entry(1, "youtube.com", "PW1234", "nico", "random.email@gmail.com", "My favourite website"),
            new Entry(2, "instagram.com", "SecurePW", "ein__nico", "another.email@gmx.com" , "This website gives me anxiety")
    ));

    public List<Entry> getAllEntries(){
        if (entryList.isEmpty()) {
            return null;
        }
        return entryList;
    }

    public void addEntry(Entry entry) {
        entryList.add(entry);
    }
}
