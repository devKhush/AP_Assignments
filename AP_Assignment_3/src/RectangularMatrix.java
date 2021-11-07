import java.util.Arrays;
import java.util.Scanner;

public class RectangularMatrix extends Matrix{
//    private int rows;
//    private int columns;
//    private double[][] matrix;
//    private int id;

    @Override
    public void changeElement(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the row number to change element :");
        int i = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the column number to change element :");
        int j = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the new value :");
        double value = Double.parseDouble(sc.nextLine());
        this.changeElementOfMatrix(i,j,value);
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions as <rows><space><columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        this.setMatrix(new double[row][column]);
        this.setRows(row);
        this.setColumns(column);
        for (int i=0; i<row; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<column; j++){
                double matrixElement = Double.parseDouble(rowInputArray[j]);
                this.changeElementOfMatrix(i,j , matrixElement);
//                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        //this.id = staticID;
        this.setID();
    }

    @Override
    public void matrixDivisionWithMatrix(Matrix B){
        if (B.getRows()!=B.getColumns()){
            System.out.println("Divisor must be Square Matrix");
            return;
        }
        if (B.getDeterminant()==0){
            System.out.println("Can't perform division as determinant of second matrix is 0");
            return;
        }
        if (this.getColumns()!=B.getRows()){
            System.out.println("Condition for both the matrix doesn't satisfy for Division");
            return;
        }
        Matrix B_Inverse = new SquareMatrix();
        B_Inverse.setRows(B.getRows());
        B_Inverse.setColumns(B.getColumns());
        B_Inverse.setMatrix(B.getInverse(true));
        this.printMatrix(this.matrixMultiplicationWithMatrixReturn(B_Inverse));
    }

    public double calculateDeterminant(){
        if (this.getRows()==1){
            return this.getElementOfMatrix(0,0);
        }
        if (this.getRows()==2){
            return (this.getElementOfMatrix(0,0)*this.getElementOfMatrix(1,1))-(this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,0));
        }
        else{
            double term1 = (this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,2))-(this.getElementOfMatrix(1,2)*this.getElementOfMatrix(2,1));
            double term2 = (this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,2))-(this.getElementOfMatrix(1,2)*this.getElementOfMatrix(2,0));
            double term3 = (this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,1))-(this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,0));
            return (this.getElementOfMatrix(0,0)*term1)-(this.getElementOfMatrix(0,1)*term2)+(this.getElementOfMatrix(0,2)*term3);
        }
    }

    @Override
    public double getDeterminant(){
        if (this.getRows()!=this.getColumns()){
            System.out.println("Can't find Determinant as its not a square matrix");
            return Double.MIN_VALUE;
        }
        return this.calculateDeterminant();
    }

    @Override
    public boolean isSymmetric(){
        if (this.getRows()!=this.getColumns())
            return false;
        else
            return Arrays.deepEquals(this.getMatrix(), this.getTransposeMatrix());
    }

    @Override
    public boolean isSkewSymmetric(){
        if (this.getRows()!=this.getColumns())
            return false;

        double[][] negativeOfMatrix = this.matrixMultiplicationWithScalarReturn(-1);
        double[][] transpose = this.getTransposeMatrix();
        boolean isSkewSymmetric = true;
        for (int i=0; i<this.getRows(); i++){
            for (int j=0; j<this.getColumns(); j++){
                if (negativeOfMatrix[i][j]!=transpose[i][j])
                    isSkewSymmetric=false;
            }
        }
        return isSkewSymmetric;
        //return Arrays.deepEquals(this.matrixMultiplicationWithScalarReturn(-1), this.getTransposeMatrix());
    }

    @Override
    public double[][] getInverse(boolean toBeReturned){
        if (this.getRows()!=this.getColumns()) {
            System.out.println("Can't find inverse as its not a Square Matrix");
            return new double[][]{{Double.MIN_VALUE}};
        }
        if (this.getDeterminant()==0){
            System.out.println("Can't find inverse as determinant is 0");
            return new double[][]{{Double.MIN_VALUE}};
        }
        if (this.getRows()==1){
            double[][] adjointMatrix = new double[this.getRows()][this.getRows()];
            adjointMatrix[0][0] = this.getElementOfMatrix(0,0);
            Matrix adjoint = new Matrix();
            adjoint.setRows(this.getRows());
            adjoint.setColumns(this.getColumns());
            adjoint.setMatrix(adjointMatrix);
            double[][] inverse = adjoint.matrixDivisionWithScalarReturn(this.getDeterminant());
            if (toBeReturned)
                return inverse;
            this.printMatrix(inverse);
            return new double[][]{{Double.MIN_VALUE}};
        }
        else if (this.getRows()==2){
            double[][] adjointMatrix = new double[this.getRows()][this.getRows()];
            adjointMatrix[0][0] = this.getElementOfMatrix(1,1);
            adjointMatrix[1][1] = this.getElementOfMatrix(0,0);
            adjointMatrix[0][1] = -this.getElementOfMatrix(0,1);
            adjointMatrix[1][0] = -this.getElementOfMatrix(1,0);
            Matrix adjoint = new Matrix();
            adjoint.setRows(this.getRows());
            adjoint.setColumns(this.getColumns());
            adjoint.setMatrix(adjointMatrix);
            double[][] inverse = adjoint.matrixDivisionWithScalarReturn(this.getDeterminant());
            if (toBeReturned)
                return inverse;
            this.printMatrix(inverse);
            return new double[][]{{Double.MIN_VALUE}};
        }
        else if (this.getRows()==3){
            double[][] adjointMatrix = new double[this.getRows()][this.getRows()];
            for (int i=0; i<this.getRows(); i++){
                for (int j=0; j<this.getRows(); i++){
                    adjointMatrix[i][j] = ( (adjointMatrix[(j+1)%this.getRows()][(i+1)%this.getRows()] * adjointMatrix[(j+2)%this.getRows()][(i+2)%this.getRows()]) - (adjointMatrix[(j+1)%this.getRows()][(i+2)%this.getRows()] * adjointMatrix[(j+2)%this.getRows()][(i+1)%this.getRows()]));
                }
            }
            Matrix adjoint = new Matrix();
            adjoint.setRows(this.getRows());
            adjoint.setColumns(this.getColumns());
            adjoint.setMatrix(adjointMatrix);
            double[][] inverse = adjoint.matrixDivisionWithScalarReturn(this.getDeterminant());
            if (toBeReturned)
                return inverse;
            this.printMatrix(inverse);
            return new double[][]{{Double.MIN_VALUE}};
        }
        return new double[][]{{Double.MIN_VALUE}};
    }

    @Override
    public void solveLinearEquation(Matrix B){
        if (this.getRows()!=this.getColumns()){
            System.out.println("Matrix A must be square matrix");
            return;
        }
        if (this.getDeterminant()==0){
            System.out.println("Can't solve equations as determinant of the matrix is 0");
            return;
        }
        if (B.getColumns()!=1){
            System.out.println("Matrix B must be a Column matrix");
            return;
        }
        if (this.getColumns()!=B.getRows()){
            System.out.println("Numbers of Rows of A and B must be same");
            return;
        }
        Matrix A_Inverse = new SquareMatrix();
        A_Inverse.setRows(this.getRows());
        A_Inverse.setColumns(this.getColumns());
        A_Inverse.setMatrix(this.getInverse(true));
        A_Inverse.printMatrix(A_Inverse.matrixMultiplicationWithMatrixReturn(B));
    }

    @Override
    public void matrixPlusItsTranspose(){
        if (this.getRows()!=this.getColumns()){
            System.out.println("This Matrix must be a square matrix");
            return;
        }
        Matrix transpose = new SquareMatrix();
        transpose.setRows(this.getRows());
        transpose.setColumns(this.getColumns());
        transpose.setMatrix(this.getTransposeMatrix());
        this.printMatrix(this.matrixAddition(transpose,true));
    }

    public static void main(String[] args) {
        Matrix rm = new RectangularMatrix();
        rm.inputMatrix();
        rm.printMatrix();
        System.out.println(rm.getRows());
        System.out.println(rm.getColumns());
        System.out.println(rm.getClass().getName());
        System.out.println(rm.getId());

        System.out.println();
        Matrix rm1 = new RectangularMatrix();
        rm1.inputMatrix();
        rm1.printMatrix();
        rm1.printMatrix(rm1.getTransposeMatrix());
        System.out.println(rm1.getRows());
        System.out.println(rm1.getColumns());
        System.out.println(rm1.getClass().getName());
        System.out.println(rm1.getId());
    }

}
