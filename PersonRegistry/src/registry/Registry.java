package registry;

import person.Person;
import java.util.*;   // ArrayList, Använder List

// Generisk klass som hanetrar en list av objekt som är/ärvar från Person
public class Registry<T extends Person> {
    private List<T> items;  // Listan med alla personer

    public Registry() {
        items = new ArrayList<>();
    }

    // Lägger till ett objekt i listan
    public void addItem(T item) {
        items.add(item);
    }
    // Tar bort ett objekt från listan, baserat på equals()
    public void removeItem(T item) {
        items.remove(item);
    }
    
    // Skriver ut alla personer i listan

    public void listItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    // Sorterar listan
    public void sortItems() {
        Collections.sort(items); 
    }

    // Sorterar listan med en egen jämförelse
    public void sortItems(Comparator<T> comparator) {
        items.sort(comparator);
    }

    // Grupper personer efter första bokstaven i namnet
    public void countByInitial() {
        Map<Character, Integer> map = new TreeMap<>();
        for (T item : items) {
            char initial = Character.toUpperCase(item.getName().charAt(0));
            map.put(initial, map.getOrDefault(initial, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
