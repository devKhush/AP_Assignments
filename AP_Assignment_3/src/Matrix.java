public class Matrix {
    protected int rows;
    protected int columns;
    protected double[][] matrix;
    protected int id;
    protected static int staticID=0;

    public void inputMatrix(){}

    public Matrix(){
        staticID++;
    }
    public int getColumns(){
        return this.columns;
    }
    public int getRows(){
        return this.rows;
    }
    public double[][] getMatrix(){
        return this.matrix;
    }
    public int getId(){
        return this.id;
    }

}
