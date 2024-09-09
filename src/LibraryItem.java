public abstract class LibraryItem implements Readable {
    abstract String getDetails(String dataType);
    abstract void printDetails();
}