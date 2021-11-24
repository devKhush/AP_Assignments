package Question_2;

public class BlackAndWhiteImage extends Image{

    public BlackAndWhiteImage (int rows, int columns){
        this.setPixelRows(rows);
        this.setPixelColumn(columns);
        this.setImagePixelMatrix(new int[1][rows][columns]);
    }

    @Override
    public int getPixelValueOfImageMatrix(int unUsed, int i, int j){
        return getImagePixelMatrix()[1][i][j];
    }

    @Override
    public void createDefaultImage(){
        for (int i =0; i<this.getPixelRows(); i++){
            for(int j=0; j<this.getPixelColumn(); j++){
                this.updateImage(i,j,0);
            }
        }
    }

    @Override
    public void displayImage(){
        System.out.printf("[");
        for (int i=0; i<this.getPixelRows();i++){
            if (i==0)
                System.out.printf(" [");
            else
                System.out.printf("  [");
            for (int j=0; j<this.getPixelColumn()-1; j++){
                System.out.printf("%d, ",this.getPixelValueOfImageMatrix(1,i,j));
            }
            if (i==this.getPixelRows()-1)
                System.out.printf("%d ] ]\n", this.getPixelValueOfImageMatrix(1,i,getPixelColumn()-1));
            else
                System.out.printf("%d ]\n",this.getPixelValueOfImageMatrix(1,i,getPixelColumn()-1));
        }
    }

    @Override
    public void updateImage(int i,int j, int value){
        this.getImagePixelMatrix()[1][i][j] = value;
    }
}
