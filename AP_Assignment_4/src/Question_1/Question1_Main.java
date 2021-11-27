package Question_1;

import java.util.Scanner;

public class Question1_Main {

    private void showOption(){
        System.out.println("1. To find the Rack number");
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
        myLibrary.sortAllBooks();
        myLibrary.arrangeBooks();

        System.out.println("\n\nBooks Arranged in Racks Successfully...\n\n");

        myLibrary.showAllSortedBook();

        int option;

    }



    /*
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
            Book newBook = new Book(bookTitle,myLibrary.bookBarcodeGenerator(),isbn);
            myLibrary.addBookInLibrary(newBook);
        }

        myLibrary.sortAllBooks();
        myLibrary.arrangeBooks();
        myLibrary.showAllSortedBook();

        System.out.println("\nBooks Arranged in Racks Successfully\n");
    }
    */
}
