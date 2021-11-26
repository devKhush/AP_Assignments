package Question_2;

import java.util.Arrays;
import java.util.Scanner;

public class ImageProcessing <M extends Image>{

    public void computeNegative(M image){
        System.out.println("\nComputing the Negative of a Image...");
        int[][][] negativeImage = image.getImagePixelMatrix();
        int k = negativeImage.length;
        int i = negativeImage[0].length;
        int j = negativeImage[0][0].length;
        negativeImage = new int[k][i][j];
        for (int a =0; a<k; a++){
            for (int b =0; b<i; b++){
                for (int c=0; c<j; c++){
                    negativeImage[a][b][c] = 255 - image.getPixelValueOfImageMatrix(a,b,c);
                }
            }
        }
        System.out.println("Negative Image Matrix of this matrix is = ");
        for(int a = 0; a<k; a++){
            String colour =  (k==1)?("Black and White") : ((a==0) ? "Red" : ((a==1) ? "Blue" : "Green"));
            System.out.println(colour+" Negative Image's Pixels");
            System.out.printf("[");
            for (int b=0; b<i;b++){
                if (b==0)
                    System.out.printf(" [");
                else
                    System.out.printf("  [");
                for (int c=0; c<j-1; c++){
                    System.out.printf("%d, ",negativeImage[a][b][c]);
                }
                if (b==i-1)
                    System.out.printf("%d ] ]\n", negativeImage[a][b][j-1]);
                else
                    System.out.printf("%d ]\n",negativeImage[a][b][j-1]);
            }
        }
    }


    public void inputImage(M image){
        System.out.println("\n\nTaking pixel values inputs of the Image...");
        image.inputImage();
        System.out.println("\nSuccessfully created this Image with given Inputs");
    }

    public void displayImage(M image){
        System.out.println("\nDisplaying the Image with this ID...\n");
        image.displayImage();
    }

    public void createDefaultImage(M image){
        System.out.println("\nCreating a Default a Image...");
        Scanner scan = new Scanner(System.in);
        System.out.println("Default Images have their all Pixel values as either all 8-bit 0's OR  all 8-bit 1's");
        System.out.println("Whether you want to make Image with pixel values as all 8-bit Ones values ?");
        System.out.printf("Enter '1' for Yes OR '0' for No :");
        int yesOrNo = Integer.parseInt(scan.nextLine().trim());
        while (yesOrNo!=0 && yesOrNo!=1){
            System.out.printf("Only Enter '1' for Yes OR '0' for No :");
            yesOrNo = Integer.parseInt(scan.nextLine().trim());
        }
        boolean allOnes = yesOrNo==1;
        image.createDefaultImage(allOnes);
        System.out.println("\nSuccessfully created this Default Image");
    }

    public void changePixelValueOfImage(M image){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nChanging pixel value of the Image with this ID...\n");
        System.out.println("NOTE: Indexing starts with 1 ");
        System.out.printf("Enter the Row number to change Pixel value in Image :");
        int row = Integer.parseInt(scan.nextLine().trim());
        System.out.printf("Enter the Column number to change Pixel value in Image :");
        int column = Integer.parseInt(scan.nextLine().trim());
        image.changePixelValueInImage(row,column);
        System.out.println("\nSuccessfully Updated pixel value of this Image");
    }


    public static void main(String[] args) {
        ImageProcessing<Image> imageProcessing = new ImageProcessing<>();

        Image rbg = new ColourImage(2,2);
        System.out.println(Arrays.deepToString(rbg.getImagePixelMatrix()));
        rbg.createDefaultImage(true);
        rbg.displayImage();
        System.out.println();
        rbg.updateImage(1,1,1,22);
        System.out.println();
        rbg.displayImage();

        imageProcessing.computeNegative(rbg);
        rbg.displayImage();


        System.out.println("\n\n\n");
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

        imageProcessing.computeNegative(bw);
        bw.displayImage();

    }
}
