package Question_2;

abstract class Image {
    private int pixelRows;
    private int pixelColumn;
    private int ID;

    private static int IDcounter = 0;

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

    public abstract void updateImage();

    public abstract void inputImage();

}
