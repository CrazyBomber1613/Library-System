public class EBook extends Book{
    private String title;
    private String publisher;
    private double price;
    private String author;
    private String ISBN;
    private String genre;
    private final String DownloadURL;
    private final double FileSize;

    public EBook(String title, String publisher, double price, String author, String ISBN, String downloadURL, double fileSize, String genre) {
        super(title, publisher, price, author, ISBN , genre);
        DownloadURL = downloadURL;
        FileSize = fileSize;
    }

    @Override
    void printDetails(){
        System.out.printf("EBook : \"%s\" by %s %n" , title , author);
        System.out.println("Publisher : " + publisher);
        System.out.println("Price : " + price);
        System.out.println("ISBN : " + ISBN);
        System.out.println("Download URL : " + DownloadURL);
        System.out.println("File size : " + FileSize + " MB");
    }
    @Override
    String getDetails(String dataType){
        String value = switch (dataType) {
            case "title" -> title;
            case "publisher" -> publisher;
            case "price" -> String.valueOf(price);
            case "author" -> author;
            case "ISBN", "isbn" -> ISBN;
            case "genre" -> genre;
            case "file size" -> String.valueOf(FileSize);
            case "download url" -> DownloadURL;
            default -> "invalid data type!";
        };
        return value;
    }
    @Override
    public void read(){System.out.println("read as an EBook");}
}
