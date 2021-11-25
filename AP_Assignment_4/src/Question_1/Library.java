package Question_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library {
    private final int numberOfBooks;          // N
    private final int numberOfRacks;          // K
    private final ArrayList<Book> allBooks;
    private final Book[][] sortedBooks;
    private final ArrayList<Long> allBarcodes;

    private static long bookBarcodeCounter = 1000_0000;

    public long bookBarcodeGenerator(){
        long barcode = bookBarcodeCounter;
        bookBarcodeCounter += 4;
        return barcode;
    }

    public Library(int N,int K){
        this.allBooks = new ArrayList<Book>();
        this.allBarcodes = new ArrayList<>();
        this.numberOfBooks = N;
        this.numberOfRacks = K;
        this.sortedBooks = new Book[getNumberOfRacks()][getNumberOfBooks()/getNumberOfRacks()];
    }

    private ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    private int getNumberOfBooks() {
        return numberOfBooks;
    }

    private ArrayList<Long> getAllBarcodes() {
        return allBarcodes;
    }

    private int getNumberOfRacks() {
        return numberOfRacks;
    }

    private void setBookInARack(int rackNumber, int bookPosition, Book toPlace){
        this.sortedBooks[rackNumber][bookPosition] = toPlace;
    }

    private Book getBookInARack(int rackNumber, int bookPosition){
        return this.sortedBooks[rackNumber][bookPosition];
    }

    public void sortAllBooks(){
        Collections.sort(allBooks);
    }

    public void arrangeBooks(){
        int indexOfBook = 0;
        for (int i=0; i<this.getNumberOfRacks(); i++){
            for (int j=0; j<this.getNumberOfBooks()/this.getNumberOfRacks(); j++){
                this.setBookInARack(i,j,getAllBooks().get(indexOfBook));
                indexOfBook++;
            }
        }

    }

    public void addBookInLibrary(Book toBeAdded){
        this.getAllBooks().add(toBeAdded);
        this.getAllBarcodes().add(toBeAdded.getBarcode());
    }

    public void showAllSortedBook(){
        System.out.println("\n\n");
        System.out.println("==========================================================================================");
        System.out.println("All Books are Sorted as shown");
        for (int i=0; i<getNumberOfRacks(); i++){
            System.out.println("\n==========================================================================================");
            System.out.printf("Rack number --> %d \n",i+1);
            System.out.println("--------------------");
            for (int j=0; j<getNumberOfBooks()/getNumberOfRacks(); j++){
                System.out.printf("Slot number %d : Book stored --> ",j+1);
                System.out.println(getBookInARack(i,j));
            }
        }
        System.out.println("==========================================================================================");

    }

    public static void main(String[] args) {

        System.out.println("\nWelcome to my Library!\n");
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter number of Books in Library \n> ");
        int N = Integer.parseInt(scan.nextLine().trim());
        System.out.printf("Enter number of Racks in Library \n> ");
        int K = Integer.parseInt(scan.nextLine().trim());
        while (N%K!=0){
            System.out.println("\nNumber of Books should be a multiple of number of Racks in the Library\nEnter again");
            System.out.printf("\nEnter number of Books in Library \n> ");
            N = Integer.parseInt(scan.nextLine().trim());
            System.out.printf("Enter number of Racks in Library \n> ");
            K = Integer.parseInt(scan.nextLine().trim());
        }

        Library myLibrary = new Library(N,K);

        for (int bookNumber=0; bookNumber<N; bookNumber++){
            System.out.printf("\n\nEnter the %dth Book details below \n",bookNumber+1);
            System.out.printf("Book Title Name :");
            String bookTitle = scan.nextLine().trim();
            System.out.printf("Book ISBN :");
            long isbn = Long.parseLong(scan.nextLine().trim());
            System.out.printf("Book Barcode :");
            long barcode = Long.parseLong(scan.nextLine().trim());
            if (!myLibrary.getAllBarcodes().contains(barcode)) {
                Book newBook = new Book(bookTitle, barcode, isbn);
                myLibrary.addBookInLibrary(newBook);
            }
            else{
                System.out.println("Book with this barcode is already present in Library");
                System.out.printf("Enter some different Barcode and Try Again");
                bookNumber--;
            }
        }

        //System.out.println(myLibrary.getAllBooks());
        myLibrary.sortAllBooks();
        //System.out.println(myLibrary.getAllBooks());
        myLibrary.arrangeBooks();
        myLibrary.showAllSortedBook();

        System.out.println("\nBooks Arranged in Racks Successfully\n");
    }
}
