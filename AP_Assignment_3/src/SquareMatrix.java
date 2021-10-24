import java.util.Arrays;
import java.util.Scanner;

public class SquareMatrix extends Matrix{

    @Override
    public double[][] getTransposeMatrix(){
        return this.calculateTranspose();
    }

    @Override
    public boolean isSymmetric(){
        return Arrays.deepEquals(this.getMatrix(), this.getTransposeMatrix());
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of square matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.matrix = new double[dimension][dimension];
        this.rows=dimension;
        this.columns=dimension;
        for (int i=0; i<dimension; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<dimension; j++){
                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        this.id = this.staticID;
    }

//    @Override
//    public double[][] calculateTranspose(){
//        double[][] transpose = new double[this.columns][this.rows];
//        for(int i=0; i<this.rows; i++){
//            for (int j=0; j<this.columns; j++){
//                transpose[j][i]=this.matrix[i][j];
//            }
//        }
//        return transpose;
//    }

    public static void main(String[] args) {
        Matrix sm = new SquareMatrix();
        sm.inputMatrix();
        sm.printMatrix();
        System.out.println(sm.getId());
        System.out.println(sm.getRows());
        System.out.println(sm.getColumns());
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
    }
}
