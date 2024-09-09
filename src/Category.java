import java.util.ArrayList;

public class Category {
    private final String name;
    static private ArrayList<LibraryItem> items;

    Category(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void removeItem(int index){
        items.remove(index);
    }

    void showItems(){
        int ItemNumber = 0;
        for (LibraryItem a : items) {
            ItemNumber++;
            System.out.println("item " + ItemNumber + ":");
            a.printDetails();
            a.read();
            System.out.println();
        }
    }

    void addItem(LibraryItem item) {
        items.add(item);
    }
}