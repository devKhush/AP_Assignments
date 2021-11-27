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

    public ArrayList<Long> getAllBarcodes() {
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
        Collections.sort(allBooks, new BookComparator());
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
        System.out.println("==========================================================================================");
        System.out.printf("All the %d Books are arranged in the %d Racks as shown",this.getNumberOfBooks(),this.getNumberOfRacks());
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

}
