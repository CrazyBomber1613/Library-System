public abstract class LibraryItem implements Readable , Printable {
    abstract String getDetails(String dataType);
    abstract void catalogueItem();
    abstract void printDetails();
}