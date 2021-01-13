package treeSet;

import java.util.Comparator;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

/**
 * TreeSet和HashSet类似，不过TreeSet是一个有序集合
 */
public class TreeSetTest {
    
    public static void main(String[] args) {
        var parts = new TreeSet<Item>();

        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));

        System.out.println(parts);

        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);

        System.out.println(sortByDescription);
    }
}
