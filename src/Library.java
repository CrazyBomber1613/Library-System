import java.util.Scanner;
import java.util.ArrayList;

public class Library {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Book> Books = new ArrayList<>();
    static ArrayList<EBook> EBooks = new ArrayList<>();
    static ArrayList<Magazine> Magazines = new ArrayList<>();
    static ArrayList<Category> Categories = new ArrayList<>();

    static void remove() {
        showAll();
        System.out.print("Enter the number of the item to remove: ");
        int chosenItem;
        try {
            chosenItem = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }
        if (chosenItem <= Books.size()) {
            int itemIndex = 0;
            for (Category a : Categories) {
                if (a.getName().equals(Books.get(chosenItem - 1).genre())) {
                    a.removeItem(itemIndex);
                }
                itemIndex++;
            }
            Books.remove(chosenItem - 1);
            System.out.println("book removed successfully!");
        } else if (chosenItem <= Books.size() + EBooks.size()) {
            EBooks.remove(chosenItem - Books.size() - 1);
            int itemIndex = 0;
            for (Category a : Categories) {
                if (a.getName().equals(EBooks.get(chosenItem - 1).genre())) {
                    a.removeItem(itemIndex);
                }
                itemIndex++;
                System.out.println("Ebook removed Successfully!");
            }
        } else if (chosenItem <= Books.size() + EBooks.size() + Magazines.size()) {
            Magazines.remove(chosenItem - Books.size() - EBooks.size() - 1);
            int itemIndex = 0;
            for (Category a : Categories) {
                if (a.getName().equals(Magazines.get(chosenItem - 1).genre())) {
                    a.removeItem(itemIndex);
                }
                itemIndex++;
                System.out.println("magazine removed successfully!");
            }
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public static void run() {
        System.out.print("choose the item you want to add or type \"show items\" to display the items or \"remove\" to remove. " + "\n(book / ebook / magazine / show items / remove): ");
        String ChosenType = input.nextLine();
        switch (ChosenType) {
            case "book":
                AddNewBook();
                break;
            case "ebook":
                AddNewEBook();
                break;
            case "magazine":
                AddNewMagazine();
                break;
            case "show items":
                DisplayItems();
                break;
            case "remove":
                remove();
                break;
            default:
                System.out.println("please choose again.");
        }
        run();
    }

    private static void DisplayItems() {
        System.out.print("Display them by category. (yes / no) : ");
        String choice = input.nextLine();
        if (choice.equals("yes")) {
            System.out.println("available categories");
            int catNumber = 0;
            for (Category a : Categories) {
                catNumber++;
                System.out.print(catNumber + ": ");
                System.out.println(a.getName());
            }
            System.out.print("enter the category name: ");
            String chosenCat = input.nextLine();

            for (Category a : Categories) {
                if (a.getName().equals(chosenCat))
                    a.showItems();
            }
        } else {
            showAll();
        }

    }

    private static void showAll() {
        int ItemNumber = 0;
        for (LibraryItem a : Books) {
            ItemNumber++;
            System.out.println("item " + ItemNumber + ":");
            a.printDetails();
            a.read();
            System.out.println();
        }
        for (LibraryItem a : EBooks) {
            ItemNumber++;
            System.out.println("item " + ItemNumber + ":");
            a.printDetails();
            a.read();
            System.out.println();
        }
        for (LibraryItem a : Magazines) {
            ItemNumber++;
            System.out.println("item " + ItemNumber + ":");
            a.printDetails();
            a.read();
            System.out.println();
        }
    }

    private static void AddNewBook() {
        System.out.print("Enter the book title: ");
        String title = input.nextLine();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter the publisher name: ");
        String publisher = input.nextLine();
        if (publisher.isEmpty()) {
            System.out.println("Publisher name cannot be empty.");
            return;
        }

        System.out.print("Enter the author name: ");
        String author = input.nextLine();
        if (author.isEmpty()) {
            System.out.println("Author name cannot be empty.");
            return;
        }

        System.out.print("Enter the ISBN: ");
        String ISBN = input.nextLine();
        if (ISBN.isEmpty()) {
            System.out.println("ISBN cannot be empty.");
            return;
        }

        System.out.print("Enter the genre: ");
        String genre = input.nextLine();
        if (genre.isEmpty()) {
            System.out.println("Genre cannot be empty.");
            return;
        }

        double price;
        while (true) {
            try {
                System.out.print("Enter the price: ");
                price = Double.parseDouble(input.nextLine());
                if (price < 0) {
                    throw new IllegalArgumentException("Price must be positive.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("This isn't a valid price! Please enter a numeric value.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Book newBook = new Book(title, publisher, price, author, ISBN, genre);
        Books.add(newBook);

        Category cat = null;
        for (Category a : Categories) {
            if (a.getName().equals(genre)) {
                cat = a;
                break;
            }
        }
        if (cat == null) {
            cat = new Category(genre);
            Categories.add(cat);
        }
        cat.addItem(newBook);
    }

    private static void AddNewEBook() {
        System.out.print("Enter the book title: ");
        String title = input.nextLine();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter the publisher name: ");
        String publisher = input.nextLine();
        if (publisher.isEmpty()) {
            System.out.println("Publisher name cannot be empty.");
            return;
        }

        double price;
        while (true) {
            try {
                System.out.print("Enter the price: ");
                price = Double.parseDouble(input.nextLine());
                if (price < 0) {
                    throw new IllegalArgumentException("Price must be positive.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("This isn't a valid price! Please enter a numeric value.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter the author name: ");
        String author = input.nextLine();
        if (author.isEmpty()) {
            System.out.println("Author name cannot be empty.");
            return;
        }

        System.out.print("Enter the ISBN: ");
        String ISBN = input.nextLine();
        if (ISBN.isEmpty()) {
            System.out.println("ISBN cannot be empty.");
            return;
        }

        System.out.print("Enter the download URL: ");
        String downloadURL = input.nextLine();
        if (downloadURL.isEmpty()) {
            System.out.println("Download URL cannot be empty.");
            return;
        }

        double fileSize;
        while (true) {
            try {
                System.out.print("Enter the file size: ");
                fileSize = Double.parseDouble(input.nextLine());
                if (fileSize < 0) {
                    throw new IllegalArgumentException("File size must be positive.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("This isn't a valid number! Please enter a double.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter the genre: ");
        String genre = input.nextLine();
        if (genre.isEmpty()) {
            System.out.println("Genre cannot be empty.");
            return;
        }

        EBook newEbook = new EBook(title, publisher, price, author, ISBN, downloadURL, fileSize, genre);
        EBooks.add(newEbook);

        Category cat = null;
        for (Category a : Categories) {
            if (a.getName().equals(genre)) {
                cat = a;
                break;
            }
        }
        if (cat == null) {
            cat = new Category(genre);
            Categories.add(cat);
        }
        cat.addItem(newEbook);
    }

    private static void AddNewMagazine() {
        System.out.print("Enter the magazine title: ");
        String title = input.nextLine();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter the publisher name: ");
        String publisher = input.nextLine();
        if (publisher.isEmpty()) {
            System.out.println("Publisher name cannot be empty.");
            return;
        }

        double price;
        while (true) {
            try {
                System.out.print("Enter the price: ");
                price = Double.parseDouble(input.nextLine());
                if (price < 0) {
                    throw new IllegalArgumentException("Price must be positive.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("This isn't a valid price! Please enter a numeric value.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int issueNumber;
        while (true) {
            System.out.print("Enter the issue number: ");
            try {
                issueNumber = Integer.parseInt(input.nextLine());
                if (issueNumber < 0) {
                    throw new IllegalArgumentException("Issue number must be positive.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter the genre: ");
        String genre = input.nextLine();
        if (genre.isEmpty()) {
            System.out.println("Genre cannot be empty.");
            return;
        }

        Magazine newMagazine = new Magazine(title, publisher, price, issueNumber, genre);
        Magazines.add(newMagazine);

        Category cat = null;
        for (Category a : Categories) {
            if (a.getName().equals(genre)) {
                cat = a;
                break;
            }
        }
        if (cat == null) {
            cat = new Category(genre);
            Categories.add(cat);
        }
        cat.addItem(newMagazine);
    }
}