public class Book extends LibraryItem{
    private final String title;
    private final String publisher;
    private final double price;
    private final String author;
    private final String ISBN;
    private final String genre;

    Book(String title , String publisher , double price , String author , String ISBN , String genre){
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
    }

    @Override
    void printDetails(){
        System.out.printf("Book : \"%s\" by %s %n" , title , author);
        System.out.println("Publisher : " + publisher);
        System.out.println("ISBN : " + ISBN);
    }
    @Override
    String getDetails(String dataType){
        String value;
        switch (dataType) {
            case "title":
                value = title;
                break;
            case "publisher":
                value = publisher;
                break;
            case "price":
                value = String.valueOf(price);
                break;
            case "author":
                value = author;
                break;
            case "ISBN" , "isbn":
                value = ISBN;
                break;
            case "genre":
                value = genre;
                break;
            default:
                value = "invild data type!";
                break;
        }
        return value;
    }
    public String genre(){return genre;}
    @Override
    public void read(){System.out.println("read as a physical book");}
    String getTitle(){return title;}
}