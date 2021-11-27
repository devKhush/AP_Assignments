package Question_1;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book thisBook, Book otherBook){
        if(!thisBook.getBookTitle().equals(otherBook.getBookTitle())){
            return thisBook.getBookTitle().compareTo(otherBook.getBookTitle());
        }
        else if (!(thisBook.getISBN()==otherBook.getISBN())){
            return (int)(thisBook.getISBN()-otherBook.getISBN());
        }
        else
            return (int)(thisBook.getBarcode()- otherBook.getBarcode());
    }
}
