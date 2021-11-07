import java.util.Arrays;
import java.util.Scanner;

public class SquareMatrix extends Matrix{

    @Override
    public double[][] getTransposeMatrix(){
        return this.calculateTranspose();
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
        return this.calculateDeterminant();
    }

    @Override
    public boolean isSymmetric(){
        return Arrays.deepEquals(this.getMatrix(), this.getTransposeMatrix());
    }

    @Override
    public boolean isSkewSymmetric(){
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
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        switch (this.getClass().getName()) {
            case "SymmetricMatrix":
                System.out.printf("Enter dimension of symmetric square matrix (one number): ");
                break;
            case "SkewSymmetricMatrix":
                System.out.printf("Enter dimension of skew-symmetric square matrix (one number): ");
                break;
            case "LowerTriangularMatrix":
                System.out.printf("Enter dimension of Lower-Triangular square matrix (one number): ");
                break;
            case "UpperTriangularMatrix":
                System.out.printf("Enter dimension of Upper-Traingular square matrix (one number): ");
                break;
            case "SingularMatrix":
                System.out.println("Enter dimension of Singular square matrix (one number):");
                break;
            default:
                System.out.printf("Enter dimension of square matrix (one number): ");

        }
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.setMatrix(new double[dimension][dimension]);
        this.setRows(dimension);
        this.setColumns(dimension);
        for (int i=0; i<dimension; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<dimension; j++){
                double matrixElement = Double.parseDouble(rowInputArray[j]);
                this.changeElementOfMatrix(i,j , matrixElement);
            }
        }
        //this.id = this.staticID;
        this.setID();
    }

    @Override
    public double[][] getInverse(boolean toBeReturned){
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
            System.out.println("Dimensions of both the matrix should be same for Division");
            return;
        }
        Matrix B_Inverse = new SquareMatrix();
        B_Inverse.setRows(B.getRows());
        B_Inverse.setColumns(B.getColumns());
        B_Inverse.setMatrix(B.getInverse(true));
        this.printMatrix(this.matrixMultiplicationWithMatrixReturn(B_Inverse));
    }

    @Override
    public void solveLinearEquation(Matrix B){
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
        Matrix transpose = new SquareMatrix();
        transpose.setRows(this.getRows());
        transpose.setColumns(this.getColumns());
        transpose.setMatrix(this.getTransposeMatrix());
        this.printMatrix(this.matrixAddition(transpose,true));
    }

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

    public static void main(String[] args) {
        Matrix sm = new SquareMatrix();
        sm.inputMatrix();
        sm.printMatrix();
        sm.printMatrix(sm.getTransposeMatrix());
        System.out.println(sm.isSymmetric());
        System.out.println(sm.getId());
        System.out.println(sm.getRows());
        System.out.println(sm.getColumns());
        sm.getAllTypes();
        System.out.println();

        Matrix rm = new RectangularMatrix();
        rm.inputMatrix();
        rm.printMatrix();
        System.out.println(rm.getId());
        System.out.println(rm.getRows());
        System.out.println(rm.getColumns());
        System.out.println();

        Matrix sm1 = new SquareMatrix();
        sm1.inputMatrix();
        sm1.printMatrix();
        System.out.println(sm1.getId());
        System.out.println(sm1.getRows());
        System.out.println(sm1.getColumns());

        System.out.println();
        sm.matrixMultiplicationWithMatrix(rm);
    }
}
