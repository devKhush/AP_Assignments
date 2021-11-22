package Question_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library {
    private int numberOfBooks;          // N
    private int numberOfRacks;          // K
    private ArrayList<Book> allBooks;
    private Book[][] sortedBooks;

    public Library(int N,int K){
        this.allBooks = new ArrayList<Book>();
        this.numberOfBooks = N;
        this.numberOfRacks = K;
        this.sortedBooks = new Book[getNumberOfRacks()/getNumberOfBooks()][getNumberOfBooks()];
    }

    public Book[][] getSortedBooks() {
        return sortedBooks;
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public int getNumberOfRacks() {
        return numberOfRacks;
    }

    public void setBookInARack(int rackNumber, int bookPosition, Book toPlace){
        this.sortedBooks[rackNumber][bookPosition] = toPlace;
    }

    public Book getBookInARack(int rackNumber, int bookPosition){
        return this.sortedBooks[rackNumber][bookPosition];
    }

    public void sortAllBooks(){
        Collections.sort(allBooks);
    }

    public void arrangeBooks(){
        int indexOfBook = 0;

        for (int i=0; i<this.getNumberOfRacks()/getNumberOfBooks(); i++){
            for (int j=0; j<this.getNumberOfBooks(); j++){
                this.setBookInARack(i,j,getAllBooks().get(indexOfBook));
                indexOfBook++;
            }
        }

    }

    public void addBookInLibrary(Book toBeAdded){
        this.getAllBooks().add(toBeAdded);
    }

    public void showAllSortedBook(){
        System.out.printf("[");
        int j;
        for (int i=0; i<this.getNumberOfRacks()/getNumberOfBooks();i++){
            if (i==0)
                System.out.printf(" [\n");
            else
                System.out.printf("  [");
            for (j=0; j<this.getNumberOfBooks()-1; j++){
                System.out.printf(this.getBookInARack(i,j).toString());
            }
            if (i==this.getNumberOfRacks()/getNumberOfBooks()-1)
                System.out.printf("%s ] ]\n",this.getBookInARack(i,this.getNumberOfBooks()-1).toString());
            else
                System.out.printf("%s ]\n",this.getBookInARack(i,this.getNumberOfBooks()-1).toString());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter number of Books in Library :");
        int N = Integer.parseInt(scan.nextLine().trim());
        System.out.printf("Enter number of Racks in Library :");
        int K = Integer.parseInt(scan.nextLine().trim());
        while (N%K!=0){
            System.out.println("\nNumber of Books should be a multiple of number of Racks in the Library\nEnter again");
            System.out.printf("\nEnter number of Books in Library :");
            N = Integer.parseInt(scan.nextLine().trim());
            System.out.printf("Enter number of Racks in Library :");
            K = Integer.parseInt(scan.nextLine().trim());
        }
        System.out.println();

        Library myLibrary = new Library(N,K);

        for (int bookNumber=0; bookNumber<N; bookNumber++){
            System.out.printf("\nEnter the %dth Book details below",bookNumber+1);
            System.out.printf("Book Title Name :");
            String bookTitle = scan.nextLine().trim();
            System.out.printf("Book ISBN :");
            long isbn = Long.parseLong(scan.nextLine().trim());
            System.out.printf("Book Barcode :");
            long barcode = Long.parseLong(scan.nextLine().trim());
            Book newBook = new Book(bookTitle,barcode,isbn);
            myLibrary.addBookInLibrary(newBook);
        }

        myLibrary.sortAllBooks();
        myLibrary.arrangeBooks();
        myLibrary.showAllSortedBook();
    }
}
