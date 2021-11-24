package Question_2;

abstract class Image {
    private int pixelRows;
    private int pixelColumn;
    private int[][][] imagePixelMatrix;
    private int ID;

    private static int IDcounter = 0;

    public int[][][] getImagePixelMatrix() {
        return imagePixelMatrix;
    }

    public void setImagePixelMatrix(int[][][] imagePixelMatrix) {
        this.imagePixelMatrix = imagePixelMatrix;
    }

    public int getPixelRows() {
        return pixelRows;
    }

    public int getPixelColumn() {
        return pixelColumn;
    }

    public void setPixelColumn(int pixelColumn) {
        this.pixelColumn = pixelColumn;
    }

    public void setPixelRows(int pixelRows) {
        this.pixelRows = pixelRows;
    }

    public void setID(){
        this.ID = ++IDcounter;
    }

    public abstract void createDefaultImage();

    public abstract void displayImage();

    public abstract void updateImage(int i,int j,int value);

    public abstract int getPixelValueOfImageMatrix(int colour, int i, int j);

    // public abstract void inputImage();

}
