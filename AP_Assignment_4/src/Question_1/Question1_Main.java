package Question_1;

import java.util.Scanner;

public class Question1_Main {

    private void showOptions(){
        System.out.println("======================================================================================");
        System.out.println("""
                All available options in the Library are :
                
                1. To find the Rack number and Slot number of the given Book in Library
                2. To print all the Racks in Library with all the Slots filled With Sorted Books
                3. To exit the program"""
        );
        System.out.println("======================================================================================");
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
            System.out.printf("Book ISBN number :");
            long isbn = Long.parseLong(scan.nextLine().trim());
            System.out.printf("Book Barcode number :");
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
        scan = null;
        scan = new Scanner(System.in);
        Question1_Main q1 = new Question1_Main();
        System.out.println("--------------------------------------------------------------------------------------------------------------\n");
        q1.showOptions();
        int option;
        System.out.println();

        while(true) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Enter '0' for repeating all available options");
            System.out.printf("Enter Option number from Above :\n> ");
            option = Integer.parseInt(scan.nextLine().trim());

            if (option == 0)
                q1.showOptions();

            else if (option==1){
                System.out.println("\nFinding the Rack number and Slot number of the said given Book...");
                System.out.printf("\nEnter the Title of of the Book :");
                String bookTitle = scan.nextLine().trim();
                System.out.printf("Enter the ISBN number of the Book :");
                long ISBN = Long.parseLong(scan.nextLine().trim());
                System.out.printf("Enter the Barcode number of the Book :");
                long barCode = Long.parseLong(scan.nextLine().trim());
                boolean bookFound = false;
                for (int rackNumber=0; rackNumber< myLibrary.getNumberOfRacks(); rackNumber++){
                    for (int slotNumber=0; slotNumber< myLibrary.getNumberOfBooks()/ myLibrary.getNumberOfRacks(); slotNumber++){
                        Book currentBook = myLibrary.getBookInARack(rackNumber,slotNumber);
                        if (currentBook.getBookTitle().equals(bookTitle) && (currentBook.getISBN()==ISBN) && (currentBook.getBarcode()==barCode)){
                            bookFound = true;
                            System.out.println("\nPosition of this book in Library is :");
                            System.out.printf("This book is placed in Rack number = %d and Slot number = %d\n",rackNumber+1,slotNumber+1);
                        }
                    }
                }
                if (!bookFound) {
                    System.out.println("\nNo Such Book with given details present in the Library!");
                }
                System.out.println();
            }

            else if (option==2)
                myLibrary.showAllSortedBook();

            else if (option == 3) {
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                break;
            }

            else
                System.out.println("Wrong option entered!");
        }
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

        System.out.println("\n\nBooks Arranged in Racks Successfully...\n\n");
        myLibrary.showAllSortedBook();
    }
    */
}
