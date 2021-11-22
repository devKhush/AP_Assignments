package Question_1;

public class Book implements Comparable<Book>{
    private final String bookTitle;
    private final long barcode;
    private final long ISBN;

    public Book(String bookTitle, long barcode, long ISBN){
        this.barcode = barcode;
        this.bookTitle = bookTitle;
        this.ISBN = ISBN;
    }

    public long getBarcode() {
        return barcode;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    @Override
    public int compareTo(Book otherBook){
        if(!this.getBookTitle().equals(otherBook.getBookTitle())){
            return this.getBookTitle().compareTo(otherBook.getBookTitle());
        }
        else if (!(this.getISBN()==otherBook.getISBN())){
            return (int)(this.getISBN()-otherBook.getISBN());
        }
        else
            return (int)(this.getBarcode()- otherBook.getBarcode());
    }

    @Override
    public String toString() {
        return "Book {" +
                "bookTitle='" + bookTitle + '\'' +
                ", barcode=" + barcode +
                ", ISBN=" + ISBN +
                '}';
    }
}
