import java.util.Arrays;
import java.util.Scanner;

public class RectangularMatrix extends Matrix{

    @Override
    public void getAllTypes(){
//        if (this.getRows()==this.getColumns())
//            System.out.println("Square Matrix");
//        else
        System.out.println("Rectangular Matrix");
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

    @Override
    public boolean inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions as <rows><space><columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        boolean isMade = true;
        if (row==column){
            System.out.println("Can' make a rectangular Matrix with equal rows and column");
            isMade=false;
            return isMade;
        }
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
        this.setID();
        return true;
    }

    @Override
    public void matrixDivisionWithMatrix(Matrix B){
        if (B.getRows()!=B.getColumns()){
            System.out.println("Divisor must be Square Matrix");
            return;
        }
        if (B.getDeterminant()==0){
            System.out.println("Can't perform division as second matrix is Singular Matrix");
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

//    public double calculateDeterminant(){
//        if (this.getRows()==1){
//            return this.getElementOfMatrix(0,0);
//        }
//        if (this.getRows()==2){
//            return (this.getElementOfMatrix(0,0)*this.getElementOfMatrix(1,1))-(this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,0));
//        }
//        else{
//            double term1 = (this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,2))-(this.getElementOfMatrix(1,2)*this.getElementOfMatrix(2,1));
//            double term2 = (this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,2))-(this.getElementOfMatrix(1,2)*this.getElementOfMatrix(2,0));
//            double term3 = (this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,1))-(this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,0));
//            return (this.getElementOfMatrix(0,0)*term1)-(this.getElementOfMatrix(0,1)*term2)+(this.getElementOfMatrix(0,2)*term3);
//        }
//    }

//    @Override
//    public double getDeterminant(){
//        if (this.getRows()!=this.getColumns()){
//            System.out.println("Can't find Determinant as its not a square matrix");
//            return Double.MIN_VALUE;
//        }
//        return this.calculateDeterminant();
//    }

//    @Override
//    public boolean isSymmetric(){
//        if (this.getRows()!=this.getColumns())
//            return false;
//        else
//            return Arrays.deepEquals(this.getMatrix(), this.getTransposeMatrix());
//    }

//    @Override
//    public boolean isSkewSymmetric(){
//        if (this.getRows()!=this.getColumns())
//            return false;
//
//        double[][] negativeOfMatrix = this.matrixMultiplicationWithScalarReturn(-1);
//        double[][] transpose = this.getTransposeMatrix();
//        boolean isSkewSymmetric = true;
//        for (int i=0; i<this.getRows(); i++){
//            for (int j=0; j<this.getColumns(); j++){
//                if (negativeOfMatrix[i][j]!=transpose[i][j])
//                    isSkewSymmetric=false;
//            }
//        }
//        return isSkewSymmetric;
//        //return Arrays.deepEquals(this.matrixMultiplicationWithScalarReturn(-1), this.getTransposeMatrix());
//    }

//    @Override
//    public double[][] getAdjointof3x3Matrix(){
//        double[][] cofactorMatrix = new double[this.getRows()][this.getColumns()];
//        cofactorMatrix[0][0] = 1*((this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,1)*this.getElementOfMatrix(1,2)));
//        cofactorMatrix[0][1] = -1*((this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,0)*this.getElementOfMatrix(1,2)));
//        cofactorMatrix[0][2] = 1*((this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,1)) - (this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,0)));
//        cofactorMatrix[1][0] = -1*((this.getElementOfMatrix(0,1)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,1)*this.getElementOfMatrix(0,2)));
//        cofactorMatrix[1][1] = 1*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,0)*this.getElementOfMatrix(0,2)));
//        cofactorMatrix[1][2] = -1*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(2,1)) - (this.getElementOfMatrix(2,0)*this.getElementOfMatrix(0,1)));
//        cofactorMatrix[2][0] = 1*((this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,2)) - (this.getElementOfMatrix(1,1)*this.getElementOfMatrix(0,2)));
//        cofactorMatrix[2][1] = -1*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(1,2)) - (this.getElementOfMatrix(1,0)*this.getElementOfMatrix(0,2)));
//        cofactorMatrix[2][2] = 1*((this.getElementOfMatrix(1,1)*this.getElementOfMatrix(0,0)) - (this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,0)));
//
//        Matrix cofactor = new SquareMatrix();
//        cofactor.setRows(this.getRows());
//        cofactor.setColumns(this.getColumns());
//        cofactor.setMatrix(cofactorMatrix);
//        double[][] adjointMatrix = cofactor.calculateTranspose();
//        return adjointMatrix;
//    }

//    @Override
//    public double[][] getInverse(boolean toBeReturned){
//        if (this.getRows()!=this.getColumns()) {
//            System.out.println("Can't find inverse as its not a Square Matrix");
//            return new double[][]{{Double.MIN_VALUE}};
//        }
//        if (this.getDeterminant()==0){
//            System.out.println("Can't find inverse as determinant is 0");
//            return new double[][]{{Double.MIN_VALUE}};
//        }
//        if (this.getRows()==1){
//            double[][] adjointMatrix = new double[this.getRows()][this.getRows()];
//            adjointMatrix[0][0] = 1.0;
//            Matrix adjoint = new Matrix();
//            adjoint.setRows(this.getRows());
//            adjoint.setColumns(this.getColumns());
//            adjoint.setMatrix(adjointMatrix);
//            double[][] inverse = adjoint.matrixDivisionWithScalarReturn(this.getDeterminant());
//            if (toBeReturned)
//                return inverse;
//            this.printMatrix(inverse);
//            return new double[][]{{Double.MIN_VALUE}};
//        }
//        else if (this.getRows()==2){
//            double[][] adjointMatrix = new double[this.getRows()][this.getRows()];
//            adjointMatrix[0][0] = this.getElementOfMatrix(1,1);
//            adjointMatrix[1][1] = this.getElementOfMatrix(0,0);
//            adjointMatrix[0][1] = -this.getElementOfMatrix(0,1);
//            adjointMatrix[1][0] = -this.getElementOfMatrix(1,0);
//            Matrix adjoint = new Matrix();
//            adjoint.setRows(this.getRows());
//            adjoint.setColumns(this.getColumns());
//            adjoint.setMatrix(adjointMatrix);
//            double[][] inverse = adjoint.matrixDivisionWithScalarReturn(this.getDeterminant());
//            if (toBeReturned)
//                return inverse;
//            this.printMatrix(inverse);
//            return new double[][]{{Double.MIN_VALUE}};
//        }
//        else if (this.getRows()==3){
//            double[][] adjointMatrix = this.getAdjointof3x3Matrix();;
//            Matrix adjoint = new Matrix();
//            adjoint.setRows(this.getRows());
//            adjoint.setColumns(this.getColumns());
//            adjoint.setMatrix(adjointMatrix);
//            double[][] inverse = adjoint.matrixDivisionWithScalarReturn(this.getDeterminant());
//            if (toBeReturned)
//                return inverse;
//            this.printMatrix(inverse);
//            return new double[][]{{Double.MIN_VALUE}};
//        }
//        return new double[][]{{Double.MIN_VALUE}};
//    }


//    @Override
//    public void matrixPlusItsTranspose(){
//        if (this.getRows()!=this.getColumns()){
//            System.out.println("This Matrix must be a square matrix");
//            return;
//        }
//        Matrix transpose = new SquareMatrix();
//        transpose.setRows(this.getRows());
//        transpose.setColumns(this.getColumns());
//        transpose.setMatrix(this.getTransposeMatrix());
//        this.printMatrix(this.matrixAddition(transpose,true));
//    }


}
