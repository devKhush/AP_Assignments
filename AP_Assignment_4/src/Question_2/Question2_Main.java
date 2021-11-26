package Question_2;

import Question_1.Book;

import java.util.HashMap;
import java.util.Scanner;

public class Question2_Main {

    private HashMap<Integer, Image> images;

    private HashMap<Integer, Image> getImages() {
        return images;
    }

    private void setImages(HashMap<Integer, Image> images) {
        this.images = images;
    }

    private Question2_Main() {
        this.setImages(new HashMap<Integer,Image>());
    }

    private void showOptions(){
        System.out.println("======================================================================================");
        System.out.println("""
                All available operations on Image are :
                
                1. Input a Image of any pixel Size (with pixel values as input)
                2. Create a Default Image of any pixel Size (with pixel values as either all 0's or 255)
                3. Update the pixel value of a Image
                4. Display the pixel values of a Image
                5. To compute negative of a Image
                6. To exit the program""");
        System.out.println("======================================================================================");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println();

        Question2_Main q2 = new Question2_Main();
        System.out.println("Welcome to Image Processing!!!\n");
        q2.showOptions();
        int option;
        System.out.println();
        //System.out.println("--------------------------------------------------------------------------------------------------------------");

        ImageProcessing<Image> imageProcessor = new ImageProcessing<Image>();

        while(true){
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("You're Currently in Main thread");
            System.out.println("Enter '0' for repeating all available options");
            System.out.printf("Enter Image operation's option number\n> ");
            option = Integer.parseInt(scan.nextLine().trim());

            if(option==0)
                q2.showOptions();

            else if (option==6) {
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                break;
            }

            else if (option==1){
                System.out.printf("\nWhich image you want to create \"Colour Image (enter 1)\" or \"Black and White Image (enter 0)\" :");
                int imageType = Integer.parseInt(scan.nextLine().trim());
                Image imageToBeMade;
                if (imageType!=0 && imageType!=1){
                    System.out.println("""
                            Wrong option entered!
                            Enter '0' to make a Colourful Image or '0' to make a Black and White Image
                            Try again!""");
                    continue;
                }
                System.out.printf("Enter the number of Pixels in the Rows of Image :");
                int pixelRows = Integer.parseInt(scan.nextLine().trim());
                System.out.printf("Enter the number of Pixels in the Columns of Image :");
                int pixelColumns = Integer.parseInt(scan.nextLine().trim());
                if (imageType==1){
                    imageToBeMade = new ColourImage(pixelRows,pixelColumns);
                }
                else {
                    imageToBeMade = new BlackAndWhiteImage(pixelRows,pixelColumns);
                }
                imageToBeMade.setID();
                imageProcessor.inputImage(imageToBeMade);
                q2.getImages().put(imageToBeMade.getID(),imageToBeMade);
                System.out.println("Image ID = "+imageToBeMade.getID());

            }

            else if (option==2){
                System.out.printf("\nWhich image you want to create \"Colour Image (enter 1)\" or \"Black and White Image (enter 0)\" :");
                int imageType = Integer.parseInt(scan.nextLine().trim());
                Image imageToBeMade;
                if (imageType!=0 && imageType!=1){
                    System.out.println("""
                            Wrong option entered!
                            Enter '0' to make a Colourful Image or '0' to make a Black and White Image
                            Try again!""");
                    continue;
                }
                System.out.printf("Enter the number of Pixels in the Rows of Image :");
                int pixelRows = Integer.parseInt(scan.nextLine().trim());
                System.out.printf("Enter the number of Pixels in the Columns of Image :");
                int pixelColumns = Integer.parseInt(scan.nextLine().trim());
                if (imageType==1){
                    imageToBeMade = new ColourImage(pixelRows,pixelColumns);
                }
                else {
                    imageToBeMade = new BlackAndWhiteImage(pixelRows,pixelColumns);
                }
                imageToBeMade.setID();
                imageProcessor.createDefaultImage(imageToBeMade);
                q2.getImages().put(imageToBeMade.getID(),imageToBeMade);
                System.out.println("Image ID = "+imageToBeMade.getID());
            }

            else if (option==3){
                System.out.printf("Enter the ID of the Image to update its Pixel Value :");
                int id = Integer.parseInt(scan.nextLine().trim());
                Image imageToUpdate = q2.getImages().get(id);
                if (imageToUpdate!=null){
                    imageProcessor.changePixelValueOfImage(imageToUpdate);
                }
                else{
                    System.out.println("No Image with this ID");
                }
            }

            else if (option==4){
                System.out.printf("Enter the ID of the Image to display its Pixel Value :");
                int id = Integer.parseInt(scan.nextLine().trim());
                Image imageToDisplay = q2.getImages().get(id);
                if (imageToDisplay!=null){
                    imageProcessor.displayImage(imageToDisplay);
                    System.out.println("Image ID = "+imageToDisplay.getID());
                }
                else{
                    System.out.println("No Image with this ID");
                }
            }

            else if (option==5){
                System.out.printf("Enter the ID of the Image to Compute its Negative Image :");
                int id = Integer.parseInt(scan.nextLine().trim());
                Image imageToComputeNegative = q2.getImages().get(id);
                if (imageToComputeNegative!=null){
                    imageProcessor.computeNegative(imageToComputeNegative);
                }
                else{
                    System.out.println("No Image with this ID");
                }
            }
            else{
                System.out.println("Wrong option entered!");
            }
        }

    }

}
