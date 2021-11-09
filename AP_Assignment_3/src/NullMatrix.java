import java.util.Arrays;
import java.util.Scanner;

public class NullMatrix extends RectangularMatrix{
    double nullElement = 0;

    @Override
    public double getNullElement() {
        return nullElement;
    }

    @Override
    public double getElementOfMatrix(int i,int j){
        return nullElement;
    }

    @Override
    public void getAllTypes(){
        System.out.println("NullMatrix");
        if (this.getRows()==this.getColumns())
            System.out.println("SquareMatrix");
        else
            System.out.println("RectangularMatrix");
    }

    @Override
    public boolean isSymmetric(){
        return this.getRows() == this.getColumns();
    }

    @Override
    public boolean isSkewSymmetric(){
        return this.getRows() == this.getColumns();
    }

    @Override
    public double getDeterminant(){
        if (this.getRows()==this.getColumns())
            return 0;
        System.out.println("Can't find determinant as this matrix is not a Square matrix");
        return Double.MIN_VALUE;
    }

    @Override
    public void solveLinearEquation(Matrix B){
        if (this.getRows()==this.getColumns())
            System.out.println("Can't solve equations as this matrix is Singular Matrix");
        else
            System.out.println("Can't solve equations as matrix is not Square Matrix");
    }

    @Override
    public void matrixPlusItsTranspose(){
        if (this.getRows()!=this.getColumns()){
            System.out.println("Can't perform as this Matrix must be a square matrix");
            return;
        }
        this.printMatrix();
    }

    @Override
    public double[][] getInverse(boolean toBeReturned){
        if (this.getRows()==this.getColumns())
            System.out.println("Can't find Inverse of this Matrix as it is a Singular Matrix");
        else
            System.out.println("Can't find Inverse of this Matrix as it is not a Square Matrix");
        return new double[][]{{Double.MIN_VALUE}};
    }

    @Override
    public boolean inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions of Null matrix as <rows><space><columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        this.setMatrix(new double[row][column]);
        this.setRows(row);
        this.setColumns(column);
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                this.changeElementOfMatrix(i,j,nullElement);
            }
        }
        // this.id = this.staticID++;
        this.setID();
        return true;
    }

    @Override
    public void matrixMultiplicationWithMatrix(Matrix B){
        if (this.getColumns()!=B.getRows()){
            System.out.println("Can't perform multiplication as the condition for matrix multiplication doesn't satisfy");
            return;
        }
        double[][] nullMatrix = new double[this.getRows()][B.getColumns()];
        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<B.getColumns(); j++){
                nullMatrix[i][j] = 0;
            }
        }
        this.printMatrix(nullMatrix);
    }

    @Override
    public void matrixElementWiseMultiplication(Matrix B){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform Element wise multiplication as Dimension of two matrices doesn't match");
            return;
        }
        double[][] product = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                product[i][j] = 0;
            }
        }
        this.printMatrix(product);
    }

    @Override
    public void matrixMultiplicationWithScalar(double scalar){
        double[][] product = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                product[i][j] = 0;
            }
        }
        this.printMatrix(product);
    }

    @Override
    public double[][] matrixAddition(Matrix B, boolean toBeReturned){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform addition as Dimension of two matrices doesn't match");
            return new double[][]{{Double.MIN_VALUE}};
        }
        if (toBeReturned)
            return B.getMatrix();
        B.printMatrix();
        return B.getMatrix();
    }

    @Override
    public void changeElement(){
        System.out.println("Can't change element of a null matrix");
    }

    @Override
    public void getEigenValues(){
        if (this.getRows()!=this.getColumns()){
            System.out.println("\nMatrix must be Square for finding Eigen Values");
            return;
        }
        SquareMatrix dummy = new SquareMatrix();
        dummy.setRows(this.getRows());
        dummy.setColumns(this.getColumns());
        dummy.setMatrix(this.getMatrix());
        dummy.getEigenValues();
    }

    @Override
    public void getEigenVectors(){
        if (this.getRows()!=this.getColumns()){
            System.out.println("\nMatrix must be Square for finding Eigen Values");
            return;
        }
        SquareMatrix dummy = new SquareMatrix();
        dummy.setRows(this.getRows());
        dummy.setColumns(this.getColumns());
        dummy.setMatrix(this.getMatrix());
        dummy.getEigenVectors();
    }

}
