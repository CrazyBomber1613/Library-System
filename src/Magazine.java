public class Magazine extends LibraryItem {
    //data fields
    private String title;
    private String publisher;
    private double price;
    private int IssueNumber;
    private String genre;
    //!! add setter and getter methods!!

    Magazine(String title, String publisher, double price, int IssueNumber, String genre) {
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.IssueNumber = IssueNumber;
        this.genre = genre;
    }

    @Override
        //not completed
    void printDetails() {
        System.out.printf("Magazine: \"%s\"", title);
        System.out.println();
        System.out.printf("Publisher: \"%s\"", publisher);
        System.out.println();
        System.out.printf("Price: \"%.2f\"", price);
        System.out.println();
        System.out.printf("Issue Number: \"%d\"", IssueNumber);
        System.out.println();
    }

    @Override
    String getDetails(String dataType) {
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
            case "issue number":
                value = String.valueOf(IssueNumber);
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

    public String genre() {
        return genre;
    }

    @Override
    public void read() {
        System.out.println("read as a physical magazine");
    }
}