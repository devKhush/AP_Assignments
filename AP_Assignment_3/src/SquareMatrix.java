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
        sm.printMatrix(sm.getTransposeMatrix());
        System.out.println(sm.isSymmetric());
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

        System.out.println();
        sm.matrixMultiplication(rm);
    }
}
