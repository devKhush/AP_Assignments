package Question_2;

public abstract class BlackAndWhiteImage extends Image{
    private int[][] grayImagePixelMatrix;

    public int[][] getGrayImagePixelMatrix() {
        return grayImagePixelMatrix;
    }

    public void setGrayImagePixelMatrix(int[][] grayImagePixelMatrix) {
        this.grayImagePixelMatrix = grayImagePixelMatrix;
    }

    BlackAndWhiteImage (int rows, int columns){
        this.setPixelRows(rows);
        this.setPixelColumn(columns);
        setGrayImagePixelMatrix(new int[rows][columns]);
    }
}
