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

}
