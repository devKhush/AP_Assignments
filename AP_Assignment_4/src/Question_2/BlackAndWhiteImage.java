package Question_2;

import java.util.Arrays;
import java.util.Scanner;

public class BlackAndWhiteImage extends Image{

    public BlackAndWhiteImage (int rows, int columns){
        this.setPixelRows(rows);
        this.setPixelColumn(columns);
        this.setImagePixelMatrix(new int[1][rows][columns]);
    }

    @Override
    public int getPixelValueOfImageMatrix(int unUsed, int i, int j){
        return getImagePixelMatrix()[0][i][j];
    }

    @Override
    public void createDefaultImage(boolean allOnes){
        for (int i =0; i<this.getPixelRows(); i++){
            for(int j=0; j<this.getPixelColumn(); j++){
                if (allOnes)
                    this.updateImage(0,i,j,255);
                else
                    this.updateImage(0,i,j,0);
            }
        }
    }

    @Override
    public void inputImage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("NOTE: Indexing starts with 1 ");
        for (int i =0; i<this.getPixelRows(); i++){
            System.out.println();
            for(int j=0; j<this.getPixelColumn(); j++){
                System.out.printf("Enter the pixel value of GrayImage[%d][%d] matrix :",i+1,j+1);
                int pixelValue = Integer.parseInt(scan.nextLine().trim());
                while(pixelValue>255 || pixelValue<0){
                    System.out.println("Only enter 8-bit values, numbers between 0-255");
                    System.out.printf("Enter the pixel value of GrayImage[%d][%d] matrix :",i+1,j+1);
                    pixelValue = Integer.parseInt(scan.nextLine().trim());
                }
                this.updateImage(0,i,j,pixelValue);
            }
        }
        System.out.printf("\nUpdated ");
    }

    @Override
    public void displayImage(){
        System.out.println("Black and White Image's Pixels");
        System.out.printf("[");
        for (int i=0; i<this.getPixelRows();i++){
            if (i==0)
                System.out.printf(" [");
            else
                System.out.printf("  [");
            for (int j=0; j<this.getPixelColumn()-1; j++){
                System.out.printf("%d, ",this.getPixelValueOfImageMatrix(0,i,j));
            }
            if (i==this.getPixelRows()-1)
                System.out.printf("%d ] ]\n", this.getPixelValueOfImageMatrix(0,i,getPixelColumn()-1));
            else
                System.out.printf("%d ]\n",this.getPixelValueOfImageMatrix(0,i,getPixelColumn()-1));
        }
    }

    @Override
    public void updateImage(int unused, int i,int j, int value){
        this.getImagePixelMatrix()[0][i][j] = value;
    }

    @Override
    public void changePixelValueInImage(int row, int column){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter the pixel value of GrayImage[%d][%d] matrix :",row,column);
        int pixelValue = Integer.parseInt(scan.nextLine().trim());
        while(pixelValue>255 || pixelValue<0){
            System.out.println("Only enter 8-bit values, numbers between 0-255");
            System.out.printf("Enter the pixel value of GrayImage[%d][%d] matrix :",row,column);
            pixelValue = Integer.parseInt(scan.nextLine().trim());
        }
        this.updateImage(0,row-1,column-1,pixelValue);
    }

    public static void main(String[] args) {
        Image bw = new BlackAndWhiteImage(3,2);
        System.out.println(Arrays.deepToString(bw.getImagePixelMatrix()));
        bw.createDefaultImage(true);
        System.out.println();
        bw.displayImage();
        bw.updateImage(0,2,1,22);
        System.out.println();
        bw.displayImage();
        bw.inputImage();
        bw.displayImage();
    }
}