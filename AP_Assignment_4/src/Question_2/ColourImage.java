package Question_2;

import java.util.Arrays;
import java.util.Scanner;

public class ColourImage extends Image{

    ColourImage(int rows, int columns){
        this.setPixelRows(rows);
        this.setPixelColumn(columns);
        this.setImagePixelMatrix(new int[3][rows][columns]);
    }

    @Override
    public int getPixelValueOfImageMatrix(int colour, int i, int j){
        return getImagePixelMatrix()[colour][i][j];
    }

    @Override
    public void inputImage() {
        Scanner scan = new Scanner(System.in);
        for (int colour =0; colour<3; colour++) {
            String rbg = (colour==0) ? "RedImage" : ((colour==1) ? "BlueImage" : "GreenImage");
            System.out.println();
            for (int i = 0; i < this.getPixelRows(); i++) {
                for (int j = 0; j < this.getPixelColumn(); j++) {
                    System.out.printf("Enter the pixel value of %s[%d][%d] matrix :",rbg, i + 1, j + 1);
                    int pixelValue = Integer.parseInt(scan.nextLine().trim());
                    while (pixelValue > 255 || pixelValue < 0) {
                        System.out.println("Only enter 8-bit values, numbers between 0-255");
                        System.out.printf("Enter the pixel value of %s[%d][%d] matrix :",rbg, i + 1, j + 1);
                        pixelValue = Integer.parseInt(scan.nextLine().trim());
                    }
                    this.updateImage(colour,i, j, pixelValue);
                }
            }
        }
    }

    @Override
    public void createDefaultImage(boolean allOnes){
        for (int colour=0; colour<3; colour++) {
            for (int i = 0; i < this.getPixelRows(); i++) {
                for (int j = 0; j < this.getPixelColumn(); j++) {
                    if (allOnes)
                        this.updateImage(colour,i,j,255);
                    else
                        this.updateImage(colour,i,j,0);
                }
            }
        }
    }

    @Override
    public void displayImage(){
        for(int colour = 0; colour<3; colour++){
            String rbg = (colour==0) ? "Red" : ((colour==1) ? "Blue" : "Green");
            System.out.println(rbg+" Image's Pixels");
            System.out.printf("[");
            for (int i=0; i<this.getPixelRows();i++){
                if (i==0)
                    System.out.printf(" [");
                else
                    System.out.printf("  [");
                for (int j=0; j<this.getPixelColumn()-1; j++){
                    System.out.printf("%d, ",this.getPixelValueOfImageMatrix(colour,i,j));
                }
                if (i==this.getPixelRows()-1)
                    System.out.printf("%d ] ]\n", this.getPixelValueOfImageMatrix(colour,i,getPixelColumn()-1));
                else
                    System.out.printf("%d ]\n",this.getPixelValueOfImageMatrix(colour,i,getPixelColumn()-1));
            }
        }
    }

    @Override
    public void updateImage(int colour, int row,int column, int value){
        this.getImagePixelMatrix()[colour][row][column] =value;
    }

    @Override
    public void changePixelValueInImage(int row, int column){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter the Colour of the Image whose pixel value to be changed (Red/Blue/Green) :");
        String colour = scan.nextLine().trim();
        while(!(colour.equalsIgnoreCase("red") || colour.equalsIgnoreCase("blue") || colour.equalsIgnoreCase("green"))){
            System.out.println("Only Enter Colour as Red/Blue/Green");
            System.out.printf("Enter the Colour of the Image whose pixel value to be changed (Red/Blue/Green) :");
            colour = scan.nextLine().trim();
        }
        System.out.println();
        int rbg = (colour.equalsIgnoreCase("red")) ? 0 : ((colour.equalsIgnoreCase("blue")) ? 1 : 2);
        System.out.printf("Enter the pixel value of %sImage[%d][%d] matrix :",colour,row,column);
        int pixelValue = Integer.parseInt(scan.nextLine().trim());
        while(pixelValue>255 || pixelValue<0){
            System.out.println("Only enter 8-bit values, numbers between 0-255");
            System.out.printf("Enter the pixel value of %sImage[%d][%d] matrix :",colour,row,column);
            pixelValue = Integer.parseInt(scan.nextLine().trim());
        }
        this.updateImage(rbg,row-1,column-1,pixelValue);

    }

    public static void main(String[] args) {
        Image rbg = new ColourImage(2,2);
        System.out.println(Arrays.deepToString(rbg.getImagePixelMatrix()));
        rbg.createDefaultImage(true);
        System.out.println();
        rbg.displayImage();
        rbg.updateImage(1,1,1,22);
        System.out.println();
        rbg.displayImage();
        rbg.inputImage();
        rbg.displayImage();
    }
}
