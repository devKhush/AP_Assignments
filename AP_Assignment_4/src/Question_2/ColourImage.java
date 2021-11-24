package Question_2;

public abstract class ColourImage extends Image{
    private int[][] redImagePixelMatrix;
    private int[][] blueImagePixelMatrix;
    private int[][] greenImagePixelMatrix;


    ColourImage(int rows, int columns){
        this.setPixelRows(rows);
        this.setPixelColumn(columns);
        setBlueImagePixelMatrix(new int[rows][columns]);
        setRedImagePixelMatrix(new int[rows][columns]);
        setGreenImagePixelMatrix(new int[rows][columns]);
    }

    public int[][] getRedImagePixelMatrix() {
        return redImagePixelMatrix;
    }

    public int[][] getBlueImagePixelMatrix() {
        return blueImagePixelMatrix;
    }

    public int[][] getGreenImagePixelMatrix() {
        return greenImagePixelMatrix;
    }

    public void setGreenImagePixelMatrix(int[][] greenImagePixelMatrix) {
        this.greenImagePixelMatrix = greenImagePixelMatrix;
    }

    public void setBlueImagePixelMatrix(int[][] blueImagePixelMatrix) {
        this.blueImagePixelMatrix = blueImagePixelMatrix;
    }

    public void setRedImagePixelMatrix(int[][] redImagePixelMatrix) {
        this.redImagePixelMatrix = redImagePixelMatrix;
    }
}
