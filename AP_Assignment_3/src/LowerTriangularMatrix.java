import java.util.Scanner;

public class LowerTriangularMatrix extends SquareMatrix{
    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of Lower-Triangular square matrix (one number): ");
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
}
