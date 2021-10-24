import java.util.Scanner;

public class ScalarMatrix extends SquareMatrix{
    double scalarElement;

    @Override
    double getScalarElement(){
        return this.scalarElement;
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of Lower-Triangular square matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        System.out.printf("Enter the element of scalar matrix: ");
        double scalar = Double.parseDouble(sc.nextLine().trim());
        this.matrix = new double[dimension][dimension];
        this.rows=dimension;
        this.columns=dimension;
        this.scalarElement=scalar;
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                if (i==j) {
                    this.matrix[i][j]=scalar;
                }
                else{
                    this.matrix[i][j]=0;
                }
            }
        }
        this.id = this.staticID;
    }

    public static void main(String[] args) {
        Matrix sm = new ScalarMatrix();
        sm.inputMatrix();
        System.out.println(sm.getScalarElement());
        System.out.println(sm.getId());
        sm.printMatrix();
        sm.printMatrix(sm.getTransposeMatrix());
    }
}
