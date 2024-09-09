public class EBook extends Book{
    private String title;
    private String publisher;
    private double price;
    private String author;
    private String ISBN;
    private String genre;
    private String DownloadURL;
    private double FileSize;
    //!! add setter and getter methods!!


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
            case "file size":
                value = String.valueOf(FileSize);
                break;
            case "download url":
                value = DownloadURL;
                break;
            default:
                value = "invild data type!";
                break;
        }
        return value;
    }
    @Override
    public void read(){System.out.println("read as an EBook");}
}
