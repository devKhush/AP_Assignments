import java.util.Scanner;

public class RowMatrix extends RectangularMatrix{

    @Override
    public boolean inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter numbers of columns: ");
        int column = Integer.parseInt(sc.nextLine().trim());
        this.setMatrix(new double[1][column]);
        this.setRows(1);
        this.setColumns(column);
        for (int i=0; i<1; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<column; j++){
                double matrixElement = Double.parseDouble(rowInputArray[j]);
                this.changeElementOfMatrix(i,j , matrixElement);
            }
        }
        this.setID();
        return true;
    }

    @Override
    public void getAllTypes(){
        System.out.println("Row Matrix");
        if (this.getRows()==this.getColumns()) {
            System.out.println("Square Matrix");
            System.out.println("Singleton Matrix");
            System.out.println("Diagonal Matrix");
            System.out.println("Scalar Matrix");
            if (this.getElementOfMatrix(0,0)==1){
                System.out.println("Ones matrix");
                System.out.println("Identity matrix");
            }
            else if (this.getElementOfMatrix(0,0)==0){
                System.out.println("Null matrix");
            }
        }
        else
            System.out.println("Rectangular Matrix");
    }

    @Override
    public double getDeterminant(){
        if (this.getRows()!=this.getColumns()) {
            System.out.println("Can't find determinant as this matrix is not a Square matrix");
            return Double.MIN_VALUE;
        }
        else
            return this.getElementOfMatrix(0,0);
    }

    @Override
    public boolean isSymmetric(){
        return this.getRows() == this.getColumns();
    }

    @Override
    public boolean isSkewSymmetric(){
        return false;
    }

    @Override
    public double[][] getInverse(boolean toBeReturned){
        if (this.getRows()!=this.getColumns()) {
            System.out.println("Can't find Inverse of this Matrix as the it is not a Square Matrix");
            return new double[][]{{Double.MIN_VALUE}};
        }
        else {
            SquareMatrix demoMatrix = new SquareMatrix();
            demoMatrix.setMatrix(this.getMatrix());
            demoMatrix.setRows(this.getRows());
            demoMatrix.setColumns(this.getColumns());
            if (toBeReturned)
                return demoMatrix.getInverse(true);
            demoMatrix.getInverse(false);
            return demoMatrix.getInverse(true);
        }
    }

    @Override
    public void solveLinearEquation(Matrix B){
        if (this.getRows()!=this.getColumns()) {
            System.out.println("Can't solve equations as this matrix is Singular Matrix");
            return;
        }
        SquareMatrix demoMatrix = new SquareMatrix();
        demoMatrix.setMatrix(this.getMatrix());
        demoMatrix.setRows(this.getRows());
        demoMatrix.setColumns(this.getColumns());
        demoMatrix.solveLinearEquation(B);
    }

    @Override
    public void matrixPlusItsTranspose(){
        if (this.getRows()!=this.getColumns()){
            System.out.println("Can't perform as this Matrix must be a square matrix");
            return;
        }
        SquareMatrix demoMatrix = new SquareMatrix();
        demoMatrix.setMatrix(this.getMatrix());
        demoMatrix.setRows(this.getRows());
        demoMatrix.setColumns(this.getColumns());
        demoMatrix.matrixPlusItsTranspose();
    }

    public static void main(String[] args) {
        Matrix rm = new RowMatrix();
        rm.inputMatrix();
        rm.printMatrix();
        rm.printMatrix(rm.getTransposeMatrix());
        System.out.println(rm.getId());
        System.out.println(rm.getRows());
        System.out.println(rm.getColumns());

        Matrix cm = new ColumnMatrix();
        cm.inputMatrix();
        cm.printMatrix();
        cm.printMatrix(cm.getTransposeMatrix());
        System.out.println(cm.getId());
        System.out.println(cm.getRows());
        System.out.println(cm.getColumns());

        Matrix rm1 = new RowMatrix();
        rm1.inputMatrix();
        rm1.printMatrix();
        rm1.printMatrix(rm1.getTransposeMatrix());
        System.out.println(rm1.getId());
        System.out.println(rm1.getRows());
        System.out.println(rm1.getColumns());
    }
}
