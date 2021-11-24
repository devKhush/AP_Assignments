package Question_2;

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
    public void createDefaultImage(){
        for (int colour=0; colour<3; colour++) {
            for (int i = 0; i < this.getPixelRows(); i++) {
                for (int j = 0; j < this.getPixelColumn(); j++) {
                    this.updateImage(i, j, 0);
                }
            }
        }
    }

    @Override
    public void displayImage(){
        System.out.printf("[");
        for(int colour = 0; colour<3; colour++){
            if(colour==0)
                System.out.println("\nRed Image Pixels");
            else if (colour==1)
                System.out.println("\nBlue Image Pixels");
            else
                System.out.println("\nGreen Image Pixels");

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
    public void updateImage(int row,int column, int value){
        for (int colour =0; colour<3; colour++)
            this.getImagePixelMatrix()[colour][row][column] =value;
    }
}
