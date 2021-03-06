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
    public boolean inputMatrix(){
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
        return true;
    }

    @Override
    public double[][] getAdjointof3x3Matrix(){
        double[][] cofactorMatrix = new double[this.getRows()][this.getColumns()];
        cofactorMatrix[0][0] = 1*((this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,1)*this.getElementOfMatrix(1,2)));
        cofactorMatrix[0][1] = -1*((this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,0)*this.getElementOfMatrix(1,2)));
        cofactorMatrix[0][2] = 1*((this.getElementOfMatrix(1,0)*this.getElementOfMatrix(2,1)) - (this.getElementOfMatrix(1,1)*this.getElementOfMatrix(2,0)));
        cofactorMatrix[1][0] = -1*((this.getElementOfMatrix(0,1)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,1)*this.getElementOfMatrix(0,2)));
        cofactorMatrix[1][1] = 1*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(2,2)) - (this.getElementOfMatrix(2,0)*this.getElementOfMatrix(0,2)));
        cofactorMatrix[1][2] = -1*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(2,1)) - (this.getElementOfMatrix(2,0)*this.getElementOfMatrix(0,1)));
        cofactorMatrix[2][0] = 1*((this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,2)) - (this.getElementOfMatrix(1,1)*this.getElementOfMatrix(0,2)));
        cofactorMatrix[2][1] = -1*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(1,2)) - (this.getElementOfMatrix(1,0)*this.getElementOfMatrix(0,2)));
        cofactorMatrix[2][2] = 1*((this.getElementOfMatrix(1,1)*this.getElementOfMatrix(0,0)) - (this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,0)));

        Matrix cofactor = new SquareMatrix();
        cofactor.setRows(this.getRows());
        cofactor.setColumns(this.getColumns());
        cofactor.setMatrix(cofactorMatrix);
        double[][] adjointMatrix = cofactor.calculateTranspose();
        return adjointMatrix;
    }

    @Override
    public double[][] getInverse(boolean toBeReturned){
        if (this.getDeterminant()==0){
            System.out.println("Can't find inverse as determinant is 0");
            return new double[][]{{Double.MIN_VALUE}};
        }
        if (this.getRows()==1){
            double[][] adjointMatrix = new double[this.getRows()][this.getRows()];
            adjointMatrix[0][0] = 1.0;
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
            double[][] adjointMatrix = this.getAdjointof3x3Matrix();
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

    @Override
    public void getEigenValues(){
        if (this.getRows()==1){
            System.out.println("\nEigen Value is  "+this.getElementOfMatrix(0,0));
        }
        else if (this.getRows()==2){
            double D = Math.pow(this.getElementOfMatrix(0,0)+this.getElementOfMatrix(1,1), 2) - 4*((this.getElementOfMatrix(0,0)*this.getElementOfMatrix(1,1)) - this.getElementOfMatrix(0,1)*this.getElementOfMatrix(1,0));
            if (D>=0){
                double eigenValue1 = ((this.getElementOfMatrix(0,0)+this.getElementOfMatrix(1,1)) + Math.sqrt(D))/2;
                double eigenValue2 = ((this.getElementOfMatrix(0,0)+this.getElementOfMatrix(1,1)) - Math.sqrt(D))/2;
                System.out.printf("\nEigen Values are  %.4f  and  %.4f \n",eigenValue1,eigenValue2);
            }
            else{
                double negative_D = Math.sqrt(-D)/2;
                double a_plus_d = (this.getElementOfMatrix(0,0)+this.getElementOfMatrix(1,1))/2;
                System.out.printf("\nEigen Values are  %.4f + %.4fi    and    %.4f - %.4fj \n",a_plus_d,negative_D,a_plus_d,negative_D);
            }
        }
    }

    @Override
    public void getEigenVectors(){
        if (this.getRows()==1){
            System.out.println("Eigen Vector is   [[1.00]]");
        }
        else if (this.getRows()==2){
            System.out.println("\nFinding Eigen vector of 2x2 Matrix may take some time");
            double a = this.getElementOfMatrix(0,0);
            double b = this.getElementOfMatrix(0,1);
            double c = this.getElementOfMatrix(1,0);
            double d = this.getElementOfMatrix(1,1);
            double eigenvalue1 = ((a+d) + Math.sqrt( Math.pow(a+d,2) - 4*((a*d) - (b*c))))/2.0;
            double eigenvalue2 = ((a+d) - Math.sqrt( Math.pow(a+d,2) - 4*((a*d) - (b*c))))/2.0;
            double[][] eigenVector1 = new double[2][1];
            double[][] eigenVector2 = new double[2][1];
            boolean eigenVector1Found = false; boolean eigenVector2Found = false;

            for (double y = 3; y >= -3; y=y-0.01) {
                for (double x = 3; x >= -3; x=x-0.01) {
                    if ((x!=0) && (y!=0) && (Math.abs((a-eigenvalue1)*x + b*y)<0.001) && (Math.abs(c*x + (d-eigenvalue1)*y)<0.001) && (!eigenVector1Found)) {
                        eigenVector1[0][0] = x;
                        eigenVector1[1][0] = y;
                        eigenVector1Found=true;
                    }
//                    if ((x!=0) && (y!=0) && ((a-eigenvalue1)*x + b*y == 0) && (c*x + (d-eigenvalue1)*y == 0) && (!eigenVector1Found)) {
//                        eigenVector1[0][0] = x;
//                        eigenVector1[1][0] = y;
//                        eigenVector1Found=true;
//                    }
                }
            }
            for (double y = 3; y >= -3; y=y-0.01) {
                for (double x = 3; x >= -3; x=x-0.01) {
                    if ((x!=0) && (y!=0) && (Math.abs((a-eigenvalue2)*x + b*y)<0.001) && (Math.abs(c*x + (d-eigenvalue2)*y)<0.001) && (!eigenVector2Found)) {
                        eigenVector2[0][0] = x;
                        eigenVector2[1][0] = y;
                        eigenVector2Found=true;
                    }
                }
            }

            if (!eigenVector1Found) {
                for (double y = 5; y >= -5; y = y - 0.01) {
                    for (double x = 5; x >= -5; x = x - 0.01) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue1) * x + b * y) < 0.001) && (Math.abs(c * x + (d - eigenvalue1) * y) < 0.001) && (!eigenVector1Found)) {
                            eigenVector1[0][0] = x;
                            eigenVector1[1][0] = y;
                            eigenVector1Found = true;
                        }
                    }
                }
            }
            if (!eigenVector2Found) {
                for (double y = 5; y >= -5; y = y - 0.01) {
                    for (double x = 5; x >= -5; x = x - 0.01) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue2) * x + b * y) < 0.001) && (Math.abs(c * x + (d - eigenvalue2) * y) < 0.001) && (!eigenVector2Found)) {
                            eigenVector2[0][0] = x;
                            eigenVector2[1][0] = y;
                            eigenVector2Found = true;
                        }
                    }
                }
            }

            if (!eigenVector1Found) {
                for (double y = 10; y >= -10; y = y - 0.01) {
                    for (double x = 10; x >= -10; x = x - 0.01) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue1) * x + b * y) < 0.001) && (Math.abs(c * x + (d - eigenvalue1) * y) < 0.001) && (!eigenVector1Found)) {
                            eigenVector1[0][0] = x;
                            eigenVector1[1][0] = y;
                            eigenVector1Found = true;
                        }
                    }
                }
            }
            if (!eigenVector2Found) {
                for (double y = 10; y >= -10; y = y - 0.01) {
                    for (double x = 10; x >= -10; x = x - 0.01) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue2) * x + b * y) < 0.001) && (Math.abs(c * x + (d - eigenvalue2) * y) < 0.001) && (!eigenVector2Found)) {
                            eigenVector2[0][0] = x;
                            eigenVector2[1][0] = y;
                            eigenVector2Found = true;
                        }
                    }
                }
            }
            if (!eigenVector1Found) {
                for (double y = 100; y >= -100; y = y - 0.25) {
                    for (double x = 100; x >= -100; x = x - 0.25) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue1) * x + b * y) < 0.01) && (Math.abs(c * x + (d - eigenvalue1) * y) < 0.01) && (!eigenVector1Found)) {
                            eigenVector1[0][0] = x;
                            eigenVector1[1][0] = y;
                            eigenVector1Found = true;
                        }
                    }
                }
            }
            if (!eigenVector2Found) {
                for (double y = 100; y >= -100; y = y - 0.25) {
                    for (double x = 100; x >= -100; x = x - 0.25) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue2) * x + b * y) < 0.01) && (Math.abs(c * x + (d - eigenvalue2) * y) < 0.01) && (!eigenVector2Found)) {
                            eigenVector2[0][0] = x;
                            eigenVector2[1][0] = y;
                            eigenVector2Found = true;
                        }
                    }
                }
            }

            if (!eigenVector1Found) {
                for (double y = 1000; y >= -1000; y = y - 0.25) {
                    for (double x = 1000; x >= -1000; x = x - 0.25) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue1) * x + b * y) < 0.01) && (Math.abs(c * x + (d - eigenvalue1) * y) < 0.01) && (!eigenVector1Found)) {
                            eigenVector1[0][0] = x;
                            eigenVector1[1][0] = y;
                            eigenVector1Found = true;
                        }
                    }
                }
            }
            if (!eigenVector2Found) {
                for (double y = 1000; y >= -1000; y = y - 0.25) {
                    for (double x = 1000; x >= -1000; x = x - 0.25) {
                        if ((x != 0) && (y != 0) && (Math.abs((a - eigenvalue2) * x + b * y) < 0.01) && (Math.abs(c * x + (d - eigenvalue2) * y) < 0.01) && (!eigenVector2Found)) {
                            eigenVector2[0][0] = x;
                            eigenVector2[1][0] = y;
                            eigenVector2Found = true;
                        }
                    }
                }
            }
            System.out.println("Eigen Vector 1 = ");
            this.printMatrix(eigenVector1);
            System.out.println("Eigen Vector 2 = ");
            this.printMatrix(eigenVector2);
        }
    }

}
